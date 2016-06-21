public class AllPermutationsOfAString {

	/**
	 * Write a function that finds all possible permutations of a given string...
	 */
	
	
	public static void main(String[] args) throws Exception {
	    String str = "abc";
	    StringBuffer strBuf = new StringBuffer(str);
	    permutation(strBuf,str.length());
	} 

	private static void permutation(StringBuffer str, int index){
		if (index <= 0) {
	        System.out.println(str);   
	    }
		//recursively solve this by placing all other chars at current first pos
		else { 
	        permutation(str, index-1);
	        int currPos = str.length()-index;
	      
	        //start swapping all other chars with current first char
	        for (int i = currPos+1; i < str.length(); i++) {
	            swap(str,currPos, i);
	            permutation(str, index-1);
	         
	            //restore back my string buffer
	            swap(str,i, currPos);
	        }
	    }
	}

	private static void swap(StringBuffer str, int pos1, int pos2){
	    char t1 = str.charAt(pos1);
	    str.setCharAt(pos1, str.charAt(pos2));
	    str.setCharAt(pos2, t1);
	} 
	
}
