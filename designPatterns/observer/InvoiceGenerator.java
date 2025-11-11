package designPatterns.observer;

public class InvoiceGenerator implements OrderPlacedSubscriber, OrderCancelledSubscriber {


    public InvoiceGenerator() {
        FlipKart flipKart = FlipKart.getInstance();
        flipKart.subscribeOrderPlaced(this);
        flipKart.subscribeOrderCancelled(this);
    }

    @Override
    public void onOrderPlaced(String orderId) {
        System.out.println("Generating invoice for order: " + orderId);
    }

    @Override
    public void onOrderCancelled(String orderId) {
        System.out.println("Cancelling invoice for order: " + orderId);
    }
    
}
