package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
public class AdministrationTest {
    @Test
    void getOverallMoneyTest(){
    /** One equivalence class is the amount of balances being added together.
     * One is the minimum, if it is less than one it will throw an exception. 
     * There is no maximum. 
     * Another equivalence class is correct/incorrect balances.
     * An incorrect balance (negative) would throw an exception. Overall money should never
     * be negative.
     * Edge cases: only one bank account object added, overall money = 0
    */
    ArrayList bankAccounts = new ArrayList<BankAccount>();
    bankAccounts.add(new BankAccount("a@b.com", 200));
    assertEquals(200, Administration.getOverallMoney(bankAccounts));
    bankAccounts.add(new BankAccount("a@b.com", 12.32));
    assertEquals(212.32, Administration.getOverallMoney(bankAccounts));
    bankAccounts.add(new BankAccount("a@b.com", 0));
    assertEquals(212.32, Administration.getOverallMoney(bankAccounts));
    bankAccounts.clear();
    bankAccounts.add(new BankAccount("a@b.com", 0));
    assertEquals(0, Administration.getOverallMoney(bankAccounts));
    bankAccounts.add(new BankAccount("a@b.com", -10));
    assertThrows(IllegalArgumentException.class, () -> Administration.getOverallMoney(bankAccounts));

    }
    @Test
    void requestReportTest(){
    /** Equivalence class: freezing non-suspicious accounts and freezing suspicious accounts
     * Suspicious accounts would follow the following criteria: 
     * 
     */

    }
    @Test
    void freezeTest(){
        /** Equivalence class:
         * 
         */

    }
    @Test
    void unfreezeTest(){
        /** Equivalence class:
         * 
         */

    }
}
