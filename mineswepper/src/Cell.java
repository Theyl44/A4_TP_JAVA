public class Cell {
    //Attributs
    private int row;
    private int col;
    private Boolean mine;
    private Boolean visible;
    private int nbTouchineMine;
    //Constructeur
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
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

    public void setNbTouchineMine(int nbTouchineMine) {
        this.nbTouchineMine = nbTouchineMine;
    }

    public int getNbTouchineMine() {
        return nbTouchineMine;
    }
    //Methodes
}
