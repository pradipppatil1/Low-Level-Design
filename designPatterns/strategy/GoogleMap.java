package designPatterns.strategy;

public class GoogleMap {
    
    public void navigate(String startPoint, String endPoint, String mode) {
        PathFinderStrategy strategy = PathFinderFactory.getPathFinder(mode);
        strategy.findPath(startPoint, endPoint);
    }
}
