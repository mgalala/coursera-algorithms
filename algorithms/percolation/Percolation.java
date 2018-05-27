
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] gridState;
    private WeightedQuickUnionUF unionFindPercolater;
    private WeightedQuickUnionUF unionFindFullPercolator;
    private int totalSize;
    private int edgeSize;
    private int numberOfOpenSites;
    private int additionalTopSite;
    private int additionalBottomSite;

    public Percolation(int sideSize) {
        // create n-by-n grid, with all sites blocked
        if (sideSize <= 0)
            throw new java.lang.IllegalArgumentException();

        gridState = new boolean[sideSize][sideSize];
        for (int i = 0; i < sideSize; ++i) {
            for (int j = 0; j < sideSize; ++j) {
                gridState[i][j] = false;
            }
        }
        this.edgeSize = sideSize;

        additionalTopSite = edgeSize * edgeSize;
        additionalBottomSite = edgeSize * edgeSize + 1;

        int area = edgeSize * edgeSize;
        totalSize = area + 2;
        unionFindPercolater = new WeightedQuickUnionUF(totalSize);
        unionFindFullPercolator = new WeightedQuickUnionUF(area + 1);

        connectAdditionalSites(edgeSize);

    }

    private void connectAdditionalSites(int edgeSize) {
        for (int column = 1; column <= edgeSize; column++) {
            unionFindPercolater.union(additionalBottomSite, getIndex(edgeSize, column));
            unionFindPercolater.union(additionalTopSite, getIndex(1, column));
            unionFindFullPercolator.union(additionalTopSite, getIndex(1, column));
        }
    }

    public void open(int row, int col) {
        // open site (row, col) if it is not open already
        gridState[row - 1][col - 1] = true;
        int index = getIndex(row, col);

        if (!isFull(row, col)) {
            numberOfOpenSites++;
        }

        if (row > 1 && isOpen(row - 1, col)) {
            unionFindPercolater.union(getIndex(row - 1, col), index);
            unionFindFullPercolator.union(getIndex(row - 1, col), index);
        }
        if (row < edgeSize && isOpen(row + 1, col)) {
            unionFindPercolater.union(getIndex(row + 1, col), index);
            unionFindFullPercolator.union(getIndex(row + 1, col), index);
        }
        if (col > 1 && isOpen(row, col - 1)) {
            unionFindPercolater.union(getIndex(row, col - 1), index);
            unionFindFullPercolator.union(getIndex(row, col - 1), index);
        }
        if (col < edgeSize && isOpen(row, col + 1)) {
            unionFindPercolater.union(getIndex(row, col + 1), index);
            unionFindFullPercolator.union(getIndex(row, col + 1), index);
        }
    }

    private int getIndex(int row, int col) {
        return (row - 1) * edgeSize + (col - 1);
    }

    public boolean isOpen(int row, int col) {
        // is site (row, col) open?
        return gridState[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        // is site (row, col) full?
        return isOpen(row, col) && unionFindFullPercolator.connected(getIndex(row, col), 0);
    }

    public int numberOfOpenSites() {
        // number of open sites
        return numberOfOpenSites;
    }

    public boolean percolates() {
        // does the system percolate?
        if (edgeSize == 1) {
            return isOpen(1, 1);
        }
        return unionFindPercolater.connected(0, totalSize - 1);
    }

    public static void main(String[] args) {
        // test client (optional)
        Percolation perc = new Percolation(2);
        perc.open(1, 1);
        perc.open(1, 2);
        perc.open(2, 1);
        perc.open(2, 2);
        // perc.open(3, 2);
        // perc.open(2, 2);
        System.out.println(perc.isFull(2, 2));
        System.out.println(perc.numberOfOpenSites());
        System.out.println(perc.percolates());
    }
}