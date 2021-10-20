import java.awt.*;

public class Rectangle extends Shape {
    //Attributs
    private int width;
    private int height;
    //Constructeur

    public Rectangle(Point center, int width, int height){
        super(center);
        this.width = width;
        this.height = height;
    }
    public Rectangle(Point center, int width, int height, Color lineColor, int lineWidth){
        super(center,lineColor,lineWidth);
        this.width = width;
        this.height = height;
    }
    //Setters & Getters

    //Methodes

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void print(){
        System.out.println("Rectangle center : "+this.center+", width : "+this.width+", height : "+ this.height);
    }
    public void draw(Paint p){
        Point a  = new Point(this.center.getX() - this.width/2, this.center.getY() - this.height/2);
        Point b  = new Point(this.center.getX() + this.width/2, this.center.getY() - this.height/2);
        Point c  = new Point(this.center.getX() + this.width/2, this.center.getY() + this.height/2);
        Point d  = new Point(this.center.getX() - this.width/2, this.center.getY() + this.height/2);

        p.setColor(this.lineColor);
        p.setLineWidth(this.lineWidth);

        p.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
        p.drawLine(b.getX(), b.getY(), c.getX(), c.getY());
        p.drawLine(c.getX(), c.getY(), d.getX(), d.getY());
        p.drawLine(d.getX(), d.getY(), a.getX(), a.getY());
    }
    public Rectangle getBounding(){
        return new Rectangle(new Point(this.center.getX(), this.center.getY()),this.width,this.height);
    }
}
