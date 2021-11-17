public class Cell {
    //Attributs
    private int row;
    private int col;
    private Boolean mine;
    private Boolean visible;
    private int nbTouchingMine;
    //Constructeur
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.visible = false;
        this.mine = false;
        this.nbTouchingMine = 0;
    }
    //Setters & Getters

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Boolean isMine() {
        return mine;
    }

    public void setMine(Boolean mine) {
        this.mine = mine;
    }

    public Boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public void setNbTouchingMine(int nbTouchineMine) {
        this.nbTouchingMine = nbTouchineMine;
    }
    public void NbTouchingMineplus() {
        if(!this.isMine()){
            this.nbTouchingMine++;
        }
    }
    public int getNbTouchingMine() {
        return nbTouchingMine;
    }
    //Methodes
}
