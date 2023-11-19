/*
BST - a class that represents a binary search tree ADT that can be traversed in 4 different ways
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate knowledge of ADTs using the Binary Search Tree on Currency and Dollar classes
*/
public class BST {
    private BSTNode root;		// the root of the tree

    /**	constructor for BinaryTree */
	public BST() 
	{
		root = null;
	}
	/**
	 * Add a node to the tree
	 * pre: value (value to put into the tree)
	 * post: value has been added to tree
	 * returnL none
	 */
	public void insert(Dollar value) 
	{
		BSTNode curr = root;
		BSTNode toAdd = new BSTNode(value);
		boolean hasAdded = false;

		if(root == null)
		{
			root = toAdd;
			return;
		}
		recursiveAdd(value, curr);
	}

	/**
	 * Recursive helper method called for recursive version of add
	 *  Each time called, checks if value greater than or less than current 
	 *  value. Based on this, goes down right or left subtree. If corresponding
	 *  right/left node is null, adds value at that point.
	 * pre: value (value to add), curr (current node in binary tree)
	 * post: value is added in appropriate location on tree
	 * return: none
	 */
	public void recursiveAdd(Dollar value, BSTNode curr)
	{
		if(value.isGreater(curr.getData()))
		{
			if(curr.getLeftChild()==null)
			{
				curr.setLeftChild(new BSTNode(value));
				return;
			}
			else
				recursiveAdd(value, curr.getLeftChild());
		}
		else
		{
			if(curr.getRightChild()==null)
			{
				curr.setRightChild(new BSTNode(value));
				return;
			}
			else
				recursiveAdd(value, curr.getRightChild());
		}
	}

	/**
	 * Remove value from Binary Tree
	 * pre: value (value to remove from the tree)
	 * post: value removed from tree
	 * return: none
	 */
	public void delete(Dollar value) {
		root = remove(root, value);
	}

	/**
	 * remove value from Binary Tree
	 * pre: node (root of the subtree), value (value to remove from the subtree)
	 * post: value removed from tree
	 * return: removed value
	 */
	public BSTNode remove(BSTNode node, Dollar value) {
		if(node == null)
			return null;
		if(value.isGreater(node.getData()))
			node.setLeftChild(remove(node.getLeftChild(),value));
        else if(value.isEqual(node.getData()))
		{
			if(node.getLeftChild()==null)
				return node.getRightChild();
			else if(node.getRightChild()==null)
				return node.getLeftChild();

			BSTNode minimum = minNode(node.getRightChild());
			BSTNode temp = new BSTNode(minimum.getData(), node.getLeftChild(), node.getRightChild());
			node = temp;
			node.setRightChild(remove(node.getRightChild(), minimum.getData())) ;
		}
		else
			node.setRightChild(remove(node.getRightChild(),value));
		
		return node;
	}

	/**
	 * find node with minimum value in tree
	 * pre: n (root of subtree)
	 * post: none
	 * return: node with minimum value
	 */
	public BSTNode minNode(BSTNode n)
	{
		BSTNode curr = n;
		while (curr.getLeftChild() != null)
			curr = curr.getLeftChild();
		return curr;
	}

	/**
	 * traverses tree breadth first
	 * pre: breadthfirstVals (queue of tree values to be traversed)
	 * post: tree has been traversed breadth first
	 * return: none
	 */
	public void traverseBreadthFirst(Queue breadthfirstVals)
    {
        int h = getTreeHeight(root);
        for (int i = 1; i <= h; i++)
            traverseCurrentLevel(root, i, breadthfirstVals);
    }
 
	/**
	 * gets height of tree
	 * pre: curr (current node)
	 * post: none
	 * return: height of tree
	 */
    public int getTreeHeight(BSTNode curr)
    {
        if (curr == null)
            return 0;
        else {
            int lheight = getTreeHeight(curr.getLeftChild());
            int rheight = getTreeHeight(curr.getRightChild());
 
			return Math.max(lheight,rheight) + 1;
        }
    }
 
	/**
	 * Algorithm traverseCurrentLevel(curr, level, breadthfirstVals){
	 * 		if (curr == null) {
	 * 			return
	 * 		}
	 * 		if (level = 1) {
	 * 			add value of curr to breadthfirstVals queue
	 * 		}
	 * 		else if (level > 1) {
	 * 			traverseCurrentLevel(leftChild of curr, level-1, breadthfirstVals)
	 * 			traverseCurrentLevel(rightChild of curr, level-1, breadthfirstVals)
	 * 		}
     * }
	 * 
	 * recursively traverses current level of tree
	 * pre: curr (current BSTNode), level (level that is being traversed), breadthfirstVals (queue of values being traversed)
	 * post: current level has been traversed
	 * return: none
	 */
    public void traverseCurrentLevel(BSTNode curr, int level, Queue breadthfirstVals)
    {
        if (curr == null)
            return;
        if (level == 1)
            breadthfirstVals.enqueue(curr.getData());
        else if (level > 1) {
            traverseCurrentLevel(curr.getLeftChild(), level - 1, breadthfirstVals);
            traverseCurrentLevel(curr.getRightChild(), level - 1, breadthfirstVals);
        }
    }

	/**
	 * traverses tree inorder
	 * pre: inorderVals (queue of values in inorder)
	 * post: inorderVals has values in inorder
	 * return: none
	 */
	public void traverseInorder(Queue inorderVals) 
	{
		recurseInorder(root, inorderVals);
	}

	/**
	 * Algorithm recurseInorder(curr, inorderVals){
	 * 		if (leftChild of curr != null) {
	 * 			recurseInorder(leftChild of curr, inorderVals)
	 * 		}
	 * 		add value of curr to inorder Queue
	 * 		if (rightChild of curr != null) {
	 * 			recurseInorder(rightChild of curr, inorderVals)
	 * 		}
     * }
	 * 
	 * Recursively adds the numbers of the binary tree to 
	 * a queue of values inorder
	 * pre: curr (current node), inorderVals (queue to add to)
	 * post: indorderVals has all values inorder
	 * return: none
	 */
	public void recurseInorder(BSTNode curr, Queue inorderVals)
	{
		if(curr.getLeftChild()!= null)
			recurseInorder(curr.getLeftChild(), inorderVals);
		
		inorderVals.enqueue(curr.getData());

		if(curr.getRightChild()!= null)
			recurseInorder(curr.getRightChild(), inorderVals);
	}

	/**
	 * traverses tree preorder
	 * pre: preorderVals (queue of values in preorder)
	 * post: preorderVals has values in preorder
	 * return: none
	 */
	public void traversePreorder(Queue preorderVals) 
	{
		recursePreorder(root, preorderVals);
	}

	/** 
	 * Algorithm recursePreorder(curr, preorderVals){
	 * 		add value of curr to preorder Queue
	 * 
	 * 		if (leftChild of curr != null) {
	 * 			recursePreorder(leftChild of curr, preorderVals)
	 * 		}
	 * 		if (rightChild of curr != null) {
	 * 			recursePreorder(rightChild of curr, preOrderVals)
	 * 		}
     * }
	 * 
	 * Recursively prints node, goes down left subtree 
	 * until reaches a null node, then goes down 
	 * right subtree until reaches null node.
	 * pre: curr (current tree node), preorderVals (queue to add to)
	 * post: preorderVals has all values in preorder
	 * return: none
	 */
	public void recursePreorder(BSTNode curr, Queue preorderVals)
	{
		preorderVals.enqueue(curr.getData());

		if(curr.getLeftChild()!= null)
			recursePreorder(curr.getLeftChild(), preorderVals);

		if(curr.getRightChild()!= null)
			recursePreorder(curr.getRightChild(), preorderVals);
	}

	/**
	 * traverses tree postorder
	 * pre: postorderVals (queue of values in postorder)
	 * post: postorderVals has values in postorder
	 * return: none
	 */
	public void traversePostorder(Queue postorderVals) 
	{
		recursePostorder(root, postorderVals);
	}

	/** 
	 * Algorithm recursePostorder(curr, postorderVals){
	 * 		if (leftChild of curr != null) {
	 * 			recursePostorder(leftChild of curr, postorderVals)
	 * 		}
	 * 		if (rightChild of curr != null) {
	 * 			recursePostorder(rightChild of curr, postOrderVals)
	 * 		}
	 * 		add value of curr to postorder Queue
     * }
	 * 
	 * Recursively goes down left subtree 
	 * until reaches a null node, then goes down 
	 * right subtree until reaches null node, then prints node
	 * pre: curr (current tree node), postorderVals (queue to add to)
	 * post: postorderVals has all values in postorder
	 * return: none
	 */
	public void recursePostorder(BSTNode curr, Queue postorderVals)
	{
		if(curr.getLeftChild()!= null)
			recursePostorder(curr.getLeftChild(), postorderVals);

		if(curr.getRightChild()!= null)
			recursePostorder(curr.getRightChild(), postorderVals);

		postorderVals.enqueue(curr.getData());
	}

	/**
	 * searches through tree to find certain value
	 * pre: key (Dollar object to find in tree)
	 * post: key found or not found
	 * return: BSTNode that matches key
	 */
	public BSTNode search(Dollar key) 
	{
		return recurseSearch(root, key);
	}

	/**
	 * Algorithm recurseSearch(curr, key){
	 * 		if (curr is null OR value of curr is equal to value of key) {
	 * 			return curr
	 * 		}
	 * 		if (value of curr is greater than key) {
	 * 			return recurseSearch(rightChild of curr, key)
	 * 		}
	 * 		else {
	 * 			return recurseSearch(leftChild of curr, key)
	 * 		}
     * }
	 * 
	 * recursively searches through tree to find key
	 * pre: curr (current node), key (Dollar object to be found)
	 * post: none
	 * return: null (if not found) or non null value of found Dollar object
	 */
	public BSTNode recurseSearch(BSTNode curr, Dollar key)
	{
        if (curr == null || curr.getData().isEqual(key))
            return curr;
 
        if (curr.getData().isGreater(key))
            return recurseSearch(curr.getRightChild(), key);
		else
        	return recurseSearch(curr.getLeftChild(), key);
	}

	/**
	 * returns string of all 4 traversals of the tree
	 * pre: none
	 * post: none
	 * return: string that contains all 4 traversals of the tree
	 */
	public String print()
	{
		Queue breadthfirstVals = new Queue();
		traverseBreadthFirst(breadthfirstVals);
		Queue inorderVals = new Queue();
		traverseInorder(inorderVals);
		Queue preorderVals = new Queue();
		traversePreorder(preorderVals);
		Queue postorderVals = new Queue();
		traversePostorder(postorderVals);
		String printout = "";
		printout += "\n\nBreadth-first Order: \n" + breadthfirstVals.printQueue() + "\n\n";
		printout += "In-order: \n" + inorderVals.printQueue() + "\n\n";
		printout += "Pre-order: \n" + preorderVals.printQueue() + "\n\n";
		printout += "Post-order: \n" + postorderVals.printQueue() + "\n\n";
		return printout;
	}

	/**
	 * returns number of nodes in tree
	 * pre: none
	 * post: none
	 * return: number of nodes in tree
	 */
	public int count()
	{
		if(!isEmpty())
		{
			Queue inorderVals = new Queue();
			traverseInorder(inorderVals);
			return inorderVals.countCurrency();
		}
		else	
			return 0;
	}

	/**
	 * checks if tree is empty or not
	 * pre: none
	 * post: none
	 * return: true if tree is empty or false if tree is not empty
	 */
	public boolean isEmpty()
	{
		if(root==null)
			return true;
		return false;
	}
}