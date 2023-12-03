/*
HashTable - a class that represents a HashTable ADT of Entry
Kanchan Kaushik and Roopa Srinivas
F23 CIS D022C 09Y, 10Y Data Abstract & Structures
Purpose: To demonstrate knowledge of ADTs using the HashTable Dollar class
*/

public class HashTable {

    private int capacity, numCollisions;
    private double loadFactor;
    private int numItems;
    private Entry[] table;

    public HashTable() {
        capacity = 29;
        numCollisions= 0;
        loadFactor = 0;
        numItems = 0;
        table = new Entry[29];
        initializeTable();
    }   
    public HashTable(int initial) {
        capacity = initial;
        numCollisions= 0;
        loadFactor = 0;
        numItems = 0;
        table = new Entry[capacity];
    }

    /**
     * initializes table to have Entry objects at each index
     * pre: none
     * post: table has been properly initialized
     * return: none
     */
    public void initializeTable()
    {
        for(int i = 0; i< table.length; i++)
            table[i] = new Entry();
    }
    
    /**
     * getter methods return capacity, numItems, loadFactor and numCollisions
     * pre: none
     * post: none
     * return: capacity, numItems, loadFactor, numCollisions
     */
    public int getCapacity() {
        return capacity;
    }

    public int getNumItems(){
        return numItems;
    }
    public double getLoadFactor() {
        return (double)(numItems)/capacity;
    }
    public int getNumCollisions() {
        return numCollisions;
    }

    public Dollar getDollarAtIndex(int index) {
        return table[index].getData();
    }
    
    /**
     * sets object at given index to be a Dollar object
     * pre: index (index to set Dollar object), value (Dollar object to be set)
     * post: object at given index has been assigned to Dollar object
     * return: none
     */
    public void setDollarAtIndex(int index, Dollar value)
    {
        table[index].setData(value);
    }

    /**
     * calculates and returns hash value for given Dollar object
     * pre: value (Dollar object to calculate hash for)
     * post: none
     * return: hash value
     */
    public int hash(Dollar value) {
        return (2*value.getNoteValue() + 3*value.getCoinValue()) % capacity;
    }

    /**
     * Algorithm search(Dollar value) 
     *      i = 0
     *      bucketsProbed = 0
     *      start = hash(value)
     *      bucket = start
     *      while (bucketsProbed<capacity and Dollar at bucket index != null)
     *          if (Dollar at bucket index != null and Dollar object at bucket index == value)
     *              return bucket
     *          i++
     *          bucketsProbed++
     *          bucket index incremented using quadratic probe(start, i)
     *      return -1
     * 
     * returns the index of the Dollar to be searched
     * pre: value (Dollar object to be searched for)
     * post: none
     * return: index of Dollar object to be searched (if not found, returns -1)
     */
    public int search(Dollar value) 
    {
        int i = 0;
        int bucketsProbed = 0;

        int start = hash(value);
        int bucket = start;
        while(bucketsProbed<capacity && getDollarAtIndex(bucket)!=null)
        {
            if(getDollarAtIndex(bucket)!=null &&
                getDollarAtIndex(bucket).isEqual(value)) {
                return bucket;
            }
            i++;
            bucketsProbed++;
            bucket = quadraticProbe(start, i);
        }
        return -1;
    }

    /**
     * Algorithm addDollar(Dollar value) 
     *      i = 0
     *      bucketsProbed = 0
     *      start = hash(value)
     *      bucket = start
     *      while (bucketsProbed<capacity)
     *          if (Dollar at bucket index != null)
     *              setDollarAtIndex(bucket, value)
     *              numItems++
     *              return
     *          numCollisions++
     *          i++
     *          bucketsProbed++
     *          bucket index incremented using quadratic probe(start, i)
     *      return
     * 
     * add Dollar object to HashTable
     * pre: value (Dollar object to add)
     * post: value added to table
     * return: none
     */
    public void addDollar(Dollar value)
    {
        int i = 0;
        int bucketsProbed = 0;

        int start = hash(value);
        int bucket = start;
        while(bucketsProbed<capacity)
        {
            if(getDollarAtIndex(bucket)==null)
            {
                setDollarAtIndex(bucket, value);
                numItems++;
                return;
            }
            numCollisions++;
            i++;
            bucketsProbed++;
            bucket = quadraticProbe(start, i);
        }
        return;
    }

    /**
     * calculates next bucket to insert at using quadratic probe algorithm
     * pre: start (start index), n (number that replaces x variable in quadratic equation: ax^2+bx+c)
     * post: next bucket calculated
     * return: index for next bucket
     */
    public int quadraticProbe(int start, int n) {
        return ((start + n + (n*n)) % capacity);
    }
}
