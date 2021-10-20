public class Point implements Movable{
    //attributs de coordonnées
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public String toString(){
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public void moveTo(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
}
