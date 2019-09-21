package me.argraur.hahacalc;

import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends JDialog {
    private JPanel contentPane;
    public JButton a1Button,
                    a2Button,
                    a3Button,
                    a4Button,
                    a5Button,
                    a6Button,
                    a7Button,
                    a8Button,
                    a9Button,
                    a0Button,
                    minButton,
                    mpButton,
                    divButton,
                    eqButton,
                    plButton,
                    cButton;
    public JTextField mathField;

    GUI() {
        setContentPane(contentPane);
        setModal(true);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    void buttonLock(boolean lock) {
        a7Button.setEnabled(!lock);
        a8Button.setEnabled(!lock);
        a9Button.setEnabled(!lock);
        divButton.setEnabled(!lock);
        a4Button.setEnabled(!lock);
        a5Button.setEnabled(!lock);
        a6Button.setEnabled(!lock);
        mpButton.setEnabled(!lock);
        a1Button.setEnabled(!lock);
        a2Button.setEnabled(!lock);
        a3Button.setEnabled(!lock);
        minButton.setEnabled(!lock);
        a0Button.setEnabled(!lock);
        eqButton.setEnabled(!lock);
        plButton.setEnabled(!lock);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.pack();
        calc.setTitle("Calculator");
        calc.setSize(350, 350);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        calc.setLocation(dim.width / 2 - calc.getSize().width / 2, dim.height / 2 - calc.getSize().height / 2);
        calc.setVisible(true);
    }
}
