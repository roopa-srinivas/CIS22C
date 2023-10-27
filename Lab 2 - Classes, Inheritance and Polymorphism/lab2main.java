/*
lab2 - Classes, Inheritance and Polymorphism
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate inheritance and polymorphism between 3 classes, currency, 
and its subclasses dollar and pound
*/

import java.util.Scanner;

public class lab2main {
    public static void main(String[] args) throws Exception{
        Currency curr[] = new Currency[2];
        curr[0] = new Pound();
        curr[1] = new Dollar();

        Scanner scnr = new Scanner(System.in);
        String operation = "";
        String type = "";
        double amount = 0.0;
        String units = "";
        boolean continueToLoop = true;
        Currency objectToOperateOn;
        curr[0].print();
        curr[1].print();
        System.out.println();

        while (continueToLoop) {
            operation = scnr.next();
            if (operation.equals("q")){
                continueToLoop = false;
            } else {
                type = scnr.next();
                amount = scnr.nextDouble();
                units = scnr.next();

                
                if (units.equals("pound")) {
                    objectToOperateOn = new Pound(amount);
                } else {
                    objectToOperateOn = new Dollar(amount);
                }

                if (type.equals("p")) {
                    if (operation.equals("a")) {
                        try {
                            curr[0].add(objectToOperateOn);
                        } catch (Exception e) {
                            System.out.println("Invalid Addition");
                        }
                    } else {
                        try {
                            curr[0].subtract(objectToOperateOn);
                        } catch (Exception e) {
                            System.out.println("Invalid Subtraction");
                        }
                    }
                } else {
                    if (operation.equals("a")) {
                        try {
                            curr[1].add(objectToOperateOn);
                        } catch (Exception e) {
                            System.out.println("Invalid Addition");
                        }
                    } else {
                        try {
                            curr[1].subtract(objectToOperateOn);
                        } catch (Exception e) {
                            System.out.println("Invalid Subtraction");
                        }
                    }
                }

                curr[0].print();
                curr[1].print();
                System.out.println();
            }
            
        }
    }
    
}
