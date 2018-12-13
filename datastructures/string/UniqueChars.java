package datastructures.string;

/**
 * Cracking the coding interview: 1.1
 * Implement an algorithm to determine if a string has all unique chars.
 */
public class UniqueChars {

    public static void main(String[] args) {

        String s = "aBC";
        boolean isUnique = isStringUnique(s); //isStringUniqueBitManip(s);

        if (isUnique) {
            System.out.println(String.format("String %s is unique", s));
        } else {
            System.out.println(String.format("String %s is not unique", s));
        }

    }

    /**
     * checks if a string is unique using array.
     * @param s string
     * @return true/false
     */
    private static boolean isStringUnique(String s) {

        int[] arr = new int[52];

        for(char elem : s.toCharArray()) {
            int index = (int) elem - (int)'A';
            if(arr[index] == 1) {
                return false;
            } else {
                arr[index] = 1;
            }
        }

        return true;
    }

    /**
     * This approach is case insensitive.
     * @param s String
     * @return true/false
     */
    private static boolean isStringUniqueBitManip(String s) {

        int value = 0;

        for(char c : s.toCharArray()) {
            // get ith bit value
            int bit = value & (1 << ((int)c));
            // if value is 1 return false
            if(bit != 0)
                return false;

            value = value | (1 << ((int)c));
        }

        return true;
    }
}
