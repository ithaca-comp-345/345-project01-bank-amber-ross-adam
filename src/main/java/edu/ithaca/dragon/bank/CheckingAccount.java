package edu.ithaca.dragon.bank;

public class CheckingAccount implements BankAccountInterface{

    public String accountId;
    public double balance;

    public CheckingAccount(String accountId, double balanceIn){
        this.accountId = accountId;
        this.balance = balanceIn;
    }

    @Override
    public double checkBal() {
        return balance;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException{
        if ((amount <= balance) && (balance != 0)){
            balance -= amount;
        }
        else{
            throw new InsufficientFundsException("Not enough money in account");
        }
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0){
            balance += amount;
        }
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

    public String getAccountID() {
        return accountId;
    }

}