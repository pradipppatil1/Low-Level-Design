package tictactoe.stratergies.gameWinningStratergies;

import tictactoe.models.Board;
import tictactoe.models.Cell;
import tictactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStratergy implements GameWinningStratergies {

    private List<HashMap<Character, Integer>> rowPlayerCount =  new ArrayList<HashMap<Character, Integer>>();
    private List<HashMap<Character, Integer>> columnPlayerCount =  new ArrayList<HashMap<Character, Integer>>();
    private HashMap<Character, Integer> rightDiagonalPlayerCount =  new HashMap<Character, Integer>();
    private HashMap<Character, Integer> leftDiagonalPlayerCount =  new HashMap<Character, Integer>();

    // Initialize Hashmap inside arraylist as per size of board
    public OrderOneGameWinningStratergy(int size) {
        for(int i = 0; i < size; i++){
            rowPlayerCount.add(new HashMap<>());
            columnPlayerCount.add(new HashMap<>());
        }
    }
    // Helper methods to check right and left diagonal cell

    public boolean isLeftTopDiagonal(int row, int column){
        return row == column;
    }

    public boolean isRightTopDiagonal(int row, int column, int size){
        return row + column == size - 1;
    }

    @Override
    public boolean checkWinner(Board board, Player player, Cell movedCell) {
        // firslty get Player symbol, rows, column from Cell and size fom board
        char symbol = movedCell.getPlayer().getSymbol();
        int row = movedCell.getRow();
        int column = movedCell.getCol();
        int size = board.getSize();

        // Now based on move made update values for symbol in List of HashMap for rows
        if(!rowPlayerCount.get(row).containsKey(symbol)){
            rowPlayerCount.get(row).put(symbol, 0);
        }
        rowPlayerCount.get(row).put(symbol, rowPlayerCount.get(row).get(symbol) + 1);

        // Now based on move made update values for symbol in List of HashMap for column
        if(!columnPlayerCount.get(column).containsKey(symbol)){
            columnPlayerCount.get(column).put(symbol, 0);
        }
        columnPlayerCount.get(column).put(symbol, columnPlayerCount.get(column).get(symbol) + 1);

        // update leftdiagonal based on move, use helper methods
        if(isLeftTopDiagonal(row, column)){
            if(!leftDiagonalPlayerCount.containsKey(symbol)){
                leftDiagonalPlayerCount.put(symbol, 0);
            }
            leftDiagonalPlayerCount.put(symbol, leftDiagonalPlayerCount.get(symbol) + 1);
        }

        // update rightdiagonal based on move, use helper methods
        if(isRightTopDiagonal(row, column, size)){
            if(!rightDiagonalPlayerCount.containsKey(symbol)){
                rightDiagonalPlayerCount.put(symbol, 0);
            }
            rightDiagonalPlayerCount.put(symbol, rightDiagonalPlayerCount.get(symbol) + 1);
        }

        // Lets check if Player win or not
        if(rowPlayerCount.get(row).get(symbol) == size ||
                columnPlayerCount.get(column).get(symbol) == size ){
            return true;
        }

        // check diagonals
        if(isRightTopDiagonal(row, column, size) &&
            rightDiagonalPlayerCount.get(symbol) == size ){ return true; }

        if(isLeftTopDiagonal(row, column) &&
                leftDiagonalPlayerCount.get(symbol) == size ){ return true; }

        return false;
    }
}
