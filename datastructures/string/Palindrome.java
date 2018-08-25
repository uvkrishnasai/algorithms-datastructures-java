package datastructures.string;

/**
 * Created by Krishna on 5/22/16.
 *
 * If reverse of string is same as original one,
 * than our string is palindrome
 * or palindrome is a string which reads the same backward or forward.
 *
 */
public class Palindrome {

    //mine
    public static boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length/2; i++) {
            if (charArray[i] != charArray[charArray.length-1-i])
                return false;
        }
        return true;

    }

    //JMSE
    public static boolean isPalindromeJMSE(String inputString){
        char ar[]=inputString.toCharArray();
        for(int i=0,j=ar.length-1; i<(ar.length/2); i++,j--){
            if(ar[i]!=ar[j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("aqprtshncdcnhstrpqa"));
        System.out.println(isPalindromeJMSE("aqprtshncdcnhstrpqa"));

    }



}
