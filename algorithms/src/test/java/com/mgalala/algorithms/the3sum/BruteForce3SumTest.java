/**
 * 
 */
package com.mgalala.algorithms.the3sum;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;

import com.mgalala.algorithms.the3sum.BruteForce3Sum;

/**
 * @author mgalala
 *
 */
public class BruteForce3SumTest {
	private BruteForce3Sum bruteForce3Sum;

	@Test
	public void testCount() {
		bruteForce3Sum = new BruteForce3Sum();
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();

		// int actual = bruteForce3Sum.count(new int[] { -80, 100, 90, 20, 70,
		// -50, 30, -40, -20, -10, 40, 0, 10, 5 });
		int actual = bruteForce3Sum.count(generateRandom(2000));

		System.out.printf("Consumed time %s", stopwatch.getTime());
		System.out.println("****************************");
		System.out.println(actual);
		// Assert.assertEquals(12, actual);
	}

	private int[] generateRandom(int total) {
		int[] numbers = new int[total];
		for (int i = 0; i < total; i++) {
			numbers[i] = ThreadLocalRandom.current().nextInt(-total, total + 1);
		}
		System.out.println(Arrays.toString(numbers));

		return numbers;
	}
}
