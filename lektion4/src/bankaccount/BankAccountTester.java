package bankaccount;

public class BankAccountTester {
	
	
	private double BankAccount;
	private double interest;
	private double interestadder;
	
	
	public BankAccountTester (double BankAccount1, double Addinterest) {
		BankAccount = BankAccount1;
		interest = Addinterest;	
		interestadder = BankAccount / 100 * interest;
	}
	
	public double getBankAccount() {
		return BankAccount;
	}
	
	public double getInterest() {
		return interest;
	}
	
	public void momsSavings(int BankAccount1) {
		this.BankAccount = BankAccount1;
	}
	
	public void addInterest(int Addinterest) {
		this.interest = Addinterest;
		
	}

		public void printBankAccountTester() {
			System.out.println(BankAccount);
			System.out.println(interest);
			System.out.println("Med interest er det " + Math.round(interestadder + BankAccount));
		}
	}
	
