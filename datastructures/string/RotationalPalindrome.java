package datastructures.string;

/**
 * Created by Krishna on 6/12/16.
 *
 * If reverse of a String is same as the original one , after series of rotations
 *
 */
public class RotationalPalindrome {

    public static boolean isRotationalPalindrome(String str){
        String rotateStr = str;

        do {
            if (isPalindrome(rotateStr))
                return true;

            rotateStr = rotate(rotateStr);

        }while(!str.equals(rotateStr));

        return false;
    }

    public static String rotate(String str) {
        char[] chars = str.toCharArray();
        char temp = chars[0];
        for (int i = 1; i < chars.length; i++) {
            chars[i-1] = chars[i];
        }
        chars[chars.length-1] = temp;
        return new String(chars);
    }

    public static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            if (chars[i] != chars[chars.length-1-i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(RotationalPalindrome.isRotationalPalindrome("daaaa"));
    }

}
