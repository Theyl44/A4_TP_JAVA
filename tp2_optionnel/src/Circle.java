import java.awt.*;

public class Circle extends Shape{
    private int radius;

    public Circle(Point center, int radius) {
        super(center);
        this.radius = radius;
    }
    public Circle(Point center, int radius, Color lineColor, int lineWidth){
        super(center,lineColor,lineWidth);
        this.radius = radius;
    }
    public void setRadius(int radius){
            this.radius = radius;
    }
    public int getRadius(){
        return this.radius;
    }
    public void print(){
        System.out.println("Circle center : "+this.center+" , radius : " + this.radius);
    }
    public void draw(Paint p ){
        p.setColor(this.lineColor);
        p.setLineWidth(this.lineWidth);
        p.drawArc(getCenter().getX(), getCenter().getY(), 2*this.radius, 2*this.radius, 0, 360);
    }
    public Rectangle getBounding(){
        return new Rectangle(new Point(this.center.getX(), this.center.getY()),2*this.radius,2*this.radius);
    }
}