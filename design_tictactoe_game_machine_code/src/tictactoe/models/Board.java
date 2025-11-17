import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;

    private List<List<Cell>> cells;

    public Board(int size) {
        this.size = size;
        this.cells = initializeBoard(size); 
    }

    /*
     * Initializes the board with empty cells.
     * this.cells.add(new ArrayList<>()); this line will create
     * 3 empty arrays inside cells to represent 3 rows.
     * The inner loop will add 3 Cell objects to each row representing columns.
     * [[Cell(0,0), Cell(0,1), Cell(0,2)],
     *  [Cell(1,0), Cell(1,1), Cell(1,2)],
     *  [Cell(2,0), Cell(2,1), Cell(2,2)]]
     */

    private List<List<Cell>> initializeBoard(int size) {
        this.cells = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            cells.add(new ArrayList<>());
            for(int j = 0; j < size; j++) {
                cells.get(i).add(new Cell(i,j));
            }
        }

        return cells; // Placeholder
    }

     public int getSize() {
        return size;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }
    
}
