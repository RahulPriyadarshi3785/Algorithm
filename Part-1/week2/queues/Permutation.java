/* *****************************************************************************
 *  Name: Rahul Priyadarshi
 *  Date: 18/05/2020
 *  Description: Learning Queues again
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        RandomizedQueue<String> r = new RandomizedQueue<>();
        while (!StdIn.isEmpty())
            r.enqueue(StdIn.readString());
        for (int i = 0; i < x; i++)
            StdOut.println(r.dequeue());
    }

}
