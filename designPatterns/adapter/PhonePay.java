package designPatterns.adapter;

public class PhonePay {

    private BankApiAdapter bankApiAdapter;

    public PhonePay(BankApiAdapter bankApiAdapter) {
        this.bankApiAdapter = bankApiAdapter;
    }

    public void sendMoney(String fromAccount, String toAccount, double amount) {
        bankApiAdapter.transferMoney(fromAccount, toAccount, amount);
    }

    public double getBalance(String accountNumber) {
        return bankApiAdapter.checkBalance(accountNumber);
    }
    
}
