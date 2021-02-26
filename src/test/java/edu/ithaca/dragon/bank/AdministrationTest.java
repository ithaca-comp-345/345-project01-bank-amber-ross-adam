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
    BankAccountInterface account1 = new CheckingAccount("123", 0);
    BankAccountInterface account2 = new SavingsAccount("1234", 100, .05, 1000);
    admin.freeze(account1);
    assertThrows(IllegalArgumentException.class, () -> account1.checkBal());
    assertThrows(IllegalArgumentException.class, () -> account1.getPassword());
    assertThrows(IllegalArgumentException.class, () -> account1.transferTo(account2, 100));
    assertThrows(IllegalArgumentException.class, () -> account1.deposit(11));
    assertThrows(IllegalArgumentException.class, () -> account1.withdraw(1));

    admin.freeze(account2);
    assertThrows(IllegalArgumentException.class, () -> account2.checkBal());
    assertThrows(IllegalArgumentException.class, () -> account2.getPassword());
    assertThrows(IllegalArgumentException.class, () -> account2.transferTo(account1, 100));
    assertThrows(IllegalArgumentException.class, () -> account2.deposit(11));
    assertThrows(IllegalArgumentException.class, () -> account2.withdraw(1));
    
    }

    @Test
    void unfreezeTest() throws InsufficientFundsException {
        /** Equivalence classes: freeze correctly halts all banking ability of account by throwing exception
     * Edge case: freeze an account with no balance and no history
     * 
     */
    

     //checking
    Administration admin = new Administration();
    BankAccountInterface account = new CheckingAccount("123", 0);
    BankAccountInterface account2 = new CheckingAccount("123", 100);
    admin.freeze(account);
    admin.unfreeze(account);
    assertEquals(0, account.checkBal());
    assertEquals("123", account.getPassword());
    account.deposit(11);
    assertEquals(11, account.checkBal());
    account.withdraw(10);
    assertEquals(1, account.checkBal());
    account2.transferTo(account, 100);
    assertEquals(101, account.checkBal());
    assertEquals(0, account2.checkBal());

    //savings
    SavingsAccount account3 = new SavingsAccount("123", 0, 0.5, 1000);
    SavingsAccount account4 = new SavingsAccount("123", 100, 1, 500);
    admin.freeze(account3);
    admin.unfreeze(account3);
    assertEquals(0, account3.checkBal());
    assertEquals("123", account3.getPassword());
    account3.deposit(11);
    assertEquals(11, account3.checkBal());
    account3.withdraw(10);
    assertEquals(1, account3.checkBal());
    account4.transferTo(account3, 100);
    assertEquals(101, account3.checkBal());
    assertEquals(0, account4.checkBal());
    account3.compound();
    assertEquals(151.5, account3.checkBal());

    }
    
    
}
