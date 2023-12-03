/*
Entry - a class that represents each Dollar entry into the HashTable 
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate knowledge of ADTs using the HashTable Dollar class
*/

public class Entry
{
    private Dollar data;
    public Entry()
    {
        data = null;
    }
    public Entry(Dollar val)
    {
        data = val;
    }

    /**
     * sets data to val parameter
     * pre: val (Dollar value to be set)
     * post: data is set to val
     * return: none
     */
    public void setData(Dollar val)
    {
        data = val;
    }

    /**
     * returns data object
     * pre: none
     * post: none
     * return: data
     */
    public Dollar getData()
    {
        return data;
    }
}