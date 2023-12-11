import java.util.Arrays;

public class lab6main {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(20);
        
        
        heap.insert(new Dollar(57.12));
        heap.insert(new Dollar(23.44));
        heap.insert(new Dollar(87.43));
        heap.insert(new Dollar(68.99));
        heap.insert(new Dollar(111.22));
        heap.insert(new Dollar(44.55));
        heap.insert(new Dollar(77.77));
        heap.insert(new Dollar(18.36));
        heap.insert(new Dollar(543.21));
        heap.insert(new Dollar(20.21));

        heap.insert(new Dollar(345.67));
        heap.insert(new Dollar(36.18));
        heap.insert(new Dollar(48.48));
        heap.insert(new Dollar(101.00));
        heap.insert(new Dollar(11.00));
        heap.insert(new Dollar(21.00));
        heap.insert(new Dollar(51.00));
        heap.insert(new Dollar(1.00));
        heap.insert(new Dollar(251.00));
        heap.insert(new Dollar(151.00));

        System.out.println(heap.print());

        heap.minHeap();
        heap.printHeap();
        heap.makeBST();

    }
}
