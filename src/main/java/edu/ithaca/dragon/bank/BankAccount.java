package edu.ithaca.dragon.bank;

public class BankAccount {

    public double balance;

    /**
     * Checks the validity of an amount being entered for a given transaction
     * @param amount
     * @return true if amount is positive and has two decimal places or less, false otherwise
     */
    public static boolean isAmountValid(double amount){
        if (amount < 0){
            return false;
        }
        Double amountWrapper = amount;
        String amountString = amountWrapper.toString();
        if (amountString.contains(".")){
            String[] splitAmount = amountString.split("\\.");
            String decimals = splitAmount[1];
            if (decimals.length() > 2){
                return false;
            }
        }
        return true;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     * throws an InsufficientFundsException if the amount is greater than the balance, or if balance is zero
     * throws an IllegalArgumentException if the amount is negative
     */
    public void withdraw (double amount) throws InsufficientFundsException{
        if (isAmountValid(amount) == true){
            if (amount <= balance){
                balance -= amount;
            }
            else {
                throw new InsufficientFundsException("Not enough money");
            }
        }
        else {
            throw new IllegalArgumentException("Invalid amount");
        }
    }

    /**
     * deposits amount into given account
     * @param amount
     */
    public void deposit(double amount) throws IllegalArgumentException{
        if (BankAccount.isAmountValid(amount) == false){
            throw new IllegalArgumentException("Invalid amount");
        }
        else{
            balance += amount;
        }
    }

    /**
     * withdraws amount from a BankAccount and deposits the amount into another BankAccount
     * @param amount
     * @param transferAccount
     */
    public void transfer(double amount, BankAccount transferAccount) throws IllegalArgumentException{
        if (BankAccount.isAmountValid(amount) == false){
            throw new IllegalArgumentException("Invalid amount");
        }
        if (this.balance == 0){
            throw new IllegalArgumentException("Account is empty");
        }
        if (amount <= this.balance){
            this.balance -= amount;
            transferAccount.balance += amount;
        }
        else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public static boolean isEmailValid(String email){
        
        if (email.length() < 6){
            return false;
        }
        else if (email.indexOf('@') == -1 || email.indexOf('.')==-1){
            return false;
        }
        else if(email.indexOf('@')==0 || email.indexOf('@')==email.length()-1){
            return false;
        }
        else if(email.indexOf('.')==0 || email.indexOf('.')==email.length()-1){
            return false;
        }
        else if(email.indexOf('@')!=email.lastIndexOf('@')){
            return false;
        }
        else {

            String[] atArr = email.split("@");
            String[] dotArr = email.split("\\.");
            
            
            if(atArr[0].charAt(atArr[0].length()-1)<46 || atArr[0].charAt(atArr[0].length()-1)>122){
                return false;
            }
            if(dotArr[1].length()<2){
                return false;
            }
            for(int j=0;j<atArr[1].length();j++){
                if (atArr[1].charAt(j)<36 ||atArr[1].charAt(j)>122){
                    return false;
                }
            }
            for(int j=0;j<atArr[0].length();j++){
                if (atArr[0].charAt(j)<36 ||atArr[0].charAt(j)>122){
                    return false;
                }
            }
            return true;
        }
    }

}
