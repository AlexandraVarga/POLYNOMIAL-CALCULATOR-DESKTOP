package controller;

import model.Polinom;
import view.CalculatorGUI;

public class OperatieAvansata {

    public Polinom crearePolinom(String bufferCommand, String buffer, CalculatorGUI calculatorGUI) {
        String[] monoame;
        String finalBuffer;
        ///PARSARE + REGEX
        if (bufferCommand.toLowerCase().contains("deriv")) {
            /// DERIVARE POLINOAME
            String actualBuffer = (buffer.contains("-")) ? buffer.replace("-", "+-") : buffer;
            finalBuffer = (actualBuffer.charAt(0) == '+') ? actualBuffer.substring(1) : actualBuffer;
            monoame = finalBuffer.split("\\+");
            Polinom poli = new Polinom(monoame, calculatorGUI.x);
            poli.derivarePolinom();
            return poli;
        } else if (bufferCommand.toLowerCase().contains("integr")) {
            ///INTEGRARE POLINOAME
            String actualBuffer = (buffer.contains("-")) ? buffer.replace("-", "+-") : buffer;
            finalBuffer = (actualBuffer.charAt(0) == '+') ? actualBuffer.substring(1) : actualBuffer;
            monoame = finalBuffer.split("\\+");
            Polinom poli = new Polinom(monoame, calculatorGUI.x);
            poli.integrarePolinom();
            return poli;
        } else {
            ///CELELALTE OPERATII
            String actualBuffer = (buffer.contains("-")) ? buffer.replace("-", "+-") : buffer;
            finalBuffer = (actualBuffer.charAt(0) == '+') ? actualBuffer.substring(1) : actualBuffer;
            monoame = finalBuffer.split("\\+");
            Polinom poli = new Polinom(monoame, calculatorGUI.x);
            return poli;
        }
    }
}
