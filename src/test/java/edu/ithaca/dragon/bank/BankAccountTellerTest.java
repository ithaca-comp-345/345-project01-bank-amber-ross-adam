package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BankAccountTellerTest {
   
    
    @Test
    void createAccountAndGetBalanceTest() {
        BankAccountTeller teller = new BankAccountTeller(); 
        teller.createAccount("123405", "Checking", 400.50, 0, 0);
        assertNotNull(teller.accounts.get(0).checkBal());
        
        teller.createAccount("123", "Savings", 100, 0.5, 1000);
        assertEquals(100, teller.accounts.get(1).checkBal());
        
    }


    @Test
    void getAccountIDTest() throws IllegalArgumentException {
        BankAccountTeller teller = new BankAccountTeller(); 
        teller.createAccount("123405", "Checking", 400.50, 0, 0);
        teller.createAccount("43235", "Savings", 400.50, .5, 1000);
        teller.createAccount("43235", "Savings", 40.00, 1.00, 10);

        //Make accounts
        assertEquals("123405", teller.getAccountID(0));
        assertEquals("43235", teller.getAccountID(1));
        assertEquals("43235", teller.getAccountID(2));
        

        //Account doesn't exists
        assertThrows(IllegalArgumentException.class, () -> teller.getAccountID(-1));
        assertThrows(IllegalArgumentException.class, () -> teller.getAccountID(-10));
        assertThrows(IllegalArgumentException.class, () -> teller.getAccountID(3));
        assertThrows(IllegalArgumentException.class, () -> teller.getAccountID(10));
        
    }

    @Test
    void closeAccountTest() throws IllegalArgumentException {
        BankAccountTeller teller = new BankAccountTeller(); 
        teller.createAccount("123405", "checking", 400.50, 0, 0);
        teller.createAccount("345654", "savings", 400.50, 0.5, 1000);

        teller.closeAccount("123405");
        assertThrows(IllegalArgumentException.class, () -> teller.getAccountID(0));
        
    


    }

    @Test 
    void checkBalance() throws InsufficientFundsException{

    }

    //system test  
    @Test 
    void customerTest() throws InsufficientFundsException{
        BankAccountTeller teller = new BankAccountTeller(); 
        teller.createAccount("123405", "checking", 400.50, 0, 0);
        teller.createAccount("345654", "savings", 400.50, 0.5, 1000);
        
        //checking
         
        
    }


    
}
