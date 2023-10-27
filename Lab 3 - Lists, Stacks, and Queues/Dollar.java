/*
dollar - a subclass of currency
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate inheritance and polymorphism between 3 classes, currency, 
and its subclasses dollar and pound
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

    /** This is a print method that calls the super constructor, of the currency class,
     * to print out the object's dollar value, and then prints out the currency type
     * Pre: none
     * Post: Dollar's value and type "Dollar" are printed 
     * Return: none
     */
    public void print() {
        super.print();
        System.out.print(" " + getCurrencyName() + " ");
    }
}
