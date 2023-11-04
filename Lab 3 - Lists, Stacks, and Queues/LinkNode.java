public class LinkNode {
    private Currency data;
    private LinkNode nextNode;

    public LinkNode(Currency data) {
        this.data = data;
    }

    public LinkNode(Currency data, LinkNode nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public Currency getData() {
        return data;
    }
    public LinkNode getNextNode() {
        return nextNode;
    }

    public void setData(Currency data) {
        this.data = data;
    }
    public void setNextNode(LinkNode nextNode) {
        this.nextNode = nextNode;
    }

    public boolean hasNextNode() {
        return getNextNode() != null;
    }
}