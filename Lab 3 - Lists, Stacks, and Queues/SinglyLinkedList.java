public class SinglyLinkedList {
    private int count;
    private LinkNode start, end;

    public SinglyLinkedList() {
        count = 0;
        start = null;
        end = null;
    }

    public SinglyLinkedList(LinkNode start, LinkNode end) {
        count = 2;
        this.start = start;
        this.end = end;
    }

    public LinkNode getStart() {
        return start;
    }
    public LinkNode getEnd() {
        return end;
    }

    public void setCount(int ct)
    {
        count = ct;
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
            if (nodeIndex == 0) {
                newNode.setNext(getStart());
                setStart(newNode);
            } else if (nodeIndex == count) {
                getEnd().setNext(newNode);
                setEnd(newNode);
            } else {
                LinkNode previousNode = getNode(nodeIndex-1);
                newNode.setNext(previousNode.getNext());
                previousNode.setNext(newNode);
            }
        }
        count++;
    }

    public Currency removeCurrency(Currency currencyToRemove) {
        int currencyToRemoveIndex = findCurrency(currencyToRemove);
        return removeCurrency(currencyToRemoveIndex);
    }

    public Currency removeCurrency(int currencyToRemoveIndex) {
       /* LinkNode currentNode = getStart();
        Currency temp = getNode(currencyToRemoveIndex).getData();
        LinkNode previousNode;
        if(count>0)
        {
            if(currencyToRemoveIndex ==0 && count>0)
            {
                if (currentNode.hasNext()) {
                    currentNode = currentNode.getNext();
                    setStart(currentNode);
                } else {
                    setStart(null);
                    setEnd(null);
                }
            }
            else if(currencyToRemoveIndex==count-1 && count>0)
            {
                previousNode = getNode(count-2);
                previousNode.setNext(null);
                setEnd(previousNode);
            }
            else
            {
                for (int i = 0; i < currencyToRemoveIndex; i++) {
                    currentNode = currentNode.getNext();
                }
                previousNode = getNode(currencyToRemoveIndex-1);
                previousNode.setNext(currentNode.getNext());
            }
            count--;
        }
        return temp;
        */

        LinkNode currentNode = getStart();
        if (currencyToRemoveIndex == 0) {
            setStart(currentNode.getNext());
        } else {
            LinkNode previousNode = getNode(currencyToRemoveIndex - 1);
            previousNode.setNext(currentNode.getNext());
        }
        count--;
        return currentNode.getData(); 
    }

    public int findCurrency(Currency currencyToFind) {
        int nodeIndex = 0;
        LinkNode currentNode = getStart();
        while(nodeIndex<count && currentNode !=null)
        {
            if (currentNode.getData().isEqual(currencyToFind)) {
                return nodeIndex;
            }
            currentNode = currentNode.getNext();
            nodeIndex++;
        }
        return -1;
    }

    public Currency getCurrency(int indexValue) {
        LinkNode currentNode = getNode(indexValue);
        if(currentNode==null)
            return getStart().getData();
        else
            return currentNode.getData();
    }

    public LinkNode getNode(int indexValue) {
        LinkNode currentNode = getStart();
        if(indexValue<0 || indexValue>=count)
            return null;
        else
        {
            for (int i = 0; i < indexValue; i++) {
                currentNode = currentNode.getNext();
            }
            return currentNode;
        }
    }

    public String printList() {
        LinkNode currentNode = getStart();
        String returnList = "";
        while (currentNode!=null) {
            returnList += currentNode.getData().getCurrencyAsString() + "\t"; 
            currentNode = currentNode.getNext();
        }
        return returnList; 
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
