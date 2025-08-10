package oops;

class Car {
	String model;
	String color;
	public Car(String model,String color)
	{
		this.model=model;
		this.color=color;
	}
	public void start()
	{
		if(model=="")
		{
			System.out.println("Car started (but model not shown)");
		}
		else
		{
			System.out.println("Car started");
		}
	}public void stop()
	{
		System.out.println("Car stopped");
	}
}
package oops;

public class Main {

	public static void main(String[] args) {
		Car c1=new Car("Tesla","Red");
		System.out.println("TC-1");
		c1.start();
		Car c2=new Car("BMW", "Black");
		System.out.println("TC-2");
		c2.start();
		Car c3=new Car("", "Black");
		System.out.println("TC-3");
		c3.start();
		Car c4=new Car("", "Black");
		System.out.println("TC-4");
		Car c5=new Car("BMW", "Black");
		System.out.println("TC-5");
		c5.stop();
	}
}

