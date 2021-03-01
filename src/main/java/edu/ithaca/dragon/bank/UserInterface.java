package edu.ithaca.dragon.bank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) throws InsufficientFundsException {
        String logIn = "";
        String empty = "";
        CheckingAccount accountCheck = new CheckingAccount("password", 100);
        SavingsAccount accountSav = new SavingsAccount("password", 100, 0.5, 1000);
        Scanner sc = new Scanner(System.in);
        while(!logIn.equalsIgnoreCase("quit")){
            System.out.println("Welcome to the Banking Software.");
            System.out.println("Please select from the options: ATM, Administration, Teller, or Quit: ");
            String softwareSelection = sc.nextLine();
            if(softwareSelection.equalsIgnoreCase("ATM")){
                System.out.println("Please enter your password: ");
                String password = sc.nextLine();
                if(password.equals("password")){ //updated when getAccountId is finished
                    String atmQuit = "";
                    while(!atmQuit.equalsIgnoreCase("back")){
                        System.out.println("Do you want to access your checking or savings account or log out?: ");
                        String checkOrSavings = sc.nextLine();
                        if(checkOrSavings.equalsIgnoreCase("checking")){
                            //find and get checking account here
                            System.out.println("Would you like to: Check balance, deposit, withdraw, transfer, or log out?: ");
                            String checkSelect = sc.nextLine();
                            if(checkSelect.equalsIgnoreCase("check balance")){
                                System.out.println(accountCheck.checkBal());
                            }
                            else if(checkSelect.equalsIgnoreCase("deposit")){
                                System.out.println("Deposit amount: ");
                                Double depositAmount = sc.nextDouble();
                                empty = sc.nextLine();
                                accountCheck.deposit(depositAmount);
                                System.out.println("Deposited: " + depositAmount);
                            }
                            else if(checkSelect.equalsIgnoreCase("withdraw")){
                                System.out.println("Withdraw amount: ");
                                Double withDrawamount = sc.nextDouble();
                                empty = sc.nextLine();
                                accountCheck.deposit(withDrawamount);
                                System.out.println("Withdrew: " + withDrawamount);
                            }
                            else if(checkSelect.equalsIgnoreCase("transfer")){
                                System.out.println("Enter password of account to transfer to: ");
                                String transferPass = sc.nextLine();
                                System.out.println("Amount to transfer: ");
                                Double amount = sc.nextDouble();
                                empty = sc.nextLine();
                                accountCheck.transferTo(accountSav, amount);
                                System.out.println("Transfered: " + amount);
                            }
                            else if(checkSelect.equalsIgnoreCase("log out")){
                                System.out.println("Thanks for using the ATM!");
                                atmQuit = "back";
                            }
                            else{
                                System.out.println("Incorrect input");
                            }
                        }
                        if(checkOrSavings.equalsIgnoreCase("savings")){
                            //find and get checking account here
                            System.out.println("Would you like to: Check balance, deposit, withdraw, transfer, or log out?: ");
                            String checkSelect = sc.nextLine();
                            if(checkSelect.equalsIgnoreCase("check balance")){
                                System.out.println(accountCheck.checkBal());
                            }
                            else if(checkSelect.equalsIgnoreCase("deposit")){
                                System.out.println("Deposit amount: ");
                                Double depositAmount = sc.nextDouble();
                                empty = sc.nextLine();
                                accountCheck.deposit(depositAmount);
                                System.out.println("Deposited: " + depositAmount);
                            }
                            else if(checkSelect.equalsIgnoreCase("withdraw")){
                                System.out.println("Withdraw amount: ");
                                Double withDrawamount = sc.nextDouble();
                                empty = sc.nextLine();
                                accountCheck.deposit(withDrawamount);
                                System.out.println("Withdrew: " + withDrawamount);
                            }
                            else if(checkSelect.equalsIgnoreCase("transfer")){
                                System.out.println("Enter password of account to transfer to: ");
                                String transferPass = sc.nextLine();
                                System.out.println("Amount to transfer: ");
                                Double amount = sc.nextDouble();
                                empty = sc.nextLine();
                                accountCheck.transferTo(accountSav, amount);
                                System.out.println("Transfered: " + amount);
                            }
                            else if(checkSelect.equalsIgnoreCase("log out")){
                                System.out.println("Thanks for using the ATM!");
                                atmQuit = "back";
                            }
                            else{
                                System.out.println("Incorrect input");
                            }
                        }
                        else if(checkOrSavings.equalsIgnoreCase("log out")){
                            logIn = "back";
                        }
                        else{
                            System.out.println("Incorrect input");
                        }
                    }
                }
            }
            else if(softwareSelection.equalsIgnoreCase("administration")){

            }
            else if(softwareSelection.equalsIgnoreCase("teller")){

            }
            else if(softwareSelection.equalsIgnoreCase("Quit")){
                logIn = "quit";
            }
            else{
                System.out.println("Incorrect input");
            }
        }
        
    }
}
