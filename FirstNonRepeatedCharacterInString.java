import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacterInString {

	/**
	 * Write a function that finds the first non repeated character in a string
	 */
	
	public static void main(String[] args) {
		Character c = firstNonRepeatedChar("aaabbbcetcteyyyyy");
		if (c != null) {
			System.out.println(c + " is the first non repeated character in the string");
		}
		else {
			System.out.println("All characters were repeated...");
		}
	}
	
	private static Character firstNonRepeatedChar(String str) {
		Map<Character, Integer> charCountMap = new LinkedHashMap<Character, Integer>();
		
		for (int i=0; i<str.length(); i++) {
			char currChar = str.charAt(i);
			int charCount = charCountMap.containsKey(currChar) ? charCountMap.get(currChar) : 0;
			
			charCountMap.put(currChar, charCount+1);
		}
		
		for (Map.Entry<Character, Integer> mapEntry: charCountMap.entrySet()) {
			if (mapEntry.getValue() == 1) {
				return mapEntry.getKey();
			}
		}
		return null;
	}
	
}
