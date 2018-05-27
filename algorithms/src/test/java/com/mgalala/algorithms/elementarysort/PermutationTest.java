/**
 * 
 */
package com.mgalala.algorithms.elementarysort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mgalala
 *
 */
public class PermutationTest {

	private Permutation permutation;

	@Test
	public void testPermutation() {
		Integer[] first = { 5, 9, 6, 4, 1, 2 };
		Integer[] second = { 2, 9, 6, 1, 5, 4 };

		permutation = new Permutation();
		Assert.assertTrue(permutation.checkPermutation(first, second));
		Assert.assertEquals(6, permutation.getNumberOfCompares());
	}

	@Test
	public void testPermutation_Fail() {
		Integer[] first = { 5, 9, 6, 4, 1, 2 };
		Integer[] second = { 2, 9, 6, 1, 5, 3 };

		permutation = new Permutation();
		Assert.assertFalse(permutation.checkPermutation(first, second));
		Assert.assertEquals(3, permutation.getNumberOfCompares());
	}

}
