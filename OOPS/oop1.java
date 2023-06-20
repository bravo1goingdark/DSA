public class oop1 {
    public static void main(String[] args) {

        Student st1 = new Student(); // Student() ---> Java default Constructor
        Student st2 = new Student(24, 94, "Ashutosh Kumar"); // Student(int rollno , double marks , String name) ---> Parameterized Constructor

        final int a = 20;
        // a = 30; // ref_variable initialized with final keyword, it cannot be further updated since the value is final
        

        System.out.println(st1.rollno);
        System.out.println(st1.name);
        System.out.println(st1.marks);
        
        System.out.println();
        
        System.out.println(st2.rollno);
        System.out.println(st2.name);
        System.out.println(st2.marks);

    }

}
// Creating new class 
class Student {

    // these are objects of the class student
    // ref_variable get stored in stack memory and the value(object) of the ref_variable get stored in heap memory
    int rollno = 0;
    double marks = 0.0f;
    String name = "Ashutosh kumar";
    
    static final int ab;
    static final String naaam;

    // static block 
    static {
        ab = 20;
        naaam = "Aakash";
    }

    
    // Constructor name must be the same as its class name
    // A Constructor must have no explicit return type
    // A Java constructor cannot be abstract, static, final, and synchronized
    Student() {

        // calling diffrent constructor using this keyword
        this(26, 80, "mayank");
    }

    Student(int rollno , double marks , String name) {
        // this --> used to point ref_variable to itself 
        // example : this.rollno = rollno;

        // this --> it itself act as reference variable
        // example: ashutosh.rollno = 26 instead we can say this.rollno = rollno , here this == ashutosh
        this.rollno = rollno;
        this.marks = marks;
        this.name = name;
    }
}