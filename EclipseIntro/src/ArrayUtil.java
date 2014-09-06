
public class ArrayUtil {
	
	/* 
	 * @param values array to look through
	 * @param search term to look for in values
	 * @return last index of the search value given
	 */
	public static int lastIndexOf(int[] values, int search) {
		for(int i = values.length - 1; i >= 0; i--) {
			if(values[i] == search)
				return i;
		}
		return -1;
	}
	
	/*
	 * TODO: Write a static method called range that takes an array of integers
	 * and returns the range of values in that array. For example an array of 
	 * [1, 5, 17, 12] would return 17 - 1 -> 16. See tests for more info on how this
	 * method behaves. You may assume the given array has at least one value. 
	 */
	
}
