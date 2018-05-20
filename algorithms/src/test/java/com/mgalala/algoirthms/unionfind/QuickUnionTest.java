/**
 * 
 */
package com.mgalala.algoirthms.unionfind;

import org.junit.Assert;
import org.junit.Test;

import com.mgalala.algorithms.unionfind.QuickUnion;
import com.mgalala.algorithms.unionfind.WeightedQuickUnion;

/**
 * @author mgalala
 *
 */
public class QuickUnionTest {
	private QuickUnion quickUnion;

	private WeightedQuickUnion weightedQuickUnion;

	@Test
	public void testUnionFind() {
		quickUnion = new QuickUnion(10);
		quickUnion.union(0, 5);
		quickUnion.union(0, 6);
		Assert.assertTrue(quickUnion.connected(0, 5));
		Assert.assertTrue(quickUnion.connected(0, 6));

		Assert.assertFalse(quickUnion.connected(0, 7));

		quickUnion.union(7, 2);
		quickUnion.union(2, 0);
		quickUnion.union(9, 0);
		quickUnion.union(7, 3);
		Assert.assertTrue(quickUnion.connected(9, 3));
		for (int i = 0; i < quickUnion.getId().length; i++) {
			System.out.print(quickUnion.getId()[i] + " ");
		}
		System.out.println("end of quick union");
	}

	@Test
	public void testWeightedUnionFind() {
		weightedQuickUnion = new WeightedQuickUnion(10);
		weightedQuickUnion.union(0, 5);
		weightedQuickUnion.union(0, 6);
		Assert.assertTrue(weightedQuickUnion.connected(0, 5));
		Assert.assertTrue(weightedQuickUnion.connected(0, 6));

		Assert.assertFalse(weightedQuickUnion.connected(0, 7));

		weightedQuickUnion.union(7, 2);
		weightedQuickUnion.union(2, 0);
		weightedQuickUnion.union(9, 0);
		weightedQuickUnion.union(7, 3);
		Assert.assertTrue(weightedQuickUnion.connected(9, 3));
		for (int i = 0; i < weightedQuickUnion.getId().length; i++) {
			System.out.print(weightedQuickUnion.getId()[i] + " ");
		}

		for (int i = 0; i < weightedQuickUnion.getSize().length; i++) {
			System.out.println("size of " + i + " is: " + weightedQuickUnion.getSize()[i] + " ");
		}

		System.out.println("end of weighted quick union");

	}
}
