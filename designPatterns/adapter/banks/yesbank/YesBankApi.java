package designPatterns.adapter.banks.yesbank;

public class YesBankApi {
    
    public void sendFunds(String sourceAcc, String destAcc, double amt) {
        // Logic to send funds using Yes Bank's API
        System.out.println("YesBank: Sending " + amt + " from " + sourceAcc + " to " + destAcc);
    }

    public double getAccountBalance(String accNumber) {
        // Logic to get account balance using Yes Bank's API
        System.out.println("YesBank: Getting balance for account " + accNumber);
        return 5000.0; // Dummy balance
    }
    
}
