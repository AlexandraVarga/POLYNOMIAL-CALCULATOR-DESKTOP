package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import view.CalculatorGUI;
import model.Polinom;

import javax.swing.*;

public class OperatieElementara implements ActionListener {

    OperatieAvansata operatieAvansata = new OperatieAvansata();
    CalculatorGUI calculatorGUI;

    public OperatieElementara(CalculatorGUI calculatorGUI) {
        this.calculatorGUI = calculatorGUI;
    }

    ///CONTROLLER - OPERATII PE POLINOAME PARSATE
    public Polinom adunarePolinoame(String buffer1, String buffer2) {
        Polinom poli1, poli2, poli3;
        poli1 = operatieAvansata.crearePolinom("plus", buffer1, calculatorGUI);
        poli2 = operatieAvansata.crearePolinom("plus", buffer2, calculatorGUI);
        poli3 = poli1.adunarePolinom(poli2);
        return poli3;
    }

    public Polinom scaderePolinoame(String buffer1, String buffer2) {
        Polinom poli1, poli2, poli3;
        poli1 = operatieAvansata.crearePolinom("minus", buffer1, calculatorGUI);
        poli2 = operatieAvansata.crearePolinom("minus", buffer2, calculatorGUI);
        poli3 = poli1.scaderePolinom(poli2);
        return poli3;
    }

    public Polinom inmultirePolinoame(String buffer1, String buffer2) {
        Polinom poli1, poli2, poli3;
        poli1 = operatieAvansata.crearePolinom("times", buffer1, calculatorGUI);
        poli2 = operatieAvansata.crearePolinom("times", buffer2, calculatorGUI);
        poli3 = poli1.inmultirePolinom(poli2);
        return poli3;
    }

    public ArrayList<Polinom> impartirePolinoame(String buffer1, String buffer2) {
        Polinom poli1, poli2;
        ArrayList<Polinom> polis;
        poli1 = operatieAvansata.crearePolinom("divide", buffer1, calculatorGUI);
        poli2 = operatieAvansata.crearePolinom("divide", buffer2, calculatorGUI);
        polis = poli1.impartirePolinom(poli2);
        return polis;
    }

    ///CONTROLLER DE OPERATII EFECTUATE PE POLINOAME - IN FUNCTIE DE BUTON APASAT

    public void actionPerformed(ActionEvent e) {
        if (!calculatorGUI.polinom1.getText().equals("") && !calculatorGUI.polinom2.getText().equals("")) {
            String command = e.getActionCommand();

            switch (command) {
                case "plus" -> {
                    ///afisareInteger suma polinoame
                    String buffer1 = calculatorGUI.polinom1.getText();
                    String buffer2 = calculatorGUI.polinom2.getText();
                    Polinom poli3 = this.adunarePolinoame(buffer1, buffer2);
                    calculatorGUI.statusLabelSuma.setText(poli3.afisareInteger());
                }
                case "minus" -> {
                    ///afisareInteger diferenta polinoame
                    String buffer1 = calculatorGUI.polinom1.getText();
                    String buffer2 = calculatorGUI.polinom2.getText();
                    Polinom poli3 = this.scaderePolinoame(buffer1, buffer2);
                    calculatorGUI.statusLabelDif.setText(poli3.afisareInteger());
                }
                case "times" -> {
                    ///afisareInteger inmultire polinoame
                    String buffer1 = calculatorGUI.polinom1.getText();
                    String buffer2 = calculatorGUI.polinom2.getText();
                    Polinom poli3 = this.inmultirePolinoame(buffer1, buffer2);
                    calculatorGUI.statusLabelInmult.setText(poli3.afisareInteger());
                }
                case "divide" -> {
                    ///afisareInteger impartire polinoame
                    String buffer1 = calculatorGUI.polinom1.getText();
                    String buffer2 = calculatorGUI.polinom2.getText();
                    ArrayList<Polinom> polis;
                    polis = this.impartirePolinoame(buffer1, buffer2);
                    calculatorGUI.statusLabelImpartire.setText(polis.get(0).afisareInteger() + "  |   " + polis.get(1).afisareInteger());
                }
                case "deriv" -> {
                    calculatorGUI.statusLabelDerivate1.setText(operatieAvansata.crearePolinom("deriv", calculatorGUI.polinom1.getText(), calculatorGUI).afisareInteger());
                    calculatorGUI.statusLabelDerivate2.setText(operatieAvansata.crearePolinom("deriv", calculatorGUI.polinom2.getText(), calculatorGUI).afisareInteger());
                }
                case "integr" -> {
                    calculatorGUI.statusLabelIntegrale1.setText(operatieAvansata.crearePolinom("integr", calculatorGUI.polinom1.getText(), calculatorGUI).afisareDouble());
                    calculatorGUI.statusLabelIntegrale2.setText(operatieAvansata.crearePolinom("integr", calculatorGUI.polinom2.getText(), calculatorGUI).afisareDouble());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nu ati introdus suficiente polinoame!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

}
