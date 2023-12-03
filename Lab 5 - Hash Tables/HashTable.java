public class HashTable {

    private int capacity;
    private int numCollisions = 0;
    private double loadFactor = 0;
    private int numItems = 0;
    private Dollar[] table;

    public HashTable() {
        capacity = 29;
        table = new Dollar[capacity];
    }   
    public HashTable(int initial) {
        capacity = initial;
        table = new Dollar[capacity];
    }
    
    public int getCapacity() {
        return capacity;
    }

    public int getNumItems(){
        return numItems;
    }
    public double getLoadFactor() {
        calculateLoadFactor();
        return loadFactor;
    }
    public int getNumCollisions() {
        return numCollisions;
    }

    public Dollar getDollarAtIndex(int index) {
        // Dollar dollarAtIndex;
        // try {
        //     dollarAtIndex = table[index];
        // } catch (NullPointerException e) {
        //     dollarAtIndex = null;
        // }
        // return dollarAtIndex;
        return table[index];
    }
    
    public void setDollarAtIndex(int index, Dollar value) {
        table[index].setNoteValue(value.getNoteValue());
        table[index].setCoinValue(value.getCoinValue());
        
    }

    public int hash(Dollar value) {
        return (int)(2*value.getNoteValue() + 3*value.getCoinValue()) % capacity;
    }

    public void calculateLoadFactor() {
        int count = 0;
        for (int i = 0; i < capacity; i++) {
            if (getDollarAtIndex(i)!=null) {
                count++;
            }
        }
        numItems = count;
        loadFactor = (double)(numItems)/capacity;
    }

    public int search(Dollar value) 
    {
        int i = 0;
        int bucketsProbed = 0;

        int start = hash(value);
        int bucket = start;
        while(bucketsProbed<capacity && getDollarAtIndex(bucket)!=null)
        {
            if(getDollarAtIndex(bucket)!=null &&
                getDollarAtIndex(bucket).isEqual(value))
            {
                return bucket;
            }
            i++;
            bucketsProbed++;
            bucket = quadraticProbe(start, i);
        }
        return -1;
    }

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
                // return true;
            }
            numCollisions++;
            i++;
            bucketsProbed++;
            bucket = quadraticProbe(start, i);
        }
        // return false;
    }

    public int quadraticProbe(int start, int n) {
        return ((start + n + (n*n)) % capacity);
    }
}
