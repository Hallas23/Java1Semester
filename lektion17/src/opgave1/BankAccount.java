package opgave1;


public class BankAccount {
	private double balance;
	private static int lastassignednumber = 1000;
	private int accountnumber;
	
	/**
     * Constructor that creates a bankaccount.
     * @param balance the balance of the bankaccount
     */

	public BankAccount(double initialBalance) {
		accountnumber = BankAccount.lastassignednumber;
		BankAccount.lastassignednumber++;
		balance = initialBalance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		balance -= amount;
	}

	public double getBalance() {
		return balance;
	}
	
	public static int getAntalNumber() {
		return BankAccount.lastassignednumber;
	}
	
	public int getNumber() {
		return accountnumber;
	}
	
}