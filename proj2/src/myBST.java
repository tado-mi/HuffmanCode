
public class myBST<T extends Comparable<T>> implements BST<T> {

	public MyTreeNode<T> root;
	private MyTreeNode<T> focusNode;

	public MyTreeNode<T>  tree;

	public MyTreeNode<T>  instance;
	public MyTreeNode<T> myNode;

	public boolean check = true;
	


	public myBST() {

		this.root = new MyTreeNode<T>(); // null;

	}
	public myBST(T data) {
		this.root = new MyTreeNode<T>();
		root.data = data;
		
	}

	public void delete(T x) {
		
		myNode.delete(root, x);
		

	}


	public boolean lookup(T x) {
		focusNode = root;

		while (focusNode.data != x && root!=null) {
			if (x.compareTo(focusNode.data) < 0) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}
			if (focusNode == null) {
				return false;
			}
		}
		return true;
	}

	public  void printPreOrder(T x) {
		root.preOrdertraversal(root);

	}
	
	
	public void printPreOrder() {
		printPreOrder(root.data);
	}
	
	public void printInOrder() {
		printInOrder(root.data);
	}

	public void printPostOrder() {
		printPostOrder(root.data);
	}

	public void printInOrder(T x) {
		// focusNode=root;
		if (root != null) {
			root.inOrdertraversal(root,0);
		}
	}

	public void printPostOrder(T x) {

		root.postOrdertraversal(root);
	}
	@Override
	public void insert(T x) {
		// TODO Auto-generated method stub
		root.insert(x);
		
	}

}
