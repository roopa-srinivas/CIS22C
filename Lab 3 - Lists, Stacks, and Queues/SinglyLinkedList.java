public class SinglyLinkedList {
    private int count;
    private LinkNode start, end;

    public SinglyLinkedList() {
        count = 0;
    }

    public SinglyLinkedList(LinkNode start, LinkNode end) {
        count = 2;
        this.start = start;
        this.end = end;
    }

    public int getCount() {
        return count;
    }
    public LinkNode getStart() {
        return start;
    }
    public LinkNode getEnd() {
        return end;
    }


    public void setStart(LinkNode start) {
        this.start = start;
    }
    public void setEnd(LinkNode end) {
        this.end = end;
    }


    public void addCurrency(Currency currencyToAdd, int nodeIndex) {
        LinkNode newNode = new LinkNode(currencyToAdd);
        if (count == 0) {
            setStart(newNode);
            setEnd(newNode);
        } else {
            LinkNode previousNode;
            LinkNode currentNode = getStart();
            if (currentNode.hasNextNode()) {
                previousNode = currentNode;
                currentNode = currentNode.getNextNode();
            } else {
                previousNode = getEnd();
                currentNode = null;
            }

            if (nodeIndex == 0) {
                newNode.setNextNode(getStart());
                setStart(newNode);
            } else if (nodeIndex == count) {
                getEnd().setNextNode(newNode);
                setEnd(newNode);
            } else {
                previousNode = getNode(count-1);
                currentNode = previousNode.getNextNode();
                newNode.setNextNode(currentNode);
                previousNode.setNextNode(newNode);
            }
        }
        count++;
    }

    public Currency removeCurrency(Currency currencyToRemove) {
        LinkNode currentNode = getStart();
        LinkNode previousNode;
        int currencyToRemoveIndex = findCurrency(currencyToRemove);
        for (int i = 0; i < currencyToRemoveIndex; i++) {
            currentNode = currentNode.getNextNode();
        }
        previousNode = getNode(currencyToRemoveIndex-1);
        previousNode.setNextNode(currentNode.getNextNode());
        return currencyToRemove; 
    }

    public int findCurrency(Currency currencyToFind) {
        int nodeIndex = 0;
        LinkNode currentNode = getStart();
        if (currentNode.getData() == currencyToFind) {
            return nodeIndex;
        } else {
            if (currentNode.hasNextNode()) {
                currentNode = currentNode.getNextNode();
                nodeIndex++;
            }
        }
        return -1;
    }

    public Currency getCurrency(int indexValue) {
        LinkNode currentNode = getStart();
        for (int i = 0; i < indexValue; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getData();
    }

    public LinkNode getNode(int indexValue) {
        if (indexValue >= getCount()) {
            return getStart();
        }
        LinkNode currentNode = getStart();
        for (int i = 0; i < indexValue; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    public String printList() {
        LinkNode currentNode = getStart();
        String returnList = "";
        while (currentNode.hasNextNode()) {
            // returnList += currentNode.getData().print() + "\n"; 
            //Currency.print is a void method so we need to figure out how to call that here (maybe we modify that print method to return a String)
        }
        return returnList; //need to replace
    }

    public boolean isListEmpty() {
        if (start == null && end == null) {
            return true;
        } 
        return false;
    }

    public int countCurrency() {
        return count;
    }
}
