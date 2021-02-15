package edu.ithaca.dragon.bank;

import java.util.ArrayList;

public class Administration {
    private double equity;

    /**
     * Returns sum of all bank accounts
     * @param accountList
     * @return sum of all balances in accountList
     */
    public static double getOverallMoney(ArrayList<BankAccount> accountList){
        double sum = 0;
        for(int i = 0; i< accountList.size(); i++){
            sum += accountList.get(i).getBalance();
        }
        return sum;
    }
    
}
