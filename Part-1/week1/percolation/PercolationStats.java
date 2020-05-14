/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {
    private static final double VAL = 1.96;
    private final double mean;
    private final double stddev;
    private final double confidenceLo;
    private final double confidenceHi;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n < 1 || trials < 1)
            throw new IllegalArgumentException();
        double[] trialProbability = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates())
                percolation.open(StdRandom.uniform(n) + 1, StdRandom.uniform(n) + 1);
            trialProbability[i] = percolation.numberOfOpenSites() / (double) (n * n);
        }
        mean = StdStats.mean(trialProbability);
        stddev = StdStats.stddev(trialProbability);
        confidenceLo = mean - VAL * stddev / Math.sqrt(trials);
        confidenceHi = mean + VAL * stddev / Math.sqrt(trials);
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {

        return confidenceHi;
    }

    public static void main(String[] args) {
        // Test to do
        int x = Integer.parseInt("10");
        StdOut.print(x);
        int y = Integer.parseInt("10");
        x = x * y;
        StdOut.print(x);
    }
}
