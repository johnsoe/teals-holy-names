package main;

public class LinkedIntList /*implements List*/{

	private Node front;

	public boolean isEmpty() {
		return front == null;
	}
	
	public void insert(int value) {
		front = new Node(value, front);
	}
	
	public int getFront() {
		if(isEmpty())
			throw new IllegalStateException("Can't get front when list is empty");
		return front.data;
	}
	
	//TODO Write the add method
	//lookup Java API for List interface for more information
	public void add(int index, int value) {

	}
	
	//TODO Write the contains method
	//lookup Java API for List interface for more information
	public boolean contains(int value) {
		return false;
	}
	
	//TODO Write the remove method
	//lookup Java API for List interface for more information
	public int remove(int index) {
		return 0;
	}
	
	//TODO Write the lastIndexOf method
	//lookup Java API for List interface for more information
	public int lastIndexOf(int value) {
		return 0;
	}
	
	//TODO Write the size method
	//lookup Java API for List interface for more information
	public int size() {
		return 0;
	}
}