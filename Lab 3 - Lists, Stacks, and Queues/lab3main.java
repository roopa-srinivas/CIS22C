/*
lab3 - Lists, Stacks and Queues
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate knowledge of ADT's using the above three mentioned 
ADT's, Lists, Stacks, and Queues, on Currency and Dollar classes
*/
public class lab3main {
    public static void main(String[] args) {
        System.out.println("Welcome to Kanchan Kaushik's and Roopa Srinivas' ADT demo! \n"
            + "We will be demonstrating the use of a SinglyLinkedList, a Stack, and a Queue!\n"); 
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
        System.out.println(linkedList.findCurrency(new Dollar(87.43)) + "\n");
        System.out.println(linkedList.findCurrency(new Dollar(44.56)));
        
        //Part C
        linkedList.removeCurrency(new Dollar(111.22));
        linkedList.removeCurrency(2);

        //Part D
        System.out.println("\n"+linkedList.printList()+ "\n");

        //Part E
        for (int i = 8; i < 12; i++) {
            linkedList.addCurrency(currencyList[i], i%5);
        }

        //Part F
        linkedList.removeCurrency(linkedList.countCurrency()%6);
        linkedList.removeCurrency(linkedList.countCurrency()/7);

        //Part G
        System.out.println(linkedList.printList() + "\n");

        //for stack
        //Part A
        for (int i = 13; i < currencyList.length; i++) {
            stack.push(currencyList[i]);
        }

        //Part B
        stack.peek().print();
        System.out.println();

        //Part C
        stack.pop();
        stack.pop();
        stack.pop();

        //Part D
        System.out.println(stack.printStack());
        System.out.println();

        //Part E
        for (int i = 0; i < 5; i++) {
            stack.push(currencyList[i]);
        }

        //Part F
        stack.pop();
        stack.pop();

        //Part G
        System.out.println(stack.printStack());
        System.out.println();

        //for queue
        //Part A
        for (int i = 5; i < currencyList.length-1; i+=2) {
            queue.enqueue(currencyList[i]);
        }

        //Part B
        queue.peekFront().print();
        System.out.println();
        queue.peekRear().print();
        System.out.println();

        //Part C
        queue.dequeue();
        queue.dequeue();

        //Part D
        System.out.println(queue.printQueue());
        System.out.println();

        //Part E
        for (int i = 10; i < 15; i++) {
            queue.enqueue(currencyList[i]);
        }

        //Part F
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        //Part G
        System.out.println(queue.printQueue());
        System.out.println();

        System.out.println("Thank you for attending our ADT demo! Have a nice day!"); 
    }
}
