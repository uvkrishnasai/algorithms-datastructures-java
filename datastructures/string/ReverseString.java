package datastructures.string;

/**
 * Created by Krishna on 5/22/16.
 */
public class ReverseString {

    // Brute force.
    public static String reverse(String s) {
        int len = s.length();
        char[] sChar = s.toCharArray();
        char[] reverseString = new char[len];
        for (int i = len; i >=0 ; i--) {
            reverseString[len-i-1] = sChar[i];
        }
        return new String(reverseString);
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        String s = "abcde";
        System.out.println(reverse(s));
        System.out.println(new StringBuilder(s).reverse()); // simple solution.
    }

}
