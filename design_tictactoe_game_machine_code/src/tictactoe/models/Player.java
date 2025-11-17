package tictactoe.models;

import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private PlayerType type;
    Scanner input;

    public Player(String name, char symbol, PlayerType type) {
        this.name = name;
        this.symbol = symbol;
        this.type = type;
        input = new Scanner(System.in);
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

    public Move decideMove(Board board) {
        System.out.println("Which row you want to move?");
        int row = input.nextInt();
        System.out.println("Which column you want to move?");
        int column = input.nextInt();

        if(!(row >= 0 && row <= board.getSize() -1 &&
                column >= 0 && column <= board.getSize() - 1 &&
                board.getCells().get(row).get(column).getState().equals(CellState.EMPTY))) {
            System.out.println("Enter right row you want to move?");
             row = input.nextInt();
            System.out.println("Enter right column you want to move?");
            column = input.nextInt();
        }
        Cell currentCell = board.getCells().get(row).get(column);
        return new Move(this, currentCell);

    }
}
