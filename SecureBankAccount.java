public class SecureBankAccount extends BankAccountDecorator {

    public SecureBankAccount(BankAccount account) {
        super(account);
    }
    
    
}