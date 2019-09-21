package me.argraur.hahacalc;

import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HahaCalcGUI extends JDialog {
    private JPanel contentPane;
    private JButton a1Button,
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
    private JTextField mathField;

    private HahaCalcGUI() {
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

    public static void main(String[] args) {
        HahaCalcGUI gui = new HahaCalcGUI();
        gui.pack();
        gui.setTitle("HahaCalc");
        gui.setSize(350, 350);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        gui.setLocation(dim.width / 2 - gui.getSize().width / 2, dim.height / 2 - gui.getSize().height / 2);
        gui.setVisible(true);
    }
}
