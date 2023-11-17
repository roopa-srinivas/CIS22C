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

    public Dollar getData() {
        return data;
    }
    public BSTNode getLeftChild () {
        return leftChild;
    }
    public BSTNode getRightChild() {
        return rightChild;
    }

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