package datastructures.string;

/**
 * Created by Krishna on 5/22/16.
 *
 * ASCII value of
 * A-Z = 65-90 where
 * A=65, Z=90

 * and ASCII value of
 * a-z = 97-122 where
 * a=97, z=122
 *
 */
public class ToggleChar {

    public static String toggle(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {

            if ((int)charArray[i] >= 65 && (int)charArray[i] <= 90) {
                charArray[i] = (char) ((int) charArray[i] + 32);
                continue;
            }

            if ((int)charArray[i] >= 97 && (int)charArray[i] <= 122) {
                charArray[i] = (char) ((int)charArray[i] - 32);
                continue;
            }

        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        System.out.println(toggle("Java"));
    }
}
