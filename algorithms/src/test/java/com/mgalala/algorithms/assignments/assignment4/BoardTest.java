/**
 * 
 */
package com.mgalala.algorithms.assignments.assignment4;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mgalala
 *
 */
public class BoardTest {

	@Test
	public void testHamming() {
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
		Assert.assertEquals(4, board.hamming());
	}

	@Test
	public void testManhattan() {
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
		Assert.assertEquals(4, board.manhattan());
	}
}
