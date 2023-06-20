import java.util.ArrayList;
public class operators {
    public static void main(String[] args) {
        System.out.println('a' + 'b'); // taking ASCII value of a and b and adding it up
        System.out.println("a" + "b"); // return --> ab
        System.out.println((char)('a' + 3)); // converting value of a i.e 97 + 3 == 100 which is then equal to d
        System.out.println("Ashutosh kumar" + new ArrayList<>());
        
        // String Performance --> in this example the time complexity is O(N^2)
        String alphabhet = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            alphabhet += ch; 
        }

        System.out.println(alphabhet);
        
        // now to reduce the time complexity we can use Stringbuilder
        StringBuilder alphabhet1 = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            alphabhet1.append(ch);
            alphabhet1.reverse(); // reverse the string
        }
        alphabhet1.length();
        System.out.println(alphabhet1);
        
    }
}
