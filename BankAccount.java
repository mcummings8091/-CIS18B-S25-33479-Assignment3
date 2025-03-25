public class BankAccount {
    private String accountHolderName;
    private int accountNumber; // Needs RNG implementation
    private double balance;
    private boolean isActive;

    public BankAccount() {
        accountHolderName = "";
        accountNumber = 0;
        balance = 0.0;
        accountSta
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

    public void deposit(double amount) throws NegativeDepositException {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new NegativeDepositException("Deposit amount must be greater than 0");
        }

        System.out.println("Deposit successful! New balance: $" + getAccountBalance()); 
    }

    public void withdraw(double amount) throws OverdrawException {
        if (balance > amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully! New balance: $" + getAccountBalance());
        } else if (amount > balance) {
            throw new OverdrawException("Current withdrawl attempt will overdraw the account.");  
        } else if (amount < 0) {
            System.out.println("Withdrwal amount must be greater than 0");
        } else {
            System.out.println("Insufficient funds!");
        } 
    }

    public void displayBalance() {
        System.out.println("Current balance: $" + getAccountBalance());
    }
}