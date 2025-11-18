package tictactoe.factories;

import tictactoe.models.Cell;
import tictactoe.models.GameDiffculty;
import tictactoe.models.Player;
import tictactoe.stratergies.botPlayingStratergies.BotPlayingStratergy;
import tictactoe.stratergies.botPlayingStratergies.RandomBotPlayingStratergy;

public class BotPlayingStratergyFactory {
    public static BotPlayingStratergy getBotPlayingStratergy(GameDiffculty gameDiffculty)
    {
        if(gameDiffculty.equals(GameDiffculty.EASY))
        {
            return new RandomBotPlayingStratergy();
        }
        return null;
    }

}
