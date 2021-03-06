package adt.bst;

import java.util.ArrayList;
import java.util.List;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return this.height(this.root);
	}

	private int height(BSTNode<T> node) {
		if (node.isEmpty()) {
			return -1;
		}
		return Math.max(this.height((BSTNode<T>) node.getLeft()), this.height((BSTNode<T>) node.getRight())) + 1;
	}

	@Override
	public BSTNode<T> search(T element) {
		if (this.getRoot().isEmpty() || element.compareTo(this.getRoot().getData()) == 0) {
			return this.getRoot();
		} else {
			if (element.compareTo(root.getData()) < 0) {
				return search(element, (BSTNode<T>) this.getRoot().getLeft());
			} else {
				return search(element, (BSTNode<T>) this.getRoot().getRight());
			}
		}
	}

	private BSTNode<T> search(T element, BSTNode<T> node) {
		if (node.isEmpty()) {
			return node;
		}
		if (element.compareTo(node.getData()) < 0) {
			return this.search(element, (BSTNode<T>) node.getLeft());
		}
		if (element.compareTo(node.getData()) > 0) {
			return this.search(element, (BSTNode<T>) node.getRight());
		} else {
			return node;
		}
	}

	@Override
	public void insert(T element) {
		this.insert(this.root, element, new BSTNode<T>());
	}

	private void insert(BSTNode<T> node, T element, BSTNode<T> parent) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.setParent(parent);
		} else if (element.compareTo(node.getData()) < 0) {
			insert((BSTNode<T>) node.getLeft(), element, node);
		} else if (element.compareTo(node.getData()) > 0) {
			insert((BSTNode<T>) node.getRight(), element, node);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return this.maximum(this.root);
	}

	private BSTNode<T> maximum(BTNode<T> root) {
		BTNode<T> node = root;
		if (node.isEmpty()) {
			return null;
		} else {
			while (!node.getRight().isEmpty()) {
				node = node.getRight();
			}
			return (BSTNode<T>) node;
		}
	}

	@Override
	public BSTNode<T> minimum() {
		return this.minimum(this.root);
	}

	private BSTNode<T> minimum(BTNode<T> root) {
		BTNode<T> node = root;
		if (node.isEmpty()) {
			return null;
		} else {
			while (!node.getLeft().isEmpty()) {
				node = node.getLeft();
			}
			return (BSTNode<T>) node;
		}
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		if (node.isEmpty()) {
			return null;
		}
		if (!node.getRight().isEmpty()) {
			return this.minimum(node.getRight());
		}
		if (node.getParent().getLeft() == node) {
			return (BSTNode<T>) node.getParent();
		}
		while (!node.isEmpty() && this.eFilhoDir(node, node.getParent())) {
			node = (BSTNode<T>) node.getParent();
		}
		return (BSTNode<T>) node.getParent();
	}

	// Indica se o "node" e filho direito do "parent"
	private boolean eFilhoDir(BSTNode<T> node, BTNode<T> parent) {
		if (node == null || node.isEmpty()) {
			return false;
		}
		return parent.getRight() == node;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = this.search(element);
		if (node.isEmpty()) {
			return null;
		}
		if (!node.getLeft().isEmpty()) {
			return this.maximum(node.getLeft());
		}
		if (node.getParent().getRight() == node) {
			return (BSTNode<T>) node.getParent();
		}
		while (!node.isEmpty() && this.eFilhoEsq(node, node.getParent())) {
			node = (BSTNode<T>) node.getParent();
		}
		if (node == this.root) {
			return null;
		}
		return (BSTNode<T>) node.getParent();

	}

	// Indica se o "node" e filho esquerdo do "parent"
	private boolean eFilhoEsq(BSTNode<T> node, BTNode<T> parent) {
		if (node == null || node.isEmpty()) {
			return false;
		}
		return parent.getLeft() == node;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = this.search(element);
		remove(node);
	}

	private void remove(BSTNode<T> node) {
		if (node == null || node.isEmpty()) {
			return;
		}
		if (node.isLeaf()) {
			if (node == this.root) {
				this.root = new BSTNode<T>();
			} else if (eFilhoEsq(node, node.getParent())) {
				node.getParent().setLeft(new BSTNode<T>());
			} else {
				node.getParent().setRight(new BSTNode<T>());
			}
		} else if (soFilhoDir(node)) {
			if (node == this.root) {
				this.root = (BSTNode<T>) node.getRight();
			} else {
				if (eFilhoEsq(node, node.getParent())) {
					node.getParent().setLeft(node.getRight());
				} else {
					node.getParent().setRight(node.getRight());
				}
				node.getRight().setParent(node.getParent());
			}
		} else if (soFilhoEsq(node)) {
			if (node == this.root) {
				this.root = (BSTNode<T>) node.getLeft();
			} else {
				if (eFilhoEsq(node, node.getParent())) {
					node.getParent().setLeft(node.getLeft());
				} else {
					node.getParent().setRight(node.getLeft());
				}
				node.getLeft().setParent(node.getParent());
			}
		} else {
			BSTNode<T> auxNode = this.sucessor(node.getData());
			if (auxNode == null) {
				auxNode = this.predecessor(node.getData());
			}
			T aux = node.getData();
			node.setData(auxNode.getData());
			auxNode.setData(aux);
			this.remove(auxNode);
		}
	}

	// Indica se o "node" passado possui apenas irmao esquerdo
	private boolean soFilhoEsq(BSTNode<T> node) {
		if (node == null || node.isEmpty()) {
			return false;
		}
		return !node.getLeft().isEmpty() && node.getRight().isEmpty();
	}

	// Indica se o "node" passado possui apenas irmao direito
	private boolean soFilhoDir(BSTNode<T> node) {
		if (node == null || node.isEmpty()) {
			return false;
		}
		return !node.getRight().isEmpty() && node.getLeft().isEmpty();
	}

	@Override
	public T[] preOrder() {
		List<T> list = new ArrayList<>(this.size());
		preOrder(list, this.root);
		return list.toArray((T[]) new Comparable[this.size()]);
	}

	private void preOrder(List<T> list, BTNode<T> node) {
		if (!node.isEmpty()) {
			list.add(node.getData());
			preOrder(list, node.getLeft());
			preOrder(list, node.getRight());
		}
	}

	@Override
	public T[] order() {
		List<T> list = new ArrayList<>(this.size());
		order(list, this.root);
		return list.toArray((T[]) new Comparable[this.size()]);
	}

	private void order(List<T> list, BTNode<T> node) {
		if (!node.isEmpty()) {
			order(list, node.getLeft());
			list.add(node.getData());
			order(list, node.getRight());
		}
	}

	@Override
	public T[] postOrder() {
		List<T> list = new ArrayList<>(this.size());
		postOrder(list, this.root);
		return list.toArray((T[]) new Comparable[this.size()]);
	}

	private void postOrder(List<T> list, BTNode<T> node) {
		if (!node.isEmpty()) {
			postOrder(list, node.getLeft());
			postOrder(list, node.getRight());
			list.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand how
	 * it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
		}
		return result;
	}
}