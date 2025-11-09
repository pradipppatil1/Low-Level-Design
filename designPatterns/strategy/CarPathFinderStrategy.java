package designPatterns.strategy;

public class CarPathFinderStrategy implements PathFinderStrategy {

    @Override
    public void findPath(String startPoint, String endPoint) {
        System.out.println("Finding path for Car from " + startPoint + " to " + endPoint);
    }
    
}
