
public class BankAccount {
    private String accountHolderName;
    private int accountNumber; // Needs RNG implementation
    private double balance;
    private boolean isActive;

    private TransactionLogger transactionLogger;


    public BankAccount() {
        accountHolderName = "";
        accountNumber = 0;
        balance = 0.0;

        //Create and add transaction observer
        transactionLogger = new TransactionLogger();
        Observer transactionObserver = new TransactionObserver();
        transactionLogger.addObserver(transactionObserver);
    }

    public BankAccount(String holderName, double initialDeposit) {
        accountHolderName = holderName;
        balance = initialDeposit;
        isActive = true;

        //Create and add transaction observer
        transactionLogger = new TransactionLogger();
        Observer transactionObserver = new TransactionObserver();
        transactionLogger.addObserver(transactionObserver);
    }


    //Getters & Setters
    public void setAccountName(String holderName) {
        accountHolderName = holderName;
    }

    public void setAccountBalance(double amount) throws NegativeDepositException {
        if(isActive) {
            if (amount > 0) {
                balance = amount;
                transactionLogger.setTransactionLog("Initial deposit: $" + getAccountBalance());
            } else {
                throw new NegativeDepositException("Initial deposit amount must be greater than 0");
            }
        }
    }

    public String getAccountName() {
        return accountHolderName;
    }

    public double getAccountBalance() {
        return balance;
    }

    public boolean getAccountStatus() {
        if (isActive) {
            return true;
        }
        return false;
    }

    // Procedures 
    public void deposit(double amount) throws NegativeDepositException, InvalidAccountOperationException {
        if (isActive) {
            if (amount > 0) {
                balance += amount;
                transactionLogger.setTransactionLog("Deposit: $" + amount);
            } else {
                throw new NegativeDepositException("Deposit amount must be greater than 0");
            }

            System.out.println("Deposit successful! New balance: $" + getAccountBalance()); 
        } else {
            throw new InvalidAccountOperationException("Account is closed!");
        }
    }

    public void withdraw(double amount) throws OverdrawException, InvalidAccountOperationException {
        if (isActive) {
             if (balance > amount) {
                balance -= amount;
                transactionLogger.setTransactionLog("Withdrawl: $" + amount);
                System.out.println(amount + " withdrawn successfully! New balance: $" + getAccountBalance());
            } else if (amount > balance) {
                throw new OverdrawException("Current withdrawl attempt will overdraw the account.");  
            } else if (amount < 0) {
                System.out.println("Withdrwal amount must be greater than 0");
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            throw new InvalidAccountOperationException("Account is closed!");
        }

    }

    public void displayBalance() throws InvalidAccountOperationException {
        if (isActive) {
            System.out.println("Current balance: $" + getAccountBalance());
        } else {
            throw new InvalidAccountOperationException("Account is closed!");
        }
    }

    public void closeAccount() {
        isActive = false; // Sets status to false preventing use of account functions. 
    }
    
    public void activateAccount() {
        isActive = true;
    }

}

