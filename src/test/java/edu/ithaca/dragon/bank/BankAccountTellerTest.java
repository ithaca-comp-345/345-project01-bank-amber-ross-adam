package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BankAccountTellerTest {
   
    
    @Test
    void createAccountAndGetBalanceTest() {
        BankAccountTeller teller = new BankAccountTeller(); 
        teller.createAccount("123405", "Checking", 400.50);
        assertNotNull(teller.accounts.get(0));
        //assertEquals(400.50, teller.checkBalance("123405"));
        //teller.createAccount("123", "Savings", 100);
        //assertEquals(400.50, teller.checkBalance("123"));
        
    }


    @Test
    void getAccountIDTest() throws InsufficientFundsException {
        BankAccountTeller teller = new BankAccountTeller(); 
        teller.createAccount("123405", "Checking", 400.50);
        
        teller.createAccount("43235", "Savings", 400.50);

        assertEquals("123405", teller.getAccountID(0));
        
        assertEquals("43235", teller.getAccountID(1));
        
        //assertEquals("43235", teller.getAccountID(2)); //not in list
    
    
    }

    @Test
    void closeAccountTest() throws InsufficientFundsException {
        BankAccountTeller teller = new BankAccountTeller(); 
        teller.createAccount("123405", "checking", 400.50);
        teller.createAccount("345654", "savings", 400.50);



    }

    @Test 
    void checkBalance() throws InsufficientFundsException{

    }

    //st
    @Test 
    void custumerTest() throws InsufficientFundsException{

    }


    
}
