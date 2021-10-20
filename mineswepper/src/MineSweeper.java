import java.util.Random;

public class MineSweeper {
    //Attributs
    private int nbRows;
    private int nbCols;
    private Cell[][] grid;

    //Constructeur
    public MineSweeper(int nbRows, int nbCols){
        this.setNbCols(nbCols);
        this.setNbRows(nbRows);
        this.grid = new Cell[nbRows][nbCols];
        for(int i = 0 ; i < nbRows ; i++){
            for(int j = 0 ; j < nbCols ; j++)
                this.grid[i][j] = new Cell(i,j);
        }
    }
    public MineSweeper(int nbRows, int nbCols,int nbMines){
        this(nbRows,nbCols);
        this.putMines(nbMines);
    }
    //Setters & Getters

    public void setNbCols(int nbCols) {
        this.nbCols = nbCols;
    }

    public void setNbRows(int nbRows) {
        this.nbRows = nbRows;
    }

    public int getNbRows() {
        return nbRows;
    }

    public int getNbCols() {
        return nbCols;
    }
    //Methodes
    public void print(){

        for(int i = -1; i < this.nbRows ; i++){
            for(int j = -1 ; j < this.nbCols ; j++){
                if(i == -1 && j == -1){
                    System.out.print("  ");
                }
                else if(i == -1){
                    System.out.print(j+" ");
                }
                else if(j == -1){
                    System.out.print(i+" ");
                }
                else{
                    if(this.grid[i][j].isVisible()){
                        if(this.grid[i][j].isMine()){
                            System.out.print("° ");             //TODO BOOM
                        }else{
                            System.out.print(this.grid[i][j].getNbTouchingMine()+" ");
                        }
                    } else {
                        if(this.grid[i][j].isMine()){
                            System.out.print("* ");
                        }else{
                            System.out.print("# ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }
    void updateNeighboor(int row, int col){ //on ++ tous les voisins
        if(row == 0 ){
            if(col == 0){                   //up left
                this.grid[row][col+1].NbTouchingMineplus();
                this.grid[row+1][col].NbTouchingMineplus();
                this.grid[row+1][col+1].NbTouchingMineplus();
            }
            else if(col == nbCols-1){       //up right
                this.grid[row][col-1].NbTouchingMineplus();
                this.grid[row+1][col-1].NbTouchingMineplus();
                this.grid[row+1][col].NbTouchingMineplus();
            }else{                          //up line but not corners
                this.grid[row][col-1].NbTouchingMineplus();
                this.grid[row][col+1].NbTouchingMineplus();
                this.grid[row+1][col].NbTouchingMineplus();
                this.grid[row+1][col+1].NbTouchingMineplus();
                this.grid[row+1][col-1].NbTouchingMineplus();
            }
        }
        else if(row == nbRows-1){
            if(col == 0){                   //down left
                this.grid[row-1][col].NbTouchingMineplus();
                this.grid[row-1][col+1].NbTouchingMineplus();
                this.grid[row][col+1].NbTouchingMineplus();
            }
            else if(col == nbCols-1){       //down right
                this.grid[row-1][col].NbTouchingMineplus();
                this.grid[row-1][col-1].NbTouchingMineplus();
                this.grid[row][col-1].NbTouchingMineplus();
            }else{                          //down line but not corners
                this.grid[row][col-1].NbTouchingMineplus();
                this.grid[row][col+1].NbTouchingMineplus();
                this.grid[row-1][col].NbTouchingMineplus();
                this.grid[row-1][col+1].NbTouchingMineplus();
                this.grid[row-1][col-1].NbTouchingMineplus();
            }
        }else{                              //middle
            if(col == 0){                   //middle left
                this.grid[row+1][col].NbTouchingMineplus();
                this.grid[row-1][col].NbTouchingMineplus();
                this.grid[row+1][col+1].NbTouchingMineplus();
                this.grid[row-1][col+1].NbTouchingMineplus();
                this.grid[row][col+1].NbTouchingMineplus();
            }
            else if(col == nbCols-1){       //middle right
                this.grid[row+1][col].NbTouchingMineplus();
                this.grid[row-1][col].NbTouchingMineplus();
                this.grid[row][col-1].NbTouchingMineplus();
                this.grid[row+1][col-1].NbTouchingMineplus();
                this.grid[row-1][col-1].NbTouchingMineplus();
            }else{                          //middle middle
                this.grid[row][col+1].NbTouchingMineplus();
                this.grid[row][col-1].NbTouchingMineplus();
                this.grid[row+1][col].NbTouchingMineplus();
                this.grid[row+1][col+1].NbTouchingMineplus();
                this.grid[row+1][col-1].NbTouchingMineplus();
                this.grid[row-1][col].NbTouchingMineplus();
                this.grid[row-1][col+1].NbTouchingMineplus();
                this.grid[row-1][col-1].NbTouchingMineplus();
            }
        }
    }
    public void putMines(int nbMines){
        for(int i = 0 ; i < nbMines ; i++){
            Random random = new Random();
            int row = random.nextInt(nbRows); // ligne aléatoire entre 0 et nbRows
            int col = random.nextInt(nbCols); // colonne aléatoire entre 0 et nbCols
            if(!this.grid[row][col].isMine()){
                this.grid[row][col].setMine(true);
                updateNeighboor(row,col);
            }else{
                i--;
            }
        }
    }
}
