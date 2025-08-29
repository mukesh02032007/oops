package javaoops;
interface Bankingservice {
	   void deposit(double amount); 
	   void withdraw(double amount); 
	   void log(); 
}
class Account implements Bankingservice{
	   private double balance = 0; 
	   @Override 
	   public void deposit(double amount) { 
	       if (amount > 0) { 
	           balance += amount; 
	           System.out.println("Balance: " + balance); 
	       } else { 
	           System.out.println("Invalid deposit amount."); 
	       } 
	   } 
	   @Override 
	   public void withdraw(double amount) { 
	       if (amount <= balance) { 
	           balance -= amount; 
	           System.out.println("Balance: " + balance); 
	       } else { 
	           System.out.println("Insufficient funds."); 
	       } 
	   } 
}
class Transaction implements Bankingservice{
	@Override
	public void log() { 
		System.out.println("Transaction recorded"); 
	} 
}
public class Bank {
	public static void main(String[] args) {
	       Bankingservice account = new Account(); 
	       System.out.println("TC1: Deposit 1000"); 
	       account.deposit(1000); 
	       System.out.println("\nTC2: Withdraw 500"); 
	       account.withdraw(500);  
	       System.out.println("\nTC3: Withdraw 1500"); 
	       account.withdraw(1500); 
	       System.out.println("\nTC4: Deposit -200"); 
	       account.deposit(-200); 
	       System.out.println("\nTC5: Log transaction"); 
	       account.log();
	}

}
