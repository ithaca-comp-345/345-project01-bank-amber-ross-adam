package edu.ithaca.dragon.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    //Conducts a system test for the full functionality of the SavingsAccount class and its objects
    @Test
    public void savingsAccountSystemTest() throws InsufficientFundsException{
        SavingsAccount mySavings = new SavingsAccount("apple", 100, 0.03, 500);

        assertEquals("apple", mySavings.getAccountID());

        mySavings.deposit(100);
        assertEquals(200, mySavings.checkBal());
        mySavings.deposit(-100);
        assertEquals(200, mySavings.checkBal());

        mySavings.withdraw(100);
        assertEquals(100, mySavings.checkBal());
        mySavings.withdraw(101);
        assertEquals(100, mySavings.checkBal());

        mySavings.compound();
        assertEquals(103, mySavings.checkBal());
    }
}
