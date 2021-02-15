package edu.ithaca.dragon.bank;

public class SavingsAccount implements BankAccountInterface{

    public String password;
    public double balance;
    public double interest;
    public double maxWithdrawAmt;

    public SavingsAccount(String passwordIn, double balanceIn, double interestIn, double maxWithdrawAmtIn){
        this.password = passwordIn;
        this.balance = balanceIn;
        this.interest = interestIn;
        this.maxWithdrawAmt = maxWithdrawAmtIn;
    }

    @Override
    public double checkBal() {
        return balance;
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
    public void transferTo(BankAccount transferAccount, double amount) throws InsufficientFundsException {
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
        // TODO Auto-generated method stub
        return null;
    }

    public void compound() {
        balance += balance * interest;
    }
    
}
