public class Turtle extends Paint{
    //Attributs
    private Boolean pen; //true if down false if up
    private Point position;
    private int orientation;
    //Constructeur
    public Turtle(int width, int height) {
        super(width, height);
        this.orientation = 0;
        this.pen = true;
        this.position = new Point(width/2,height/2);
    }
    public Turtle(int width, int height,Boolean b,Point p,int orientation ) {
        super(width, height);
        this.orientation = orientation;
        this.pen = b;
        this.position = p;
    }
    //Setters & Getters
    public int getHeadind(){
        return this.orientation;
    }
    public Point getPosition(){
        return this.position;
    }
    //Methode
    public void penUp(){
        this.pen = false;
    }

    public void penDown(){
        this.pen = true;
    }

    public int getXCentered(){
        return position.getX()-getWidth()/2;
    }

    public int getYCentered(){
        return -position.getY()+getHeight()/2;
    }

    public int conv_X_LCornerSys(int x){
        return x+getWidth()/2;
    }

    public int conv_Y_LCornerSys(int y){
        return (-y)+getHeight()/2;
    }

    public void forward(int distance){
        int newX = (int)(this.getXCentered() + distance*Math.cos(Math.toRadians(orientation)));
        int newY =  (int)(this.getYCentered() + distance*Math.sin(Math.toRadians(orientation)));
        moveTo(newX,newY);
    }

    public void backward(int distance){
        int newX = (int)(this.getXCentered() - distance*Math.cos(Math.toRadians(orientation)));
        int newY =  (int)(this.getYCentered() - distance*Math.sin(Math.toRadians(orientation)));
        moveTo(newX,newY);
    }

    public void moveTo(int x, int y){
        int newX = x+getWidth()/2;
        int newY = -y+getHeight()/2;
        if(this.isDown()){
            //Conversion vers le repère 0,0 en haut à gauche
            drawLine(position.getX(),position.getY(),newX,newY);
            position.setX(newX);
            position.setY(newY);
        }
        position.setX(newX);
        position.setY(newY);
    }

    public void right(int degrees){
        this.orientation = (this.orientation + degrees)%360;
    }

    public void left(int degrees){
        this.orientation = (this.orientation - degrees)%360;
    }

    public Boolean isDown(){
        return this.pen;
    }
}
