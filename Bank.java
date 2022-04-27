package starter;
import java.util.*;
public class Bank{
	String name;
	Bank(String name){}
	Set<Branch> branchs=new HashSet<>();
	Set<Account> typesOfAccount=new HashSet<>();
	void addNewBranch(Branch branch) {}
	void removeBranch(Branch branch) {}
	void addNewAccountType(Account account) {}
	void showTypesOfAccount() {}
}
class Branch {
	String Name,ifscCode;
	HashMap<Customer,Account> customers=new HashMap<>();
	void addNewCustomer(Customer customer) {}
	void getCustomerDetails(int accNo) {}
	String getBranchName(){
		return Name;
	}
	String getIFSCcode(){
		return ifscCode;
	}
	void updateInterestForAll() {}
}
class Customer{
	private String name;
	private int accountNumber;
	private Account account;
	Customer(String name,int accNo,Account acc){
		this.accountNumber=accNo;
		this.account=acc;
	}
	int getBalance() {
		return account.getBalance();
	}
	void deposit(int amount) {
	}
	void withdrawal(int amount) {}
	void changeAccountType(Account account) {}
	public String getName() {
		return name;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
}
class Account{
	int minBal,interestRate,balance,interestEarned;
	Account(int minBal,int interestRate){
	}
	int getBalance() {
		return balance;
	}
	void credit(int amount) {

	}
	void debit(int amount){}
	void interestupdate() {}
	int getInterestEarned() {
		return interestEarned;
	}
}
class SavingAccount extends Account{
	static private int minBal,interestRate;
	SavingAccount(){
		super(minBal,interestRate);
	}
	public int getMinBal() {
		return minBal;
	}
	public void setMinBal(int minBal) {
		SavingAccount.minBal = minBal;
	}
	public int getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(int interestRate) {
		SavingAccount.interestRate = interestRate;
	}
}
class CurrentAccount extends Account{
	static private int minBal;
	CurrentAccount(){
		super(minBal,1);
	}
	public int getMinBal() {
		return minBal;
	}
	public void setMinBal(int minBal) {
		CurrentAccount.minBal = minBal;
	}
}