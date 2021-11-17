import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelButtonListener implements ActionListener {

    private JLabel label;

    public CancelButtonListener(JLabel label) {
        this.label = label;
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("Cancel clicked !");
        this.label.setText("Cancel clicked !");
    }
}
