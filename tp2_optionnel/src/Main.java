import java.awt.*;

public class Main {
    public static void dessiner_carre(){
        Turtle t = new Turtle(500,500);
        t.moveTo(0,100);
        t.moveTo(100,100);
        t.moveTo(100,0);
        t.moveTo(0,0);

    }
    public static void dessiner_tri_eq(){
        Turtle t = new Turtle(500,500);
        t.forward(100);
        t.right(180 - 60);
        t.forward(100);
        t.right(180 - 60);
        t.forward(100);
        t.right(180 - 60);
    }
    public static void main(String[] args){
        //Turtle t = new Turtle(500,500);
        //t.moveTo(100,100);
        //dessiner_carre();
        dessiner_tri_eq();
    }
}
