package designPatterns.observer;

public class Client {
    public static void main(String[] args) {
        FlipKart flipKart = FlipKart.getInstance();

        // Creating subscribers
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        EmailSend emailSend = new EmailSend();

        // Simulating order events
        flipKart.orderPlaced("ORDER1234");
        flipKart.orderCancelled("ORDER456");
    }
    
}
