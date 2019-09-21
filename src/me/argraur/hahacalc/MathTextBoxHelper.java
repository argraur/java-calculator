package me.argraur.hahacalc;

import javax.swing.JTextField;

class MathTextBoxHelper {
    private JTextField textBox;
    private HahaCalcGUI gui;
    private String[] dec, symb;
    private int curr;

    MathTextBoxHelper(JTextField textBox, HahaCalcGUI gui) {
        this.textBox = textBox;
        this.gui = gui;
        dec = new String[10];
        symb = new String[10];
        for (int i = 0; i < 10; i++) {
            dec[i] = "";
            symb[i] = "";
        }
        curr = 0;
    }

    void addNumber(int a) {
        addText(String.valueOf(a));
        dec[curr] = dec[curr] + a;
    }

    void addSymbol(String symb) {
        // Check if we don't place 2 symbols in a row
        try { Integer.parseInt(dec[curr]); } catch (NumberFormatException e) { return; }
        // Add symbol to the textBox
        addText(" " + symb + " ");
        this.symb[curr] = symb;
        curr++;
    }

    void addZero() {
        if (!dec[curr].equals("") || curr != 0) addNumber(0);
    }

    void result() {
        float res = 0, first;
        for (int i = 0; i < curr; i++) {
            if (i == 0) first = Float.parseFloat(dec[i]); else first = res;
            switch (symb[i]) {
                case "/":
                    if (Float.parseFloat(dec[i + 1]) == 0) { errorOut("Can't divide by zero!"); return; }
                    res = first / Float.parseFloat(dec[i + 1]);
                    break;
                case "*":
                    res = first * Float.parseFloat(dec[i + 1]);
                    break;
                case "-":
                    res = first - Float.parseFloat(dec[i + 1]);
                    break;
                case "+":
                    res = first + Float.parseFloat(dec[i + 1]);
                    break;
            }
        }
        addText(" = " + res);
        gui.buttonLock(true);
    }

    void reset() {
        gui.buttonLock(false);
        dec = new String[10];
        symb = new String[10];
        for (int i = 0; i < 10; i++) {
            dec[i] = "";
            symb[i] = "";
        }
        curr = 0;
        textBox.setText("");
    }

    private void addText(String text) {
        textBox.setText(textBox.getText() + text);
    }

    private void errorOut(String error) {
        textBox.setText(error);
        gui.buttonLock(true);
    }
}
