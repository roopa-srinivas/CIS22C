public class Stack extends SinglyLinkedList {

    public Stack () {
        super();
    }

    public void push(Currency currencyToPush) {
        addCurrency(currencyToPush, 0);
    }

    public Currency pop() {
        LinkNode nodeToRemove = getStart();
        return removeCurrency(nodeToRemove.getData());
    }

    public Currency peek() {
        return getStart().getData();
    }

    public String printStack() {
        return printList();
    }
}
