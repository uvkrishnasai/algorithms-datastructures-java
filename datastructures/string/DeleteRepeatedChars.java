package datastructures.string;

/**
 * Created by Krishna on 6/12/16.
 * Brute force.
 */
public class DeleteRepeatedChars {

    public static void delete(String str1, String str2) {
        char[] str1Chars = str1.toCharArray();
        char[] str2Chars = str2.toCharArray();


        for (int i = 0; i < str1Chars.length; i++) {
            boolean charFound= false;
            for (int j = 0; j < str2Chars.length; j++) {
                if (String.valueOf(str1Chars[i]).toLowerCase().equals(String.valueOf(str2Chars[j]).toLowerCase())) {
                    charFound = true;
                    break;
                }
            }

            if (charFound) {
                str1 = str1.replace(String.valueOf(str1Chars[i]).toLowerCase(), "");
                str1 = str1.replace(String.valueOf(str1Chars[i]).toUpperCase(), "");
                str2 = str2.replace(String.valueOf(str1Chars[i]).toLowerCase(), "");
                str2 = str2.replace(String.valueOf(str1Chars[i]).toUpperCase(), "");
            }
        }

        System.out.println(str1+ " " + str2);
    }

    public static void main(String[] args) {
        DeleteRepeatedChars.delete("abc", "cde");
        DeleteRepeatedChars.delete("abc@", "cd@e");
        DeleteRepeatedChars.delete("aBc", "bcde");
    }

}
