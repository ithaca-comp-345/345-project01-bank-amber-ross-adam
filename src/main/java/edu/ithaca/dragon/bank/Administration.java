package edu.ithaca.dragon.bank;

import java.util.ArrayList;
import java.util.List;
public class Administration {
    
    public ArrayList<BankAccountInterface> frozenAccounts;

    /**
     * Returns sum of all bank accounts
     * @param accountList
     * @return sum of all balances in accountList
     */
    public double getOverallMoney(List<BankAccountInterface> accountList){
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
        return "Account ID: " + account.getAccountID() + " Balance: " + account.checkBal() + " History: " + account.transactionHistory();
    }
    
    /**
     * Puts freeze on account to halt all functions.
     * @param account
     * @return Void.
     */
    public void freeze(BankAccountInterface account){
        Boolean freezeAct = true;
        account.isFrozen(freezeAct);
    }

    /**
     * Takes freeze off account to continue all functions.
     * @param account
     * @return Void.
     */
    public void unfreeze(BankAccountInterface account){
        Boolean unFreezeAct = false;
        account.isFrozen(unFreezeAct);
    }
}
