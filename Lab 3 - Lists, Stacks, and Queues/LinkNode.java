public class LinkNode {
    private Currency data;
    private LinkNode nextNode;

    public LinkNode() {
        nextNode = new LinkNode();
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
}