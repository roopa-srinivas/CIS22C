public class MinHeap extends BST {
    private Dollar[] heap;
    private int capacity;
    private int currentSize;

    public MinHeap(int n) {
        capacity = n;
        heap = new Dollar[capacity];
        currentSize = 0;
        for (int i = 0; i < capacity; i++) {
            heap[i] = new Dollar();
        }
    }

    private void swap(Dollar[] arr, int a, int b) {
        Dollar temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // private void swap(BSTNode value1, BSTNode value2) {
    //     BSTNode temp = new BSTNode(value1.getData());
    //     value1.setData(value2.getData());
    //     value2.setData(temp.getData());
    // }

    private int getParentIndex(int key) {
        return (key-1)/2;
    }

    private int getLeftChildIndex(int key) {
        return 2*key+1;
    }

    private int getRightChildIndex(int key) {
        return 2*key+2;
    }

    public void insert(Dollar node) {
        if(currentSize == capacity) {
            //resize
            return;
        }

        int i = currentSize;
        heap[i] = node;
        currentSize++;

        while (i != 0 && (!heap[i].isGreater(heap[getParentIndex(i)]))) {
            swap(heap, i, getParentIndex(i));
            i = getParentIndex(i);
        }
    }

    public void decreaseKey(int index, Dollar value) {
        heap[index] = value;

        while (index != 0 && (!heap[index].isGreater(heap[getParentIndex(index)]))){
            swap(heap, index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public Dollar getMinDollar() {
        return heap[0];
    }

    public Dollar extractMinDollar() {
        if (currentSize <= 0) {
            return null;
        }

        if(currentSize == 1) {
            currentSize--;
            return heap[0];
        }

        Dollar root = heap[0];
        heap[0] = heap[currentSize-1];
        currentSize--;
        minHeapify(0);
        return root;
    }

    public void delete(int index, Dollar value) {
        decreaseKey(index, value);
        extractMinDollar();
    }

    private void minHeapify(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        int smallest = index;
        if (leftChildIndex < currentSize && (!heap[leftChildIndex].isGreater(heap[smallest]))) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < currentSize && (!heap[rightChildIndex].isGreater(heap[smallest]))) {
            smallest = rightChildIndex;
        }

        if (smallest != index) {
            swap(heap, index, smallest);
            minHeapify(smallest);
        }
    }

    public void increaseKey(int index, Dollar value) {
        heap[index] = value;
        minHeapify(index);
    }

    public void changeValue(int index, Dollar value) {
        if (heap[index] == value) {
            return;
        }

        if (heap[index].isGreater(value)) {
            decreaseKey(index, value);
        } else {
            increaseKey(index, value);
        }
    }
}