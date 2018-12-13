package datastructures.string;

import java.util.Arrays;

/**
 * Created by Krishna on 6/12/16.
 */
public class PalindromeUsingRecursion {

    //mine
    public static boolean isPalindrome(char[] chars) {
        if (chars == null || chars.length == 0)
            return false;

        if(chars.length == 1) {
            return true;
        } else {
            if(chars[0] == chars[chars.length-1]) {
                return isPalindrome(Arrays.copyOfRange(chars, 1, chars.length-1));
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aqprtshncdcnhstrpqa".toCharArray()));
    }

}
