

public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer , Integer> map = new MyHashMap<>(10);
        map.put(8, 8);
        map.put(3, 3);
        map.put(13, 13);
        map.put(6, 6);
        map.put(4, 4);
        map.put(10, 10);
        map.display();
        
        int val = map.get(8);
        System.out.println(val);
        int removedval = map.remove(13);
        System.out.println(removedval);
        map.display();
        System.out.println();

        HashMapLinearProbing<Integer , String> hashMap = new HashMapLinearProbing<>(10);
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");
        hashMap.put(13, "thirteen");
        hashMap.display();


        HashMapQuadraticProbing<Integer , String> hashmap = new HashMapQuadraticProbing<>(10);
        hashmap.put(1, "One");
        hashmap.put(2, "Two");
        hashmap.put(3, "Three");
        hashmap.put(13, "thirteen");
        hashmap.display();
        
    }
}
