/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */


import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] material;
    private final WeightedQuickUnionUF wqu;
    private final WeightedQuickUnionUF wquFull;
    private int openBlocks;
    private final int materialSize;
    private final int virtualTop;
    private final int virtualBottom;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        materialSize = n;
        int materialSizeSquared = n * n;
        material = new boolean[n][n];
        wqu = new WeightedQuickUnionUF(materialSizeSquared + 2);
        wquFull = new WeightedQuickUnionUF(materialSizeSquared + 1);
        virtualTop = materialSizeSquared;
        virtualBottom = materialSizeSquared + 1;
        openBlocks = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            int shiftedRow = row - 1;
            int shiftedCol = col - 1;
            int flattenMaterialIndex = flattenMaterial(shiftedRow, shiftedCol);
            material[shiftedRow][shiftedCol] = true;
            openBlocks++;
            // top
            if (shiftedRow == 0) {
                wqu.union(virtualTop, shiftedCol);
                wquFull.union(virtualTop, shiftedCol);
            }
            // bottom
            if (row == materialSize)
                wqu.union(virtualBottom, flattenMaterialIndex);
            // upper
            if (shiftedRow != 0 && isOpen(row - 1, col)) {
                wqu.union(flattenMaterial(shiftedRow - 1, shiftedCol), flattenMaterialIndex);
                wquFull.union(flattenMaterial(shiftedRow - 1, shiftedCol), flattenMaterialIndex);
            }
            // left
            if (shiftedCol != 0 && isOpen(row, col - 1)) {
                wqu.union(flattenMaterial(shiftedRow, shiftedCol - 1), flattenMaterialIndex);
                wquFull.union(flattenMaterial(shiftedRow, shiftedCol - 1), flattenMaterialIndex);
            }
            // right
            if (col != materialSize && isOpen(row, col + 1)) {
                wqu.union(flattenMaterial(shiftedRow, shiftedCol + 1), flattenMaterialIndex);
                wquFull.union(flattenMaterial(shiftedRow, shiftedCol + 1), flattenMaterialIndex);
            }
            // down
            if (row != materialSize && isOpen(row + 1, col)) {
                wqu.union(flattenMaterial(shiftedRow + 1, shiftedCol), flattenMaterialIndex);
                wquFull.union(flattenMaterial(shiftedRow + 1, shiftedCol), flattenMaterialIndex);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || col < 1 || row > materialSize || col > materialSize)
            throw new IllegalArgumentException();
        return material[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return isOpen(row, col) && /* wqu.connected((row - 1) * materialSize + col - 1,
                                                 virtualTop);*/
                (wquFull.find((row - 1) * materialSize + col - 1) == wquFull.find(virtualTop));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openBlocks;
    }

    // does the system percolate?
    public boolean percolates() {
        return // wqu.connected(virtualTop, virtualBottom);
                (wqu.find(virtualBottom) == wqu.find(virtualTop));
    }

    private int flattenMaterial(int shiftedRow, int shiftedCol) {
        return shiftedRow * materialSize + shiftedCol;
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(4); // StdIn.readInt()
        int i = 1;
        while (i <= 3) { // !StdIn.isEmpty()
            p.open(i++, 1); // StdIn.readInt();
        }
        p.open(2, 2);
        p.open(3, 2);
        p.open(2, 3);
        p.open(2, 4);
        p.open(3, 4);
        p.open(4, 4);
        System.out.println(p.percolates());

    }
}
