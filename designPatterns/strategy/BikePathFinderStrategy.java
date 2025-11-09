package designPatterns.strategy;

public class BikePathFinderStrategy implements PathFinderStrategy {

    @Override
    public void findPath(String startPoint, String endPoint) {
        System.out.println("Finding path for Bike from " + startPoint + " to " + endPoint);
    }
    
}
