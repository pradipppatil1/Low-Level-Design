package designPatterns.observer;

public interface OrderCancelledSubscriber {
    void onOrderCancelled(String orderId);
}
