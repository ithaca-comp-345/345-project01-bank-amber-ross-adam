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
    ArrayList bankAccounts = new ArrayList<BankAccountInterface>();
    Administration admin = new Administration();
    bankAccounts.add(new CheckingAccount("password", 200));
    assertEquals(200, admin.getOverallMoney(bankAccounts));
    bankAccounts.add(new SavingsAccount("password", 12.32, .10, 1000));
    assertEquals(212.32, admin.getOverallMoney(bankAccounts));
    assertEquals(212.32, admin.getOverallMoney(bankAccounts));
    bankAccounts.clear();
    bankAccounts.add(new CheckingAccount("password", 0));
    assertEquals(0, admin.getOverallMoney(bankAccounts));
    assertThrows(IllegalArgumentException.class, () -> bankAccounts.add(new CheckingAccount("password", -10)));
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
    BankAccountInterface account = new CheckingAccount("123", 0);
    assertEquals("Password: 123 Balance: 0 History: ", admin.requestReport(account));
    BankAccountInterface account2 = new SavingsAccount("1234", 100, 0.05, 100); //Will complete this test once transaction history is implemented
    assertEquals("Password: 1234 Balance: 100 History: 100 Pizza hut 1000 ATM 1000 ATM 3000 Doordash", admin.requestReport(account2));
    }
    @Test
    void freezeTest(){
    /** Equivalence classes: freeze correctly halts all banking ability of account by throwing exception
     * Edge case: freeze an account with no balance and no history
     * This is a system test.
     */
    
    Administration admin = new Administration();
    BankAccountInterface account = new CheckingAccount("123", 0);
    BankAccountInterface account2 = new SavingsAccount("1234", 100, .05, 1000);
    admin.freeze(account);
    assertThrows(IllegalArgumentException.class, () -> account.checkBal());
    assertThrows(IllegalArgumentException.class, () -> account.getPassword());
    assertThrows(IllegalArgumentException.class, () -> account.transferTo(account2, 100));
    assertThrows(IllegalArgumentException.class, () -> account.deposit(11));
    assertThrows(IllegalArgumentException.class, () -> account.withdraw(1));

    admin.freeze(account2);
    assertThrows(IllegalArgumentException.class, () -> account2.checkBal());
    assertThrows(IllegalArgumentException.class, () -> account2.getPassword());
    assertThrows(IllegalArgumentException.class, () -> account2.transferTo(account, 100));
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
    BankAccountInterface account = new CheckingAccount("123", 0);
    admin.freeze(account);
    admin.unfreeze(account);
    assertEquals(0, account.checkBal());
    assertEquals("123", account.getPassword());
    account.deposit(11);
    assertEquals(11, account.checkBal());
    account.withdraw(10);
    assertEquals(1, account.checkBal());
    
    }
    
    
}
