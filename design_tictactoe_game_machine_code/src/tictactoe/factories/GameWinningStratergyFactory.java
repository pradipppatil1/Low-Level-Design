package tictactoe.factories;

import tictactoe.stratergies.gameWinningStratergies.GameWinningStratergies;
import tictactoe.stratergies.gameWinningStratergies.OrderOneGameWinningStratergy;

public class GameWinningStratergyFactory {

    public static GameWinningStratergies getGameWinningStratergies(String winningStratergy, int size) {

        if(winningStratergy.equals("orderOne")){
            return new OrderOneGameWinningStratergy(size);
        }
        return null;
    }
}
