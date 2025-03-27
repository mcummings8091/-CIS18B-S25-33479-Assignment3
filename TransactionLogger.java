import java.util.ArrayList;

class TransactionLogger {
    private ArrayList<BankAccount> monitoredAccounts;

    public void addAccount(BankAccount account)  {
        monitoredAccounts.add(account);
    }

    public void removeAccount(BankAccount account) {
        monitoredAccounts.remove(account);
    }

    public void noitifyAccount(ArrayList<BankAccount> monitoredAccounts) {
        
    }
}