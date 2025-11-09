package designPatterns.strategy;

public class WalkPathFinderStrategy implements PathFinderStrategy {

    @Override
    public void findPath(String startPoint, String endPoint) {
        System.out.println("Finding path for Walk from " + startPoint + " to " + endPoint);
    }
    
}
