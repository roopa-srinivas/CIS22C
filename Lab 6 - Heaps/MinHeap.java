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

    

    public boolean insert(BSTNode[] heap, int lastNodeIndex, BSTNode newNode) {
        if (currentSize == capacity) {
            return false;
        }
        lastNodeIndex++;
        heap[lastNodeIndex] = newNode;
        reheapUp (heap, lastNodeIndex);
        return true;
    }

    public void reheapUp(BSTNode[] heap, int newNodeIndex) {
        if (newNodeIndex != 0) {
            int parentIndex = getParentIndex(newNodeIndex);
            //set parent to parent of newNode
            if (heap[newNodeIndex].getData().isGreater(heap[parentIndex].getData())){
                BSTNode temp = heap[newNodeIndex];
                heap[newNodeIndex] = heap[parentIndex];
                heap[parentIndex] = temp;
                reheapUp(heap, parentIndex);
            }
        }
    }

    // need to complete
    public void reheapDown(BSTNode[] heap, int rootIndex, int lastNodeIndex) {
        int leftKey = 0;
        int rightKey = 0;
        if (currentSize >= 2) {
            leftKey = 1; //need to fix --> should be height of left subtree -- i think?
            if (currentSize >= 3) {
                rightKey = 2; //need to fix --> should be height of right subtree -- i think?
            } else {
                rightKey = -1;
            }

            if (leftKey > rightKey) {

            }
        }
    }

    public void buildHeap (BSTNode[] heap, int size) {
        for (int i = 1; i < size; i++) {
            reheapUp(heap, i);
        }
    }

    public boolean deleteHeap (BSTNode[] heap, int lastNodeIndex, BSTNode dataOut) {
        if (currentSize == 0) {
            return false;
        }
        dataOut = heap[0];
        heap[0] = heap[lastNodeIndex];
        lastNodeIndex--;
        reheapDown(heap, 0, lastNodeIndex);
        return true;
    }




    // private void swap(BSTNode[] arr, int a, int b) {
    //     BSTNode temp = arr[a];
    //     arr[a] = arr[b];
    //     arr[b] = temp;
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