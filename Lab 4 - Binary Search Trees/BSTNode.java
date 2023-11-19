/*
BSTNode - a class that represents one element of the BST ADT
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate knowledge of ADTs using the Binary Search 
Tree on Currency and Dollar classes
*/
public class BSTNode {
    private Dollar data; // the value in this node
    private BSTNode leftChild; // left branch of this node
    private BSTNode rightChild; // right branch of this node

    public BSTNode(Dollar amt, BSTNode left, BSTNode right) {
        this.data = amt;
        this.leftChild = left;
        this.rightChild = right;
    }

    public BSTNode(Dollar amt) {
        this(amt, null, null);
    }

    /**
     * Getter methods to return data, leftChild, and rightChild nodes respectively
     * pre: none
     * post: used in BST to get Dollar or BSTNode object at specific nodes
     * return: data, leftChild, or rightChild
     */
    public Dollar getData() {
        return data;
    }
    public BSTNode getLeftChild () {
        return leftChild;
    }
    public BSTNode getRightChild() {
        return rightChild;
    }

    /**
     * Setter methods to set data, leftChild, and rightChild to be the respective parameters
     * pre: data parameter of Dollar type and leftChild and rightChild parameters of BSTNode type
     * post: data, leftChild, and rightChild have new values respectively
     * return: none
     */
    public void setData(Dollar amt) {
        data = amt;
    }
    public void setLeftChild(BSTNode left) {
        leftChild = left;
    }
    public void setRightChild(BSTNode right) {
        rightChild = right;
    }
}