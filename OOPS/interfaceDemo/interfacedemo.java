package interfaceDemo;


public class interfacedemo{
    public static void main(String[] args) {
        // we cannot instantiate a interface 
        In1 t = new TestClass();
        t.display();
        System.out.println(TestClass.a);
    }
}


// A simple interface
interface In1 {

	// variable are public, static and final by default
	public static final int a = 10;

	// by default function are public and abstract
	public abstract void display();
}

// A class that implements the interface.
class TestClass implements In1 {

	// Implementing the capabilities of interface.
	public void display(){
        System.out.println("Hello World");
	}

}
