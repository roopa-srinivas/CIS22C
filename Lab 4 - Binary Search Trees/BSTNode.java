public class BSTNode {
    Dollar data;
    BSTNode leftChild, rightChild;

    public BSTNode(Dollar data) {
        this.data = data;
    }

    public BSTNode(Dollar data, BSTNode left, BSTNode right) {
        this.data = data;
        this.leftChild = left;
        this.rightChild = right;
    }

    public BSTNode getLeftChild () {
        return leftChild;
    }
    public BSTNode getRightChild() {
        return rightChild;
    }

    public void setLeftChild(BSTNode left) {
        leftChild = left;
    }
    public void setRightChild(BSTNode right) {
        rightChild = right;
    }
}