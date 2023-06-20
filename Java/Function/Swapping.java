public class Swapping {
    public static void main(String[] args) {
        // int a = 10;
        // int b = 30;
        // swap(a , b);
        // System.out.println(a + " " + b);
        String name = "Ashutosh";
        passingvalue(name);
        System.out.println(name);
    }
    static void passingvalue(String naam) {
        naam = "kumar";
    }
    static void swap(int a , int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
