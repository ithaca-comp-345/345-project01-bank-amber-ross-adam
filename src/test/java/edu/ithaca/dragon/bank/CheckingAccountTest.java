package edu.ithaca.dragon.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CheckingAccountTest {

    @Test
    public CheckingAccountTest(){
        CheckingAccount myChecking = new CheckingAccount("carrot", 100);
        CheckingAccount yourChecking = new CheckingAccount("zucchini", 100);

        assertEquals(myChecking.checkBal(), 100);

        myChecking.withdraw(50);
        assertEquals(myChecking.checkBal(), 50);
        myChecking.withdraw(100);
        assertEquals(myChecking.checkBal(), 50);
        myChecking.withdraw(50);
        assertEquals(myChecking.checkBal(), 0);

        myChecking.deposit(100);
        assertEquals(myChecking.checkBal(), 100);

    }
    
}
