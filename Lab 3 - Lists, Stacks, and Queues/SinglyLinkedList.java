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

    public void setCount(int count) {
        this.count = count;
    }
    public void setStart(LinkNode start) {
        this.start = start;
    }
    public void setEnd(LinkNode end) {
        this.end = end;
    }


    public void addCurrency(Currency currencyToAdd, int nodeIndex) {
        count++;
    }

    public Currency removeCurrency(Currency currencyToRemove) {
        count--;
        return currencyToRemove; //need to replace
    }

    public int findCurrency(Currency currencyToFind) {
        return 0; //need to replace
    }

    public Currency getCurrency(int indexValue) {
        return new Dollar(); //need to replace
    }

    public String printList() {
        return ""; //need to replace
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
