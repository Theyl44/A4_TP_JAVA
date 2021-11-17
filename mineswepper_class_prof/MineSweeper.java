import java.util.LinkedList;

public class MineSweeper {

    // debug flags
    private boolean showMines = false;
    private boolean showNbTouchingMines = false;

    // grid properties
    private int nbRows;
    private int nbCols;
    private Cell[][] grid;


    // returns the String representation of a Cell, depending on its attributes and the debug flags
    public String getCellSymbol(Cell cell){

        String symbol = "#";        // default symbol = hidden cell

        // shows the mine in the cell if the cell is visible or if the showMines flag is on
        if((cell.isVisible() || this.showMines) && cell.isMine()){
            symbol = "*";
        }
        // shows the number of touching mines if the cell is visible or if the showNbTouchingMines flag is on
        else if( cell.isVisible() || this.showNbTouchingMines ){

            // special case of a visible cell : " " is displayed instead of "0"
            if( cell.isVisible() && cell.getNbTouchingMines() == 0){
                symbol = " ";
            }
            else{
                symbol = Integer.toString(cell.getNbTouchingMines());
            }

        }

        return symbol;
    }

    // prints the game grid
    public void print(){

        int firstColumnWidth = (int)Math.ceil(Math.log10(this.nbRows));     // first column width = number of digits in nbRows
        int otherColumnsWidth = (int)Math.ceil(Math.log10(this.nbCols));    // other columns width = number of digits in nbCols

        // first line = column numbers
        System.out.printf("%" + firstColumnWidth + "s ", "");
        for(int j = 0; j < this.nbCols; j++){
            System.out.printf("%" + otherColumnsWidth + "s ", j);
        }
        System.out.println();

        for(int i = 0; i < this.nbRows; i++){

            // first column = row numbers
            System.out.printf("%" + firstColumnWidth + "s ", i);
            for(int j= 0; j < this.nbCols; j++){

                Cell cell = this.grid[i][j];
                String cellSymbol = getCellSymbol(cell);
                System.out.printf("%" + otherColumnsWidth + "s ", cellSymbol);
            }
            System.out.println();
        }
    }

    // returns the neighbors of a Cell at the specified row and col in the grid
    public LinkedList<Cell> getNeighbors(Cell cell){

        LinkedList<Cell> neighbors = new LinkedList<>();
        int row = cell.getRow();
        int col = cell.getCol();

        if(row - 1 >= 0){
            neighbors.add( this.grid[row - 1][col] );

            if(col + 1 < this.nbCols){
                neighbors.add( this.grid[row - 1][col + 1] );
            }

            if(col - 1 >= 0){
                neighbors.add( this.grid[row - 1][col - 1] );
            }
        }

        if(col + 1 < this.nbCols){
            neighbors.add(  this.grid[row][col + 1] );
        }

        if(col - 1 >= 0){
            neighbors.add(  this.grid[row][col - 1] );
        }

        if(row + 1 < this.nbRows){
            neighbors.add( this.grid[row + 1][col] );

            if(col + 1 < this.nbCols){
                neighbors.add(  this.grid[row + 1][col + 1] );
            }

            if(col - 1 >= 0){
                neighbors.add( this.grid[row + 1][col - 1] );
            }
        }

        return neighbors;
    }

}
