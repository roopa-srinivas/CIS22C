/*
SinglyLinkedList - a class that represents a list ADT, with each node referencing
the node next to it (It can only be traversed in one direction)
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate knowledge of ADTs using the Binary Search 
Tree on Currency and Dollar classes
*/
public class SinglyLinkedList {
    private int count; // field variable represents current length of list
    private LinkNode start, end; // field variables represent first and last
                                // nodes that are currently in the list

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

    /**
     * Getter methods to return start and end nodes respectively
     * pre: none
     * post: used within this class to add/remove nodes and find nodes, etc.
     * return: start and end
     */
    public LinkNode getStart() {
        return start;
    }
    public LinkNode getEnd() {
        return end;
    }

    /**
     * Setter methods to set count, start, and end variables to be the respective parameters
     * pre: int ct, start and end of type LinkNode
     * post: data count, start, and/or end have new values have new values respectively
     * return: none
     */
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

    /**
     * Algorithm addCurrency(currencyToAdd, nodeIndex){
     *      create new node
     *      if (no nodes exist is the SinglyLinkedList)
     *          set start and end node to the new node
     *      else
     *          if (nodeIndex is 0)
     *              new node is added to start of list
     *          else if (nodeIndex is same as length of list)
     *              new node is added to end of list
     *          else
     *              new node is added to given nodeIndex
     * }
     * 
     * 
     * Method adds a new Currency object specified by the param at the specified index
     * 
     * pre: Currency currencyToAdd, int nodeIndex
     * post: the Currency has been added to the list
     * return: none
     */
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

    /**
     * Method removes a Currency object specified by the specified index
     * 
     * pre: int currencyToRemoveIndex
     * post: the Currency has been removed from the list at that index
     * return: the removed currency object
     */
    public Currency removeCurrency(Currency currencyToRemove) {
        int currencyToRemoveIndex = findCurrency(currencyToRemove);
        return removeCurrency(currencyToRemoveIndex);
    }

    /**
     * Method removes a Currency object specified by the object to remove
     *  if the remove index is 0
     *      the start element is removed and start is reset
     * otherwise
     *      iterate through to find which element to remove
     *      the remove by setting previous element to next one of current
     *      reset the end if the element to be removed is the last one
     * return removed element
     * 
     * pre: Currency currencyToRemove
     * post: the Currency specified has been removed from the list
     * return: the removed currency object
     */
    public Currency removeCurrency(int currencyToRemoveIndex) {
		if(currencyToRemoveIndex == 0)
		{
			LinkNode currentNode = getStart();
			setStart(getStart().getNext());
            count--;
			return currentNode.getData();
		}
		else
		{
			LinkNode tmp = getStart();
			int ind = 0;
			while (ind<count && tmp.getNext() != null)
			{
				if(ind+1 == currencyToRemoveIndex)
				{
					LinkNode currentNode = tmp.getNext();
					tmp.setNext(currentNode.getNext());
                    if(currencyToRemoveIndex==count-1)
                        setEnd(tmp);
                    count--;
					return currentNode.getData();
				}
				else
				{
					tmp = tmp.getNext();
					ind++;
				}
			}
            count--;
			return null;
		} 
    }

    /**
     * Method finds a Currency object specified by the Currency to find
     * 
     * pre: Currency currencyToFind
     * post: the Currency has been found, used to print out indices of certain elements in main
     * return: the index of the currencyToFind object in the SinglyLinkedList
     */
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

    /**
     * Method returns a Currency object specified by the index
     * 
     * pre: int indexValue
     * post: the Currency at an index specified has been found, used to search for a value
     * return: the Currency object at the specified index in the SinglyLinkedList
     */
    public Currency getCurrency(int indexValue) {
        LinkNode currentNode = getNode(indexValue);
        if(currentNode==null)
            return getStart().getData();
        else
            return currentNode.getData();
    }

    /**
     * Method returns a Linknode object specified by the index
     * 
     * pre: int indexValue
     * post: the LinkNodeode at an index specified has been found, used to search for a value
     * return: the LinkNode object at the specified index in the SinglyLinkedList
     */
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

    /**
     * Method iterates through the list, printing each element to a String
     * 
     * pre: none
     * post: the String returnList is concatenated with the values of all the list elements
     * return: the returnList string with the values of all the SinglyLinkedList Elements
     */
    public String printList() {
        LinkNode currentNode = getStart();
        String returnList = "";
        while (currentNode!=null) {
            returnList += "$" + currentNode.getData().getCurrencyAsString() + "\t"; 
            currentNode = currentNode.getNext();
        }
        return returnList; 
    }

    /**
     * Method checks if SinglyLinkedList is empty
     * 
     * pre: none
     * post: none
     * return: boolean whether or not the list is empty
     */
    public boolean isListEmpty() {
        if (start == null && end == null) {
            return true;
        } 
        return false;
    }

    /**
     * Method finds the current length of the singly linked list
     * 
     * pre: none
     * post: none
     * return: int length (count) of the list
     */
    public int countCurrency() {
        return count;
    }
}
