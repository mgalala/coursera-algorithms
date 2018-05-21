/**
 * 
 */
package com.mgalala.algorithms.collections;

/**
 * @author mgalala
 *
 */
public class MyNode {
	private String value;
	private MyNode node;

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public MyNode value(String value) {
		setValue(value);
		return this;
	}

	/**
	 * @return the node
	 */
	public MyNode getNode() {
		return node;
	}

	/**
	 * @param node
	 *            the node to set
	 */
	public void setNode(MyNode node) {
		this.node = node;
	}

	public MyNode node(MyNode node) {
		setNode(node);
		return this;
	}
}
