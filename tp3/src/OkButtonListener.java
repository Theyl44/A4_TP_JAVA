import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OkButtonListener implements ActionListener {

    private JLabel label;

    public OkButtonListener(JLabel label) {
        this.label = label;
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("OK clicked !");
        this.label.setText("OK clicked !");
    }
}
