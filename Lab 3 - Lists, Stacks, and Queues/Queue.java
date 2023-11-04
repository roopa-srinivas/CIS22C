public class Queue extends SinglyLinkedList{
    SinglyLinkedList queue = new SinglyLinkedList();

    public Queue() {
        super();
    }

    public void enqueue(Currency currencyToEnqueue) {
        queue.addCurrency(currencyToEnqueue, getCount());
    }

    public Currency dequeue() {
        LinkNode currentNode = queue.getEnd();
        return queue.removeCurrency(currentNode.getData());
    }

    public Currency peekFront() {
        LinkNode currentNode = queue.getStart();
        return currentNode.getData();
    }

    public Currency peekBack() {
        LinkNode currentNode = queue.getEnd();
        return currentNode.getData();
    }

    public String printQueue() {
        return ""; //need to replace
    }

    
}
