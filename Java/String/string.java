public class string{
    public static void main(String[] args) {
        // comparison of string ---> these will return in false beacause two objects are created and it is outside the string pool
        String a = new String("Ashutosh");
        String b = new String("Ashutosh");
        System.out.println(a == b);
        // comparison of string ---> these will return in true beacause two ref_variable are pointing towards same object inside the string pool 
        String c = "Ashutosh";
        String d = "Ashutosh";
        System.out.println(c == d);
        // use .equal() method if you only want to compare value of the string --> will return true
        String e = new String("Ashutosh");
        String f = new String("Ashutosh");
        System.out.println(e.equals(f));
        // pretty printing in java
        float num = 123.1234f;
        System.out.printf("%.3f" , num); // %f is acting as placeholder
    }
}