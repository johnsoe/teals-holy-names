import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class ArrayUtilTest {
	
	@Test
	public void testLastIndexOf() {
		int[] values = {0, 1, 2, 3, 4};
		assertEquals(0, ArrayUtil.lastIndexOf(values, 0));
		assertEquals(2, ArrayUtil.lastIndexOf(values, 2));
	}
	
	@Test
	public void testRepeatValuesOfLastIndex() {
		int[] values = {0, 3, 3, 4, 5};
		assertEquals(2, ArrayUtil.lastIndexOf(values, 3));
	}
	
	@Test
	public void searchTermNotFound() {
		int[] values = {0, 1, 2, 4, 5};
		assertEquals(-1, ArrayUtil.lastIndexOf(values, 17));
	}
	
	@Test
	public void testRangeOfArray() {
		int range = ArrayUtil.range(new int[]{1, 2, 3, 4});
		assertEquals(3, range);
		
		range = ArrayUtil.range(new int[]{100, 40, -29, 0, 12});
		assertEquals(129, range);
	}
	
	@Test
	public void testRangeOfArrayLengthOne() {
		assertEquals(0, ArrayUtil.range(new int[]{15}));
		assertEquals(0, ArrayUtil.range(new int[]{277}));
	}
}
