package datastructures.string;

public class ReplaceString {

	public static void replaceSpaceWithSOS() {
		
		String test = "This is a program";
	}

	public static void replaceSOSWithSpace() {

		String test = "This$#$is$#$a$#$program";

		char[] testChar = test.toCharArray();
		int length = testChar.length;

		for (int i = 0; i < length - 2; i++) {
			if (testChar[i] == '$' && testChar[i + 1] == '#' && testChar[i + 2] == '$') {
				testChar[i] = ' ';

				int j = i + 1;
				while (j < length - 2) {
					testChar[j] = testChar[j + 2];
					j++;
				}

				testChar[j] = ' ';
				testChar[j + 1] = ' ';
			}
		}

		System.out.println(testChar);

	}

	public static void main(String[] args) {
	}

}
