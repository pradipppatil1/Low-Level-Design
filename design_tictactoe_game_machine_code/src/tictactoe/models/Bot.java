public class Bot extends Player {
    private GameDiffculty difficulty;

    public Bot(String name, char symbol, GameDiffculty difficulty) {
        super(name, symbol, PlayerType.BOT);
        this.difficulty = difficulty;
    }
    
}
