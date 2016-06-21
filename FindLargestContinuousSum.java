public class FindLargestContinuousSum {

	/**
	 * Write a function that finds the largest continuous sum. If the sum dips below 0, start a new sum
	 */
	
	public static void main(String[] args) {
		int[] largestSum = findLargestSum(new int[] {-40,1,40,-50,1,50,-20,1,20,0,0});
		
		if (largestSum[1] != largestSum[2]) {
			System.out.println(largestSum[0] + " is the largest sum and the sequence starts at index " 
				+ largestSum[1] + " and ends at index " + (largestSum[2] - 1));
		}
		else {
			System.out.println(largestSum[0] + " was a single integer value, the largest sum,"
					+ " and was found at index " + largestSum[1]);
		}
	}
	
	private static int[] findLargestSum(int[] array) {
		if (array.length == 0) {
			throw new IllegalArgumentException("Array has no elements");
		}
		
		int sequenceStartIndex = 0;
		int currentSum         = array[0];
		int[] maxSumInfo       = new int[] {array[0], 0, 0};
		
		for (int i=1; i<array.length; i++) {
			if (maxSumInfo[0] < currentSum + array[i]) {
				currentSum += array[i];
			}
			else {
				if (maxSumInfo[0] < currentSum) {
					maxSumInfo[0] = currentSum;
					maxSumInfo[1] = sequenceStartIndex;
					maxSumInfo[2] = i;
					
					currentSum         = array[i];
					sequenceStartIndex = i;
				}
			}
			if (i == array.length-1 && maxSumInfo[0] < currentSum) {
				maxSumInfo[0] = currentSum;
				maxSumInfo[1] = sequenceStartIndex;
				maxSumInfo[2] = i;
			}
		}
		return maxSumInfo;
	}
}
