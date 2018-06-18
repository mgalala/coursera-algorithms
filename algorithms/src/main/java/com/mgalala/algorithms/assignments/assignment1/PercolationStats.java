package com.mgalala.algorithms.assignments.assignment1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private double[] results;
	Percolation perc;

	public PercolationStats(int n, int trials) {
		// perform trials independent experiments on an n-by-n grid
		if (trials <= 0)
			throw new IllegalArgumentException("Please specify a positive integer to carry out the experiments!");
		results = new double[trials];
		perc = new Percolation(n);
		for (int i = 0; i < trials; i++) {
			results[i] = simulate(n, true);
		}
	}

	public double mean() {
		// sample mean of percolation threshold
		return StdStats.mean(results);
	}

	public double stddev() {
		// sample standard deviation of percolation threshold
		return StdStats.stddev(results);
	}

	public double confidenceLo() {
		// low endpoint of 95% confidence interval
		return mean() - 1.96 * stddev() / Math.sqrt(results.length);
	}

	public double confidenceHi() {
		// high endpoint of 95% confidence interval
		return mean() + 1.96 * stddev() / Math.sqrt(results.length);
	}

	public static void main(String[] args) {
		// test client (described below)
		int n = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);

		PercolationStats percolationStats = new PercolationStats(n, trials);
		StdOut.printf("mean = %f%n", percolationStats.mean());
		StdOut.printf("stddev = %f%n", percolationStats.stddev());
		StdOut.printf("95%% confidence interval = %f, %f%n", percolationStats.confidenceLo(),
				percolationStats.confidenceHi());
	}

	public double simulate(int sideSize, boolean print) {
		while (!perc.percolates()) {
			int i = StdRandom.uniform(sideSize) + 1;
			int j = StdRandom.uniform(sideSize) + 1;
			while (perc.isOpen(i, j)) {
				i = StdRandom.uniform(sideSize) + 1;
				j = StdRandom.uniform(sideSize) + 1;
			}
			if (print)
				System.out.println("Open " + i + "," + j);
			perc.open(i, j);
		}
		return (double) (perc.numberOfOpenSites()) / (double) (sideSize * sideSize);
	}

}