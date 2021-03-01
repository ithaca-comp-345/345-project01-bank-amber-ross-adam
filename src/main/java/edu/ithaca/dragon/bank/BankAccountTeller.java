package edu.ithaca.dragon.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountTeller {
    
    public String accountID;
    List<BankAccountInterface> accounts = new ArrayList<BankAccountInterface>();
    
    /**
     * @param j
     * @param i
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
     *
     */
    public void closeAccount(String removeAccountID) {
        for (int index=0; index < accounts.size(); index++){
           /* if (accounts.getAccountID(index) == removeAccountID ){
                accounts.remove(index);
            } 
            */
        }
        
        
    }
    /**
     * returns account based off accountID
     */
    public BankAccountInterface getAccount(String accountID){
        return null;
    }
    /**
     * returns the accountID
     */
    public String getAccountID( int index ){
        if (accounts.isEmpty() || index <0 ||  index >= accounts.size() ){
            throw new IllegalArgumentException("Account doesn't exits");
        }
        return accounts.get(index).getAccountID();

    }

     /**
     * @returns the balance of the account
     */
    public double checkBalance(String accountID){
        throw new RuntimeException("not done yet");
    }

}
