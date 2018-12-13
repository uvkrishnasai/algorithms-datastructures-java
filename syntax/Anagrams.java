package syntax;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Anagrams {

    /**
     * Solution:
     *  Convert both the string to chars
     *  Sort the chars
     *  Check if all chars from both the lists match in order
     *
     * @param a: String
     * @param b: String
     * @return boolean
     */
    static boolean isAnagram(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        List<Integer> aChars = a.toLowerCase().chars()
                .mapToObj(i -> new Integer(i))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        List<Integer> bChars = b.toLowerCase().chars()
                .mapToObj(i -> new Integer(i))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        return java.util.stream.IntStream
                .range(0, aChars.size())
                .allMatch(i ->
                        aChars.get(i).equals(bChars.get(i)
                        )
                );
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("cinema","iceman"));
    }

}
