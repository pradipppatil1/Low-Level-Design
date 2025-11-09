package designPatterns.adapter;

import designPatterns.adapter.banks.icicibank.IciciBankApi;

public class IciciBankAPIAdapter implements BankApiAdapter {
    
    private IciciBankApi iciciBankApi;

    public IciciBankAPIAdapter() {
        this.iciciBankApi = new IciciBankApi();
    }

    @Override
    public void transferMoney(String fromAccount, String toAccount, double amount) {
        iciciBankApi.iciciTransfer(fromAccount, toAccount, amount);
    }

    @Override
    public double checkBalance(String accountNumber) {
        double balance = iciciBankApi.iciciCheckBalance(accountNumber);
        System.out.println("Balance for account " + accountNumber + " is: " + balance);
        return balance;
    }

    
}
