package edu.ithaca.dragon.bank;

import java.util.ArrayList;
import java.util.List;

public class BankAccountTeller {
    
    private String accountID;
    
    /**
     * @post Creates a new bankAccount() with accountID 
     * returns the account number of this new account 
     * Keep track of this accounts using array list.
     * 
     */
    public void createAccount(String accountID, String email, String accountType, double startingBalance){
        
        List<Object> accounts = new ArrayList<Object>();

        if (accountType.equalsIgnoreCase("checking")){
            accounts.add(new CheckingAccount(email, startingBalance));
        }
        else if (accountType.equalsIgnoreCase("savings")){
            accounts.add(new SavingsAccount(email, startingBalance, 0.03, 500));
        }
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
}
