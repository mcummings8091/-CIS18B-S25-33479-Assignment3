public class BankAccount {
    private String accountHolderName;
    private int accountNumber; // Needs RNG implementation
    private double balance;

    public BankAccount() {
        accountHolderName = "";
        accountNumber = 0;
        balance = 0.0;
    }

    public BankAccount(String holderName, double initialDeposit) {
        accountHolderName = holderName;
        balance = initialDeposit;
    }


    public void setAccountName(String holderName) {
        accountHolderName = holderName;
    }

    public void setAccountBalance(double amount) {
        balance = amount;
    }

    public String getAccountName() {
        return accountHolderName;
    }

    public double getAccountBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be greater than 0");
        }

        System.out.println("Deposit successful! New balance: $" + getAccountBalance()); 
    }

    public void withdraw(double amount) {
        if (balance > amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully! New balance: $" + getAccountBalance());
        } else if (amount < 0) {
            System.out.println("Deposit amount must be greater than 0");
        } else {
            System.out.println("Insufficient funds!");
        } 
    }

    public void displayBalance() {
        System.out.println("Current balance: $" + getAccountBalance());
    }
}