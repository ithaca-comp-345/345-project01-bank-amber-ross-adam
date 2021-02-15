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
    Administration admin = new Administration();
    bankAccounts.add(new BankAccount("abc@b.com", 200));
    assertEquals(200, admin.getOverallMoney(bankAccounts));
    bankAccounts.add(new BankAccount("abc@b.com", 12.32));
    assertEquals(212.32, admin.getOverallMoney(bankAccounts));
    assertEquals(212.32, admin.getOverallMoney(bankAccounts));
    bankAccounts.clear();
    bankAccounts.add(new BankAccount("abc@b.com", 0));
    assertEquals(0, admin.getOverallMoney(bankAccounts));
    assertThrows(IllegalArgumentException.class, () -> bankAccounts.add(new BankAccount("a@b.com", -10)));
    }
    @Test
    void requestReportTest(){
    /** Equivalence classes: Correct reports and incorrect reports.
     * Correct reports follow the same format and provide accurate bank info
     * info includes: balance, email, transaction history
     * Edge case: An account with a 0 balance and 0 history.
     * 
     */
    Administration admin = new Administration();
    BankAccount account = new BankAccount("a@b.com", 0);
    assertEquals("Email: a@b.com Balance: 0 History: ", admin.requestReport(account));
    BankAccount account2 = new BankAccount("sus@sus.com", 100); //Will complete this test once transaction history is implemented
    assertEquals("Email: sus@sus.com Balance: 100 History: 100 Pizza hut 1000 ATM 1000 ATM 3000 Doordash", admin.requestReport(account2));
    }
    @Test
    void freezeTest(){
    /** Equivalence classes: freeze correctly halts all banking ability of account by throwing exception
     * Edge case: freeze an account with no balance and no history
     * 
     */
    Administration admin = new Administration();
    BankAccount account = new BankAccount("a@b.com", 0);
    BankAccount account2 = new BankAccount("a@b.com", 100);
    admin.freeze(account);
    assertThrows(IllegalArgumentException.class, () -> account.getBalance());
    assertThrows(IllegalArgumentException.class, () -> account.getEmail());
    assertThrows(IllegalArgumentException.class, () -> account.transfer(100, account2));
    assertThrows(IllegalArgumentException.class, () -> account.deposit(11));
    assertThrows(IllegalArgumentException.class, () -> account.withdraw(1));


    assertThrows(IllegalArgumentException.class, () -> account2.getBalance());
    assertThrows(IllegalArgumentException.class, () -> account2.getEmail());
    assertThrows(IllegalArgumentException.class, () -> account2.transfer(100, account));
    assertThrows(IllegalArgumentException.class, () -> account2.deposit(11));
    assertThrows(IllegalArgumentException.class, () -> account2.withdraw(1));
    }
    @Test
    void unfreezeTest() throws InsufficientFundsException {
        /** Equivalence classes: freeze correctly halts all banking ability of account by throwing exception
     * Edge case: freeze an account with no balance and no history
     * 
     */
    Administration admin = new Administration();
    BankAccount account = new BankAccount("a@b.com", 0);
    admin.freeze(account);
    assertEquals(0, account.getBalance());
    assertEquals("a@b.com", account.getEmail());
    account.deposit(11);
    assertEquals(11, account.getBalance());
    account.withdraw(10);
    assertEquals(1, account.getBalance());
    }
}
