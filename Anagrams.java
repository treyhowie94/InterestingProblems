import java.util.HashMap;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		System.out.println(isAnagram("Eleven plus two","Twelve plus one")); // true
		System.out.println(isAnagram("Mother-in-law", "Hitler woman")); // true
		System.out.println(isAnagram("Debit card", "Bad     %^%$^%$^%$ crediT")); // true
		System.out.println(isAnagram("Astronomer", "moon Starrer")); // false
		System.out.println(isAnagram("School master", "The classroom")); // true
	}
	
	/**
	 * O(N) solution using hash tables and the character counts stored in them
	 * 
	 * @param str1
	 * @param str2
	 * @return boolean - whether str2 contains the same exact character as str1 in whatever order
	 */
	private static boolean isAnagram(String str1, String str2) {
		String reducedStr1 = removeUneededChars(str1.toLowerCase());
		String reducedStr2 = removeUneededChars(str2.toLowerCase());
		
		if (reducedStr1.length() != reducedStr2.length()) {
			return false;
		}
		
		Map<Character, Integer> characterMap1 = new HashMap<Character, Integer>();
		for (int i=0; i<reducedStr1.length(); i++) {
			char currChar = reducedStr1.charAt(i);
			int charCount = characterMap1.containsKey(currChar) ? characterMap1.get(currChar) : 0;
			
			characterMap1.put(currChar, charCount+1);
		}
		
		Map<Character, Integer> characterMap2 = new HashMap<Character, Integer>();
		for (int i=0; i<reducedStr2.length(); i++) {
			char currChar = reducedStr2.charAt(i);
			int charCount = characterMap2.containsKey(currChar) ? characterMap2.get(currChar) : 0;
			
			characterMap2.put(currChar, charCount+1);
		}
		
		for (Character currChar: characterMap1.keySet()) {
			if (characterMap1.get(currChar) != characterMap2.get(currChar)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * remove punctuation, symbols & numbers from the passed string
	 * 
	 * @param str
	 * @return String - new String not containing any excess characters
	 */
	private static String removeUneededChars(String str) {
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
	
}
