package edu.ithaca.dragon.bank;

import java.util.ArrayList;

public class Administration {
    private double equity;

    /**
     * Returns sum of all bank accounts
     * @param accountList
     * @return sum of all balances in accountList
     */
    public double getOverallMoney(ArrayList<BankAccountInterface> accountList){
        double sum = 0;
        for(int i = 0; i< accountList.size(); i++){
            sum += accountList.get(i).checkBal();
        }
        return sum;
    }

    /**
     * Returns report of account.
     * @param account
     * @return prints report of recent transactions, password, balance.
     */
    public String requestReport(BankAccountInterface account){
        return " Balance: " + account.checkBal() + " History: " + account.transactionHistory();
    }
    
    /**
     * Puts freeze on account to halt all functions.
     * @param account
     * @return Void.
     */
    public void freeze(BankAccount account){

    }

    /**
     * Takes freeze off account to continue all functions.
     * @param account
     * @return Void.
     */
    public void unfreeze(BankAccount account){

    }


}
