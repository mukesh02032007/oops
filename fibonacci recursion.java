package oops;
import java.util.Scanner;
public class Fibonaccirecursion {
	public static int fibo(int n)
	{
		if(n<=1)
		{
			return n;
		}
		return fibo(n-1)+fibo(n-2);
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.print("Enter number:");
		int n=s.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.print(fibo(i)+" ");
		}s.close();
	}
}
