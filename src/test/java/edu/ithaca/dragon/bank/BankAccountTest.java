package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() throws InsufficientFundsException {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
        bankAccount.withdraw(100);
        assertEquals(100, bankAccount.getBalance());
        bankAccount.withdraw(100);
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() throws InsufficientFundsException{
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        //Test basic functionality of method
        bankAccount.withdraw(100);

        //Test oversized withdraw
        assertEquals(100, bankAccount.getBalance());
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(300));

        //Test withdraw from zero balance
        bankAccount.withdraw(100);
        assertEquals(0, bankAccount.getBalance());
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(100));

        //Test negative withdraw
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-100));

        //Test withdraw with >2 decimal places
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(100.111));
    }

    @Test
    void isEmailValidTest(){
        /**
         * Equivalent classes are invalid prefixes and invalid domains.
         * The latter can be separated into invalid top-level domains and invalid website name.
         * Boundary cases are testing the minimum possible length or cases that test the first
         * and last characters of the email prefix. 
         */
        //minimum length test
        assertTrue(BankAccount.isEmailValid( "a@b.com"));
        assertFalse(BankAccount.isEmailValid(""));

        //punctuation followed by a character test
        assertFalse(BankAccount.isEmailValid("abc-@mail.com"));
        assertTrue(BankAccount.isEmailValid("abc-d@mail.com"));

        //no sequential punctuation test
        assertFalse(BankAccount.isEmailValid("abc..def@mail.com"));
        assertTrue(BankAccount.isEmailValid("abc.def@mail.com"));

        //first character can't be punctuation test
        assertFalse(BankAccount.isEmailValid(".abc@mail.com"));
        assertTrue(BankAccount.isEmailValid("abc@mail.com"));

        //invalid character test
        assertFalse(BankAccount.isEmailValid("abc#def@mail.com"));
        assertTrue(BankAccount.isEmailValid("abc_def@mail.com"));

        //valid top-level domain test
        assertFalse(BankAccount.isEmailValid("abc@mail.c"));
        assertTrue(BankAccount.isEmailValid("abc@mail.cc"));

        //valid characters in domain test
        assertFalse(BankAccount.isEmailValid("abc@mail#archive.com"));
        assertTrue(BankAccount.isEmailValid("abc@mail-archive.com"));

        //existence of a top-level domain test
        assertFalse(BankAccount.isEmailValid("abc@mail"));
        assertTrue(BankAccount.isEmailValid("abc@mail.org"));

        //valid domain test
        assertFalse(BankAccount.isEmailValid("abc@mail..com"));
        assertTrue(BankAccount.isEmailValid("abc@mail.com"));
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));

        //check for exception thrown with a negative value or a value with >2 decimal places
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", -100));
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("a@b.com", 100.111));
    }


    @Test
    void isAmountValidTest(){
        //negative amount test
        assertFalse(BankAccount.isAmountValid(-1.23));
        assertFalse(BankAccount.isAmountValid(-1));
        assertFalse(BankAccount.isAmountValid(-0.01));

        //two or less decimal places test
        assertFalse(BankAccount.isAmountValid(1.234));

        //valid amount test
        assertTrue(BankAccount.isAmountValid(1));
        assertTrue(BankAccount.isAmountValid(1.1));
        assertTrue(BankAccount.isAmountValid(1.23));
    }

    @Test
    void depositTest(){
        BankAccount theSwankBank = new BankAccount("a@b.com", 100.00);

        //amount must be valid (non-negative and two decimal places at most)
        assertThrows(IllegalArgumentException.class, ()-> theSwankBank.deposit(-100));
        assertThrows(IllegalArgumentException.class, ()-> theSwankBank.deposit(100.001));

        //deposit a zero amount
        assertThrows(IllegalArgumentException.class, ()-> theSwankBank.deposit(0));
        assertThrows(IllegalArgumentException.class, ()-> theSwankBank.deposit(0.00));
    }

    @Test
    void transferTest(){
        BankAccount bank1 = new BankAccount("a@b.com", 100);
        BankAccount bank2 = new BankAccount("c@d.com", 100);

        //amount must be valid (non-negative and two decimal places at most)
        assertThrows(IllegalArgumentException.class, ()-> bank1.transfer(-1, bank2));
        assertThrows(IllegalArgumentException.class, ()-> bank1.transfer(1.001, bank2));
        assertEquals(bank1.getBalance(), 100);
        assertEquals(bank2.getBalance(), 100);

        //can't transfer more than the account's balance
        assertThrows(IllegalArgumentException.class, ()-> bank1.transfer(101, bank2));
        assertEquals(bank1.getBalance(), 100);
        assertEquals(bank2.getBalance(), 100);
    }

}