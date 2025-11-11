package designPatterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FlipKart {

    private static FlipKart instance = null;
    private List<OrderPlacedSubscriber> orderPlacedSubscribers = new ArrayList<>();
    private List<OrderCancelledSubscriber> orderCancelledSubscribers = new ArrayList<>();
    public static final Lock lock = new ReentrantLock();

    private FlipKart() {

    }

    public static FlipKart getInstance() {
        if (instance == null) {
            lock.lock();
            if (instance == null) {
                instance = new FlipKart();
            }
            lock.unlock();
            
        }
        return instance;
    }

    public void subscribeOrderPlaced(OrderPlacedSubscriber subscriber) {
        orderPlacedSubscribers.add(subscriber);
    }
    public void subscribeOrderCancelled(OrderCancelledSubscriber subscriber) {
        orderCancelledSubscribers.add(subscriber);
    }

    public void orderPlaced(String orderId) {
        for (OrderPlacedSubscriber subscriber : orderPlacedSubscribers) {
            subscriber.onOrderPlaced(orderId);
        }
    }   
    public void orderCancelled(String orderId) {
        for (OrderCancelledSubscriber subscriber : orderCancelledSubscribers) {
            subscriber.onOrderCancelled(orderId);
        }
    }
    
}
