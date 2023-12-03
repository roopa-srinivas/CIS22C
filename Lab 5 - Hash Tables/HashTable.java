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
    }   
    public HashTable(int initial) {
        capacity = initial;
        numCollisions= 0;
        loadFactor = 0;
        numItems = 0;
        table = new Entry[capacity];
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
        return table[index].getData();
    }
    
    public void setDollarAtIndex(int index, Dollar value)
    {
        table[index].setData(value);
    }

    public void hash(Dollar value) {
        return (2*value.getNoteValue() + 3*value.getCoinValue()) % capacity;
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
        while(bucketsProbed<capacity && getDollarAtIndex(bucket)!=0)
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
                return true;
            }
            numCollisions++;
            i++;
            bucketsProbed++;
            bucket = quadraticProbe(start, i);
        }
        return false;
    }

    public int quadraticProbe(int start, int n) {
        return ((start + n + (n*n)) % capacity);
    }
}
