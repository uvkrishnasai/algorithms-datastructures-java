package org.practice.programs.intermediate;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {

	public static void main(String[] args) {
		String str="abc";
		System.out.println("longest palindrome in "+str+" = "+findLongestPalindromeInString(str));
	 
		str="abcd";
		System.out.println("longest palindrome in "+str+" = "+findLongestPalindromeInString(str));
	 
		str="abcba";
		System.out.println("longest palindrome in "+str+" = "+findLongestPalindromeInString(str));
	       
		str="aabc";
		System.out.println("longest palindrome in "+str+" = "+findLongestPalindromeInString(str));
	 
		str="zzabcbai";
		System.out.println("longest palindrome in "+str+" = "+findLongestPalindromeInString(str));
	   
		str="12aqbciolloicbqa12";
		System.out.println("longest palindrome in "+str+" = "+findLongestPalindromeInString(str));
		
	}
	
	private static String findLongestPalindromeInString(String str) {
		String highestLengthPalindrome = null;
		int highestLength = 0;
		
		List<String> distinctSubStrings= distinctSubStrings(str);
		for (String string : distinctSubStrings) {
//			System.out.println(string);
			if (isPalindrome(string)) {
				if (string.length() > highestLength) {
					highestLength = string.length();
					highestLengthPalindrome = string;
				}
//				System.out.println(string + " is palindrome with length " + string.length());
			}
		}
		
		return highestLengthPalindrome;
	}

	public static boolean isPalindrome(String str){
		if (str == null || str.length() == 1 || str.length() == 0) {
			return true;
		}
		
		char[] toChar = str.toCharArray();
		if (toChar[0] == toChar[toChar.length-1]) {
//			System.out.println(toChar[0] + " == " + toChar[toChar.length-1] + " : " +str.substring(1, toChar.length-1));
			return isPalindrome(str.substring(1, toChar.length-1));
		}
		
		return false;
	}
	
	public static List<String> distinctSubStrings(String str){
		List<String> list = new ArrayList<>();
		char[] toChar = str.toCharArray();
		for (int i = 0; i < toChar.length; i++) {
			int length = toChar.length;
			while(length > i){
				list.add(str.substring(i, length));
				length--;
			}
		}
		return list;
	}

}
