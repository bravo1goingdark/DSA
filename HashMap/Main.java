

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
        
    }
}
