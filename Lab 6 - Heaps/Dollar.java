/*
dollar - a subclass of currency
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate knowledge of ADTs using the HashTable Dollar class
*/

public class Dollar extends Currency{
    private String currencyName = "Dollar"; // field var for currency name of a dollar

    public Dollar() {
        super();
    }

    public Dollar(double value){
        super(value);
    }

    public Dollar(Currency newCurrency) {
        super(newCurrency);
    }

    /** This is a getter method that returns the currency name of the object, Dollar
     * Pre: none
     * Post: String result from function is used to compare objects to check if they 
        are of the same currency type 
     * Return: String name of currency
     */
    public String getCurrencyName() {
        return currencyName;
    }

    /** This is a print method that calls the getCurrencyAsString() method of the currency class,
     * to print out the object's dollar symbol and value
     * Pre: none
     * Post: Dollar's symbol "$" and value  are printed 
     * Return: none
     */
    public void print() {
        System.out.println("$" + super.getCurrencyAsString());
    }
}
