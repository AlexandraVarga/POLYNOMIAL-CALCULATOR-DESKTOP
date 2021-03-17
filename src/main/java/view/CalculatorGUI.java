package view;

import controller.OperatieElementara;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import static javax.swing.JLabel.*;

public class CalculatorGUI {

    public JFrame calcFrame;
    public JLabel labelDerivate1, statusLabelDerivate1,
            labelIntegrale1, statusLabelIntegrale1,
            labelDerivate2, statusLabelDerivate2,
            labelIntegrale2, statusLabelIntegrale2,
            labelSuma, statusLabelSuma,
            labelDif, statusLabelDif,
            labelInmultire, statusLabelInmult,
            labelImpartire, statusLabelImpartire;
    public JPanel pol1, pol2;
    public JTextField polinom1, polinom2;
    public JButton plus, minus, ori, divide, integr, deriv;
    public int x; // valoarea lui x


    public CalculatorGUI() {
        prepareGUI();
    }

    ///CREARE INTERFATA CALCULATOR DE POLINOAME
    private void prepareGUI() {

        ///Frame calculator
        calcFrame = new JFrame("Calculator Polinoame");
        calcFrame.setSize(800, 320);
        calcFrame.setLayout(new GridLayout(1, 2));
        calcFrame.setLocationRelativeTo(null);
        JPanel panelCalc = new JPanel();
        calcFrame.add(panelCalc);
        calcFrame.setResizable(false);
        calcFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        ///Panel-uri pentru cele 2 polinoame
        pol1 = new JPanel();
        pol1.setLayout(new FlowLayout());
        pol2 = new JPanel();
        pol2.setLayout(new FlowLayout());
        polinom1 = new JTextField(20);
        polinom2 = new JTextField(20);
        pol1.add(new JLabel("Polinom 1: ", LEFT));
        pol1.add(polinom1);
        pol2.add(new JLabel("Polinom 2: ", LEFT));
        pol2.add(polinom2);

        ///Label afisareInteger suma polinoame
        labelSuma = new JLabel("", LEFT);
        labelSuma.setPreferredSize(new Dimension(350, 20));
        labelSuma.setText(" Suma celor doua polinoame");
        statusLabelSuma = new JLabel("", LEFT);
        statusLabelSuma.setVerticalTextPosition(TOP);
        statusLabelSuma.setPreferredSize(new Dimension(350, 20));
        JPanel panelSuma = new JPanel();
        panelSuma.setLayout(new GridLayout(2, 1));
        panelSuma.add(labelSuma);
        panelSuma.add(statusLabelSuma);
        panelSuma.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.black));

        ///Label afisareInteger diferenta polinoame
        labelDif = new JLabel("", LEFT);
        labelDif.setPreferredSize(new Dimension(350, 20));
        labelDif.setText(" Diferenta celor doua polinoame");
        statusLabelDif = new JLabel("", LEFT);
        statusLabelDif.setVerticalTextPosition(TOP);
        statusLabelDif.setPreferredSize(new Dimension(350, 20));
        JPanel panelDif = new JPanel();
        panelDif.setLayout(new GridLayout(2, 1));
        panelDif.add(labelDif);
        panelDif.add(statusLabelDif);
        panelDif.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.black));

        ///Label afisareInteger inmultire polinoame
        labelInmultire = new JLabel("", LEFT);
        labelInmultire.setPreferredSize(new Dimension(350, 20));
        labelInmultire.setText(" Inmultirea celor doua polinoame");
        statusLabelInmult = new JLabel("", LEFT);
        statusLabelInmult.setVerticalTextPosition(TOP);
        statusLabelInmult.setPreferredSize(new Dimension(350, 20));
        JPanel panelInmultire = new JPanel();
        panelInmultire.setLayout(new GridLayout(2, 1));
        panelInmultire.add(labelInmultire);
        panelInmultire.add(statusLabelInmult);
        panelInmultire.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.black));

        labelImpartire = new JLabel("", LEFT);
        labelImpartire.setPreferredSize(new Dimension(350, 20));
        labelImpartire.setText(" Impartirea celor doua polinoame");
        statusLabelImpartire = new JLabel("", LEFT);
        statusLabelImpartire.setVerticalTextPosition(TOP);
        statusLabelImpartire.setPreferredSize(new Dimension(350, 20));
        JPanel panelImpartire = new JPanel();
        panelImpartire.setLayout(new GridLayout(2, 1));
        panelImpartire.add(labelImpartire);
        panelImpartire.add(statusLabelImpartire);
        panelImpartire.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.black));

        labelDerivate1 = new JLabel("", LEFT);
        labelDerivate1.setPreferredSize(new Dimension(350, 20));
        labelDerivate1.setText(" Derivata Polinom 1");
        statusLabelDerivate1 = new JLabel("", LEFT);
        statusLabelDerivate1.setVerticalTextPosition(TOP);
        statusLabelDerivate1.setPreferredSize(new Dimension(350, 20));
        JPanel panelDerivate1 = new JPanel();
        panelDerivate1.setLayout(new GridLayout(2, 1));
        panelDerivate1.add(labelDerivate1);
        panelDerivate1.add(statusLabelDerivate1);
        panelDerivate1.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.black));

        labelDerivate2 = new JLabel("", LEFT);
        labelDerivate2.setPreferredSize(new Dimension(350, 20));
        labelDerivate2.setText(" Derivata Polinom 2");
        statusLabelDerivate2 = new JLabel("", LEFT);
        statusLabelDerivate2.setVerticalTextPosition(TOP);
        statusLabelDerivate2.setPreferredSize(new Dimension(350, 20));
        JPanel panelDerivate2 = new JPanel();
        panelDerivate2.setLayout(new GridLayout(2, 1));
        panelDerivate2.add(labelDerivate2);
        panelDerivate2.add(statusLabelDerivate2);
        panelDerivate2.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.black));


        labelIntegrale1 = new JLabel("", LEFT);
        labelIntegrale1.setPreferredSize(new Dimension(350, 20));
        labelIntegrale1.setText(" Integrala Polinom 1");
        statusLabelIntegrale1 = new JLabel("", LEFT);
        statusLabelIntegrale1.setVerticalTextPosition(TOP);
        statusLabelIntegrale1.setPreferredSize(new Dimension(350, 20));
        JPanel panelIntegrale1 = new JPanel();
        panelIntegrale1.setLayout(new GridLayout(2, 1));
        panelIntegrale1.add(labelIntegrale1);
        panelIntegrale1.add(statusLabelIntegrale1);
        panelIntegrale1.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.black));

        labelIntegrale2 = new JLabel("", LEFT);
        labelIntegrale2.setPreferredSize(new Dimension(350, 20));
        labelIntegrale2.setText(" Integrala Polinom 2");
        statusLabelIntegrale2 = new JLabel("", LEFT);
        statusLabelIntegrale2.setVerticalTextPosition(TOP);
        statusLabelIntegrale2.setPreferredSize(new Dimension(350, 20));
        JPanel panelIntegrale2 = new JPanel();
        panelIntegrale2.setLayout(new GridLayout(2, 1));
        panelIntegrale2.add(labelIntegrale2);
        panelIntegrale2.add(statusLabelIntegrale2);
        panelIntegrale2.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.black));

        // Butoane operatii pe polinoame
        JPanel operatori = new JPanel();
        GridLayout op = new GridLayout(1, 6);
        op.setHgap(51);
        operatori.setLayout(op);
        plus = CalculatorGUI.createSimpleButton("+");
        minus = CalculatorGUI.createSimpleButton("-");
        ori = CalculatorGUI.createSimpleButton("x");
        divide = CalculatorGUI.createSimpleButton("/");
        deriv = CalculatorGUI.createSimpleButton("d/dx");
        integr = CalculatorGUI.createSimpleButton("dx");

        operatori.add(plus);
        operatori.add(minus);
        operatori.add(ori);
        operatori.add(divide);
        operatori.add(deriv);
        operatori.add(integr);

        panelCalc.add(pol1);
        panelCalc.add(pol2);
        panelCalc.add(operatori);
        panelCalc.add(panelSuma);
        panelCalc.add(panelDif);
        panelCalc.add(panelInmultire);
        panelCalc.add(panelImpartire);
        panelCalc.add(panelDerivate1);
        panelCalc.add(panelIntegrale1);
        panelCalc.add(panelDerivate2);
        panelCalc.add(panelIntegrale2);
        panelCalc.setVisible(true);

    }

    /// FUNCTIE CREARE BUTON GRAFIC PENTRU OPERATII
    private static JButton createSimpleButton(String text) {
        JButton button = new JButton(text);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.lightGray);
        Border line = BorderFactory.createLineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        button.setBorder(compound);
        return button;
    }

    public void showEventDemo() {


        JButton second_ok = new JButton("OK");
        second_ok.setActionCommand("ok2");
        plus.setActionCommand("plus");
        minus.setActionCommand("minus");
        ori.setActionCommand("times");
        divide.setActionCommand("divide");
        deriv.setActionCommand("deriv");
        integr.setActionCommand("integr");

        //CONTROLLER
        second_ok.addActionListener(new OperatieElementara(this));
        plus.addActionListener(new OperatieElementara(this));
        minus.addActionListener(new OperatieElementara(this));
        ori.addActionListener(new OperatieElementara(this));
        divide.addActionListener(new OperatieElementara(this));
        deriv.addActionListener(new OperatieElementara(this));
        integr.addActionListener(new OperatieElementara(this));
        pol2.add(second_ok);
        calcFrame.setVisible(true);
    }

    public static void main(String[] args) {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        calculatorGUI.showEventDemo();
    }
}
