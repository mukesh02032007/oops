//2117240070193
//mukesh p
package oops;
interface BankingService {
    void deposit(double amount);
    void withdraw(double amount);
    void log();
}
class Account implements BankingService {
    private double balance = 0;
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Balance = " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Balance = " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    @Override
    public void log() {
        System.out.println("Transaction recorded.");
    }
}
class Transaction implements BankingService {
    @Override
    public void deposit(double amount) {}
    @Override
    public void withdraw(double amount) {}
    @Override
    public void log() {
        System.out.println("Transaction recorded.");
    }
}
public class Bank {
	public static void main(String[] args) {
		System.out.println("MUKESH P\n2117240070193");
        BankingService account = new Account();
        System.out.print("TC1:");
        account.deposit(1000);
        System.out.print("TC2:");
        account.withdraw(500);
        System.out.print("TC3:");
        account.withdraw(1500);
        System.out.print("TC4:");
        account.deposit(-200);
        System.out.print("TC5:");
        account.log();
	}
}
