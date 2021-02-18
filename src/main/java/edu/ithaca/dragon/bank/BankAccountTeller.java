package edu.ithaca.dragon.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountTeller {
    
    private String accountID;
    private List<BankAccountInterface> accounts;
    
    /**
     * @post Creates a new bankAccount() with accountID 
     * 
     * checking or saving account if/statment
     * Keep track of this accounts using array list.
     * 
     */
    public void createAccount(String accountID, String which, double startingBalance){
        if(which.equalsIgnoreCase("Checking")){
            accounts.add(new CheckingAccount(accountID, startingBalance));
        }
        else if(which.equalsIgnoreCase("Savings")){
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter interest");
            double interestIn = myObj.nextDouble();
            System.out.println("Enter max withdrawal amount");
            double maxWithdrawAmtIn = myObj.nextDouble();
            accounts.add(new SavingsAccount(accountID, startingBalance, interestIn, maxWithdrawAmtIn));
        }
        else{
            throw new IllegalArgumentException("Must be Checking or Savings");
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

     /**
     * @returns the balance of the account
     */
    public double checkBalance(String accountID){
        throw new RuntimeException("not done yet");
    }

}
