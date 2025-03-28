//Concrete observer
public class TransactionObserver implements Observer {
    private String transactionLog;

    public void displayTransaction() {
        System.out.println("Transaction: " + transactionLog);
    }

    @Override
    public void update(String transactionInfo) {
        transactionLog = transactionInfo;
        displayTransaction();
    }
}