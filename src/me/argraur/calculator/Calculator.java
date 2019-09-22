package me.argraur.calculator;

class Calculator extends GUI {
    // String[integer][0]
    // String[symbol][1]
    private String[][] calc = new String[10][2];
    private int curr = 0;

    private Calculator() {
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
        dotButton.addActionListener(actionEvent -> addDot());

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 2; j++)
                calc[i][j] = "";
    }

    private void addNumber(int a) {
        addText(String.valueOf(a));
        calc[curr][0] = calc[curr][0] + a;
    }

    private void addSymbol(String symb) {
        // Check if we don't place 2 symbols in a row
        try { Float.parseFloat(calc[curr][0]); } catch (NumberFormatException e) { return; }
        // Add symbol to the textBox
        addText(" " + symb + " ");
        calc[curr][1] = symb;
        curr++;
    }

    private void addZero() {
        if (!calc[curr][0].equals("") || curr != 0) addNumber(0);
    }

    private void addDot() {
        if (calc[curr][0].equals("")) addNumber(0);
        calc[curr][0] = calc[curr][0] + ".";
        addText(".");
    }
    private void result() {
        try {
            float res = 0, frs = Float.parseFloat(calc[0][0]);
            for (int i = 0; i < curr; i++) {
                switch (calc[i][1]) {
                    case "/":
                        if (Float.parseFloat(calc[i + 1][0]) == 0) {
                            errorOut("Can't divide by zero!");
                            return;
                        }
                        res = frs / Float.parseFloat(calc[i + 1][0]);
                        break;
                    case "*":
                        res = frs * Float.parseFloat(calc[i + 1][0]);
                        break;
                    case "-":
                        res = frs - Float.parseFloat(calc[i + 1][0]);
                        break;
                    case "+":
                        res = frs + Float.parseFloat(calc[i + 1][0]);
                        break;
                }
                frs = res;
            }
            addText(" = " + res);
            buttonAvailable(false);
        } catch (NumberFormatException nfe) {
            errorOut("Error!");
        }
    }

    private void reset() {
        buttonAvailable(true);
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 2; j++)
                calc[i][j] = "";
        curr = 0;
        mathField.setText("");
    }

    private void addText(String text) {
        mathField.setText(mathField.getText() + text);
    }

    private void errorOut(String err) {
        mathField.setText(err);
        buttonAvailable(false);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.setTitle("Calculator");
        calc.setVisible(true);
    }
}
