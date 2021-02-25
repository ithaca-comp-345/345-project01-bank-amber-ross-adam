package edu.ithaca.dragon.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CheckingAccountTest {

    @Test
    public void withdrawTest() throws InsufficientFundsException {
        CheckingAccount myChecking = new CheckingAccount("carrot", 100);

        assertEquals(myChecking.checkBal(), 100);

        myChecking.withdraw(50);
        assertEquals(myChecking.checkBal(), 50);
        myChecking.withdraw(100);
        assertEquals(myChecking.checkBal(), 50);
        myChecking.withdraw(50);
        assertEquals(myChecking.checkBal(), 0);
    }

    @Test
    public void depositTest(){
        CheckingAccount myChecking = new CheckingAccount("carrot", 100);
        myChecking.deposit(100);
        assertEquals(myChecking.checkBal(), 100);
        myChecking.deposit(-100);
        assertEquals(myChecking.checkBal(), 100);
    }

    @Test
    public void transferTest() throws InsufficientFundsException {
        CheckingAccount myChecking = new CheckingAccount("carrot", 100);
        CheckingAccount yourChecking = new CheckingAccount("zucchini", 100);

        myChecking.transferTo(yourChecking, 50);
        assertEquals(50, myChecking.checkBal());
        assertEquals(150, yourChecking.checkBal());

        yourChecking.transferTo(myChecking, 150);
        assertEquals(200, myChecking.checkBal());
        assertEquals(0, yourChecking.checkBal());

    }
    
}
