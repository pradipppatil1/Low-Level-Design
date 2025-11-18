package tictactoe.models;

import tictactoe.factories.BotPlayingStratergyFactory;
import tictactoe.stratergies.botPlayingStratergies.BotPlayingStratergy;

public class Bot extends Player {
    private GameDiffculty difficulty;
    private BotPlayingStratergy playingStratergy;

    public Bot(String name, char symbol, GameDiffculty difficulty) {
        super(name, symbol, PlayerType.BOT);
        this.difficulty = difficulty;
        this.playingStratergy = BotPlayingStratergyFactory.getBotPlayingStratergy(difficulty);

    }

    public Move decideMove(Board board) {
        return this.playingStratergy.decideMove(this, board);
    }


    
}
