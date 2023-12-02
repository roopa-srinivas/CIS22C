public class HashTable {

    private int capacity, numCollisions;
    private double loadFactor;

    public HashTable() {
        capacity = 0;
    }   
    public HashTable(int initial) {
        capacity = initial;
    }
    

    public int getSize() {
        return capacity;
    }
    public double getLoadFactor() {
        return loadFactor;
    }
    public int getNumCollisions() {
        return numCollisions;
    }
    public Dollar search(Dollar value) {

    }
    public Dollar getDollarAtIndex(int index) {

    }

    public void remove(Dollar value) {
        
    }
    public void hash (Dollar value) {
        
    }
    public void calculateLoadFactor() {
        int numItems = 0;
        for (int i = 0; i < capacity; i++) {
            if (getDollarAtIndex(i)==null) {
                numItems++;
            }
        }
        loadFactor = numItems/capacity;
    }

    public int quadraticProbe(int start, int n) {
        return ((start + (n*n)) % capacity);
    }
}
