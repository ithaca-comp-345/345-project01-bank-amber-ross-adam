package edu.ithaca.dragon.bank;

public class SavingsAccount implements BankAccountInterface{

    public String accountID;
    public double balance;
    public double interest;
    public double maxWithdrawAmt;
    public boolean freeze;

    public SavingsAccount(String accountID, double balanceIn, double interestIn, double maxWithdrawAmtIn){
        if(freeze){
            throw new IllegalArgumentException("Your account is frozen");
        }
        else{
            this.accountID = accountID;
            this.balance = balanceIn;
            this.interest = interestIn;
            this.maxWithdrawAmt = maxWithdrawAmtIn;
            this.freeze = false;
        }
    }


    @Override
    public double checkBal() {
        if(freeze){
            throw new IllegalArgumentException("Your account is frozen");
        }
        else{
            return balance;
        }
    }

    
    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if(freeze){
            throw new IllegalArgumentException("Your account is frozen");
        }
        else if ((amount <= balance) && (balance != 0) && (amount <= maxWithdrawAmt)){
            balance -= amount;
        }
        else{
            throw new InsufficientFundsException("Not enough money in account");
        }
    }

    @Override
    public void deposit(double amount) {
        if(freeze){
            throw new IllegalArgumentException("Your account is frozen");
        }
        else if(amount > 0){
            balance += amount;
        }
    }

    @Override
    public void transferTo(BankAccountInterface transferAccount, double amount) throws InsufficientFundsException {
        if(freeze){
            throw new IllegalArgumentException("Your account is frozen");
        }
        else if (this.balance <= amount){
            this.balance -= amount;
            transferAccount.deposit(amount);
        }
        else{
            throw new InsufficientFundsException("Insufficient funds");
        }
    }

    @Override
    public String transactionHistory() {
        if(freeze){
            throw new IllegalArgumentException("Your account is frozen");
        }
        else{
            return null;
        }
    }

    public void compound() {
        if(freeze){
            throw new IllegalArgumentException("Your account is frozen");
        }
        else{
            balance += balance * interest;
        }
    }

    @Override
    public String getAccountID() {
        if(freeze){
            throw new IllegalArgumentException("Your account is frozen");
        }
        else{
            return accountID;
        }
    }

    @Override
    public void isFrozen(Boolean isFreeze) {
        if(isFreeze){
            this.freeze = true;
        }
        else{
            this.freeze = false;
        }  
    }
}
