/*
currency - superclass of dollar
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate knowledge of ADT's using the above three mentioned 
ADT's, Lists, Stacks, and Queues, on Currency and Dollar classes
*/

public abstract class Currency {
    private int noteValue, coinValue; // field variables representing the whole and 
                                      // fractional parts of a dollar, respectively
    public Currency() {
        noteValue = 0;
        coinValue = 0;
    }
    public Currency(double value) {
        noteValue = (int)value;
        coinValue = (int)(value*100)%100;
    }
    public Currency(Currency newCurrency) {
        noteValue = newCurrency.noteValue;
        coinValue = newCurrency.coinValue;
    }

    /** These 3 getter methods return the name of the Currency, whole part, and fractional parts
     * Pre: none
     * Post: String or int return values are used in add and subtract methods below and in main to 
     *          check if the currency types of objects are the same
     * Return: String/int of name of the Currency, whole part, and fractional part
     */
    public abstract String getCurrencyName();
    public int getNoteValue() {
        return noteValue;
    }
    public int getCoinValue() {
        return coinValue;
    }

    /**
     * These 2 setter methods set the value of the noteValue and coinValue fields to the passed in parameters
     * Pre: integers note (whole part) and coin (fractional part) for each respectively
     * Post: noteValue and coinValue have the new parameter values
     * Return: none
     */
    public void setNoteValue(int note) {
        noteValue = note;
    }
    public void setCoinValue(int coin) {
        coinValue = coin;
    }

    /** This is a method that adds the whole part and fractional part of the passed in Currency object to this Currency object
     * Pre: Currency object whose values to add to this Currency object
     * Post: This Currency object now has its previous value + the value of the passed in Currency object
     *       Throws an exception if the type (dollar vs. pound) of the passed in Currency object differs from the type of this Currency object
     * Return: none
     */
    public void add(Currency currencyToAdd) throws Exception {
        if (!(getCurrencyName().equals(currencyToAdd.getCurrencyName()))){
            throw new Exception("Invalid addition");
        } else {  
            noteValue += currencyToAdd.getNoteValue();
            coinValue += currencyToAdd.getCoinValue();
            if (coinValue >= 100) {
                noteValue++;
                coinValue-=100;
            }
        }
    }

    /** This is a method that subtracts the whole part and fractional part of the passed in Currency object from this Currency object
     * Pre: Currency object whose values to subtract from this Currency object
     * Post: This Currency object now has its previous value - the value of the passed in Currency object
     *       Throws an exception if the type (dollar vs. pound) of the passed in Currency object differs from the type of this Currency object OR if the value of the passed in Currency object is 
     *          larger than the value of this Currency object
     * Return: none
     */
    public void subtract(Currency currencyToSubtract) throws Exception {
        if (isGreater(currencyToSubtract) || !(getCurrencyName().equals(currencyToSubtract.getCurrencyName()))){
            throw new Exception("Invalid subtraction");
        } else {
            noteValue -= currencyToSubtract.getNoteValue();
            coinValue -= currencyToSubtract.getCoinValue();
            if (coinValue < 0) {
                noteValue--;
                coinValue += 100;
            }
        }
    }

    /** This is a method that checks if the passed in Currency object has the exact same whole and fractional parts as this Currency object
     * Pre: Currency object whose values to check against this Currency object
     * Post: none
     * Return: true or false depending on if the Currency objects' values are equal or not
     */
    public boolean isEqual(Currency currencyToCheck) {
        if (currencyToCheck.getNoteValue() == noteValue && currencyToCheck.getCoinValue() == coinValue) {
            return true;
        }
        return false;
    }

    /** This is a method that checks if the passed in Currency object's whole and fractional parts are greater than the values of this Currency object
     * Pre: Currency object whose values to check against this Currency object
     * Post: none
     * Return: true or false depending on if the passed in Currency object's value is greater than this Currency object's value
     */
    public boolean isGreater(Currency currencyToCheck){
        if (currencyToCheck.getNoteValue() > noteValue || 
            (currencyToCheck.getNoteValue() == noteValue && currencyToCheck.getCoinValue() > coinValue)) {
            return true;
        } 
        return false;
    }

    /** This is a method that prints the whole and fractional parts of the Currency
     * Pre: none
     * Post: Currency's whole and fractional parts are printed in traditional form (ex. 13.45 or 1.03)
     * Return: none
     */
    public void print() {
        System.out.print(getCurrencyAsString());
    }

     /** This is a method that returns the string of the whole and fractional parts of the Currency
     * Pre: none
     * Post: Currency's whole and fractional parts are turned into a string in traditional form (ex. 13.45 or 1.03)
     * Return: String of the currency
     */
    public String getCurrencyAsString()
    {
        String temp = "";
        temp+= noteValue + ".";
        if (coinValue == 0) {
            temp+= "00";
        } else if (coinValue < 10) {
            temp+= "0" + coinValue;
        } else {
            temp+= coinValue;
        }
        return temp;
    }
}
