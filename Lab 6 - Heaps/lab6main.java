public class lab6main {
    public static void main(String[] args) {
        Queue money = new Queue();
        MinHeap heap = new MinHeap(10);
        
        money.enqueue(new Dollar(57.12));
        System.out.println("added 1st");
        money.enqueue(new Dollar(23.44));
        money.enqueue(new Dollar(87.43));
        money.enqueue(new Dollar(68.99));
        money.enqueue(new Dollar(111.22));
        money.enqueue(new Dollar(44.55));
        money.enqueue(new Dollar(77.77));
        money.enqueue(new Dollar(18.36));
        money.enqueue(new Dollar(543.21));
        money.enqueue(new Dollar(20.21));
        System.out.println("added 10th");
        System.out.println("count currency: " + money.countCurrency());
        while (money.countCurrency()>0) {
            System.out.println("count currency: " + money.countCurrency());
            heap.insert(new BSTNode(new Dollar(money.dequeue())));
        }
        System.out.println("added 10 to heap");
        heap.minHeap();
        System.out.println("First 10 dollar values: ");
        System.out.println(heap.print());
        System.out.println("-----------------------------");

        // money.enqueue(new Dollar(345.67));
        // money.enqueue(new Dollar(36.18));
        // money.enqueue(new Dollar(48.48));
        // money.enqueue(new Dollar(101.00));
        // money.enqueue(new Dollar(11.00));
        // money.enqueue(new Dollar(21.00));
        // money.enqueue(new Dollar(51.00));
        // money.enqueue(new Dollar(1.00));
        // money.enqueue(new Dollar(251.00));
        // money.enqueue(new Dollar(151.00));

        // while (money.countCurrency()>0) {
        //     heap.insert(new BSTNode(new Dollar(money.dequeue())));
        // }
        // heap.minHeap();
        // System.out.println("All dollar values: ");
        // System.out.println(heap.print());
        // System.out.println("-----------------------------");

    }
}
