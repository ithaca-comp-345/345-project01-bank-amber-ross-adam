package edu.ithaca.dragon.bank;

public class CheckingAccount implements BankAccountInterface{

    public String password;
    public double balance;
    public boolean freeze;

    public CheckingAccount(String passwordIn, double balanceIn){
        if(freeze){
            throw new IllegalArgumentException("Your account is frozen");
        }
        else{
            this.password = passwordIn;
            this.balance = balanceIn;
            freeze = false;
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
    public void withdraw(double amount) throws InsufficientFundsException{
        if ((amount <= balance) && (balance != 0)){
            balance -= amount;
        }
        else if(freeze){
            throw new IllegalArgumentException("Your account is frozen");
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
        else if (amount > 0){
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

    @Override
    public String getPassword() {
        if(freeze){
            throw new IllegalArgumentException("Your account is frozen");
        }
        else{
            return password;
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