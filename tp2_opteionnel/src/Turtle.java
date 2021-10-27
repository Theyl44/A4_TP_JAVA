public class Turtle extends Paint{
    //Attributs

    //Constructeur
    public Turtle(int width, int height) {
        super(width, height);
    }

    //Setters & Getters
    public int getHeadind(){
        return -1;
    }
    public Point getPosition(){
        return new Point(0,0);
    }
    //Methode
    public void penUp(){

    }
    public void penDown(){

    }
    public void forward(int distance){

    }
    public void backward(int distance){

    }
    public void moveTo(int x, int y){

    }
    public void right(int degrees){

    }
    public void left(int degrees){

    }
    public Boolean isDown(){
        return false;
    }
}
