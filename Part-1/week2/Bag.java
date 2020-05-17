package Week2;

import java.util.Iterator;
import java.util.NoSuchElementException;




public class Bag<T> implements Iterable<T> {

	
	private T[] bagOfItems;
	private int size;
	

	private class ArrayIterator implements Iterator<T> {

		private int i = 0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i < size;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if(i >= size)
				throw new NoSuchElementException("Next element in bag is not present");
			return bagOfItems[i++];
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public Bag(int capacity) {
		if(capacity < 1)
			throw new IllegalArgumentException("Capacity must be greater than or equal to 1");
		bagOfItems = (T[])new Object[capacity];
	}

	
	public void push(T data) {
		if(size() == bagOfItems.length)
			bagOfItems = resize(bagOfItems, bagOfItems.length << 1); //stackOfItems.length * 2 + 1
		bagOfItems[size++] = data;
	}
	
	public int size() {
		return size;
	}
	

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator();
	}
	

	private T[] resize(T[] stackOfItems, int newCapacity) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		T[] tempBagOfItems = (T[])new Object[newCapacity];
		for(int i = 0; i < size; i++)
			tempBagOfItems[i] = stackOfItems[i];
		return tempBagOfItems;
	}
	
 
}
