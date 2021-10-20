import java.awt.*;

public class Main {
    public static void question1(){
        Point p = new Point(100, 200);
        System.out.println(p.getX());
        p.setX(300);
        System.out.println(p.getX());
    }
    public static void question2(){
        Point p = new Point(100, 200);
        System.out.println(p.getY());
        p.setY(300);
        System.out.println(p.getY());
    }
    public static void question3(){
        Point p = new Point(100, 200);
        System.out.println(p);
    }
    public static void question4(){
        Point p = new Point(100, 200);
        String s = "Point coordinates : " + p;
        System.out.println(s);
    }/*
    public static void question5(){
        Point center = new Point(100, 200);
        Shape s = new Shape(center);
        s.print();
    }
    public static void question6(){
        Shape s = new Shape(new Point(100, 200));
        s.print();
    }*/
    public static void question7(){
        Circle c = new Circle(new Point(100, 200), 50);
        c.print();
    }
    public static void question8(){
        Circle c = new Circle(new Point(100, 200), 50);
        c.print();
        System.out.println("modif");
        c.setRadius(100);
        c.print();
    }
    public static void question9(){
        Shape c = new Circle(new Point(100, 200), 50);
        c.print();
    }
    public static void question10(){
        Rectangle r = new Rectangle(new Point(100,200),10,10);
        r.print();
    }
    public static void question11(){

        Circle c = new Circle(new Point(100, 200), 50);
        Rectangle r = new Rectangle(new Point(100,200),10,10);

        Shape[] shapes = {c,r};

        Shape.printShapes(shapes);
    }
    public static void question12(){
        Paint p = new Paint(500, 300);
        p.drawLine(100, 200, 200, 100);
        p.drawArc(300, 200, 200, 200, 0, 90);
    }
    public static void question13(){
        Paint p = new Paint(200, 200);
        Circle c = new Circle(new Point(100,100), 100);
        c.draw(p);

        Rectangle r = new Rectangle(new Point(100,100),173,100);
        r.draw(p);
    }
    public static void question14(){

        Paint p = new Paint(200,200);
        Circle c = new Circle(new Point(100,100),100);
        Rectangle r = new Rectangle(new Point(100,100),173,100);

        Shape[] shapes = {c,r};
        Paint paint = new Paint(200, 200);

        Shape.drawShapes(shapes,paint);

    }
    public static void question15(){
        Paint p = new Paint(200, 200);
        Circle c = new Circle(new Point( 100, 100 ),100, Color.RED,5);
        c.draw(p);
        Rectangle r = new Rectangle(new Point(100,100),173,100,Color.BLUE,2);
        r.draw(p);
    }
    static public void question16(){
        Paint p = new Paint(200, 200);
        Circle c = new Circle(new Point( 100, 100 ),100, Color.RED,5);
        c.draw(p);
        c.moveTo(150,150);
        c.draw(p);
    }
    static public void question17(){
        Paint p = new Paint(200, 200);
        Circle c = new Circle(new Point( 150, 150 ),100, Color.RED,1);
        Rectangle r = new Rectangle(new Point(100, 100),173,100);

        Shape[] shapes1 = {r,c};
        Rectangle rfinal = Shape.getBoundingBox(shapes1);
        rfinal.setLineColor(Color.BLUE);

        Shape[] shapes = {r,c,rfinal};
        Shape.drawShapes(shapes,p);
    }
    public static void main(String[] args){

        //CLASSE POINT
        //question1();
        //question2();
        //question3();
        //question4();

        //CLASSE CENTER
        //question5();
        //question6();

        //CLASSE CERCLE
        //question7();
        //question8();
        //question9();

        //CLASSE RECTANGLE
        //question10();
        //question11();

        //PAINT
        //question12();
        //question13();
        //question14();
        //question15();
        //question16();
        question17();
    }
}
