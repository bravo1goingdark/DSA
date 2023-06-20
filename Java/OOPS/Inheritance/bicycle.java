package Inheritance;

public class bicycle {
    public int gear;
    public int speed;

    public bicycle(int gear , int speed){
        this.gear = gear;
        this.speed = speed;
    }
    public void applyBrake(int decrement)
    {
        speed -= decrement;
    }
  
    public void speedUp(int increment)
    {
        speed += increment;
    }
}
