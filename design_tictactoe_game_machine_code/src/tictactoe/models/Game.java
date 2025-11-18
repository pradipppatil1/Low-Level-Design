package tictactoe.models;

import tictactoe.factories.GameWinningStratergyFactory;
import tictactoe.stratergies.gameWinningStratergies.GameWinningStratergies;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private GameState gameState;
    private Player winner;
    private int currentPlayerIndex;
    private List<Move> moves;

    private GameWinningStratergies gameWinningStratergies;

    private Game()
    {

    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public static Builder startGame() {
        return new Builder();
    }

    public void     displayBoard() {
        this.board.display();
    }

    public void setGameWinningStratergies(GameWinningStratergies gameWinningStratergies) {
        this.gameWinningStratergies = gameWinningStratergies;
    }

    public void makeNextMove() {
        // first get player to make move
        Player currentPlayer = players.get(currentPlayerIndex);
        System.out.println("Player "+currentPlayer.getName()+" is playing");
        Move currentMove = currentPlayer.decideMove(board);
        // validate move logic added in player class decideMove method
        int row = currentMove.getCell().getRow();
        int col = currentMove.getCell().getCol();

        board.getCells().get(row).get(col).setState(CellState.FILLED);
        board.getCells().get(row).get(col).setPlayer(currentPlayer);

        moves.add(currentMove);
        // check winner
        if(this.gameWinningStratergies.checkWinner(board, currentPlayer,currentMove.getCell())) {
            gameState = GameState.ENDED;
            winner = currentPlayer;
        }
        currentPlayerIndex += 1;
        currentPlayerIndex %= players.size();
    }

    private boolean validateMove(Move currentMove) {
        return currentMove.getCell().getState().equals(CellState.EMPTY);

    }

    public static class Builder {
        private int size;
        private List<Player> players;

        private GameWinningStratergies gameWinningStratergies;

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        // use factory design pattern to set diffrent winning stratergies at runtime

        public Builder setGameWinningStratergies(String winningStratergies) {
            this.gameWinningStratergies = GameWinningStratergyFactory.getGameWinningStratergies(winningStratergies,size);
            return this;
        }

        public void validate() {
            if(this.size < 3) {
                throw new IllegalArgumentException("Board or board size is less than 3");
            }
            if(this.players == null || this.players.isEmpty() || this.players.size() != this.size - 1) {
                throw new IllegalArgumentException("Players are empty");
            }
        }

        public Game build() {
            //validation
            validate();
            Game game = new Game();
            game.setGameState(GameState.IN_PROGRESS);
            game.setMoves(new ArrayList<>());
            game.setCurrentPlayerIndex(0);
            game.setPlayers(players);
            game.setBoard(new Board(size));
            game.setGameWinningStratergies(gameWinningStratergies);
            return game;

        }
    }
    
}
