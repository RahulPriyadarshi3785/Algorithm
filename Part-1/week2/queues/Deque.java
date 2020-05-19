/* *****************************************************************************
 *  Name: Rahul Priyadarshi
 *  Date: 18/05/2020
 *  Description: Learning Queues again
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size;

    private class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private final T data;

        private Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
            size++;
        }
    }

    private class MyListIterator implements Iterator<Item> {
        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current != null;
        }

        @Override
        public Item next() {
            // TODO Auto-generated method stub
            if (current == null)
                throw new NoSuchElementException();
            Item currentItem = current.data;
            current = current.next;
            return currentItem;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // construct an empty deque
    public Deque() {
        // No-arg constructor
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        Node<Item> node = first;
        first = new Node<>(item, first, null);
        if (size != 1)
            node.prev = first;
        else
            last = first;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException();
        Node<Item> node = last;
        last = new Node<>(item, null, last);
        if (size != 1)
            node.next = last;
        else
            first = last;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        Node<Item> temp = first;
        if (size == 1) {
            first = null;
            last = null;
            size--;
            return temp.data;
        }
        first = first.next;
        temp.next = null;
        first.prev = null;
        size--;
        return temp.data;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size == 0)
            throw new NoSuchElementException();
        Node<Item> temp = last;
        if (size == 1) {
            first = null;
            last = null;
            size--;
            return temp.data;
        }
        last = last.prev;
        temp.prev = null;
        last.next = null;
        size--;
        return temp.data;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new MyListIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        StdOut.println(deque.isEmpty());
        deque.addLast(12);
        deque.addFirst(10);
        deque.addFirst(9);
        deque.addLast(13);
        for (Integer integer : deque) {
            StdOut.print(integer + " -> ");
        }
        StdOut.println(deque.size());
        StdOut.println(deque.removeFirst());
        StdOut.println(deque.removeLast());
        deque.addLast(100);
        deque.addLast(Integer.MAX_VALUE);
        deque.addFirst(Integer.MIN_VALUE);
        for (Integer integer : deque) {
            StdOut.print(integer + " -> ");
        }
        StdOut.println();
        // test();
    }

    // private static void test() {
    //     Deque<Integer> deque = new Deque<Integer>();
    //     deque.addLast(1);
    //     deque.addFirst(2);
    //     deque.addLast(3);
    //     deque.addFirst(4);
    //     StdOut.println(deque.removeLast());
    //     for (Integer integer : deque) {
    //         StdOut.print(integer + " -> ");
    //     }
    //     StdOut.println();
    // }

}
