package Polymorphism;

// Method Overriding --> when both parent class and child class have same method 

public class Shapes {
    public static void main(String[] args) { 

        // it is the type of the object("new Shapes()"") being referred to (not the type of the ref_variable(Shapes s1))
       //  that determines which version of an overridden method will be executed.

        Shapes s1 = new Shapes(); // will access parent class method i.e area
        Shapes s2 = new triangle(); // will access child class method i.e area
        Shapes s3 = new square(); // will access child class method i.e area

        s1.area();
        s2.area();
        s3.area();
    }
    
    void area() {
        System.out.println("this is in shapes");
    }
}

class triangle extends Shapes{
    @Override // annotation to check if method is overriden or not
    void area() {
        System.out.println("Area is 1/2*B*H");
    }
}

class square extends Shapes{
    @Override
    void area() {
        System.out.println("a*a");
    }
}

class rectangle extends Shapes{
    @Override
    void area() {
        System.out.println("l*b");
    }
}