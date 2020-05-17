package Week2;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class QueueLL<T> implements Iterable<T> {
	
	Nodes<T> rear;
	Nodes<T> front;
	int size = 0;

	private class Nodes<E> {

		Nodes<E> next;
		E data;
		
		public Nodes(E data) {
			this.data = data;
			this.next = null;
		}
		
	}
	
	private class ListIterator implements Iterator<T>{

		private Nodes<T> current = rear;
		
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
	
	public QueueLL() {
		// TODO Auto-generated constructor stub
	}
	
	public void enqueue(T data) {
			Nodes<T> node = new Nodes<>(data);
			if(rear == null)
				rear = front = node;
			else {
				front.next = node;
				front = node;
			}
			size++;
	}
	
	public T dequeue() {
		if(isEmpty())
			throw new NoSuchElementException("Queue is Empty");
		T res = rear.data;
		Nodes<T> temp = rear;
		rear = rear.next;
		temp.next = null;
		temp = null;
		size--;
		return res;
	}
	
	public T peek() {
		if(isEmpty())
			throw new NoSuchElementException("Queue is Empty");
		return rear.data;
	}
	
	public boolean isEmpty() {
		return rear == null;
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
