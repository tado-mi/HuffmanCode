package src;

import java.util.*;

public class Tree<T extends Comparable<T>> {

	public T data;
	public Tree<T> leftChild;
	public Tree<T> rightChild;

	public Tree() {

		this.data = null;

	}

	public Tree(T data) {

		this.data = data;

	}

	public String toString() {

		String ans = inOrder(0);
		return ans;

	}

	public String inOrder(int count) {

		String str = "";

		if (leftChild != null) {
			str = str + leftChild.inOrder(count + 1);
		}

		for (int i = 0; i < count; i = i + 1) {
			str = str + " ";
		}

		str = str + data + "\n";

		if (rightChild != null) {
			str = str + rightChild.inOrder(count + 1);
		}

		return str;

	}

	public void inOrdertraversal(Tree<T> parent, int count) {
		if (parent != null) {

			inOrdertraversal(parent.leftChild,count+1);
			for(int i=0;i<count;i++) {
				System.out.print(" ");
			}
			System.out.println(parent.data);
			inOrdertraversal(parent.rightChild,count+1);

		}
	}

	public Tree<T> delete(Tree<T> node, T x) {

		// if (node == null) {
		// 	throw new NullPointerException();
		// }
		//
		// if (x.compareTo(node.data) < 0) {
		// 	node.leftChild = delete(node.leftChild, x);
		// } else if (x.compareTo(node.data) > 0) {
		// 	node.rightChild = delete(node.rightChild, x);
		// } else if (node.leftChild == null) {
		// 	return node.rightChild;
		// } else if (node.rightChild == null) {
		// 	return node.leftChild;
		// } else {
		// 	// get data from the leftmost node in the right sub-tree
		// 	node.data = retrieveData(node.rightChild);
		// 	// delete the node that has been retrieved by the above method
		// 	node.leftChild = delete(node.leftChild, node.data);
		// }
		//
		// return node;

		return null;

	}

	public void insert(T x) {

		if (data == null) { // should happen only once!

			data = x;
			return;

		}

		if (data.compareTo(x) >= 0 ) {

			// right
			if (rightChild == null) {

				rightChild = new Tree<T>(x);
				return;

			}

			rightChild.insert(x);

		}

		if (data.compareTo(x) <= 0) {

			// left
			if (leftChild == null) {

				leftChild = new Tree<T>(x);
				return;

			}

			leftChild.insert(x);

		}

	}

	public List<T> getList() {

		List<T> ans = new ArrayList<T>();
		getList(ans);

		return ans;

	}

	protected List<T> getList(List<T> list) {

		list.add(data);

		if (leftChild != null) {
			leftChild.getList(list);
		}

		if (rightChild != null) {
			rightChild.getList(list);
		}

		return list;

	}



}
