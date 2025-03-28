public class TransactionObserver implements Observer {
    private String transactionLog;

    @Override
    public void update(String transactionInfo) {
        transactionLog = transactionInfo;
        System.out.println("Transaction: " + transactionInfo);
    }
}