/*
BST - a class that represents a binary search tree ADT of Dollar 
objects that can be traversed in 4 different ways
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate knowledge of ADTs using the Binary Search 
Tree on Currency and Dollar classes
*/
public class BST {
    private BSTNode root;		// the root of the tree

    /**	constructor for BinaryTree */
	public BST() 
	{
		root = null;
	}
	/**
	 * Add a node to the tree by calling a recursive 
	 * method to traverse the tree and appropriately add the node
	 * pre: Dollar value (value to put into the tree)
	 * post: value has been added to tree
	 * return: none
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
	 * Recursive helper method called for recursively adding a value to tree
	 *
	 * Algorithm recursiveAdd(value, curr)
	 * 		if current data is greater than value to be added
	 * 			if there is no left subtree, value is added there
	 *			if there is a left subtree, recursively goes down it 
	 *		else, if current data is less than value to be added
	 *			if there is no right subtree, value is added there
	 *			if there is a right subtree, recursively goes down it
	 *
	 * pre: Dollar value (value to add), BSTNode curr (current node in binary tree)
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
	 * Remove value from Binary Tree by calling a recursive 
	 * method to traverse the tree and appropriately remove node
	 * pre: Dollar value (value to remove from the tree)
	 * post: value removed from tree
	 * return: none
	 */
	public void delete(Dollar value) {
		root = remove(root, value);
	}

	/**
	 * Recursive helper method called for recursively removing a value from tree
	 * 
	 * Algorithm remove(node, value)
	 * 		if node is null
	 *			return null
	 * 		if node's data is greater than value
	 *			set the left child of node ot be returned value of remove(leftChild of node, value)
	 * 		else if nodes data is equal to value
	 *			if node's left child is null
	 * 				return node's right child
	 * 			else if node's right child is null
	 * 				return node's left child
	 * 			find minimum BSTNode, calling minNode(node's right child)
	 * 			temp BSTNode is a new BSTNode (minimum's data value, node's leftChild, node's rightChild)
	 * 			set node to temp BSTNode
	 * 			set node's right child to be returned value of remove(rightChild of node, minimum's data)
	 * 		else
	 * 			set right child of node to returned value of remove(rightChild of node, value)
	 * 		return node
	 *
	 * pre: BSTNode node (root of the subtree), Dollar value (value to remove from the subtree)
	 * post: value has been removed from tree
	 * return: BSTNode containing removed Dollar value
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
	 * finds node with minimum value in tree by iteratively 
	 * going down left subtrees until there is none left to go down
	 * pre: BSTNode n (root of subtree)
	 * post: none
	 * return: BSTNode with minimum value
	 */
	public BSTNode minNode(BSTNode n)
	{
		BSTNode curr = n;
		while (curr.getLeftChild() != null)
			curr = curr.getLeftChild();
		return curr;
	}

	/**
	 * traverses tree breadth first by calling a recursive traverse method
	 * pre: Queue breadthfirstVals (queue to add traversed values to)
	 * post: breadthfirstVals contains values in breadthfirst order
	 * return: none
	 */
	public void traverseBreadthFirst(Queue breadthfirstVals)
    {
        int h = getTreeHeight(root);
        for (int i = 1; i <= h; i++)
            traverseCurrentLevel(root, i, breadthfirstVals);
    }
 
	/**
	 * gets height of tree recursively by getting heights of 
	 * the right and left subtrees
	 * pre: BSTNode curr (current node)
	 * post: none
	 * return: int height of tree
	 */
    public int getTreeHeight(BSTNode curr)
    {
        if (curr == null)
            return 0;
        else {
            int leftheight = getTreeHeight(curr.getLeftChild());
            int rightheight = getTreeHeight(curr.getRightChild());
 
			return Math.max(leftheight,rightheight) + 1;
        }
    }
 
	/** Recursive helper method called for recursively traversing the tree breadth first
	 * 
	 * Algorithm traverseCurrentLevel(curr, level, breadthfirstVals)
	 * 		if curr is null
	 * 			return
	 * 		else if level is 1
	 * 			add value of curr to breadthfirstVals queue
	 * 		else if level is larger than 1
	 * 			call traverseCurrentLevel(leftChild of curr, level-1, breadthfirstVals)
	 * 			call traverseCurrentLevel(rightChild of curr, level-1, breadthfirstVals)
	 * 
	 * recursively traverses current level of tree
	 * pre: BSTNode curr (current BSTNode), int level (level that is being traversed), Queue breadthfirstVals (queue of values being traversed)
	 * post: current level has been traversed
	 * return: none
	 */
    public void traverseCurrentLevel(BSTNode curr, int level, Queue breadthfirstVals)
    {
        if (curr == null)
            return;
        else if (level == 1)
            breadthfirstVals.enqueue(curr.getData());
        else if (level > 1) {
            traverseCurrentLevel(curr.getLeftChild(), level - 1, breadthfirstVals);
            traverseCurrentLevel(curr.getRightChild(), level - 1, breadthfirstVals);
        }
    }

	/**
	 * traverses tree inorder by calling method to recursively traverse inorder
	 * pre: Queue inorderVals (queue to add traversed values to)
	 * post: inorderVals has values in inorder
	 * return: none
	 */
	public void traverseInorder(Queue inorderVals) 
	{
		recurseInorder(root, inorderVals);
	}

	/** Recursive helper method called for recursively traversing the tree inorder
	 * and adds the numbers of the binary tree to a queue of values, inorder
	 *
	 * Algorithm recurseInorder(curr, inorderVals)
	 * 		if leftChild of curr is not null
	 * 			call recurseInorder(leftChild of curr, inorderVals)
	 *
	 * 		add value of curr to inorder Queue
	 *
	 * 		if rightChild of curr is not null
	 * 			call recurseInorder(rightChild of curr, inorderVals)
	 * 
	 * pre: BSTNode curr (current node), Queue inorderVals (queue to add to)
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
	 * traverses tree preorder by calling a method to recursively traverse preorder
	 * pre: Queue preorderVals (queue to add traversed values to)
	 * post: preorderVals has values in preorder
	 * return: none
	 */
	public void traversePreorder(Queue preorderVals) 
	{
		recursePreorder(root, preorderVals);
	}

	/** Recursive helper method called to recursively traverse tree in preorder
	 * Recursively prints node, goes down left subtree 
	 * until reaches a null node, then goes down 
	 * right subtree until reaches null node.
	 *
	 * Algorithm recursePreorder(curr, preorderVals)
	 * 		add value of curr to preorder Queue
	 * 
	 * 		if leftChild of curr is not null
	 * 			call recursePreorder(leftChild of curr, preorderVals)
	 * 		if rightChild of curr is not null
	 * 			call recursePreorder(rightChild of curr, preOrderVals)
	 * 
	 * pre: BSTNode curr (current tree node), Queue preorderVals (queue to add to)
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
	 * traverses tree postorder by calling a method to recursivley traverse in postorder
	 * pre: Queue postorderVals (queue to add traversed values to)
	 * post: postorderVals has values in postorder
	 * return: none
	 */
	public void traversePostorder(Queue postorderVals) 
	{
		recursePostorder(root, postorderVals);
	}

	/** Recursive helper method called to recursively traverse tree in postorder
	 * Recursively goes down left subtree 
	 * until reaches a null node, then goes down 
	 * right subtree until reaches null node, then prints node
	 *
	 * Algorithm recursePostorder(curr, postorderVals)
	 * 		if leftChild of curr is not null
	 * 			call recursePostorder(leftChild of curr, postorderVals)
	 * 		if rightChild of curr is not null
	 * 			call recursePostorder(rightChild of curr, postOrderVals)
	 *
	 * 		add value of curr to postorder Queue
	 * 
	 * pre: BSTNode curr (current tree node), Queue postorderVals (queue to add to)
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
	 * searches through tree to find certain value by calling a recursive
	 * search method
	 * pre: Dollar key (Dollar object to find in tree)
	 * post: key found or not found
	 * return: BSTNode that matches key (is null if not found)
	 */
	public BSTNode search(Dollar key) 
	{
		return recurseSearch(root, key);
	}

	/** Recursive helper method to recursively search tree for a value, key
	 *
	 * Algorithm recurseSearch(curr, key)
	 * 		if curr is null OR value of curr is equal to value of key)
	 * 			return curr
	 * 		if value of key is greater than curr
	 * 			return recurseSearch(rightChild of curr, key)
	 * 		else
	 * 			return recurseSearch(leftChild of curr, key)
     * }
	 * 
	 * pre: BSTNode curr (current node), Dollar key (Dollar object to be found)
	 * post: none
	 * return: null (if not found) or non null BSTNode containing found Dollar object
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
	 * returns string of all 4 traversals of the tree by creating
	 * queues for all 4 traversals, then concatenating a string version
	 * of each queue
	 * pre: none
	 * post: string is used in lab4main to print the tree
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
	 * return: int number of nodes in tree
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