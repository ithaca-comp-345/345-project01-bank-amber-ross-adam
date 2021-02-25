package edu.ithaca.dragon.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountTeller {
    
    public String accountID;
    List<BankAccountInterface> accounts = new ArrayList<BankAccountInterface>();
    
    /**
     * @post Creates a new bankAccount() with accountID 
     * 
     * checking or saving account if/statment
     * Keep track of this accounts using list.
     * 
     */
    public void createAccount(String accountID, String which, double startingBalance, double interestIn, double maxWithdrawAmtIn){
        if(which.equalsIgnoreCase("Checking")){
            accounts.add(new CheckingAccount(accountID, startingBalance));
        }
        else if(which.equalsIgnoreCase("Savings")){
            accounts.add(new SavingsAccount(accountID, startingBalance, interestIn, maxWithdrawAmtIn));
        }
        else{
            throw new IllegalArgumentException("Must be Checking or Savings");
        }
    }

    /**
     * @post remove accountID from list
     * if accounts empty tell user
     * else remove the account
     */
    public void closeAccount(String removeAccountID) {
        if (accounts.isEmpty()){
            
        }
    }  

    /**
     * @post get AccountID
     * returns the accountID
     */
    public String getAccountID( int index ){
        return accounts.get(index).getPassword();

    }

     /**
     * @returns the balance of the account
     */
    public double checkBalance(String accountID){
        throw new RuntimeException("not done yet");
    }

}
