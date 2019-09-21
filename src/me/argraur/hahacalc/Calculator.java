package me.argraur.hahacalc;

class Calculator extends GUI {
    private String[] dec, symb;
    private int curr;

    Calculator() {
        // GUI constructor
        super();

        // Assign actions to buttons
        a1Button.addActionListener(actionEvent -> addNumber(1));
        a2Button.addActionListener(actionEvent -> addNumber(2));
        a3Button.addActionListener(actionEvent -> addNumber(3));
        a4Button.addActionListener(actionEvent -> addNumber(4));
        a5Button.addActionListener(actionEvent -> addNumber(5));
        a6Button.addActionListener(actionEvent -> addNumber(6));
        a7Button.addActionListener(actionEvent -> addNumber(7));
        a8Button.addActionListener(actionEvent -> addNumber(8));
        a9Button.addActionListener(actionEvent -> addNumber(9));
        a0Button.addActionListener(actionEvent -> addZero());
        divButton.addActionListener(actionEvent -> addSymbol("/"));
        cButton.addActionListener(actionEvent -> reset());
        mpButton.addActionListener(actionEvent -> addSymbol("*"));
        minButton.addActionListener(actionEvent -> addSymbol("-"));
        plButton.addActionListener(actionEvent -> addSymbol("+"));
        eqButton.addActionListener(actionEvent -> result());

        dec = new String[10];
        symb = new String[10];
        for (int i = 0; i < 10; i++) {
            dec[i] = "";
            symb[i] = "";
        }
        curr = 0;
    }

    private void addNumber(int a) {
        addText(String.valueOf(a));
        dec[curr] = dec[curr] + a;
    }

    private void addSymbol(String symb) {
        // Check if we don't place 2 symbols in a row
        try { Integer.parseInt(dec[curr]); } catch (NumberFormatException e) { return; }
        // Add symbol to the textBox
        addText(" " + symb + " ");
        this.symb[curr] = symb;
        curr++;
    }

    private void addZero() {
        if (!dec[curr].equals("") || curr != 0) addNumber(0);
    }

    private void result() {
        float res = 0, first;
        for (int i = 0; i < curr; i++) {
            if (i == 0) first = Float.parseFloat(dec[i]); else first = res;
            switch (symb[i]) {
                case "/":
                    if (Float.parseFloat(dec[i + 1]) == 0) { errorZero(); return; }
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
        this.buttonLock(true);
    }

    private void reset() {
        this.buttonLock(false);
        dec = new String[10];
        symb = new String[10];
        for (int i = 0; i < 10; i++) {
            dec[i] = "";
            symb[i] = "";
        }
        curr = 0;
        mathField.setText("");
    }

    private void addText(String text) {
        mathField.setText(mathField.getText() + text);
    }

    private void errorZero() {
        mathField.setText("Can't divide by zero!");
        this.buttonLock(true);
    }
}
