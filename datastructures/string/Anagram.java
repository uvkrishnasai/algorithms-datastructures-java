package datastructures.string;

import java.util.HashSet;
import java.util.Set;

public class Anagram {
	
	public static Set<String> getAnagram(String str){
		Set<String> anagram = new HashSet<>(); 
		Set<String> set;
		char firstChar;
		if (str.length() == 0) {
			anagram.add("");
			return anagram;
		}
		firstChar = str.charAt(0);
		String strWithOutFirstChar = str.substring(1);
		set = getAnagram(strWithOutFirstChar);
		
		for (String string : set) {
			for (int i=0; i<= string.length(); i++) {
				anagram.add(insertChar(string, i, firstChar));
			}
		}
		return anagram;
		
	}
	

	private static String insertChar(String string, int i, char firstChar) {
		String begin = string.substring(0, i);
		String end = string.substring(i);
		string = begin + firstChar + end;  
		return string;
	}


	public static void main(String[] args) {
		for (String string : getAnagram("ABCD")) {
			System.out.println(string);
		}

	}

}
