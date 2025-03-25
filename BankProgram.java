import java.util.InputMismatchException;
import java.util.Scanner;

public class BankProgram {

    public static boolean isValidInput(int min, int max, int input) { // Method for simple input validation
        if (input >= min && input <= max) { // If input is withing range of min & max, inclusive
            return true;
        } else {
            return false;
        }
    }

    public static int displayMenu(boolean accountCreated) { // Method to handle repeated menu display to user
        Scanner input = new Scanner(System.in);
        int choice = 0;

        do { 
            if (!accountCreated) { // If the user hasn't created an account display full menu
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            } else {
                System.out.println("\n1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
            }
            System.out.print("\nEnter your choice: ");
            
            try {
                if (accountCreated) {
                choice = input.nextInt() + 1; // Adjustment to input value to account for lack of original option1 "create account"
                } else {
                    choice = input.nextInt();
                }
            } catch (InputMismatchException e) { // Handling for non numeric values
                System.out.println("Invalid Input... Please try again.");
                input.nextLine();
            }

            if (!isValidInput(1, 5, choice)) { // Invalid input message
                System.out.println("Invalid Input... Please try again.");
            } 
        } while (!isValidInput(1, 5, choice));

        return choice;
    }

    public static void main(String[] args) {
        boolean accountCreated = false; // variable to determine if an account has been created. 
        int userChoice; // Variable for managing user choice
        BankAccount userAccount = new BankAccount(); // Blank BankAccount instance to be filled when user uses "1.) Create Account"

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Simple Bank System!");

        do { 
            
            userChoice = displayMenu(accountCreated);

            switch (userChoice) {
                case 1: //  Create Account

                    // try-catch for handling for non numeric values
                    try {

                        System.out.print("Enter account holder name: ");
                        userAccount.setAccountName(input.nextLine());

                        System.out.print("Enter initial deposit: ");
                        userAccount.setAccountBalance(input.nextDouble());

                    } catch (InputMismatchException e) { 
                        System.out.println("Invalid Input... Please try again.");
                        input.nextLine();
                    }

                    System.out.println("\nAccount created successfully!");

                    accountCreated = true;
                    break;

                case 2: // Deposit Money

                    // Prevent user from option before account creation
                    if (!accountCreated){
                        System.out.println("\nPlease create an account first!\n");
                        break;
                    }

                    try {
                        System.out.print("Enter amount to deposit: ");
                        userAccount.deposit(input.nextDouble());
                    } catch (InputMismatchException e) { // Handling for non numeric values
                        System.out.println("Invalid Input... Please try again.");
                        input.nextLine();
                    }

                    break;

                case 3: // Withdraw

                    // Prevent user from option before account creation
                    if (!accountCreated){
                        System.out.println("\nPlease create an account first!\n");
                        break;
                    }

                    try {
                        System.out.print("Enter amount to withdraw: ");
                        userAccount.withdraw(input.nextDouble());
                    } catch (InputMismatchException e) { // Handling for non numeric values
                        System.out.println("Invalid Input... Please try again.");
                        input.nextLine();
                    }         
                    
                    break;

                case 4: // Check Balance

                    // Prevent user from option before account creation
                    if (!accountCreated){
                        System.out.println("\nPlease create an account first!\n");
                        break;
                    }
                    userAccount.displayBalance();
                    
                    break;

                case 5: // Exit

                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option... Please try again");
            }
        } while (userChoice != 5);
        
        System.out.println("Thank you for using Simple Bank System!");



    }
}