package Inheritance;
public class Main extends Object {
    public static void main(String[] args) {
        mountainbike mtb = new mountainbike(30 , 40 , 13);
        mtb.speedUp(30);
        mtb.applyBrake(10);
        System.out.println(mtb.speed);

        // Superclass Variable Can Reference a Subclass Object
        bicycle b1 = new mountainbike(10, 20, 5);
        // parent class cannot access child_class methods or field but child_class can 
        b1.applyBrake(5);
        mtb.display();
        System.out.println(b1.speed);
        racecycle c1 = new racecycle(10, 20, 3);
        c1.gear = 20;
        System.out.println(c1.gear);
        
    }
}
