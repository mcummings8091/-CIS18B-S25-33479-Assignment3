import java.util.ArrayList;

//Concrete subject
class TransactionLogger implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private String transactionLog;


    public void setTransactionLog(String transactionInfo) {
        transactionLog = transactionInfo;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer)  {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(transactionLog);
        }
    }

}