package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class BankAccountTellerTest {
   
    @Test
    void createAccountTest() {
        BankAccount checking = createAccount("123405");
        assertNotNull(checking);

        BankAccount saving = null;
        assertNull(saving);
        
    }


    @Test
    void getAccountIDTest() throws InsufficientFundsException {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getAccountID());
      

    
    }

    @Test
    void closeAccountTest() throws InsufficientFundsException {
       
    }


    
}
