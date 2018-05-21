/**
 * 
 */
package com.mgalala.algorithms.collections;

import java.util.LinkedList;
import java.util.List;

/**
 * @author mgalala
 *
 */
public class MyLinkedList {
	public static void main(String[] args) {
		List<MyNode> list = new LinkedList<>();
		MyNode node3 = new MyNode().value("3");
		MyNode node2 = new MyNode().value("2").node(node3);
		MyNode node1 = new MyNode().value("1").node(node2);
		list.add(0, node1);
		list.add(1, node2);
		list.add(2, node3);

		print(list);

		System.out.println(" ");
		System.out.println("-----------------------------------------");
		MyNode node0 = new MyNode().value("0").node(node1);
		list.add(0, node0);
		print(list);

		System.out.println(" ");
		System.out.println("-----------------------------------------");
		MyNode node1_5 = new MyNode().value("1.5").node(node2);
		list.add(2, node1_5);
		print(list);
	}

	private static void print(List<MyNode> list) {
		list.stream().forEach(e -> {
			System.out.print(e.getValue());
			if (e.getNode() != null)
				System.out.println(" is linked with node " + e.getNode().getValue());
		});
	}
}
