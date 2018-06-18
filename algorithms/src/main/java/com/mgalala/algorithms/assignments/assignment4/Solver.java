package com.mgalala.algorithms.assignments.assignment4;

import java.util.Comparator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {

	private SolutionNode solutionNode;
	private Stack<Board> solutionStack;

	public Solver(Board board) {
		if (board == null)
			throw new IllegalArgumentException();
		solve(board);
	}

	public Iterable<Board> solution() {
		if (solutionNode == null)
			return null;
		if (solutionStack != null)
			return solutionStack;
		solutionStack = new Stack<>();
		for (SolutionNode s = solutionNode; s != null; s = s.previous) {
			solutionStack.push(s.board);
		}
		return solutionStack;
	}

	public boolean isSolvable() {
		return solutionNode != null;
	}

	public int moves() {
		if (isSolvable())
			return solutionNode.moves;
		return -1;
	}

	private void solve(Board inputBoard) {
		SolutionNode twinBoardSolution = new SolutionNode(inputBoard.twin(), null, 0);
		SolutionNode originalBoardSolution = new SolutionNode(inputBoard, null, 0);

		MinPQ<SolutionNode> pq = new MinPQ<>(newManhattanComparator());
		MinPQ<SolutionNode> twinPq = new MinPQ<>(newManhattanComparator());

		while (!originalBoardSolution.board.isGoal() && !twinBoardSolution.board.isGoal()) {
			for (Board board : originalBoardSolution.board.neighbors()) {
				if ((originalBoardSolution.previous == null) || (!board.equals(originalBoardSolution.previous.board)))
					pq.insert(new SolutionNode(board, originalBoardSolution, originalBoardSolution.moves + 1));
			}
			originalBoardSolution = pq.delMin();
			for (Board board : twinBoardSolution.board.neighbors()) {
				if ((twinBoardSolution.previous == null) || (!board.equals(twinBoardSolution.previous.board)))
					twinPq.insert(new SolutionNode(board, twinBoardSolution, twinBoardSolution.moves + 1));
			}
			twinBoardSolution = twinPq.delMin();
		}
		if (originalBoardSolution.board.isGoal())
			solutionNode = originalBoardSolution;
	}

	private Comparator<SolutionNode> newManhattanComparator() {
		return (s1, s2) -> (s1.manhattan + s1.moves) - (s2.manhattan + s2.moves);
	}

	private class SolutionNode {
		Board board;
		SolutionNode previous;
		int moves;
		int manhattan;

		SolutionNode(Board board, SolutionNode prev, int moves) {
			this.board = board;
			previous = prev;
			this.moves = moves;
			this.manhattan = this.board.manhattan();
		}
	}

	public static void main(String[] args) {
		// int[][] input = new int[3][3];
		// input[0][0] = 0;
		// input[0][1] = 1;
		// input[0][2] = 3;
		// input[1][0] = 4;
		// input[1][1] = 2;
		// input[1][2] = 5;
		// input[2][0] = 7;
		// input[2][1] = 8;
		// input[2][2] = 6;
		// Board initial = new Board(input);
		//
		// // solve the puzzle
		// Solver solver = new Solver(initial);
		//
		// // print solution to standard output
		// if (!solver.isSolvable())
		// System.out.println("No solution possible");
		// else {
		// System.out.println("Minimum number of moves = " + solver.moves());
		// for (Board board : solver.solution()) {
		// System.out.println(board);
		// }
		//
		// }

		In in = new In(args[0]);
		int n = in.readInt();
		int[][] blocks = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				blocks[i][j] = in.readInt();
		Board initial = new Board(blocks);

		Solver solver = new Solver(initial);

		if (!solver.isSolvable())
			StdOut.println("No solution possible");
		else {
			StdOut.println("Minimum number of moves = " + solver.moves());
			for (Board board : solver.solution())
				StdOut.println(board);
		}
	}
}