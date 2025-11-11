package designPatterns.observer;

public interface OrderPlacedSubscriber {
    void onOrderPlaced(String orderId);
}
