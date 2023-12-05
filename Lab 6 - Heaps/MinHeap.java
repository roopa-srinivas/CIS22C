public class MinHeap extends BST {

    //breadth first traversal
    //keep track of which level you are at so you can know how many nodes to check (need to check all nodes in last level)
    //remove --> remove node, replace with right most node in sub-tree, then re-heap down, then move very last node to empty spot, then add next data into very end
    //heap sort --> always remove root node

    public MinHeap() {
        super();
    }

    @Override
    public void insert(Dollar value) {

	}

    @Override
    public void delete(Dollar value) {

    }

    @Override
    public BSTNode search(Dollar key) {
        return new BSTNode(new Dollar());
    }
    
}
