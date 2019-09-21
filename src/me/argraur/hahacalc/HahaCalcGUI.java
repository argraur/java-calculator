package me.argraur.hahacalc;

import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HahaCalcGUI extends JDialog {
    private JPanel contentPane;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton divButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton mpButton;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton minButton;
    private JButton a0Button;
    private JButton eqButton;
    private JTextField mathField;
    private JButton plButton;
    private JButton cButton;

    HahaCalcGUI() {
        setContentPane(contentPane);
        setModal(true);
        MathTextBoxHelper textBox = new MathTextBoxHelper(mathField, this);
        a1Button.addActionListener(actionEvent -> textBox.addNumber(1));
        a2Button.addActionListener(actionEvent -> textBox.addNumber(2));
        a3Button.addActionListener(actionEvent -> textBox.addNumber(3));
        a4Button.addActionListener(actionEvent -> textBox.addNumber(4));
        a5Button.addActionListener(actionEvent -> textBox.addNumber(5));
        a6Button.addActionListener(actionEvent -> textBox.addNumber(6));
        a7Button.addActionListener(actionEvent -> textBox.addNumber(7));
        a8Button.addActionListener(actionEvent -> textBox.addNumber(8));
        a9Button.addActionListener(actionEvent -> textBox.addNumber(9));
        a0Button.addActionListener(actionEvent -> textBox.addZero());
        divButton.addActionListener(actionEvent -> textBox.addSymbol("/"));
        cButton.addActionListener(actionEvent -> textBox.reset());
        mpButton.addActionListener(actionEvent -> textBox.addSymbol("*"));
        minButton.addActionListener(actionEvent -> textBox.addSymbol("-"));
        plButton.addActionListener(actionEvent -> textBox.addSymbol("+"));
        eqButton.addActionListener(actionEvent -> textBox.result());

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
}
