import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class FindAllPairsInArrayThatSumToValK {
	
	/**
	 * Write a function that finds all pairs of values in a given array that sum to the given value K
	 */
	
	public static void main(String[] args) {
		int[] randomValues = new int[100];
		
		Random random = new Random();
		for (int i=0; i<randomValues.length; i++) {
			randomValues[i] = random.nextInt(100) + 1;
		}
		
		int targetSum = random.nextInt(100) + 1;
		Set<int[]> hashFoundPairs      = findValidSummationPairsHashTable(randomValues, targetSum);
		Set<int[]> binSearchFoundPairs = findValidSummationPairsBinarySearch(randomValues, targetSum);
		
		if (hashFoundPairs.size() == 0) {
			System.out.println("No hash pairs found for " + targetSum);
		}
		else {
			System.out.println("FOUND HASH PAIRS");
			for (int[] currPair: hashFoundPairs) {
				System.out.println(currPair[0] + " and " + currPair[1] + " were found to sum to " + targetSum);
			}
		}
		if (binSearchFoundPairs.size() == 0) {
			System.out.println("No binary search pairs found for " + targetSum);
		}
		else {
			System.out.println("FOUND BINARY SEARCH PAIRS");
			for (int[] currPair: binSearchFoundPairs) {
				System.out.println(currPair[0] + " and " + currPair[1] + " were found to sum to " + targetSum);
			}
		}
		
	}
	
	/**
	 * Done in O(N) time (typically). The HashSet allows for seen values look up in O(1) time (O(N) worst case).
	 * 
	 * @param values - int[] of values
	 * @param sumToFind - the target sum value to find between pairs
	 * @return ArrayList<int[]> - A list of all pairs that sum to the targetSum 
	 */
	private static Set<int[]> findValidSummationPairsHashTable(int[] values, int targetSum) {
		Set<int[]> validPairs = new HashSet<int[]>(0);
		
		if (values.length == 0 || (values.length == 1 && values[0] != targetSum)) {
			return null;
		}
		
		Set<Integer> seenVals = new HashSet<Integer>();
		for (int currValue: values) {
			if (!seenVals.contains(currValue)) {
				seenVals.add(currValue);
			}
			
			int targetInt = targetSum - currValue;
			if (seenVals.contains(targetInt)) {
				validPairs.add(new int[] {currValue, targetSum - currValue});
			}
		}
		
		return validPairs;
	}
	
	/**
	 * Done in 0(NlogN) time, can be done faster. This uses a linear search and then searches the array
	 * of values using binary search ~~~> LogN (sort time) + N (number of Values in arr) * LogN (binary search)
	 * 
	 * ~ NLogN complexity
	 * 
	 * @param values - int[] of values
	 * @param sumToFind - the target sum value to find between pairs
	 * @return ArrayList<int[]> - A list of all pairs that sum to the targetSum
	 */
	private static Set<int[]> findValidSummationPairsBinarySearch(int[] values, int targetSum) {
		Set<int[]> validPairs = new HashSet<int[]>(0);
		
		if (values.length == 0 || (values.length == 1 && values[0] != targetSum)) {
			return null;
		}
		
		Arrays.sort(values);
		for (int i=0; i<values.length; i++) {
			int indexOfValidPartner = Arrays.binarySearch(values, targetSum - values[i]);
			
			if (indexOfValidPartner >= 0) {
				validPairs.add(new int[] {values[i], values[indexOfValidPartner]});
			}
		}
		
		return validPairs;
	}
	
}
