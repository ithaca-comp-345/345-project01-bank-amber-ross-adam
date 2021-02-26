package edu.ithaca.dragon.bank;

public class SavingsAccount implements BankAccountInterface{

    public String accountID;
    public double balance;
    public double interest;
    public double maxWithdrawAmt;

    public SavingsAccount(String accountID, double balanceIn, double interestIn, double maxWithdrawAmtIn){
        this.accountID = accountID;
        this.balance = balanceIn;
        this.interest = interestIn;
        this.maxWithdrawAmt = maxWithdrawAmtIn;
    }

    @Override
    public double checkBal() {
        return balance;
    }

    
    public String getAccountID() {
        return accountID;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if ((amount <= balance) && (balance != 0) && (amount <= maxWithdrawAmt)){
            balance -= amount;
        }
        else{
            throw new InsufficientFundsException("Not enough money in account");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void transferTo(BankAccountInterface transferAccount, double amount) throws InsufficientFundsException {
        if (this.balance <= amount){
            this.balance -= amount;
            transferAccount.deposit(amount);
        }
        else{
            throw new InsufficientFundsException("Insufficient funds");
        }
    }

    @Override
    public String transactionHistory() {
        
        return null;
    }

    public void compound() {
        balance += balance * interest;
    }

}
