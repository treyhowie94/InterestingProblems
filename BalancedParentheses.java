import static java.lang.System.out;

public class BalancedParentheses {

	/**
	 * Write a function that finds whether a string of parentheses characters ( (), {}, or [] ) are 
	 * balanced (i.e. have a closing character at the appropriate position in the string, () is balanced
	 * but {] is not, (({[]})), (){}[] are balanced but ({)} is not
	 */
	
	public static void main(String[] args) {
		out.println(isBalanced("[([{()}))]")); // false
	}
	
	/**
	 * O(N) solution - the most optimal one - for checking whether a string has balanced (,{, and [.
	 * Ex: ()[]{}, [()] are balanced, whereas ({]) is not
	 * 
	 * @param parString
	 * @return boolean - whether the string has balanced parentheses characters
	 */
	private static boolean isBalanced(String parString) {
		// check if string is odd length ~~~> odd length cannot be balanced
		if (parString.length() % 2 > 0) {
			return false;
		}
		// check if string is of length 2 and whether the two characters are not balanced
		if (parString.length() == 2 && !isValidClose(parString.charAt(0), parString.charAt(1))) {
			return false;
		}
		
		// index of the character on the back end of the string
		int backEndIndex = parString.length()-1;
		for (int i=0; i<parString.length(); i++) {
			// see if the curr index is next to the last char in the string
			// we've already checked if strings of length 2 have matching parens so we can stop looping
			if (backEndIndex == i+1) {
				break;
			}
			
			// character at the current index
			char frontEndChar = parString.charAt(i);
			
			// check to see if the character next to the current char is a valid close, if so, move on
			if (isValidClose(frontEndChar, parString.charAt(i+1))) {
				// skip the character next to the current one cause it's already a valid close char
				i++;
				continue;
			}
			// no go, check the character on the mirror index of the current one
			else {
				// character at the back end index of the string
				char backEndChar = parString.charAt(backEndIndex);
				
				// check to see if curr char and back end char are closers for each other
				if (!isValidClose(frontEndChar, backEndChar)) {
					return false;
				}
				// move to the index to the char spot to the left of the curr back end character
				else {
					backEndIndex--;
				}
			}
		}
		
		// all closing chars are found ~~~> valid string
		return true;
	}
	
	/**
	 * Checks to see if the characters passed as params are closers for each other
	 * Ex: () is valid, [] is valid, {} is valid, (} is not, etc.
	 * 
	 * @param c1
	 * @param c2
	 * @return boolean - whether two parentheses characters are valid closers for one another
	 */
	private static boolean isValidClose(char c1, char c2) {
		if (c1 == '(' && c2 == ')') {
			return true;
		}
		else if (c1 == '[' && c2 == ']') {
			return true;
		}
		else if (c1 == '{' && c2 == '}') {
			return true;
		}
		else {
			return false;
		}
	}
	
}
