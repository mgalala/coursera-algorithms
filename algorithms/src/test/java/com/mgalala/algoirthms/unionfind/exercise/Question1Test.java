/**
 * 
 */
package com.mgalala.algoirthms.unionfind.exercise;

import org.junit.Assert;
import org.junit.Test;

import com.mgalala.algorithms.unionfind.excersie.Question1;

/**
 * @author mgalala
 *
 */
public class Question1Test {

	private Question1 weightedQuickUnion;

	@Test
	public void testWeightedUnionFind() {
		weightedQuickUnion = new Question1(10);
		weightedQuickUnion.union(0, 5);
		weightedQuickUnion.union(0, 6);
		weightedQuickUnion.union(7, 2);
		weightedQuickUnion.union(2, 0);
		weightedQuickUnion.union(9, 0);
		weightedQuickUnion.union(7, 3);

		Assert.assertEquals(7, weightedQuickUnion.getCount());
	}
}
