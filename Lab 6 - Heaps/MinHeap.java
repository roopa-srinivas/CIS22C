public class MinHeap extends BST {
    private BSTNode[] heap;
    private int capacity;
    private int currentSize;
    
    public MinHeap(int n) {
        capacity = n;
        heap = new BSTNode[capacity];
        currentSize = 0;
        for (int i = 0; i < capacity; i++) {
            heap[i] = new BSTNode(new Dollar());
        }
    }

    public BSTNode[] getHeap() {
        return heap;
    }

    private int getParentIndex(int key) {
        return (key-1)/2;
    }

    private int getLeftChildIndex(int key) {
        return 2*key+1;
    }

    private int getRightChildIndex(int key) {
        return 2*key+2;
    }

    private boolean isLeaf (int key) {
        if (getRightChildIndex(key) >= capacity || getLeftChildIndex(key) >= capacity){
            return true;
        }
        return false;
    }

    @Override
    public void recursiveAdd(Dollar value, BSTNode curr) {
        if (currentSize >= capacity) {
            return;
        }
        heap[currentSize] = new BSTNode(value);
        int index = currentSize;

        while (value.isGreater(heap[getParentIndex(index)].getData())) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
        currentSize++;
    }

    private void swap(int index1, int index2) {
        BSTNode temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void minHeapify(int key) {
        if (!isLeaf(key)) {
            if (heap[getLeftChildIndex(key)].getData().isGreater(heap[key].getData()) ||
                heap[getRightChildIndex(key)].getData().isGreater(heap[key].getData())) {
                    if (heap[getRightChildIndex(key)].getData().isGreater(heap[getLeftChildIndex(key)].getData())) {
                        swap(key, getLeftChildIndex(key));
                        minHeapify(getLeftChildIndex(key));
                    } else {
                        swap(key, getRightChildIndex(key));
                        minHeapify(getRightChildIndex(key));
                    }
            }
        }
    }

    public void minHeap() {
        for (int i = (currentSize-1)/2; i >= 1; i--) {
            minHeapify(i);
        }
    }   

    public BSTNode makeBST() {
        return createBST(0, heap.length-1);
    }

    private BSTNode createBST(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right-left)/2;
        BSTNode root = new BSTNode(new Dollar(heap[mid].getData()));
        root.setLeftChild(createBST(left, mid-1));
        root.setRightChild(createBST(mid+1, right));
        return root;
    }

    public void printHeap() {
        for (int i = 0; i < currentSize; i++) {
            heap[i].getData().print();
            System.out.println();
        }
	}

    public BSTNode remove (BSTNode node, Dollar value) {
        for (int i = 0; i < currentSize; i++) {
            if (heap[i].getData().isEqual(value)) {
                BSTNode removed = heap[i];
                heap[i].setData(heap[currentSize-1].getData());
                heap[currentSize-1].setData(null);
                return removed;
            }
        }
        return null;
    }

    // @Override
    // public String print() {
    //     String printout = "";
    //     for (int i = 0; i < currentSize; i++) {
    //         printout += "$" + heap[i].getData().getCurrencyAsString() + "  ";
    //     }
    //     return printout;
    // }

    // @Override    
    // public BSTNode remove(BSTNode node, Dollar value) {
	// 	if(node == null)
	// 		return null;
    //     for (int i = 0; i < currentSize; i++) {
    //         if (heap[i].getData().isEqual(value)) {
    //             BSTNode removed = heap[i];
    //             heap[i] = heap[currentSize-1];
    //             return removed;
    //         }
    //     } 
	// 	if(value.isGreater(node.getData()))
	// 		node.setLeftChild(remove(node.getLeftChild(),value));
    //     else if(value.isEqual(node.getData()))
	// 	{
	// 		if(node.getLeftChild()==null)
	// 			return node.getRightChild();
	// 		else if(node.getRightChild()==null)
	// 			return node.getLeftChild();

	// 		BSTNode minimum = minNode(node.getRightChild());
	// 		BSTNode temp = new BSTNode(minimum.getData(), node.getLeftChild(), node.getRightChild());
	// 		node = temp;
	// 		node.setRightChild(remove(node.getRightChild(), minimum.getData())) ;
	// 	}
	// 	else
	// 		node.setRightChild(remove(node.getRightChild(),value));
		
	// 	return node;
	// }

// ill do insert/heapify:

// public void recursiveAdd(Dollar value, BSTNode curr)
// {
//     if(value.isGreater(curr.getData()))
//     {
//         if(curr.getLeftChild()==null)
//         {
//             curr.setLeftChild(new BSTNode(value));
//             return;
//         }
//         else
//             recursiveAdd(value, curr.getLeftChild());
//     }
//     else
//     {
//         if(curr.getRightChild()==null)
//         {
//             curr.setRightChild(new BSTNode(value));
//             return;
//         }
//         else
//             recursiveAdd(value, curr.getRightChild());
//     }
// }



/*
private BSTNode root;
    private BSTNode[] heap;
    private int capacity;
    private int currentSize;
*/
/*
    public MinHeap(int n) {
        root = null;
        capacity = n;
        heap = new BSTNode[capacity];
        currentSize = 0;
        for (int i = 0; i < capacity; i++) {
            heap[i] = new BSTNode(new Dollar());
        }
    }*/

    
    
    // @Override
    // public void insert(Dollar newValue) {
    //     BSTNode newNode = new BSTNode(newValue);
    //     if (currentSize >= capacity) {
    //         return;
    //     }
    //     if (root == null) {
    //         root = newNode;
    //         return;
    //     }
    //     heap[currentSize] = newNode;
    //     int currentIndex = currentSize;
    //     while (heap[getParentIndex(currentIndex)].getData().isGreater(heap[currentIndex].getData())) {
    //         swap(currentIndex, getParentIndex(currentIndex));
    //     }
    //     currentSize++;
        
    // }

    // private void swap(int index1, int index2) {
    //     BSTNode temp = heap[index1];
    //     heap[index1] = heap[index2];
    //     heap[index2] = temp;
    // }

    // @Override
    // public BSTNode remove(BSTNode node, Dollar value) {
    //     BSTNode removed = node;
    //     heap[0] = heap[--currentSize];
    //     minHeapify(0);
    //     return removed;
    // }

    // private void minHeapify(int key) {
    //     if (!isLeaf(key)) {
    //         if (heap[key].getData().isGreater(heap[getLeftChildIndex(key)].getData()) ||
    //             heap[key].getData().isGreater(heap[getRightChildIndex(key)].getData())) {
    //                 if (heap[getLeftChildIndex(key)].getData().isGreater(heap[getRightChildIndex(key)].getData())) {
    //                     swap(key, getLeftChildIndex(key));
    //                     minHeapify(getLeftChildIndex(key));
    //                 } else {
    //                     swap(key, getRightChildIndex(key));
    //                     minHeapify(getRightChildIndex(key));
    //                 }
    //         }
    //     }
    // }

    // public void minHeap() {
    //     for (int i = (currentSize-1)/2; i >= 1; i--) {
    //         minHeapify(i);
    //     }
    // }

    // private int getParentIndex(int key) {
    //     return (key-1)/2;
    // }

    // private int getLeftChildIndex(int key) {
    //     return 2*key+1;
    // }

    // private int getRightChildIndex(int key) {
    //     return 2*key+2;
    // }

    // private boolean isLeaf(int key) {
    //     if (getRightChildIndex(key) >= capacity || getLeftChildIndex(key) >= capacity) {
    //         return true;
    //     }
    //     return false;
    // }


    

    // public boolean insert(BSTNode[] heap, int lastNodeIndex, BSTNode newNode) {
    //     if (currentSize == capacity) {
    //         return false;
    //     }
    //     lastNodeIndex++;
    //     heap[lastNodeIndex] = newNode;
    //     reheapUp(heap, lastNodeIndex);
    //     return true;
    // }

    // public void reheapUp(BSTNode[] heap, int newNodeIndex) {
    //     if (newNodeIndex != 0) {
    //         int parentIndex = getParentIndex(newNodeIndex);
    //         if (heap[newNodeIndex].getData().isGreater(heap[parentIndex].getData())){
    //             BSTNode temp = heap[newNodeIndex];
    //             heap[newNodeIndex] = heap[parentIndex];
    //             heap[parentIndex] = temp;
    //             reheapUp(heap, parentIndex);
    //         }
    //     }
    // }

    // // need to complete
    // public void reheapDown(BSTNode[] heap, int rootIndex, int lastNodeIndex) {
    //     int leftKey = 0;
    //     int rightKey = 0;
    //     if (currentSize >= 2) {
    //         leftKey = 1; //need to fix --> should be height of left subtree -- i think?
    //         if (currentSize >= 3) {
    //             rightKey = 2; //need to fix --> should be height of right subtree -- i think?
    //         } else {
    //             rightKey = -1;
    //         }

    //         if (leftKey > rightKey) {

    //         }
    //     }
    // }

    // public void buildHeap (BSTNode[] heap, int size) {
    //     for (int i = 1; i < size; i++) {
    //         reheapUp(heap, i);
    //     }
    // }

    // public boolean deleteHeap (BSTNode[] heap, int lastNodeIndex, BSTNode dataOut) {
    //     if (currentSize == 0) {
    //         return false;
    //     }
    //     dataOut = heap[0];
    //     heap[0] = heap[lastNodeIndex];
    //     lastNodeIndex--;
    //     reheapDown(heap, 0, lastNodeIndex);
    //     return true;
    // }




    

    

    // public void insert(BSTNode node) {
    //     if(currentSize == capacity) {
    //         //resize
    //         return;
    //     }

    //     int i = currentSize;
    //     heap[i] = node;
    //     currentSize++;

    //     while (i != 0 && (!heap[i].getData().isGreater(heap[getParentIndex(i)].getData()))) {
    //         swap(heap, i, getParentIndex(i));
    //         i = getParentIndex(i);
    //     }
    // }
    
    // public void decreaseKey(int index, BSTNode value) {
    //     heap[index] = value;

    //     while (index != 0 && (!heap[index].getData().isGreater(heap[getParentIndex(index)].getData()))){
    //         swap(heap, index, getParentIndex(index));
    //         index = getParentIndex(index);
    //     }
    // }

    // public BSTNode getMinDollar() {
    //     return heap[0];
    // }

    // public BSTNode extractMinDollar() {
    //     if (currentSize <= 0) {
    //         return null;
    //     }

    //     if(currentSize == 1) {
    //         currentSize--;
    //         return heap[0];
    //     }

    //     BSTNode root = heap[0];
    //     heap[0] = heap[currentSize-1];
    //     currentSize--;
    //     minHeapify(0);
    //     return root;
    // }

    // public void delete(int index, BSTNode value) {
    //     decreaseKey(index, value);
    //     extractMinDollar();
    // }

    // private void minHeapify(int index) {
    //     int leftChildIndex = getLeftChildIndex(index);
    //     int rightChildIndex = getRightChildIndex(index);

    //     int smallest = index;
    //     if (leftChildIndex < currentSize && (!heap[leftChildIndex].getData().isGreater(heap[smallest].getData()))) {
    //         smallest = leftChildIndex;
    //     }
    //     if (rightChildIndex < currentSize && (!heap[rightChildIndex].getData().isGreater(heap[smallest].getData()))) {
    //         smallest = rightChildIndex;
    //     }

    //     if (smallest != index) {
    //         swap(heap, index, smallest);
    //         minHeapify(smallest);
    //     }
    // }

    // public void increaseKey(int index, BSTNode value) {
    //     heap[index] = value;
    //     minHeapify(index);
    // }

    // public void changeValue(int index, BSTNode value) {
    //     if (heap[index] == value) {
    //         return;
    //     }

    //     if (heap[index].getData().isGreater(value.getData())) {
    //         decreaseKey(index, value);
    //     } else {
    //         increaseKey(index, value);
    //     }
    // }
}