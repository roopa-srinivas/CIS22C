public class BST {
    private BSTNode root;		// the root of the tree

    /**	constructor for BinaryTree */
	public BST() 
	{
		root = null;
	}

    /**	Add a node to the tree
	 *	@param value		the value to put into the tree
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

    /** Recursive helper method called for recursive version of add
	 *  Each time called, checks if value greater than or less than current 
	 *  value. Based on this, goes down right or left subtree. If corresponding
	 *  right/left node is null, adds value at that point.
	 * @param value 	value to add
	 * @param curr 		current node in binary tree 
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
	 *	Remove value from Binary Tree
	 *	@param value		the value to remove from the tree
	 *	Precondition: value exists in the tree
	 */
	public void delete(Dollar value) {
		root = remove(root, value);
	}

    /**
	 *	Remove value from Binary Tree
	 *	@param node			the root of the subtree
	 *	@param value		the value to remove from the subtree
	 *	@return				TreeNode that connects to parent
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
	 *	Find node with min val in binary tree
	 *	@param n			the root of the subtree
	 *	@return				TreeNode with min value
	 */
	public BSTNode minNode(BSTNode n)
	{
		BSTNode curr = n;
		while (curr.getLeftChild() != null)
			curr = curr.getLeftChild();
		return curr;
	}

	public void traverseBreadthFirst(Queue breadthfirstVals)
    {
        int h = getTreeHeight(root);
        for (int i = 1; i <= h; i++)
            traverseCurrentLevel(root, i, breadthfirstVals);
    }
 
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
	 *	Print Binary Tree Inorder
	 */
	public void traverseInorder(Queue inorderVals) 
	{
		recurseInorder(root, inorderVals);
	}

	/** Recursively adds the numbers of the binary tree to 
	 * an queue of values in the order "Inorder"
	 * USE PRINT QUEUE METHOD IN MAIN FOR TESTING
	 * @param curr 	current tree node
	 * @param vals the arraylist to add to
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
	 *	Print Binary Tree Preorder
	 */
	public void traversePreorder(Queue preorderVals) 
	{
		recursePreorder(root, preorderVals);
	}

	/** Recursively prints node, goes down left subtree 
	 * until reaches a null node, then goes down 
	 * right subtree until reaches null node.
	 * @param curr the current tree node
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
	 *	Print Binary Tree Postorder
	 */
	public void traversePostorder(Queue postorderVals) 
	{
		recursePostorder(root, postorderVals);
	}

	/** Recursively goes down left subtree 
	 * until reaches a null node, then goes down 
	 * right subtree until reaches null node, then 
	 * prints node
	 * @param curr the current tree node
	 */
	public void recursePostorder(BSTNode curr, Queue postorderVals)
	{
		if(curr.getLeftChild()!= null)
			recursePostorder(curr.getLeftChild(), postorderVals);

		if(curr.getRightChild()!= null)
			recursePostorder(curr.getRightChild(), postorderVals);

		postorderVals.enqueue(curr.getData());
	}

	
	public BSTNode search(Dollar key) 
	{
		return recurseSearch(root, key);
	}

	public BSTNode recurseSearch(BSTNode curr, Dollar key)
	{
        if (curr == null || curr.getData().isEqual(key))
            return curr;
 
        if (curr.getData().isGreater(key))
            return recurseSearch(curr.getRightChild(), key);
		else
        	return recurseSearch(curr.getLeftChild(), key);
	}

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

	public boolean isEmpty()
	{
		if(root==null)
			return true;
		return false;
	}
}