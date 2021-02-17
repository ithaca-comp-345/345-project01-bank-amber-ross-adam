package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BankAccountTellerTest {
   
    //get the balance to see if the account exits . Ask amber the balance 
    @Test
    void createAccountAndGetBalanceTest() {
        BankAccountTeller teller = new BankAccountTeller(); 
        teller.createAccount("123405", "Checking", 400.50);
        assertEquals(400.50, teller.checkBalance("123405"));
        teller.createAccount("123", "Savings", 100);
        assertEquals(400.50, teller.checkBalance("123"));
        
    }


    @Test
    void getAccountIDTest() throws InsufficientFundsException {
        BankAccountTeller amber = new BankAccountTeller(); 
        amber.createAccount("123405", "elliott.amber2017@gmail.com", 400.50);

        assertEquals("123405", amber.getAccountID());
        
    
    }

    @Test
    void closeAccountTest() throws InsufficientFundsException {
       
    }

    @Test 
    void checkBalance() throws InsufficientFundsException{

    }


    
}
