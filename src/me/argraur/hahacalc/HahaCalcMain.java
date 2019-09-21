package me.argraur.hahacalc;

import java.awt.Dimension;
import java.awt.Toolkit;

public class HahaCalcMain {
    public static void main(String[] args) {
        HahaCalcGUI gui = new HahaCalcGUI();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        gui.setTitle("HahaCalc");
        gui.pack();
        gui.setSize(350, 350);
        gui.setLocation(dim.width / 2 - gui.getSize().width / 2, dim.height / 2 - gui.getSize().height / 2);
        gui.setVisible(true);
    }
}
