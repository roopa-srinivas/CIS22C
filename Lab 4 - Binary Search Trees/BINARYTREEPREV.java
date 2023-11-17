/**
 *	Binary Tree of Comparable values.
 *	The tree only has unique values. It does not add duplicate values.
 *	
 *	@author	Kanchan Kaushik
 *	@since	25 May 2023
 */
import java.util.ArrayList;
public class BinaryTree<E extends Comparable<E>> {

	private TreeNode<E> root;		// the root of the tree
	
	private final int PRINT_SPACES = 3;	// print spaces between tree levels
										// used by printTree()
	
	/**	constructor for BinaryTree */
	public BinaryTree() 
	{
		root = null;
	}
	
	/**	Field accessors and modifiers */
	
	/**	Add a node to the tree
	 *	@param value		the value to put into the tree
	 */
	public void add(E value) 
	{
		/* iterative version of code
		TreeNode<E> curr = root;
		TreeNode<E> toAdd = new TreeNode<E>(value);
		boolean hasAdded = false;
		if(root == null)
		{
			root = toAdd;
			return;
		}
		while(!hasAdded)
		{
			if(curr.getValue().compareTo(value)>0)
			{
				if(curr.getLeft()==null)
				{
					curr.setLeft(toAdd);
					hasAdded = true;
				}
				else
					curr = curr.getLeft();
			}
			else
			{
				if(curr.getRight()==null)
				{
					curr.setRight(toAdd);
					hasAdded = true;
				}
				else
					curr = curr.getRight();
			}
		}*/

		// recursive version of code

		TreeNode<E> curr = root;
		TreeNode<E> toAdd = new TreeNode<E>(value);
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
	public void recursiveAdd(E value, TreeNode<E> curr)
	{
		if(curr.getValue().compareTo(value)>0)
		{
			if(curr.getLeft()==null)
			{
				curr.setLeft(new TreeNode<E>(value));
				return;
			}
			else
				recursiveAdd(value, curr.getLeft());
		}
		else
		{
			if(curr.getRight()==null)
			{
				curr.setRight(new TreeNode<E>(value));
				return;
			}
			else
				recursiveAdd(value, curr.getRight());
		}
	}
	
	/**
	 *	Print Binary Tree Inorder
	 */
	public void printInorder() 
	{
		recurseInorder(root);
	}

	/** Recursively goes down left subtree until reaches
	 * a node that is null, prints node, then goes down 
	 * right subtree until reaches a null node.
	 * @param curr the current tree node
	 */
	public void recurseInorder(TreeNode<E> curr)
	{
		if(curr.getLeft()!= null)
			recurseInorder(curr.getLeft());
		
		System.out.print(curr.getValue() + " ");

		if(curr.getRight()!= null)
			recurseInorder(curr.getRight());
	}
	
	/**
	 *	Print Binary Tree Preorder
	 */
	public void printPreorder() 
	{
		recursePreorder(root);
	}

	/** Recursively prints node, goes down left subtree 
	 * until reaches a null node, then goes down 
	 * right subtree until reaches null node.
	 * @param curr the current tree node
	 */
	public void recursePreorder(TreeNode<E> curr)
	{
		System.out.print(curr.getValue() + " ");

		if(curr.getLeft()!= null)
			recursePreorder(curr.getLeft());

		if(curr.getRight()!= null)
			recursePreorder(curr.getRight());
	}
	
	/**
	 *	Print Binary Tree Postorder
	 */
	public void printPostorder() 
	{
		recursePostorder(root);
	}

	/** Recursively goes down left subtree 
	 * until reaches a null node, then goes down 
	 * right subtree until reaches null node, then 
	 * prints node
	 * @param curr the current tree node
	 */
	public void recursePostorder(TreeNode<E> curr)
	{
		if(curr.getLeft()!= null)
			recursePostorder(curr.getLeft());

		if(curr.getRight()!= null)
			recursePostorder(curr.getRight());

		System.out.print(curr.getValue() + " ");
	}
		
	/**	Return a balanced version of this binary tree
	 *	@return		the balanced tree
	 */
	public BinaryTree<E> makeBalancedTree() {
		BinaryTree<E> balancedTree = new BinaryTree<E>();
		ArrayList<E> vals = new ArrayList<E>();
		storeInorder(root, vals);
		recurseBalance(0, vals.size()-1, balancedTree, vals);
		return balancedTree;
	}

	/** Recursively adds the "middle" value between two indices to balance
	 * the tree. Splits the tree into right and left subtrees to add
	 * @param start the start index
	 * @param end the end index
	 * @param balancedTree the binary tree to add to
	 * @param vals the list of vals to add values from 
	 */
	public void recurseBalance(int start, int end, BinaryTree<E> balancedTree, ArrayList<E> vals)
	{
		int ind = (start+end)/2;
		balancedTree.add(vals.get(ind));
		if(ind !=start)
			recurseBalance(start, ind-1, balancedTree, vals);
		if(ind != end)
			recurseBalance(ind+1, end, balancedTree, vals);
	}

	/** Recursively adds the numbers of the binary tree to 
	 * an arraylist of values in the order "Inorder"
	 * @param curr 	current tree node
	 * @param vals the arraylist to add to
	 */
	public void storeInorder(TreeNode<E> curr, ArrayList<E> vals)
	{
		if(curr.getLeft()!= null)
			storeInorder(curr.getLeft(), vals);
		
		vals.add(curr.getValue());

		if(curr.getRight()!= null)
			storeInorder(curr.getRight(), vals);
	}
	
	/**
	 *	Remove value from Binary Tree
	 *	@param value		the value to remove from the tree
	 *	Precondition: value exists in the tree
	 */
	public void remove(E value) {
		root = remove(root, value);
	}
	/**
	 *	Remove value from Binary Tree
	 *	@param node			the root of the subtree
	 *	@param value		the value to remove from the subtree
	 *	@return				TreeNode that connects to parent
	 */
	public TreeNode<E> remove(TreeNode<E> node, E value) {
		if(node == null)
			return null;
		int diff = (node.getValue()).compareTo(value);
		if(diff>0)
			node.setLeft(remove(node.getLeft(),value));
		else if(diff<0)
			node.setRight(remove(node.getRight(),value));
		else
		{
			if(node.getLeft()==null)
				return node.getRight();
			else if(node.getRight()==null)
				return node.getLeft();

			TreeNode<E> minimum = minNode(node.getRight());
			TreeNode<E> temp = new TreeNode<E> (minimum.getValue(), node.getLeft(), node.getRight());
			node = temp;
			node.setRight(remove(node.getRight(), minimum.getValue())) ;
		}
		return node;
	}

	/**
	 *	Find node with min val in binary tree
	 *	@param n			the root of the subtree
	 *	@return				TreeNode with min value
	 */
	public TreeNode<E> minNode(TreeNode<E> n)
	{
		TreeNode<E> curr = n;
		while (curr.getLeft() != null)
			curr = curr.getLeft();
		return curr;
	}

	/*******************************************************************************/	
	/********************************* Utilities ***********************************/	
	/*******************************************************************************/	
	/**
	 *	Print binary tree
	 *	@param root		root node of binary tree
	 *
	 *	Prints in vertical order, top of output is right-side of tree,
	 *			bottom is left side of tree,
	 *			left side of output is root, right side is deepest leaf
	 *	Example Integer tree:
	 *			  11
	 *			/	 \
	 *		  /		   \
	 *		5			20
	 *				  /	  \
	 *				14	   32
	 *
	 *	would be output as:
	 *
	 *				 32
	 *			20
	 *				 14
	 *		11
	 *			5
	 ***********************************************************************/
	public void printTree() {
		printLevel(root, 0);
	}
	
	/**
	 *	Recursive node printing method
	 *	Prints reverse order: right subtree, node, left subtree
	 *	Prints the node spaced to the right by level number
	 *	@param node		root of subtree
	 *	@param level	level down from root (root level = 0)
	 */
	private void printLevel(TreeNode<E> node, int level) {
		if (node == null) return;
		// print right subtree
		printLevel(node.getRight(), level + 1);
		// print node: print spaces for level, then print value in node
		for (int a = 0; a < PRINT_SPACES * level; a++) System.out.print(" ");
		System.out.println(node.getValue());
		// print left subtree
		printLevel(node.getLeft(), level + 1);
	}
	
	
}
