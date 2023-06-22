public class MyHashMap <K , V> {
    private HashEntry<K , V>[] bucket;
    private int size; 

    public MyHashMap() {
        this(16);

    }
    @SuppressWarnings("unchecked")
    public MyHashMap (int capacity) {
        this.bucket = new HashEntry[capacity];
        this.size = 0;
    }

    public void put(K key , V value) { // open-hashing/chaining --> used to handle collision
        int bucketIndex = getIndex(key);

        HashEntry<K , V> entry = bucket[bucketIndex];
        HashEntry<K , V> newEntry = new HashEntry<>(key, value);

        if (entry == null) {
            bucket[bucketIndex] = newEntry;
            size++;
        } else {
            while (entry.getNext() != null) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return;
                }
                entry = entry.getNext();
            }
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
            } else {
                entry.setNext(newEntry);
                size++;
            }
        }
        
    }
    public void display() {
        for (int i = 0; i < bucket.length; i++) {
            HashEntry<K , V> entry = bucket[i];

            while (entry != null) {
                System.out.println("(" + entry.getKey() + "," + entry.getValue() + ")" + " ");
                entry = entry.getNext();
            }
            System.out.println();
        }
    }
    private int getIndex(K key) {
        int hashcode = key.hashCode();
        // multiplied by -1 so that , it does not return negative index 
        return hashcode < 0 ? (hashcode % bucket.length) * - 1 : hashcode % bucket.length;
        // can also use (hashcode & Integer.MAX_VALUE) % bucket.length instead of (hashcode % bucket.length) * -1
    }
}
