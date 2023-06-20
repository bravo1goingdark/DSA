import java.util.Scanner;

public class Switch_case {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fruits = in.next();

        switch(fruits){
            case "Mango" -> System.out.println("King of fruits");
            case "Apple" -> System.out.println("a sweet red fruit");
            default -> System.out.println("Invalid operation");
        }
    }
}
