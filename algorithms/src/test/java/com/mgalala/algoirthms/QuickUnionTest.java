/**
 * 
 */
package com.mgalala.algoirthms;

import org.junit.Assert;
import org.junit.Test;

import com.mgalala.algorithms.QuickUnion;

/**
 * @author mgalala
 *
 */
public class QuickUnionTest {
	private QuickUnion quickUnion;

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
	}
}
