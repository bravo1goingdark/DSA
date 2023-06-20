package abstractDemo;


// Base class
class Base {
    public static void main(String args[]) {
        // Sunstar s = new Sunstar(); --> an instance of an abstract class cannot be created
        Sunstar s = new Employee();
        Employee e1 = new Employee();
        s.printInfo();
        System.out.println();
        s.printinfo();
        e1.printInfo();
    }
}

// Abstract class
// A non-abstract class cannot have abstract methods but an abstract class can have a non-abstract method.
abstract class Sunstar {
    Sunstar(){
        System.out.println("this is constructor of abstract class");
    }
	abstract void printInfo();
    abstract void printinfo();
}

// Abstraction performed using extends
class Employee extends Sunstar {
    @Override
	void printInfo() {
		String name = "ashutosh";
		int age = 18;
		float salary = 111.2f;

		System.out.println(name);
		System.out.println(age);
		System.out.println(salary);

	}

    @Override
    void printinfo() {
        String STUDENT_NAME = "Ashutosh Kumar";
        int REG_NO = 229302357;
        String COLLEGE_NAME = "MUJ";
        System.out.println(STUDENT_NAME);
        System.out.println(REG_NO);
        System.out.println(COLLEGE_NAME); 
    }

}

