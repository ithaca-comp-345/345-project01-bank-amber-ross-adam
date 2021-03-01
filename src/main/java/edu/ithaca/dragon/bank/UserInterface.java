package edu.ithaca.dragon.bank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) throws InsufficientFundsException {
        String logIn = "";
        String empty = "";
        BankAccountTeller teller = new BankAccountTeller();
        Administration admin = new Administration();
        Scanner sc = new Scanner(System.in);
        while(!logIn.equalsIgnoreCase("quit")){
            System.out.println("Welcome to the Banking Software.");
            System.out.println("Please select from the options: ATM, Administration, Teller, or Quit: ");
            String softwareSelection = sc.nextLine();
            if(softwareSelection.equalsIgnoreCase("ATM")){
                System.out.println("Please enter your accountID of your checking or savings account: ");
                String accountID = sc.nextLine();
                BankAccountInterface userAccount = teller.getAccount(accountID);
                if(accountID.equals(userAccount.getAccountID())){
                    String atmQuit = "";
                    while(!atmQuit.equalsIgnoreCase("back")){
                        System.out.println("Do you want to access your checking or savings account or log out?: ");
                        String checkOrSavings = sc.nextLine();
                        if(checkOrSavings.equalsIgnoreCase("checking") && userAccount instanceof CheckingAccount ){
                            System.out.println("Would you like to: Check balance, deposit, withdraw, transfer, or log out?: ");
                            String checkSelect = sc.nextLine();
                            if(checkSelect.equalsIgnoreCase("check balance")){
                                System.out.println(userAccount.checkBal());
                            }
                            else if(checkSelect.equalsIgnoreCase("deposit")){
                                System.out.println("Deposit amount: ");
                                Double depositAmount = sc.nextDouble();
                                empty = sc.nextLine();
                                userAccount.deposit(depositAmount);
                                System.out.println("Deposited: " + depositAmount);
                            }
                            else if(checkSelect.equalsIgnoreCase("withdraw")){
                                System.out.println("Withdraw amount: ");
                                Double withDrawamount = sc.nextDouble();
                                empty = sc.nextLine();
                                userAccount.deposit(withDrawamount);
                                System.out.println("Withdrew: " + withDrawamount);
                            }
                            else if(checkSelect.equalsIgnoreCase("transfer")){
                                System.out.println("Enter accountID of account to transfer to: ");
                                String transferPass = sc.nextLine();
                                BankAccountInterface transferAccount = teller.getAccount(transferPass);
                                System.out.println("Amount to transfer: ");
                                Double amount = sc.nextDouble();
                                empty = sc.nextLine();
                                userAccount.transferTo(transferAccount, amount);
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
                        else if(checkOrSavings.equalsIgnoreCase("savings") && userAccount instanceof SavingsAccount){
                            System.out.println("Would you like to: Check balance, deposit, withdraw, transfer, compound interest or log out?: ");
                            String checkSelect = sc.nextLine();
                            if(checkSelect.equalsIgnoreCase("check balance")){
                                System.out.println(userAccount.checkBal());
                            }
                            else if(checkSelect.equalsIgnoreCase("deposit")){
                                System.out.println("Deposit amount: ");
                                Double depositAmount = sc.nextDouble();
                                empty = sc.nextLine();
                                userAccount.deposit(depositAmount);
                                System.out.println("Deposited: " + depositAmount);
                            }
                            else if(checkSelect.equalsIgnoreCase("withdraw")){
                                System.out.println("Withdraw amount: ");
                                Double withDrawamount = sc.nextDouble();
                                empty = sc.nextLine();
                                userAccount.deposit(withDrawamount);
                                System.out.println("Withdrew: " + withDrawamount);
                            }
                            else if(checkSelect.equalsIgnoreCase("transfer")){
                                System.out.println("Enter password of account to transfer to: ");
                                String transferPass = sc.nextLine();
                                BankAccountInterface transferAccount = teller.getAccount(transferPass);
                                System.out.println("Amount to transfer: ");
                                Double amount = sc.nextDouble();
                                empty = sc.nextLine();
                                userAccount.transferTo(transferAccount, amount);
                                System.out.println("Transfered: " + amount);
                            }
                            else if(checkSelect.equalsIgnoreCase("log out")){
                                System.out.println("Thanks for using the ATM!");
                                atmQuit = "back";
                            }
                            else if(checkSelect.equalsIgnoreCase("compound interest")){
                                System.out.println("Compounded!");
                                SavingsAccount savingsUser = (SavingsAccount) userAccount;
                                savingsUser.compound();
                            }
                            else{
                                System.out.println("Incorrect input");
                            }
                        }
                        else if(checkOrSavings.equalsIgnoreCase("log out")){
                            atmQuit = "back";
                        }
                        else{
                            System.out.println("Incorrect input");
                        }
                    }
                }
            }
            else if(softwareSelection.equalsIgnoreCase("administration")){
                System.out.println("Enter admin password (its 'admin')");
                String adminPW = sc.nextLine();
                if(adminPW.equalsIgnoreCase("admin")){
                    String adminQuit = "";
                    while(!adminQuit.equalsIgnoreCase("back")){
                        System.out.println("Do you want to: overall money, get report, freeze, unfreeze, or log out: ");
                        adminQuit = sc.nextLine();
                        if(adminQuit.equalsIgnoreCase("overall money")){
                            System.out.println("Sum: " + admin.getOverallMoney(teller.accounts));
                        }
                        else if(adminQuit.equalsIgnoreCase("get report")){
                            System.out.println("Enter accountID of suspicious account: ");
                            String accountID = sc.nextLine();
                            BankAccountInterface susAccount = teller.getAccount(accountID);
                            System.out.println(admin.requestReport(susAccount));
                        }
                        else if(adminQuit.equalsIgnoreCase("freeze")){
                            System.out.println("Enter accountID of acount you want to freeze: ");
                            String accountID = sc.nextLine();
                            BankAccountInterface susAccount = teller.getAccount(accountID);
                            admin.freeze(susAccount);
                            System.out.println(accountID + "is now frozen.");
                        }
                        else if(adminQuit.equalsIgnoreCase("unfreeze")){
                            System.out.println("Enter accountID of acount you want to unfreeze: ");
                            String accountID = sc.nextLine();
                            BankAccountInterface susAccount = teller.getAccount(accountID);
                            admin.freeze(susAccount);
                            System.out.println(accountID + "is now unfrozen.");
                        }
                        else if(adminQuit.equalsIgnoreCase("log out")){
                            adminQuit = "back";
                        }
                        else{
                            System.out.println("Incorrect input");
                        }
                    }
                }
                else{
                    System.out.println("Incorrect password");
                }
            }
            else if(softwareSelection.equalsIgnoreCase("teller")){
                System.out.println("Enter teller password (its 'teller').");
                String tellerPW = sc.nextLine();
                if(tellerPW.equalsIgnoreCase("teller")){
                    String tellerQuit = "";
                    while(!tellerQuit.equalsIgnoreCase("back")){
                        System.out.println("Do you want to: create account, close account, or log out");
                        tellerQuit = sc.nextLine();
                        if(tellerQuit.equalsIgnoreCase("create account")){
                            System.out.println("Is it a checking or savings account: ");
                            String accountType = sc.nextLine();
                            if(accountType.equalsIgnoreCase("checking")){
                                System.out.println("Enter new UNIQUE accountID: ");
                                String accountID = sc.nextLine();
                                System.out.println("Enter starting starting balance: ");
                                Double startingBalance = sc.nextDouble();
                                empty = sc.nextLine();
                                teller.createAccount(accountID, accountType, startingBalance, 0, 0);
                            }
                            else if(accountType.equalsIgnoreCase("savings")){
                                System.out.println("Enter new UNIQUE accountID: ");
                                String accountID = sc.nextLine();
                                System.out.println("Enter starting starting balance: ");
                                Double startingBalance = sc.nextDouble();
                                empty = sc.nextLine();
                                System.out.println("Enter interest rate: ");
                                Double interest = sc.nextDouble();
                                empty = sc.nextLine();
                                System.out.println("Enter max withdraw amount: ");
                                Double maxWithdraw = sc.nextDouble();
                                empty = sc.nextLine();
                                teller.createAccount(accountID, accountType, startingBalance, interest, maxWithdraw);
                            }
                        }   
                        else if(tellerQuit.equalsIgnoreCase("close account")){
                            System.out.println("Enter accountID for the account you want to close: ");
                            String accountID = sc.nextLine();
                            teller.closeAccount(accountID);
                            System.out.println("Account closed.");
                        }
                        else if(tellerQuit.equalsIgnoreCase("log out")){
                            tellerQuit = "back";
                        }
                        else{
                            System.out.println("Wrong input.");
                        }
                    }
                }
                else{
                    System.out.println("Wrong password.");
                }
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
