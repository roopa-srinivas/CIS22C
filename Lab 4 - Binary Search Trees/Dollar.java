/*
dollar - a subclass of currency
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate inheritance and polymorphism between 3 classes, currency, 
and its subclasses dollar and pound
CHANGES MADE FROM LAST TIME:
- print() method
- Why? Because we needed a way to print the currency as just a string with the $ symbol
  without printing the full word "Dollar", so instead of just printing what the superclass
  Currency would have had, we print the ouput of the new getCurrencyAsString method in Currency,
  which returns a string of what would have been printed in Currency's print() in lab2, and we
  concatenate it with "$" to print it.
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
