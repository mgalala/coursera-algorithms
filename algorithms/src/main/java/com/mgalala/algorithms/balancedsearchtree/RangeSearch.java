/**
 * 
 */
package com.mgalala.algorithms.balancedsearchtree;

import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author mgalala
 *
 */
public class RangeSearch {
	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<>();
		map.put("3", "c");
		map.put("1", "a");
		map.put("4", "d");
		map.put("2", "b");

		String firstKey = "1";
		String secondKey = "3";
		SortedMap<String, String> subMap = null;
		Entry<String, String> groupBelow = null;
		Entry<String, String> groupAbove = null;
		if (firstKey.compareTo(secondKey) > 0) {
			System.out.println(firstKey + " > " + secondKey);
			groupBelow = map.floorEntry(firstKey);
			groupAbove = map.ceilingEntry(secondKey);
		} else if (firstKey.compareTo(secondKey) < 0) {
			System.out.println(firstKey + " < " + secondKey);
			groupBelow = map.floorEntry(secondKey);
			groupAbove = map.ceilingEntry(firstKey);
		} else {
			System.out.println(firstKey + " = " + secondKey);
			groupBelow = map.floorEntry(secondKey);
			groupAbove = map.ceilingEntry(firstKey);
		}
		subMap = map.subMap(groupAbove.getKey(), true, groupBelow.getKey(), true);
		System.out.println(subMap.toString());
		System.out.println("Size: " + subMap.size());

	}
}
