package designPatterns.strategy;

public class PathFinderFactory {

    public static PathFinderStrategy getPathFinder(String mode) {
        // if (mode.equalsIgnoreCase("Car")) {
        //     return new CarPathFinderStrategy();
        // } else if (mode.equalsIgnoreCase("Walk")) {
        //     return new WalkPathFinderStrategy();
        // } else if (mode.equalsIgnoreCase("Bike")) {
        //     return new BikePathFinderStrategy();
        // }
        // throw new IllegalArgumentException("Unknown path finder mode: " + mode);

        return switch (mode.toLowerCase()) {
            case "car" -> new CarPathFinderStrategy();
            case "walk" -> new WalkPathFinderStrategy();
            case "bike" -> new BikePathFinderStrategy();
            default -> throw new IllegalArgumentException("Unknown path finder mode: " + mode);
        };
    }
    
}
