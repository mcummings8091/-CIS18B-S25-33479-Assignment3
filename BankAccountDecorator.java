abstract class BankAccountDecorator extends BankAccount {
    protected BankAccount decoratedAccount;

    public BankAccountDecorator(BankAccount account) {
        super(account.getAccountName(), account.getAccountBalance());
        this.decoratedAccount = account;
    }
}