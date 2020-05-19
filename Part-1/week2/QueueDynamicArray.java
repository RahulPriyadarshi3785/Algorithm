package Week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueDynamicArray<T> implements Iterable<T> {

	private T[] queueOfItems;
	private int size; //size = (rear < front ? 0 : 1) * queueOfItems.length + front - rear + 1;
	private int front, rear;
	
	
	private class QueueIterator implements Iterator<T> {

		private int current = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current < size;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if(current >= size)
				throw new NoSuchElementException("Next element in queue is not present");
			return queueOfItems[(current++ + rear) % queueOfItems.length];
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public QueueDynamicArray(int capacity) {
		if(capacity < 1)
			throw new IllegalArgumentException("Capacity must be greater than or equal to 1");
		queueOfItems = (T[]) new Object[capacity];
		front = -1;
		rear = -1;
	}

	public void enqueue(T data) {
		if(isEmpty())
			rear = 0;
		// (front + 1) % queueOfItems.length == rear is equal to size == queueOfItems.length
		else if(size() == queueOfItems.length)
			queueOfItems = resize(queueOfItems.length << 1); // queueOfItems.length * 2
		queueOfItems[++front] = data;
		size++;
	}

	public T dequeue() {
		if(isEmpty())
			throw new IllegalStateException("Queue is Empty");
		
		T result = queueOfItems[rear];
		// size = 1
		if(rear == front)
			rear = front = -1;
		// resetting rear i.e. dequeue operation
		rear = (++rear) % queueOfItems.length;
		int threshold = 100;
		// resizing if size is capacity / 4 and size is greater than threshold 
		if(size() == queueOfItems.length >>> 2 && queueOfItems.length > threshold) // queueOfItems.length / 4
			queueOfItems = resize(queueOfItems.length >>> 1);// queueOfItems.length / 2
		size--;
		return result;
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return rear == -1;
	}

	public int size() {
		// TODO Auto-generated method stub
//		return (rear < front ? 0 : 1) * queueOfItems.length + front - rear + 1;
		return size;
	}
	
	public T peek() {
		if(isEmpty())
			throw new IllegalStateException("Queue is Empty");
		
		return queueOfItems[rear];
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new QueueIterator();
	}

	
	private T[] resize(int newCapacity) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		T[] tempQueueOfItems = (T[]) new Object[newCapacity];
		for(int i = 0; i < size; i++, rear = (rear + 1) % queueOfItems.length) 
			tempQueueOfItems[i] = queueOfItems[rear];
		rear = 0;
		front = size - 1;
		return tempQueueOfItems;
	}
}
