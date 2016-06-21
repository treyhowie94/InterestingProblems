import java.util.ArrayList;
import java.util.List;


public class FindWhetherShuffleOfTwoStringsIsValid {

	/**
	 * Finds whether string 3 is an in order shuffle of string a and b (i.e. the elements of strings a, b must be in
	 * the same order that they appear ~~~> abc, abc, aabbcc is valid, aaa, eee, eaeaea is valid, aaeeae is not
	 */
	
	public static void main(String[] args) {
		String str1 = "aaa";
		String str2 = "aaa";
		String str3 = "aaaaaa";
		
		System.out.println(isValidShuffle(str1, str2, str3));
	}
	
	/**
	 * Done with O(N*M) complexity. Turn strings a and b into character lists then build string builders with characters
	 * found contained in either list a or b, then see if the strings build are equal to the original strings a and b.
	 *  
	 * @param a
	 * @param b
	 * @param c
	 * @return boolean - whether the string c is comprised of the interleaving of a and
	 */
	private static boolean isValidShuffle(String a, String b, String c){
		if (c.length() != a.length() + b.length()) {
			return false;
		}
		
		StringBuilder sbA = new StringBuilder();
		StringBuilder sbB = new StringBuilder();
		
		List<Character> listA = convertStringToList(a);
		List<Character> listB = convertStringToList(b);
		
		for (int i=0; i<c.length(); i++) {
			char currChar = c.charAt(i);
			
			if (listA.contains(currChar)) {
				sbA.append(currChar);
				listA.remove((Character) currChar);
			}
			else if (listB.contains(currChar)) {
				sbB.append(currChar);
				listB.remove((Character) currChar);
			}
		}
		
		if (sbA.toString().equals(a) && sbB.toString().equals(b)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static ArrayList<Character> convertStringToList(String s) {
		ArrayList<Character> rtn = new ArrayList<Character>(0);
		for (int i=0; i<s.length(); i++) {
			rtn.add(s.charAt(i));
		}
		return rtn;
	}
	
}
