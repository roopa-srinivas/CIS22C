public class Queue extends SinglyLinkedList{

    public Queue() {
        super();
    }

    public void enqueue(Currency currencyToEnqueue) {
        addCurrency(currencyToEnqueue, countCurrency());
    }

    public Currency dequeue() {
        LinkNode currentNode = getEnd();
        return removeCurrency(currentNode.getData());
    }

    public Currency peekFront() {
        return getStart().getData();
    }

    public Currency peekRear() {
        return getEnd().getData();
    }

    public String printQueue() {
        return printList();
    }

    
}
