package Week2;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackDynamicArray<T> implements Iterable<T> {
	
	private T[] stackOfItems;
	private int size;
	
	
	private class ReverseArrayIterator implements Iterator<T> {

		private int i = size;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i > 0;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if(i == 0)
				throw new NoSuchElementException("Next element in stack is not present");
			return stackOfItems[--i];
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public StackDynamicArray(int capacity) {
		if(capacity < 1)
			throw new IllegalArgumentException("Capacity must be greater than or equal to 1");
		stackOfItems = (T[])new Object[capacity];
	}

	
	public void push(T data) {
		if(size() == stackOfItems.length)
			stackOfItems = resize(stackOfItems, stackOfItems.length << 1); //stackOfItems.length * 2 + 1
		stackOfItems[size++] = data;
	}

	public T pop() {
		int threshold = 100;
		if(isEmpty())
			throw new EmptyStackException();
		else if(size == stackOfItems.length >>> 2 && stackOfItems.length > threshold) // stackOfItems.length / 4
			stackOfItems = resize(stackOfItems, stackOfItems.length >>> 1); // stackOfItems.length / 2
		T result = stackOfItems[--size];
		return result;
	}
	
	public int size() {
		return size;
	}
	
	public T top() {
		if(isEmpty())
			throw new EmptyStackException();
		return stackOfItems[size - 1];
	}


	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}
	

	private T[] resize(T[] stackOfItems, int newCapacity) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		T[] tempStackOfItems = (T[])new Object[newCapacity];
		for(int i = 0; i < size; i++)
			tempStackOfItems[i] = stackOfItems[i];
		return tempStackOfItems;
	}
	
}
