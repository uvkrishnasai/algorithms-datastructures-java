package datastructures.string;

/**
 * Cracking the coding interview: 1.2
 * Check permutations -
 * Given 2 strings, check if one is a permutation of the other.
 */
public class Permutation {

    public static void main(String[] args) {
        String s1 = "god";
        String s2 = "dog";
        boolean result = checkPermutation(s1, s2);

        if(result) {
            System.out.println("strings are permutations of one another");
        } else {
            System.out.println("strings are not permutations of one another");
        }

    }

    /**
     * Permutation - every frequency of characters in both the strings should be same.
     * @param s1 String 1
     * @param s2 String 2
     * @return true/false
     */
    private static boolean checkPermutation(String s1, String s2) {
        // build a frequency for first string
        int[] freq = new int[128];
        for(char c : s1.toCharArray()) {
            freq[(int)c] += 1;
        }

        // reduce the build freq from chars of string s2
        for(char c : s2.toCharArray()) {
            freq[(int)c] -= 1;
        }

        // check if the freq array has all 0s
        for (int ind : freq) {
            if(ind != 0) {
                return false;
            }
        }

        return true;
    }
}
