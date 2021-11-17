import java.awt.*;

public abstract class Shape implements Movable{
    //Attributs
    protected Point center;
    protected int lineWidth;
    protected Color lineColor;


    //Constructeurs
    public Shape(Point center){
        this(center, Color.BLACK, 1);
    }
    public Shape(Point center,Color lineColor, int lineWidth){
        this.center = center;
        this.lineColor = lineColor;
        this.lineWidth = lineWidth;
    }

    //Setters & Getters

    public Color getLineColor() {
        return lineColor;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public void setCenter(Point center){
        this.center = center;
    }
    public Point getCenter(){
        return this.center;
    }

    public abstract Rectangle getBounding();
    //Methodes
    public static void printShapes(Shape[] shapes){
        for(Shape shape : shapes){
            shape.print();
        }
    }
    public static void drawShapes(Shape[] shapes,Paint paint){
        for(Shape shape : shapes){
            shape.draw(paint);
        }
    }
    public abstract void draw(Paint paint);
    public void print(){
        System.out.println("Shape - Center : " + getCenter().toString());
    }

    @Override
    public void moveTo(int x, int y) {
        this.center.setY(y);
        this.center.setX(x);
    }
    public static Rectangle getBoundingBox(Shape[] shapes){
        int xmax = Integer.MIN_VALUE;
        int ymax = Integer.MIN_VALUE;
        int xmin = Integer.MAX_VALUE;
        int ymin = Integer.MAX_VALUE;

        Rectangle r_temp;

        for(Shape shape : shapes){
            r_temp = shape.getBounding();

            if(xmax < r_temp.center.getX() + r_temp.getWidth()/2){
                xmax = r_temp.center.getX() + r_temp.getWidth()/2;
            }
            if(xmin > r_temp.center.getX() - r_temp.getWidth()/2){
                xmin = r_temp.center.getX() - r_temp.getWidth()/2;
            }
            if(ymax < r_temp.center.getY() + r_temp.getHeight()/2){
                ymax = r_temp.center.getY() + r_temp.getHeight()/2;
            }
            if(ymin > r_temp.center.getY() - r_temp.getHeight()/2){
                ymin = r_temp.center.getY() - r_temp.getHeight()/2;
            }
        }
        int h = ymax - ymin;
        int w = xmax - xmin;

        Point point = new Point(xmin + w/2 , ymin + h/2);

        return new Rectangle(point,w,h);
    }
}
