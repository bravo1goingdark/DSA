package Inheritance;


// access_modifier class sub-class extends super-class { }

public class mountainbike extends bicycle {
    public int seatHeight;

    public mountainbike(int gear , int speed , int seatHeight) {
        super(gear, speed); // invoking base-class(bicycle) constructor
        super.gear = 10; // also used to access a member of the superclass that has been hidden by a member of a subclass.
        this.seatHeight = seatHeight;
    }
    void display() {
        System.out.println("this is mountaibike class");
    }
}
class racecycle extends mountainbike {

    public racecycle(int gear, int speed, int seatHeight) {
        super(gear, speed, seatHeight);
        // this class is inheriting from mountain bike class i.e inheriting from bicycle class
        // multilevel class
    }}
