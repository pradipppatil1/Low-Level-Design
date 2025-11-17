public class Move {
    private Player player;
    private Cell cell;

    /*
     * Constructor- whenever someone makes a move, create an object of Move class
     * it is mandatory to have player and cell information to create a move
     */
    public Move(Player player, Cell cell){
        this.player = player;
        this.cell = cell;
    }

    // getters
    public Player getPlayer() {
        return this.player;
    }
    public Cell getCell() {
        return this.cell;
    }
}
