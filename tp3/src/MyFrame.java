import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class MyFrame extends JFrame{

    private JPanel center;
    private JPanel south;

    public MyFrame(){

        super("My first JFrame");
        this.setSize(300,100);

        this.center = new JPanel(new GridLayout(2,1,5,5));
        this.south = new JPanel();

        JLabel ok_label = new JLabel("Click on OK ");
        JLabel close_label = new JLabel("Click on Cancel");

        center.add(ok_label);
        center.add(close_label);

        JButton ok_button = new JButton("OK");
        south.add(ok_button);

        JButton close_button = new JButton("Cancel");
        south.add(close_button);

        this.add(center,BorderLayout.CENTER);
        this.add(south,BorderLayout.SOUTH);

        OkButtonListener okbuttonListener = new OkButtonListener(ok_label);
        ok_button.addActionListener(okbuttonListener);

        CancelButtonListener cancelButtonListener = new CancelButtonListener(close_label);
        close_button.addActionListener(cancelButtonListener);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Animation a1 = new Animation(ok_label, "Click on OK ", 200);
        a1.start();

        Animation a2 = new Animation(close_label, "Click on Cancel", 200);
        a2.start();
    }
}