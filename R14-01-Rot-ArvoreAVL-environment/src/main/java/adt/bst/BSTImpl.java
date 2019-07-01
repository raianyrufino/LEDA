package adt.bst;

@SuppressWarnings("unchecked")
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
		return height(this.getRoot());
	}

	public int height(BSTNode<T> node) {

	}

	@Override
	public BSTNode<T> search(T element) {

	}

	private BSTNode<T> search(T element, BSTNode<T> node) {

	}

	@Override
	public void insert(T element) {

	}

	protected BSTNode<T> insert(T element, BSTNode<T> node) {

	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(this.getRoot());
	}

	private BSTNode<T> maximum(BSTNode<T> node) {

	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(this.getRoot());
	}

	private BSTNode<T> minimum(BSTNode<T> node) {

	}

	@Override
	public BSTNode<T> sucessor(T element) {

	}

	@Override
	public BSTNode<T> predecessor(T element) {
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if ((!node.isEmpty()) && (element != null)) {
			remove(node);
		}
	}

	protected BSTNode<T> remove(BSTNode<T> node) {
		if (node.getRight().isEmpty() && node.getLeft().isEmpty()) {
			node.setData(null);
			node.setLeft(null);
			node.setRight(null);
		} else if (node.getRight().isEmpty()) {
			node.setData(node.getLeft().getData());
			node.setRight(node.getLeft().getRight());
			node.setLeft(node.getLeft().getLeft());
			node.getRight().setParent(node);
			node.getLeft().setParent(node);
		} else if (node.getLeft().isEmpty()) {
			node.setData(node.getRight().getData());
			node.setLeft(node.getRight().getLeft());
			node.setRight(node.getRight().getRight());
			node.getRight().setParent(node);
			node.getLeft().setParent(node);
		} else {
			T value = node.getData();
			BSTNode<T> sucessor = sucessor(value);
			node.setData(sucessor.getData());
			sucessor.setData(value);
			remove((BSTNode<T>) sucessor);
		}

		return node;
	}

	@Override
	public T[] preOrder() {

	}


	private void preOrder(T[] array, BSTNode<T> node) {

	}

	private void add(T[] array, T element, int count) {

	}

	@Override
	public T[] order() {

	}

	private void order(T[] array, BSTNode<T> node) {

	}

	@Override
	public T[] postOrder() {

	}

	private void postOrder(T[] array, BSTNode<T> node) {

	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}
}