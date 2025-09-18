//21172400070193
//Mukesh p
PROGRAM:
class Divider {
   int numerator, denominator;
   Divider(int n, int d) {
       numerator = n;
       denominator = d;
   }
   void divide() {
       try {
           int result = numerator / denominator;
           System.out.println("Output: " + result);
       } catch (ArithmeticException e) {
           System.out.println("Output: Exception handled");
       }
   }
}
public class DivisionbyZero {
	public static void main(String[] args) {
       System.out.println("Mukesh P\n2117240070193");
       System.out.print("TC1: ");
       Divider d1 = new Divider(10, 2);
       d1.divide();
       System.out.print("TC2: ");
       Divider d2 = new Divider(20, 0);
       d2.divide();
       System.out.print("TC3: ");
       Divider d3 = new Divider(-5, 5);
       d3.divide();
       System.out.print("TC4: ");
       Divider d4 = new Divider(0, 3);
       d4.divide();
       System.out.print("TC5: ");
       Divider d5 = new Divider(100, -10);
       d5.divide();
	}
}
