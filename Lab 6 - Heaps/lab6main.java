public class lab6main {
    public static void main(String[] args) {
        Queue money = new Queue();
        
        money.enqueue(new Dollar(57.12));
        money.enqueue(new Dollar(23.44));
        money.enqueue(new Dollar(87.43));
        money.enqueue(new Dollar(68.99));
        money.enqueue(new Dollar(111.22));
        money.enqueue(new Dollar(44.55));
        money.enqueue(new Dollar(77.77));
        money.enqueue(new Dollar(18.36));
        money.enqueue(new Dollar(543.21));
        money.enqueue(new Dollar(20.21));
        money.enqueue(new Dollar(345.67));
        money.enqueue(new Dollar(36.18));
        money.enqueue(new Dollar(48.48));
        money.enqueue(new Dollar(101.00));
        money.enqueue(new Dollar(11.00));
        money.enqueue(new Dollar(21.00));
        money.enqueue(new Dollar(51.00));
        money.enqueue(new Dollar(1.00));
        money.enqueue(new Dollar(251.00));
        money.enqueue(new Dollar(151.00));

        MinHeap heap = new MinHeap();
        while (money.countCurrency()>0) {
            heap.insert(new Dollar(money.dequeue()));
        }

    }
}
