public class lab3main {
    public static void main(String[] args) {
        System.out.println("Welcome to Kanchan Kaushik's and Roopa Srinivas' ADT demo"); //we can replace this with a less cheesy greeting LOL
        Currency currencyList[] = new Currency[20];

        currencyList[0] = new Dollar(57.12);
        currencyList[1] = new Dollar(23.44);
        currencyList[2] = new Dollar(87.43);
        currencyList[3] = new Dollar(68.99);
        currencyList[4] = new Dollar(111.22);
        currencyList[5] = new Dollar(44.55);
        currencyList[6] = new Dollar(77.77);
        currencyList[7] = new Dollar(18.36);
        currencyList[8] = new Dollar(543.21);
        currencyList[9] = new Dollar(20.21);
        currencyList[10] = new Dollar(345.67);
        currencyList[11] = new Dollar(36.18);
        currencyList[12] = new Dollar(48.48);
        currencyList[13] = new Dollar(101.00);
        currencyList[14] = new Dollar(11.00);
        currencyList[15] = new Dollar(21.00);
        currencyList[16] = new Dollar(51.00);
        currencyList[17] = new Dollar(1.00);
        currencyList[18] = new Dollar(251.00);
        currencyList[19] = new Dollar(151.00);

        SinglyLinkedList linkedList = new SinglyLinkedList();
        Stack stack = new Stack();
        Queue queue = new Queue();

        //for linked list
        // Part A
        for (int i = 0; i < 7; i++) {
            linkedList.addCurrency(currencyList[i], 0);
        }

        //Part B
        System.out.println(linkedList.findCurrency(new Dollar(87.43)));
        System.out.println(linkedList.findCurrency(new Dollar(44.56)));

        //Part C
        linkedList.removeCurrency(new Dollar(111.22));
        linkedList.removeCurrency(linkedList.getNode(2).getData());

        //Part D
        //print contents of list

        //Part E
        for (int i = 9; i < 12; i++) {
            linkedList.addCurrency(currencyList[i], i%5);
        }

        //Part F
        linkedList.removeCurrency(linkedList.getNode(linkedList.countCurrency()%6).getData());
        linkedList.removeCurrency(linkedList.getNode(linkedList.countCurrency()/7).getData());

        //Part G
        //print contents of list

        

        //for stack
        //Part A
        for (int i = 13; i < currencyList.length; i++) {
            stack.push(currencyList[i]);
        }

        //Part B
        System.out.println(stack.peek());

        //Part C
        stack.pop();
        stack.pop();
        stack.pop();

        //Part D
        //print contents of stack

        //Part E
        for (int i = 0; i < 5; i++) {
            stack.push(currencyList[i]);
        }

        //Part F
        stack.pop();
        stack.pop();

        //Part G
        //print contents of stack


        //for queue
        //Part A
        for (int i = 5; i < 5+(7*2); i+=2) {
            queue.enqueue(currencyList[i]);
        }

        //Part B
        System.out.println(queue.peekFront());
        System.out.println(queue.peekBack());

        //Part C
        queue.dequeue();
        queue.dequeue();

        //Part D
        //print contents of queue

        //Part E
        for (int i = 10; i < 15; i++) {
            queue.enqueue(currencyList[i]);
        }

        //Part F
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        //Part G
        //print contents of queue


        System.out.println("Thank you for attending our ADT demo"); //replace with less cheesy message
    }
}
