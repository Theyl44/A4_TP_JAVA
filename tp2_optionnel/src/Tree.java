import java.awt.*;

public class Tree {
    //Attributs

    //Constructeur

    //Setters & Getters

    //Methodes
    public static void drawTree(Turtle turtle, int l, int n){
        if(n == 1){
            turtle.forward(l);
            turtle.right(15);
            turtle.forward(2*l/3);
            turtle.penUp();
            turtle.backward(2*l/3);
            turtle.penDown();
            turtle.left(2*15);
            turtle.forward(2*l/3);
            turtle.penUp();
            turtle.backward(2*l/3);
            turtle.penDown();
            turtle.right(15);
            turtle.penUp();
            turtle.backward(l);
            turtle.penDown();
        }else{
            turtle.forward(l);
            turtle.right(15);
            drawTree(turtle,l*2/3,n-1);



            turtle.left(30);
            drawTree(turtle, l*2/3, n-1);



            turtle.right(15);
            turtle.penUp();
            turtle.backward(l);
            turtle.penDown();

        }
    }
    public static void main(String[] args){
        Turtle t = new Turtle(500,500);
        drawTree(t,100,4);
    }
}
