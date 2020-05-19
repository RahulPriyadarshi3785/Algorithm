/* *****************************************************************************
 *  Name: Rahul Priyadarshi
 *  Date: 18/05/2020
 *  Description: Learning Queues again
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] randomizedQueue;
    private int size;
    private int rear;
    private int front;

    private class RandomizedQueueIterator implements Iterator<Item> {

        private final int[] randomizedIndex;
        private int current;

        private RandomizedQueueIterator() {
            randomizedIndex = new int[size];
            for (int i = 0; i < size; i++)
                randomizedIndex[i] = (rear + i) % randomizedQueue.length;
            current = 0;
            StdRandom.shuffle(randomizedIndex);
        }

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return randomizedQueue[randomizedIndex[current++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // construct an empty randomized queue
    public RandomizedQueue() {
        // No-arg Constructor
        randomizedQueue = (Item[]) new Object[2];
        rear = -1;
        front = -1;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        else if (size == 0)
            rear = 0;
        else if (size == randomizedQueue.length)
            randomizedQueue = resize(size << 1);

        randomizedQueue[++front % randomizedQueue.length] = item;
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0)
            throw new NoSuchElementException();
        Item result;
        if (size == 1) {
            result = randomizedQueue[rear];
            randomizedQueue[rear] = null;
            rear = -1;
            front = -1;
        }
        else {
            if (size <= randomizedQueue.length >>> 2)
                randomizedQueue = resize(randomizedQueue.length >>> 1);

            int randomIndex = (rear + StdRandom.uniform(size)) % randomizedQueue.length;
            result = randomizedQueue[randomIndex];
            randomizedQueue[randomIndex] = randomizedQueue[rear];
            randomizedQueue[rear] = null;
            rear = (rear + 1) % randomizedQueue.length;
        }
        size--;
        return result;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0)
            throw new NoSuchElementException();
        if (size == 1)
            return randomizedQueue[rear];
        else
            return randomizedQueue[(rear + StdRandom.uniform(size)) % randomizedQueue.length];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> r = new RandomizedQueue<>();
        StdOut.println(r.isEmpty());
        StdOut.println(r.size());
        for (int i = 3; i > 0; i--) {
            r.enqueue(i);
        }
        StdOut.println("Element : " + r.dequeue());
        StdOut.println("Element : " + r.dequeue());
        for (int i = 3; i > 0; i--)
            r.enqueue(i);
        r.enqueue(10);
        StdOut.println(r.sample());
        StdOut.println("Element : " + r.dequeue());
        StdOut.println("Element : " + r.dequeue());
        StdOut.println("Element : " + r.dequeue());
        StdOut.println("Element : " + r.dequeue());
        r.helper();
        StdOut.println(r.sample());
        StdOut.println("-------------");
        for (int i = 3; i >= 0; i--)
            r.enqueue(i);
        r.helper();
        r.dequeue();
        StdOut.print("Elements : ");
        for (Integer i : r) {
            StdOut.print(i + " -> ");
        }
        StdOut.println();
        r.dequeue();
        r.dequeue();
        r.dequeue();
        r.dequeue();
        for (Integer i : r) {
            StdOut.print(i + " -> ");
        }
        StdOut.println();
        r.helper();
    }

    private void helper() {
        StdOut.println("Front : " + front);
        StdOut.println("Rear : " + rear);
        for (Item i : randomizedQueue)
            StdOut.print(i + " -> ");
        StdOut.println();
        StdOut.println("size : " + size);
    }

    private Item[] resize(int newCapacity) {
        Item[] tempQueueOfItems = (Item[]) new Object[newCapacity];
        for (int i = 0; i < size; i++, rear = (rear + 1) % randomizedQueue.length) {
            tempQueueOfItems[i] = randomizedQueue[rear];
        }
        rear = 0;
        front = size - 1;
        return tempQueueOfItems;
    }


}
