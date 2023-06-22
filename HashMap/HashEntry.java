public  class HashEntry<K , V> {
    private K key;
    private V value;
    private HashEntry<K , V> next;

    public HashEntry(K key , V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
    
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V val) {
        this.value = val;
    }

    public HashEntry<K , V> getNext() {
        return next;
    }
    public void setNext(HashEntry<K , V> next) {
        this.next = next;
    }
}