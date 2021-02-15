package edu.ithaca.dragon.bank;

public interface BankAccountInterface {

    public double checkBal();

    public void withdraw(double amount) throws InsufficientFundsException;

    public void deposit(double amount);

    public void transferTo(BankAccount transferAccount, double amount) throws InsufficientFundsException;

    public String transactionHistory();

}