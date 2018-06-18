package com.mgalala.algorithms.assignments.assignment4;

import java.util.Arrays;

import edu.princeton.cs.algs4.Queue;

public class Board {
	private int[][] blocks;
	private int dimension;

	public Board(int[][] input) {
		// construct a board from an n-by-n array of blocks
		if (input == null)
			throw new IllegalArgumentException();

		dimension = input[0].length;
		copyBoard(input);
	}

	private void copyBoard(int[][] input) {
		blocks = new int[dimension][];
		for (int i = 0; i < input.length; i++) {
			blocks[i] = new int[input[i].length];
			for (int j = 0; j < input[i].length; j++) {
				blocks[i][j] = input[i][j];
			}
		}
	}

	// (where blocks[i][j] = block in row i, column j)
	public int dimension() {
		// board dimension n
		return dimension;
	}

	public int hamming() {
		// number of blocks out of place
		return calculateHamming();

	}

	private int calculateHamming() {
		int hamming = 0;
		for (int i = 0; i < blocks.length; i++) {
			int[] js = blocks[i];
			for (int j = 0; j < js.length; j++) {
				int iAndJ = js[j];
				int goalValue = getGoalValue(i, j);
				// System.out.println(iAndJ + " is in the " + goalValue);
				if (iAndJ != goalValue && iAndJ != 0) {
					hamming++;
				}
			}
		}

		return hamming;
	}

	public int manhattan() {
		// sum of Manhattan distances between blocks and goal
		int manhattan = 0;

		for (int i = 0; i < blocks.length; i++) {
			int[] js = blocks[i];
			for (int j = 0; j < js.length; j++) {
				int currentValue = js[j];
				int expectedValue = getGoalValue(i, j);

				// System.out.println(currentValue + " is in the " + expectedValue);
				if (currentValue != expectedValue && currentValue != 0) {
					int goalI = 0;
					int goalJ = 0;
					while (goalI < dimension) {
						goalJ = currentValue - (goalI * dimension) - 1;
						if (goalJ >= 0 && goalJ < dimension) {
							break;
						}
						goalI++;
					}
					int rowMoves = Math.abs(i - goalI);
					int columnMoves = Math.abs(j - goalJ);
					manhattan = manhattan + (rowMoves + columnMoves);
				}
			}
		}

		return manhattan;

	}

	private int getGoalValue(int i, int j) {
		return (i * dimension) + j + 1;
	}

	public boolean isGoal() {
		// is this board the goal board?
		return manhattan() == 0;
	}

	public Board twin() {
		// a board that is obtained by exchanging any pair of blocks

		int temp = 0;
		Board twin = new Board(blocks);
		if (blocks[0][0] != 0 && blocks[0][1] != 0) {
			temp = twin.blocks[0][0];
			twin.blocks[0][0] = twin.blocks[0][1];
			twin.blocks[0][1] = temp;
		} else {
			temp = twin.blocks[1][0];
			twin.blocks[1][0] = twin.blocks[1][1];
			twin.blocks[1][1] = temp;
		}
		return twin;
	}

	public boolean equals(Object y) {
		// does this board equal y?
		if (this == y)
			return true;
		if (y == null)
			return false;
		if (!(y instanceof Board))
			return false;
		Board other = (Board) y;
		if (!Arrays.deepEquals(this.blocks, other.blocks))
			return false;
		return true;
	}

	public Iterable<Board> neighbors() {
		// all neighboring boards
		Queue<Board> queue = new Queue<Board>();

		int[][] zeroBlock = findZeroBlock();
		int row = zeroBlock[0][0];
		int col = zeroBlock[0][1];

		if (row > 0) {
			int[][] blocksCopy = copyArray(blocks);
			swap(blocksCopy, row, col, row - 1, col);
			queue.enqueue(new Board(blocksCopy));
		}

		if (row < blocks.length - 1) {
			int[][] blocksCopy = copyArray(blocks);
			swap(blocksCopy, row, col, row + 1, col);
			queue.enqueue(new Board(blocksCopy));
		}

		if (col > 0) {
			int[][] blocksCopy = copyArray(blocks);
			swap(blocksCopy, row, col, row, col - 1);
			queue.enqueue(new Board(blocksCopy));
		}

		if (col < blocks.length - 1) {
			int[][] blocksCopy = copyArray(blocks);
			swap(blocksCopy, row, col, row, col + 1);
			queue.enqueue(new Board(blocksCopy));
		}

		return queue;
	}

	private int[][] findZeroBlock() {
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks.length; j++) {
				if (blocks[i][j] == 0) {
					return new int[][] { { i, j } };
				}
			}
		}
		return null;
	}

	private static int[][] copyArray(int[][] input) {
		int[][] copy = new int[input.length][input[0].length];
		for (int i = 0; i < input.length; i++) {
			copy[i] = Arrays.copyOf(input[i], input[i].length);
		}
		return copy;
	}

	private void swap(int[][] copy, int row, int col, int newRow, int newCol) {
		int tmp = copy[row][col];
		copy[row][col] = copy[newRow][newCol];
		copy[newRow][newCol] = tmp;
	}

	public String toString() {
		// string representation of this board (in the output format specified below)
		StringBuilder s = new StringBuilder();
		int n = dimension;
		s.append(dimension + "\n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				s.append(String.format("%2d ", blocks[i][j]));
			}
			s.append("\n");
		}
		return s.toString();
	}

	public static void main(String[] args) {
		// 0 1 3
		// 4 2 5
		// 7 8 6

		int[][] input = new int[3][3];
		input[0][0] = 0;
		input[0][1] = 1;
		input[0][2] = 3;
		input[1][0] = 4;
		input[1][1] = 2;
		input[1][2] = 5;
		input[2][0] = 7;
		input[2][1] = 8;
		input[2][2] = 6;

		Board board = new Board(input);
		System.out.println(board.hamming());
		System.out.println(board.manhattan());
	}
}