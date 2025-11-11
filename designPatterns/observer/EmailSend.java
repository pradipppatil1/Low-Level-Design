package designPatterns.observer;

public class EmailSend implements OrderPlacedSubscriber {

    public EmailSend() {
        FlipKart flipKart = FlipKart.getInstance();
        flipKart.subscribeOrderPlaced(this);
    }

    @Override
    public void onOrderPlaced(String orderId) {
        System.out.println("Sending email for order: " + orderId);
    }

    
    
}
