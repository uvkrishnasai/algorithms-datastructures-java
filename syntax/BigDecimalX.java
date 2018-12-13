package syntax;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 * Java 8 Comparator, sorting, maps, inner class practise.
 * =======================================================
 * Sample Input
 * ------------
 * 9
 * -100
 * 50
 * 0
 * 56.6
 * 90
 * 0.12
 * .12
 * 02.34
 * 000.000
 *
 * Sample Output
 * -------------
 * 90
 * 56.6
 * 50
 * 02.34
 * 0.12
 * .12
 * 0
 * 000.000
 * -100
 */
public class BigDecimalX {

    public static void main(String[] args) {

        String[] s1 = {"9", "-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000"};
        int n = s1.length;

        class Custom {
            private String value;
            private int position;
            private BigDecimal bigValue;
            public Custom(String value, int position) {
                this.value = value;
                this.position = position;
                this.bigValue = new BigDecimal(value, java.math.MathContext.UNLIMITED);
            }
            public String getValue(){
                return this.value;
            }
            public int getPosition(){
                return this.position;
            }
            public BigDecimal getBigValue(){
                return this.bigValue;
            }
            public String toString() {
                return "value: " + this.value +
                        ", position: " + this.position +
                        ", bigValue: " + this.bigValue;
            }
        }

        List<Custom> customList = java.util.stream.IntStream
                .range(0, n)
                .mapToObj(i -> new Custom(s1[i], i))
                .collect(java.util.stream.Collectors.toList());

        customList.stream()
                .sorted(
                        Comparator
                                .comparing(Custom::getBigValue)
                                .reversed()
                                .thenComparingInt(Custom::getPosition)
                )
                .map(Custom::getValue)
                .forEach(System.out::println);
    }

}
