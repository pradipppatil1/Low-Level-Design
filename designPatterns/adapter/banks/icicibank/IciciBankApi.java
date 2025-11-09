package designPatterns.adapter.banks.icicibank;

public class IciciBankApi {
    
    public void iciciTransfer(String fromAccount, String toAccount, double amount) {
        // Logic to transfer money using ICICI Bank's API
        System.out.println("Transferring " + amount + " from " + fromAccount + " to " + toAccount + " using ICICI Bank API.");
    }

    public double iciciCheckBalance(String accountNumber) {
        // Logic to check balance using ICICI Bank's API
        System.out.println("Checking balance for account " + accountNumber + " using ICICI Bank API.");
        return 10000.0; // Dummy balance
    }
    
}
