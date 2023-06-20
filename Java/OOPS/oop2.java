public class oop2 {
    public static void main(String[] args) {
        Human h1 = new Human(10, "ritvik", 1000, false);
        Human h2 = new Human(12, "ritik", 10000, true);
        
        // the object population of human class can be accessed without creating any objects 
        System.out.println(Human.population);

        //static block cannot be initailized inside main method , 
        // beacause The static blocks always execute first before the main() method in Java
        // because the compiler stores them in memory at the time of class loading and before the object creation.

        // static int roolno;
        // static int age;
        // static {  
        //     roolno = 30;
        //     age = 18;
        // }

        oop2 obj = new oop2();
        obj.greeting2();
    }
    void greeting2(){
        System.out.println("Hello World");
        greeting(); // can be accessed inside non-static member
    }

    static void greeting(){
        // non-static member cannot be accessed inside static member, but opposite is true
        // greeting2();       
    }


}

class Human {
    int age;
    String name;
    int salary;
    boolean married;
    static long population;

    static void message() {
        System.out.println("Hello world");
        //System.out.println(this.age); 
        // cannot use this over here because this keyword is object dependent where
        // any variable or method declared using static are independent of objects
    }


    Human(int age , String name , int salary , boolean married){
        this.age = age;
        this.name = name;
        this.married = married;
        this.salary = salary;

        // this.population++; --> will run , but it will give warning since population is static  
        // and "this" refer to objects 

        // when we are assigning value which is common to all object we use class_name instead of this keyword 
        Human.population++;
    } 
}
