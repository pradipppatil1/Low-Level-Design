public class Player {
    private String name;
    private char symbol;
    private PlayerType type;

    public Player(String name, char symbol, PlayerType type) {
        this.name = name;
        this.symbol = symbol;
        this.type = type;
    }
    
    // Getters and Setters
    public String getName() {
        return name;    
    }
    public char getSymbol() {
        return symbol;
    }
    public PlayerType getType() {
        return type;
    }
}
