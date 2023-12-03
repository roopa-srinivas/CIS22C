import java.util.Scanner;

public class lab5main {
    public static void main(String[] args) {
        HashTable table = new HashTable();
        Scanner s = new Scanner(System.in);
        double input;
        String action = "";

        table.addDollar(new Dollar(57.12));
        table.addDollar(new Dollar(23.44));
        table.addDollar(new Dollar(87.43));
        table.addDollar(new Dollar(68.99));
        table.addDollar(new Dollar(111.22));
        table.addDollar(new Dollar(44.55));
        table.addDollar(new Dollar(77.77));
        table.addDollar(new Dollar(18.36));
        table.addDollar(new Dollar(543.21));
        table.addDollar(new Dollar(20.21));
        table.addDollar(new Dollar(345.67));
        table.addDollar(new Dollar(36.18));
        table.addDollar(new Dollar(48.48));
        table.addDollar(new Dollar(101.00));
        table.addDollar(new Dollar(11.00));
        table.addDollar(new Dollar(21.00));
        table.addDollar(new Dollar(51.00));
        table.addDollar(new Dollar(1.00));
        table.addDollar(new Dollar(251.00));
        table.addDollar(new Dollar(151.00));

        System.out.println("Number of Data Items: " + table.getNumItems());
        System.out.println("Load Factor: " + table.getLoadFactor());
        System.out.println("Number of Collisions: " + table.getNumCollisions());

        while (!action.equals("end")) {
            System.out.println("Enter a Dollar value to search for: ");
            input = s.nextDouble();
            Dollar dollarToCheck = new Dollar(input);
            if (table.search(dollarToCheck) == -1){
                System.out.println("Invalid Data");
            } else {
                System.out.println(table.search(dollarToCheck));
            }
            System.out.println("Would you like to check for another Dollar value or end the program? Enter \'check\' or \'end\'");
            action = s.next();
        }

    }
}
