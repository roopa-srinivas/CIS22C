/*
lab4main - a class that tests and runs binary tree ADT classes, BST and BSTNode, 
which help simulate a tree of values that can be traversed in 4 ways
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate knowledge of ADTs using the Binary Search 
Tree on Currency and Dollar classes
*/
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class lab4main {
    public static void main(String[] args) {
        clearFile();
        Queue money = new Queue();

        money.enqueue(new Dollar(57.12));
        money.enqueue(new Dollar(23.44));
        money.enqueue(new Dollar(87.43));
        money.enqueue(new Dollar(68.99));
        money.enqueue(new Dollar(111.22));
        money.enqueue(new Dollar(44.55));
        money.enqueue(new Dollar(77.77));
        money.enqueue(new Dollar(18.36));
        money.enqueue(new Dollar(543.21));
        money.enqueue(new Dollar(20.21));
        money.enqueue(new Dollar(345.67));
        money.enqueue(new Dollar(36.18));
        money.enqueue(new Dollar(48.48));
        money.enqueue(new Dollar(101.00));
        money.enqueue(new Dollar(11.00));
        money.enqueue(new Dollar(21.00));
        money.enqueue(new Dollar(51.00));
        money.enqueue(new Dollar(1.00));
        money.enqueue(new Dollar(251.00));
        money.enqueue(new Dollar(151.00));

        BST moneyTree = new BST();
        while(money.countCurrency()>0)
            moneyTree.insert(new Dollar(money.dequeue()));

        System.out.print("\nHere is your Binary Search Tree:");
        System.out.println(moneyTree.print());
        addToFile("Initial: ");
        addToFile(moneyTree.print());

        String input = "";
        Scanner s = new Scanner(System.in);
        do
        {
            System.out.print("How would you like to interact with the tree? (enter 'h' for a directory of commands)  ");
            input = s.next();
            if(input.equalsIgnoreCase("h"))
                userCommandHelp();
            else if (input.equalsIgnoreCase("a"))
            {
                double val = s.nextDouble();
                Dollar temp = new Dollar(val);
                if(val<0) {
                    System.out.println("\nThis dollar value is invalid and cannot be added!\n");
                    addToFile("Invalid Input: " + val);
                }
                else if(moneyTree.search(temp) != null) {
                    System.out.println("\nThis value already exists in the tree!\n");
                }
                else {
                    moneyTree.insert(temp);
                    System.out.println ("\nThis value has been added to tree!\n");
                }
            }
            else if (input.equalsIgnoreCase("s"))
            {
                double val = s.nextDouble();
                Dollar temp = new Dollar(val);
                if(val<0) {
                    System.out.println("\nThis dollar value is invalid and cannot be searched for!\n");
                    addToFile("Invalid Input: " + val);
                }
                else if(moneyTree.search(temp) != null) {
                    System.out.println("\nThis value was found in the tree!\n");
                }
                else {
                    System.out.println ("\nThis value was not found in the tree!\n");}

                }
            else if (input.equalsIgnoreCase("d"))
            {
                double val = s.nextDouble();
                Dollar temp = new Dollar(val);

                if(val<0){
                    System.out.println("\nThis dollar value is invalid and cannot be deleted!\n");
                    addToFile("Invalid Input: " + val);
                }
                else if(moneyTree.search(temp) == null) {
                    System.out.println("\nThis value does not exist in the tree and cannot be removed!\n");
                }
                else
                {
                    moneyTree.delete(temp);
                    System.out.println ("\nThis value has been deleted from the tree!\n");
                }
            }
            else if (input.equalsIgnoreCase("p"))
            {
                System.out.println(moneyTree.print());
                addToFile("----------------------------");
                addToFile("Print: ");
                addToFile(moneyTree.print());
            }
        } while(!input.equalsIgnoreCase("q"));

        System.out.print("\nHere is your final Binary Search Tree:");
        System.out.println(moneyTree.print());
        addToFile("----------------------------");
        addToFile("Final: ");
        addToFile(moneyTree.print());
        
    }

    /* Method that prints out the list of commands the user can use to 
     * interact with the binary tree and an example of how to put input
     * pre: none
     * post: command help printed to terminal window
     * return: none
     */
    public static void userCommandHelp()
    {
        System.out.println("\nUser Command Directory:");
        System.out.println("h - user help directory");
        System.out.println("q - quit program");
        System.out.println("a (dollar value) - add a dollar value to tree");
        System.out.println("s (dollar value) - search for a dollar value");
        System.out.println("d (dollar value) - delete a dollar value from tree");
        System.out.println("p - print tree (in all 4 traversal methods)");
        System.out.println("EX:  a 31.43 - adds a dollar with value $31.43 to the tree\n\n");
    }

    /* Method to add output to the output.txt file
     * pre: String output (the String to print to text file)
     * post: output has been added to text file, or if there was an error, it is printed
     * return: none
     */
    public static void addToFile(String output) {
        try {
            FileWriter fw = new FileWriter("output.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(output);
            pw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /* Method to clear the file prior to each run of the program
     * pre: none
     * post: none
     * return: none
     */
    public static void clearFile() {
        PrintWriter writer;
        try {
            writer = new PrintWriter("output.txt");
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}