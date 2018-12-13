package datastructures.string;

/**
 * Cracking the coding interview: 1.3
 * URLify: replace all the spaces in a string with %20
 */
public class URLify {

    public static void main(String[] args) {
        String s = "http://test test. com    ";

        char[] chars = s.toCharArray();
        int i = chars.length-1;
        for(int j = s.trim().length()-1; j >= 0; j--) {
            if(chars[j] == ' ') {
                chars[i] = '0';
                chars[i-1] = '2';
                chars[i-2] = '%';
                i -= 2;
            } else {
                chars[i] = chars[j];
            }
            i -= 1;
        }

        System.out.println(new String(chars));
    }
}
