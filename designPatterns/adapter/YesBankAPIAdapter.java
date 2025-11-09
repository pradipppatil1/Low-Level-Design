package designPatterns.adapter;

import designPatterns.adapter.banks.yesbank.YesBankApi;

public class YesBankAPIAdapter implements BankApiAdapter {

    private YesBankApi yesBankApi;

    public YesBankAPIAdapter() {
        this.yesBankApi = new YesBankApi();
    }

    @Override
    public void transferMoney(String fromAccount, String toAccount, double amount) {
        yesBankApi.sendFunds(fromAccount, toAccount, amount);
    }

    @Override
    public double checkBalance(String accountNumber) {
        double balance = yesBankApi.getAccountBalance(accountNumber);
        System.out.println("Balance for account " + accountNumber + " is: " + balance);
        return balance;

    }   

    
    
    
}
