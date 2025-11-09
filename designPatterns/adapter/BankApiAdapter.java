package designPatterns.adapter;

public interface BankApiAdapter {

    void transferMoney(String fromAccount, String toAccount, double amount);
    double checkBalance(String accountNumber);
    
}
