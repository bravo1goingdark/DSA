package interfaceDemo;

// Java program to demonstrate the
// real-world example of Interfaces


class GFG {
	
	public static void main (String[] args) {
	
		// creating an instance of Bicycle
		Bicycle bicycle = new Bicycle();
		bicycle.changeGear(2);
		bicycle.speedUp(3);
		bicycle.applyBrakes(1);
		
		System.out.println("Bicycle present state :");
		bicycle.printStates();
		
		// creating instance of the bike.
		Bike bike = new Bike();
		bike.changeGear(1);
		bike.speedUp(4);
		bike.applyBrakes(3);
		
		System.out.println("Bike present state :");
		bike.printStates();
	}
}
interface Vehicle {
    
	// all are the abstract methods.
	abstract void changeGear(int a);
	abstract void speedUp(int a);
	abstract void applyBrakes(int a);
}

class Bicycle implements Vehicle{
	
	int speed;
	int gear;
	
	// to change gear
	@Override
	public void changeGear(int newGear){
		
		gear = newGear;
	}
	
	// to increase speed
	@Override
	public void speedUp(int increment){
		
		speed += increment;
	}
	
	// to decrease speed
	@Override
	public void applyBrakes(int decrement){
		
		speed -= decrement;
	}

	public void printStates() {
		System.out.println("speed: " + speed + " gear: " + gear);
	}
}

class Bike implements Vehicle {
	
	int speed;
	int gear;

	// to change gear
	@Override
	public void changeGear(int newGear){
		
		gear = newGear;
	}
	
	// to increase speed
	@Override
	public void speedUp(int increment){
		
		speed += increment;
	}
	
	// to decrease speed
	@Override
	public void applyBrakes(int decrement){
		
		speed -= decrement;
	}
	
	public void printStates() {
		System.out.println("speed: " + speed + " gear: " + gear);
	}
	
}