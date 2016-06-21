
public class NextSmallestPalindrome {

	/**
	 * Write a function that finds the next smallest palindrome number according to the number given
	 * 122 ~~~> 131, 111 ~~~> 111, 1224351 ~~~> 1335331
	 * 
	 * 
	 * needs correcting for the errors that occur when a 9 is involved
	 */
	
	public static void main(String[] args) {
		System.out.println(nextSmallestPalindrome(32929));
	}
	
	private static int nextSmallestPalindrome(int val) {
		String strVal = Integer.toString(val);
		
		String charsToHalfPoint = strVal.substring(0, strVal.length()/2);
		String reversedFirstHalf = reverseString(charsToHalfPoint);
		if (strVal.length() % 2 == 0) {
			return Integer.valueOf(charsToHalfPoint + reversedFirstHalf);
		}
		
		String charsOnOtherSideOfHalfPoint = strVal.substring((strVal.length()/2) + 1, strVal.length());
		if (Integer.valueOf(charsOnOtherSideOfHalfPoint) == Integer.valueOf(reversedFirstHalf)) {
			return val;
		}
		else if (Integer.valueOf(charsOnOtherSideOfHalfPoint) < Integer.valueOf(reversedFirstHalf)) {
			return Integer.valueOf(strVal.substring(0, strVal.length()/2 + 2) + reversedFirstHalf);
		}
		else {
			String middleDigit = String.valueOf(
					Integer.valueOf(
					strVal.substring(strVal.length()/2, strVal.length()/2 + 1)) + 1);
			
			if (middleDigit == "9") {
				
			}
			
			return Integer.valueOf(charsToHalfPoint + middleDigit + reversedFirstHalf); 
		}
	}
	
	private static String reverseString(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i=str.length()-1; i>=0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
}
