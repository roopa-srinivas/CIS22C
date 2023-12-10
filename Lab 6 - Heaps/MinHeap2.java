public class MinHeap2 extends BST {

    //breadth first traversal
    //keep track of which level you are at so you can know how many nodes to check (need to check all nodes in last level)
    //remove --> remove node, replace with right most node in sub-tree, then re-heap down, then move very last node to empty spot, then add next data into very end
    //heap sort --> always remove root node

    private BSTNode root;

    public MinHeap2() {
        super();
        root = null;
    }

    @Override
    public void insert(Dollar value) {
        super.insert(value);
        heapifyUp(root, value);
	}

    private void heapifyUp(BSTNode node, Dollar value) {
        if (node == null) {
            return;
        }

        BSTNode parent = findParent(root, value);
        while (parent != null && (!node.getData().isGreater(parent.getData()))) {
            Dollar temp = node.getData();
            node.setData(parent.getData());
            parent.setData(temp);

            node = parent;
            parent = findParent(root, node.getData());
        }
    }

    private BSTNode findParent(BSTNode root, Dollar value) {
        if (root == null || root.getData() == value) {
            return null;
        }

        BSTNode parent = null;
        BSTNode current = root;

        while (current != null && current.getData() != value) {
            parent = current;
            if (!value.isGreater(current.getData())) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        return parent;
    }

    @Override
    public void delete(Dollar value) {
        root = remove(root, value);
    }

    @Override
    public BSTNode remove(BSTNode root, Dollar value) {
        if (root == null) {
            return null;
        }

        if (!value.isGreater(root.getData())) {
            root.setLeftChild(remove(root.getLeftChild(), value));
        } else if (value.isGreater(root.getData())) {
            root.setRightChild(remove(root.getRightChild(), value));
        } else {
            if (root.getLeftChild() == null) {
                return root.getRightChild();
            } else if (root.getRightChild() == null) {
                return root.getLeftChild();
            }

            root.setData(minNode(root.getRightChild()).getData());
            root.setRightChild(remove(root.getRightChild(), root.getData()));
        }

        return root;
    }

    @Override
    public BSTNode search(Dollar key) {
        return recurseSearch(root, key);
    }

    public BSTNode recursiveSearch (BSTNode root, Dollar key) {
        if (root == null) {
            return null;
        }

        if (key == root.getData()) {
            return root;
        } else if (!key.isGreater(root.getData())) {
            return recurseSearch(root.getLeftChild(), key);
        } else {
            return recurseSearch(root.getRightChild(), key);
        }
    }
    
}
