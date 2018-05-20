/**
 * 
 */
package com.mgalala.algoirthms.unionfind.exercise;

import org.junit.Assert;
import org.junit.Test;

import com.mgalala.algorithms.unionfind.excersie.Question2;

/**
 * @author mgalala
 *
 */
public class Question2Test {

	private Question2 weightedQuickUnion;

	@Test
	public void testWeightedUnionFind() {
		weightedQuickUnion = new Question2(10);
		weightedQuickUnion.union(0, 5);
		weightedQuickUnion.union(0, 6);
		weightedQuickUnion.union(7, 2);
		weightedQuickUnion.union(2, 0);
		weightedQuickUnion.union(9, 0);
		weightedQuickUnion.union(7, 3);

		Assert.assertEquals(9, weightedQuickUnion.find(3));
		Assert.assertEquals(1, weightedQuickUnion.find(1));
	}
}
