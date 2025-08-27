//2117240070193
//mukesh p
package oops;
class Shape{
	void area() {
		System.out.println("Default area");
	}
}
class Circle extends Shape {
	 double radius;
	 Circle(double r) {
	     radius = r;
	 }
	 @Override
	 void area() {
	     double result = Math.PI * radius * radius;
	     System.out.printf("Area of Circle: %.1f\n",result);
	 }
}
class Rectangle extends Shape {
	 double length, width;
	 Rectangle(double l, double w) {
	     length = l;
	     width = w;
	 }
	 @Override
	 void area() {
	     double result = length * width;
	     System.out.println("Area of Rectangle: " + result);
	 }
}
public class Shapearea {
	public static void main(String[] args) {
		System.out.print("TC1:");
		Circle c1= new Circle(5);
		c1.area();  
		System.out.print("TC2:");
	    Rectangle r1= new Rectangle(10,5);
	    r1.area();   
	    System.out.print("TC3:");
	    Shape s=new Shape();
	    s.area();
	    System.out.print("TC4:");
	    Circle c2= new Circle(0);
		c2.area();  
		System.out.print("TC5:");
	    Rectangle r2= new Rectangle(10,0);
	    r2.area(); 
	}
}
