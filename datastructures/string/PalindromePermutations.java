package datastructures.string;

/**
 * Cracking the coding interview: 1.4
 * Assumption: Lowercase with out special chars
 * Solution: 1 char odd, rest even
 */
public class PalindromePermutations {

    public static void main(String[] args) {

        String s = "tactcoao";

        boolean[] freq = new boolean[26];
        for(char c : s.toCharArray()) {
            freq[(int)c-(int)'a'] = !freq[(int)c-(int)'a'];
        }

        boolean foundOddChar = false;
        for (boolean ind : freq) {
            if(foundOddChar && ind){
                System.out.println("Not Palindrome permutation");
                return;
            }
            foundOddChar = ind ? ind : foundOddChar;
        }

        System.out.println("Is Palindrome permutation");
    }
}
