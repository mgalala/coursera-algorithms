/**
 * 
 */
package com.mgalala.algoirthms.unionfind;

import org.junit.Assert;
import org.junit.Test;

import com.mgalala.algorithms.unionfind.QuickFind;

/**
 * @author mgalala
 *
 */
public class QuickFindTest {
	private QuickFind quickFind;

	@Test
	public void testUnionFind() {
		quickFind = new QuickFind(10);
		quickFind.union(0, 5);
		quickFind.union(0, 6);
		Assert.assertTrue(quickFind.connected(0, 5));
		Assert.assertTrue(quickFind.connected(0, 6));
		Assert.assertFalse(quickFind.connected(0, 7));
	}
}
