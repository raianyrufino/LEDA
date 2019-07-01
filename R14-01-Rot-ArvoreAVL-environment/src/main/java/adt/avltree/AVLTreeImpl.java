package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 *
 * Performs consistency validations within a AVL Tree instance
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	@Override
	public void remove(T element) {
	}

	@Override
	public void insert(T element) {

	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {

	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {

	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if (node != null) {
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			if (parent != null) {
				rebalance(parent);
				rebalanceUp((BSTNode<T>) parent);
			}
		}
	}

	// AUXILIARY
	private void doubleLeftRotation(BSTNode<T> node) {
		rightRotation((BSTNode<T>) node.getRight());
		leftRotation(node);
	}

	// AUXILIARY
	private void doubleRightRotation(BSTNode<T> node) {
		leftRotation((BSTNode<T>) node.getLeft());
		rightRotation(node);
	}

	// AUXILIARY
	protected void leftRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getRight();

		if (this.getRoot() == node) {
			this.root = pivot;
		}

		Util.leftRotation(node);
	}

	// AUXILIARY
	protected void rightRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getLeft();

		if (this.getRoot() == node) {
			this.root = pivot;
		}

		Util.rightRotation(node);
	}
}