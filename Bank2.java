package starter;
import java.util.*;
public class Bank2 {
	String name;
	Bank2(String name){}
	Set<Branch> branchs=new HashSet<>();
	Set<Account> typesOfAccount=new HashSet<>();
	void addNewBranch(Branch branch) {}
	void removeBranch(Branch branch) {}
	void addNewAccountType(Account account) {}
	void showTypesOfAccount() {}
}
class Branch {
	String Name,ifscCode;
	HashSet<Customer> customers=new HashSet<>();
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
	customerAccess data;
	Customer(String name,customerAccess data){
		this.name=name;
		this.data=data;
	}
	int getBalance(int accountNumber) {
		return 0;
	}
	void deposit(int accountNumber,int amount) {
	}
	void withdrawal(int accountNumber,int amount) {}
	public String getName() {
		return name;
	}
}
interface customerAccess{
	void showAllAccountDetails();
	Account getAccount(int accountNo);
	void showAllDebitCardDetailsLinkedToAccount(Account account);
	void BlockDebitCard(int cardNo);
	CreditCard getCreditCard();
	DebitCard getDebitCard(int cardNo);
}
class CustomerDB implements customerAccess{
	private HashMap<Account,HashSet<DebitCard>> accounts =new HashMap<>();
	private CreditCard creditCard;
	void addNewAccount(Account account) {
	}
	void removeAccount(int accountNumber) {}
	@Override
	public void showAllAccountDetails() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Account getAccount(int accountNo) {
		// TODO Auto-generated method stub
		return null;
	}
	void addNewDebitCard(Account account,DebitCard card) {}
	@Override
	public void showAllDebitCardDetailsLinkedToAccount(Account account) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void BlockDebitCard(int cardNo) {
		// TODO Auto-generated method stub
		
	}
	public void removeDebitCard(int cardNo,Account account) {}
	public HashMap<Account,HashSet<DebitCard>> getAccounts() {
		return accounts;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	@Override
	public DebitCard getDebitCard(int cardNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
class Account{
	private int minimumBalance,balance,accountNumber;
	private String accountType;
	Account(int minBal,int accNo,String accountType){}
	public int getMinimumBalance() {
		return minimumBalance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	void credit(int amount) {

	}
	void debit(int amount){}
	public String getAccountType() {
		return accountType;
	}
}
interface Interest{
	int getInterestRate();
	int calculateInterest(int amount); 
	int getInterestEarned();
}
class SavingAccount extends Account implements Interest{
	static private int minBal,interestRate,interestEarned;
	static private String accountType;
	SavingAccount(int accountNo){
		super(minBal,accountNo,accountType);
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
	void interestupdate() {}
	public int getInterestEarned() {
		return interestEarned;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		SavingAccount.accountType = accountType;
	}
	@Override
	public int calculateInterest(int amount) {
		// TODO Auto-generated method stub
		return 0;
	}
}
class CurrentAccount extends Account{
	static private int minBal;
	static private String accountType;
	CurrentAccount(int accNo){
		super(minBal,accNo,accountType);
	}
	public int getMinBal() {
		return minBal;
	}
	public void setMinBal(int minBal) {
		CurrentAccount.minBal = minBal;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		CurrentAccount.accountType = accountType;
	}
}
class DebitCard{
	private int cardNo,withdrawalLimit,swipLimit;
	private boolean cardStatus=true;
	private Account account;
	DebitCard(int cardNo,Account account,int withdrawalLimit,int swipLimit){
	}
	int getCardNo(){
		return cardNo;
	}
	void withDrawal(int amount) {
		account.debit(amount);
	}
	public int getWithdrawalLimit() {
		return withdrawalLimit;
	}
	public int getSwipLimit() {
		return swipLimit;
	}
	public boolean isCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(boolean cardStatus) {
		this.cardStatus = cardStatus;
	}
	void deposit(int amount) {}
}
class CreditCard{
	private int cardNo,withdrawalLimit,swipLimit,creditedAmount,creditCardInterest;
	CreditCard(int cardNo,int withdrawalLimit,int swipLimit,int creditCardInterest){}
	public int getWithdrawalLimit() {
		return withdrawalLimit;
	}
	public int getSwipLimit() {
		return swipLimit;
	}
	public int getCardNo() {
		return cardNo;
	}
	public int getCreditedAmount() {
		return creditedAmount;
	}
	void withdrawal(int amount) {}
	void autoClaim(Account account) {}
	public int getCreditCardInterest() {
		return creditCardInterest;
	} 
}