package edu.ithaca.dragon.bank;

public interface BankAccountInterface {

	public double checkBal();

    public String getAccountID();

    public void withdraw(double amount) throws InsufficientFundsException;

    public void deposit(double amount);

    public void transferTo(BankAccountInterface transferAccount, double amount) throws InsufficientFundsException;

    public String transactionHistory();

    public void isFrozen(Boolean isFreeze);

    public Boolean getFreeze();

}
