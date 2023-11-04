public class Stack extends SinglyLinkedList {
    SinglyLinkedList stack = new SinglyLinkedList();

    public Stack () {
        super();
    }

    public void push(Currency currencyToPush) {
        stack.addCurrency(currencyToPush, 0);
    }

    public Currency pop() {
        LinkNode nodeToRemove = stack.getStart();
        return stack.removeCurrency(nodeToRemove.getData());
    }

    public Currency peek() {
        return stack.getStart().getData();
    }

    public String printStack() {
        return ""; //need to replace
    }
}
