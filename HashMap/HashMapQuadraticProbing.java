public class HashMapQuadraticProbing<K, V> {
    private Entry<K, V>[] buckets;
    private int size;

    public HashMapQuadraticProbing() {
        this(16);
    }

    @SuppressWarnings("unchecked")
    public HashMapQuadraticProbing(int capacity) {
        buckets = new Entry[capacity];
        size = 0;
    }

    public void put(K key, V value) {
        int bucketIndex = getIndex(key);

        int probeCount = 0;
        while (buckets[bucketIndex] != null) {
            if (buckets[bucketIndex].getKey().equals(key)) {
                buckets[bucketIndex].setValue(value);
                return;
            }
            probeCount++;
            bucketIndex = (bucketIndex + (probeCount * probeCount)) % buckets.length; // will find next available quadratic slot
        }

        buckets[bucketIndex] = new Entry<>(key, value);
        size++;
    }

    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                System.out.print("Bucket " + i + ": ");
                System.out.println("(" + buckets[i].getKey() + ", " + buckets[i].getValue() + ")");
            } else {
                System.out.println("Bucket " + i + ": Empty");
            }
        }
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

