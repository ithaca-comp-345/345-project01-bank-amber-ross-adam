package edu.ithaca.dragon.bank;

import java.util.ArrayList;
import java.util.List;

public class BankAccountTeller {
    
    private String accountID;
    private List<BankAccount> accounts;
    
    /**
     * @post Creates a new bankAccount() with accountID 
     * 
     * Keep track of this accounts using array list.
     * 
     */
    public void createAccount(String accountID, String email, double startingBalance){
        
       
    }

    /**
     * @post remove accountID from array list
     * what bankaccount you want to close in parm
     */
    public void closeAccount(String removeAccountID) {
        
    }  

    /**
     * @post get AccountID
     * returns the accountID
     */
    public String getAccountID(){
        return accountID;
        

    }

     /**
     * @returns the balance of the account
     */
    public double checkBalance(String accountID){
        throw new RuntimeException("not done yet");
    }

}
