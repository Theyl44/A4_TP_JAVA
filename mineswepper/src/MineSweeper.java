import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    //Attributs
    private int nbRows;
    private int nbCols;
    private Cell[][] grid;
    private Boolean end_game;

    //Constructeur
    public MineSweeper(int nbRows, int nbCols){
        this.end_game = false;
        this.setNbCols(nbCols);
        this.setNbRows(nbRows);
        this.grid = new Cell[nbRows][nbCols];
        for(int i = 0 ; i < nbRows ; i++){
            for(int j = 0 ; j < nbCols ; j++)
                this.grid[i][j] = new Cell(i,j);
        }
    }
    public MineSweeper(int nbRows, int nbCols,int nbMines){
        //TODO check : si ya pas plus de bombe que de place
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
                            System.out.print("° ");
                        }else{
                            if(this.grid[i][j].getNbTouchingMine()== 0){
                                System.out.print("  ");
                            }else{
                                System.out.print(this.grid[i][j].getNbTouchingMine()+" ");
                            }
                        }
                    } else {
                        System.out.print("# ");
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
    public void unveil(int row, int col){
        this.grid[row][col].setVisible(true);
    }
    Boolean check_if_bombe(int x,int y){
        return this.grid[x][y].isMine();
    }
    Boolean check_if_over(int x, int y){
        if(this.grid[x][y].isMine()){                       //si ce qu'on joue est une bombe
            System.out.println("BOOOOOOOOOOM");
            return true;
        }
        for(int i = 0 ; i < this.nbRows ; i++){
            for(int j = 0 ; j < this.nbCols ; j++){
                if(!this.grid[i][j].isVisible()){           //si c'est pas visible
                    if(!this.grid[i][j].isMine()){          //si c'est pas visible et pas une bombe
                        return false;
                    }
                }
            }
        }
        System.out.println("VICTOIRE");
        return true;
    }
    int[] player_input(){
        int[] coo = new int[2];
        boolean check = false;

        while(!check){
            try{
                Scanner s = new Scanner(System.in);
                coo[0] = s.nextInt();
                coo[1] = s.nextInt();
                check = true;
            }catch (Exception e){
                System.out.println("mauvaise utilisation du prgm");
            }
        }
        return coo;
    }
    public void play(){
        int nb_tour = 0 ;
        this.end_game = false;
        this.print();
        while(!end_game){
            System.out.println("ROUND "+nb_tour+"--------");
            nb_tour++;

            int[] coo = player_input();
            this.unveil(coo[0],coo[1]);

            //TODO fac : faire qqlc pour rendre d'autre case visible d'un coup
            this.end_game = check_if_over(coo[0],coo[1]);   //verifie si la partie est fini
            this.print();

            if(this.end_game){
                System.out.println("La partie est finie");
                System.out.println("Encore une partie ? (0 : oui | 1 : non)");
                Scanner s = new Scanner(System.in);
                if(s.nextInt() == 0){
                    this.play();
                    //TODO rejouer : reset bord
                    //TODO rejouer : demande le nombre de bombe
                }
            }
        }
    }
}
