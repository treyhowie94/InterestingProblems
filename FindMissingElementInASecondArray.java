import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class FindMissingElementInASecondArray {

	/**
	 * Write a function that finds the missing element in an array based on another given array
	 */
	
	public static void main(String[] args) {
		int[] arr1 = {4, 1, 0, 2, 9, 6, 8, 7, 5, 3};
		int[] arr2 = {6, 4, 7, 2, 1, 0, 8, 3, 9};
		
		System.out.println("The missing element from arr2 is: " +findMissingElementNLOGN(arr1, arr2));
		System.out.println("The missing element from arr2 is: " +findMissingElementN(arr1, arr2));
	}
	
	/**
	 * NLogN solution with sorting and binary search
	 * 
	 * @param arr1
	 * @param arr2
	 * @return int - the missing element from array2
	 */
	private static int findMissingElementNLOGN(int[] arr1, int[] arr2) {
		if (arr1.length == arr2.length || Math.abs(arr1.length - arr2.length) >= 2) {
			return -1;
		}
		else {
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			
			int missingElement = -1;
			for (int currEl: arr1) {
				if (Arrays.binarySearch(arr2, currEl) <= 0) {
					missingElement = currEl;
				}
			}
			return missingElement;
		}
	}
	
	/**
	 * This is done in O(N) time complexity with HashSet additions finding the missing element
	 * 
	 * @param arr1
	 * @param arr2
	 * @return int - the missing element from arr2
	 */
	private static int findMissingElementN(int[] arr1, int[] arr2) {
		if (arr1.length == arr2.length || Math.abs(arr1.length - arr2.length) >= 2) {
			return -1;
		}
		else {
			Set<Integer> arr2Elements = new HashSet<Integer>(0);
			for (int currEl: arr2) {
				arr2Elements.add(currEl);
			}
			
			int missingElement = -1;
			for (int currEl: arr1) {
				if (arr2Elements.add(currEl)) {
					return currEl;
				}
			}
			return missingElement;
		}
	}
	
}
