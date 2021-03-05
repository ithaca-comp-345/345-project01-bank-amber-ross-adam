package edu.ithaca.dragon.bank;

public interface BankAccountInterface {

    //Getter for field: balance
	public double checkBal();

    //Getter for field: accountID
    public String getAccountID();

    //Withdraws a positive amount from the account of choice, given that the account has sufficient funds
    public void withdraw(double amount) throws InsufficientFundsException;

    //Deposits a positive amount into the account of choice
    public void deposit(double amount);

    //Transfers a positive amount from one account to another, given that the account being transfered from has sufficient funds
    public void transferTo(BankAccountInterface transferAccount, double amount) throws InsufficientFundsException;

    //Returns a list of the transactions associated with a given account
    public String transactionHistory();

    //Checks if a given account has been frozen
    public void isFrozen(Boolean isFreeze);

    //Getter for frozen account
    public Boolean getFreeze();

}
