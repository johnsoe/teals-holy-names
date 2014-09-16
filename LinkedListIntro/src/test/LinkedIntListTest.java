package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import main.LinkedIntList;

import org.junit.Before;
import org.junit.Test;

public class LinkedIntListTest {

	private LinkedIntList list;
	
	@Before
	public void setup() {
		list = new LinkedIntList();
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(list.isEmpty());
		list.insert(5);
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testInsert() {
		list.insert(5);
		assertEquals(5, list.getFront());
		list.insert(-12);
		assertEquals(-12, list.getFront());
	}
	
	@Test
	public void testGetFrontWhenEmptyThrowsError() {
		try {
			list.getFront();
			fail("No error was thrown");
		} catch (Exception e) {}
	}
	
	@Test
	public void addThrowsExceptionWhenGivenInvalidIndex() {
		testException(12); //Greater than current size;
		testException(-1); //-1 is invalid index;
	}
	
	private void testException(int index) {
		try{
			list.add(index, 0);
			fail("Expected an IndexOutOfBoundsException");
		} catch(Exception e) {}
	}
	
	public void testContains() {
		list.insert(5);
		list.insert(12);
		list.insert(-7);
		
		assertTrue(list.contains(5));
		assertTrue(list.contains(-7));
		assertFalse(list.contains(15));
		assertFalse(list.contains(0));
	}
	
	@Test
	public void testSize() {
		assertEquals(0, list.size());
		list.insert(1);
		assertEquals(1, list.size());
		list.add(1, 2);
		assertEquals(2, list.size());
		list.remove(1);
		assertEquals(1, list.size());
	}
}
