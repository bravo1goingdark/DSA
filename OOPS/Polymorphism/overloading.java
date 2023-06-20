package Polymorphism;
// When there are multiple functions 
// with the same name but different parameters then these functions are said to be overloaded.

// compile-time polymorphism is acheived using method overloading
public class overloading {
    public static void main(String[] args) {
       double mu =  Helper.Multiply(1.3, 2.2);
       System.out.println(mu);
    }
}
class Helper {
 
    // Method with 2 integer parameters
    static int Multiply(int a, int b)
    {
        return a * b;
    }
    // With same name but with 2 double parameters
    static double Multiply(double a, double b)
    {
        return a * b;
    }
}
