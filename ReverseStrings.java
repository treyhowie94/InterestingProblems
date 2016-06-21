import java.util.ArrayList;

public class ReverseStrings {

	/**
	 * Write a function that reverses a given string without special characters or extra white spaces
	 */
	
	public static void main(String[] args) {
		String s = " Computer   science  rocks!      ";
		System.out.println(reverseString(s));
	}
	
	private static String reverseString(String originalStr) {
		ArrayList<String> formattedWords = formatStringWords(originalStr);
		
		StringBuilder sb = new StringBuilder();
		for (int i=formattedWords.size()-1; i>=0; i--) {
			if (i != 0) {
				sb.append(formattedWords.get(i) + " ");
			}
			else {
				sb.append(formattedWords.get(i));
			}
		}
		return sb.toString();
	}
	
	private static ArrayList<String> formatStringWords(String str) {
		ArrayList<String> rtn = new ArrayList<String>(0);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<str.length(); i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				sb.append(str.charAt(i));
			}
			else {
				if (!sb.toString().equals("")) {
					rtn.add(sb.toString());
					sb = new StringBuilder();
				}
			}
		}
		
		if (!sb.toString().equals("")) {
			rtn.add(sb.toString());
		}
		return rtn;
	}
	
}
