import java.util.HashMap;
import java.util.Map;

public class FindEvenOccuringElement {

	/**
	 * Write a function that finds an even occurring element in an array
	 */
	
	public static void main(String[] args) {
		System.out.println(findEvenOccurringElement(new String[] {"a", "a", "b", "a", "help", "feet", "help"}));
	}
	
	private static <T> T findEvenOccurringElement(T[] elements) {
		Map<T, Integer> elementCountMap = new HashMap<T, Integer>();
		for (T currEl: elements) {
			int elCount = elementCountMap.containsKey(currEl) ? elementCountMap.get(currEl) : 0;
			elementCountMap.put(currEl, elCount+1);
		}
		
		for (Map.Entry<T, Integer> entry: elementCountMap.entrySet()) {
			if (entry.getValue() % 2 == 0) {
				return entry.getKey();
			}
		}
		return null;
	}
	
}
