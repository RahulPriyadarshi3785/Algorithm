package Week2;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackLL<T> implements Iterable<T> {
	
	private Nodes<T> top;
	private int size = 0;
	
	private class Nodes<E> {

		Nodes<E> next;
		E data;
		
		public Nodes(E data) {
			this.data = data;
			this.next = null;
		}
		
	}
	
	private class ListIterator implements Iterator<T>{

		private Nodes<T> current = top;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if(current == null)
				throw new NoSuchElementException("Next element in queue is not present");
			T currentItem = current.data;
			current = current.next;
			return currentItem;
		}
		
	}
	
	public StackLL() {
		// TODO Auto-generated constructor stub
	}
	
	public void push(T data) {
			Nodes<T> node = new Nodes<>(data);
			if(top == null)
				top = node;
			else {
				node.next = top;
				top = node;
			}
			size++;
	}
	
	public T pop() {
		if(isEmpty())
			throw new EmptyStackException();
		T res = top.data;
		Nodes<T> temp = top;
		top = top.next;
		temp.next = null;
		temp = null;
		size--;
		return res;
	}
	
	public T top() {
		if(isEmpty())
			throw new EmptyStackException();
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}
	
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
}
