package test;

import controller.OperatieElementara;
import controller.OperatieAvansata;
import model.Polinom;
import view.CalculatorGUI;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OperatiePolinomTest {

    /*
        SETUL 1 DE POLINOAME:
        POLINOM 1 : 2x^4-3x^3-15x^2+32x^1-12
        POLINOM 2 : 1x^2-4x^1-12

     */

    @Test
    void adunarePolinoame1() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        String result = operatieElementara.adunarePolinoame("2x^4-3x^3-15x^2+32x^1-12", "1x^2-4x^1-12").afisareInteger();
        assertEquals("2x^4-3x^3-14x^2+28x^1-24", result);
    }

    @Test
    void scaderePolinoame1() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        String result = operatieElementara.scaderePolinoame("2x^4-3x^3-15x^2+32x^1-12", "1x^2-4x^1-12").afisareInteger();
        assertEquals("2x^4-3x^3-16x^2+36x^1", result);
    }

    @Test
    void inmultirePolinoame1() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        String result = operatieElementara.inmultirePolinoame("2x^4-3x^3-15x^2+32x^1-12", "1x^2-4x^1-12").afisareInteger();
        assertEquals("2x^6-11x^5-27x^4+128x^3+40x^2-336x^1+144", result);
    }

    @Test
    void impartirePolinoame1() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        ArrayList<Polinom> polis;
        polis = operatieElementara.impartirePolinoame("2x^4-3x^3-15x^2+32x^1-12", "1x^2-4x^1-12");
        String result = polis.get(0).afisareInteger() + " | " + polis.get(1).afisareInteger();
        assertEquals("2x^2+5x^1+29 | 208x^1+336", result);

    }

    @Test
    void derivarePolinoame1() {
        OperatieAvansata operatieAvansata = new OperatieAvansata();
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        String resultD1 = operatieAvansata.crearePolinom("deriv", "2x^4-3x^3-15x^2+32x^1-12", calculatorGUI).afisareInteger();
        String resultD2 = operatieAvansata.crearePolinom("deriv", "1x^2-4x^1-12", calculatorGUI).afisareInteger();
        assertEquals("8x^3-9x^2-30x^1+32", resultD1);
        assertEquals("2x^1-4", resultD2);
    }

    @Test
    void integrarePolinoame1() {
        OperatieAvansata operatieAvansata = new OperatieAvansata();
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        String resultD1 = operatieAvansata.crearePolinom("integr", "2x^4-3x^3-15x^2+32x^1-12", calculatorGUI).afisareDouble();
        String resultD2 = operatieAvansata.crearePolinom("integr", "1x^2-4x^1-12", calculatorGUI).afisareDouble();
        assertEquals("0.4x^5-0.75x^4-5.0x^3+16.0x^2-12.0x^1", resultD1);
        assertEquals("0.3333333333333333x^3-2.0x^2-12.0x^1", resultD2);

    }

    /*
        SETUL 2 DE POLINOAME:
        POLINOM 1 : -1x^7-4x^5+3x^1-10
        POLINOM 2 : 1x^7-1x^5

     */

    @Test
    void adunarePolinoame2() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        String result = operatieElementara.adunarePolinoame("-1x^7-4x^5+3x^1-10", "1x^7-1x^5").afisareInteger();
        assertEquals("-5x^5+3x^1-10", result);
    }

    @Test
    void scaderePolinoame2() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        String result = operatieElementara.scaderePolinoame("-1x^7-4x^5+3x^1-10", "1x^7-1x^5").afisareInteger();
        assertEquals("-2x^7-3x^5+3x^1-10", result);
    }

    @Test
    void inmultirePolinoame2() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        String result = operatieElementara.inmultirePolinoame("-1x^7-4x^5+3x^1-10", "1x^7-1x^5").afisareInteger();
        assertEquals("-1x^14-3x^12+4x^10+3x^8-10x^7-3x^6+10x^5", result);
    }

    @Test
    void impartirePolinoame2() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        ArrayList<Polinom> polis;
        polis = operatieElementara.impartirePolinoame("-1x^7-4x^5+3x^1-10", "1x^7-1x^5");
        String result = polis.get(0).afisareInteger() + " | " + polis.get(1).afisareInteger();
        assertEquals("-1 | -5x^5+3x^1-10", result);

    }

    @Test
    void derivarePolinoame2() {
        OperatieAvansata operatieAvansata = new OperatieAvansata();
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        String resultD1 = operatieAvansata.crearePolinom("deriv", "-1x^7-4x^5+3x^1-10", calculatorGUI).afisareInteger();
        String resultD2 = operatieAvansata.crearePolinom("deriv", "1x^7-1x^5", calculatorGUI).afisareInteger();
        assertEquals("-7x^6-20x^4+3", resultD1);
        assertEquals("7x^6-5x^4", resultD2);
    }

    @Test
    void integrarePolinoame2() {
        OperatieAvansata operatieAvansata = new OperatieAvansata();
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        String resultD1 = operatieAvansata.crearePolinom("integr", "-1x^7-4x^5+3x^1-10", calculatorGUI).afisareDouble();
        String resultD2 = operatieAvansata.crearePolinom("integr", "1x^7-1x^5", calculatorGUI).afisareDouble();
        assertEquals("-0.125x^8-0.6666666666666666x^6+1.5x^2-10.0x^1", resultD1);
        assertEquals("0.125x^8-0.16666666666666666x^6", resultD2);

    }

    /*
        SETUL 3 DE POLINOAME:
        POLINOM 1 : 1x^9+2x^3+1
        POLINOM 2 : 1x+1

     */


    @Test
    void adunarePolinoame3() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        String result = operatieElementara.adunarePolinoame("1x^9+2x^3+1", "1x+1").afisareInteger();
        assertEquals("1x^9+2x^3+1x^1+2", result);
    }

    @Test
    void scaderePolinoame3() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        String result = operatieElementara.scaderePolinoame("1x^9+2x^3+1", "1x+1").afisareInteger();
        assertEquals("1x^9+2x^3-1x^1", result);
    }

    @Test
    void inmultirePolinoame3() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        String result = operatieElementara.inmultirePolinoame("1x^9+2x^3+1", "1x+1").afisareInteger();
        assertEquals("1x^10+1x^9+2x^4+2x^3+1x^1+1", result);
    }

    @Test
    void impartirePolinoame3() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        ArrayList<Polinom> polis;
        polis = operatieElementara.impartirePolinoame("1x^9+2x^3+1", "1x+1");
        String result = polis.get(0).afisareInteger() + " | " + polis.get(1).afisareInteger();
        assertEquals("1x^8-1x^7+1x^6-1x^5+1x^4-1x^3+3x^2-3x^1+3 | -2", result);

    }

    @Test
    void derivarePolinoame3() {
        OperatieAvansata operatieAvansata = new OperatieAvansata();
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        String resultD1 = operatieAvansata.crearePolinom("deriv", "1x^9+2x^3+1", calculatorGUI).afisareInteger();
        String resultD2 = operatieAvansata.crearePolinom("deriv", "1x+1", calculatorGUI).afisareInteger();
        assertEquals("9x^8+6x^2", resultD1);
        assertEquals("+1", resultD2);
    }

    @Test
    void integrarePolinoame3() {
        OperatieAvansata operatieAvansata = new OperatieAvansata();
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        String resultD1 = operatieAvansata.crearePolinom("integr", "1x^9+2x^3+1", calculatorGUI).afisareDouble();
        String resultD2 = operatieAvansata.crearePolinom("integr", "1x+1", calculatorGUI).afisareDouble();
        assertEquals("0.1x^10+0.5x^4+1.0x^1", resultD1);
        assertEquals("0.5x^2+1.0x^1", resultD2);

    }

    /*
        SETUL 4 DE POLINOAME:
        POLINOM 1 : 70x^9-21x^7+11x^3-19
        POLINOM 2 : -1x^9-1x^3-70

     */

    @Test
    void adunarePolinoame4() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        String result = operatieElementara.adunarePolinoame("70x^9-21x^7+11x^3-19", "-1x^9-1x^3-70").afisareInteger();
        assertEquals("69x^9-21x^7+10x^3-89", result);
    }

    @Test
    void scaderePolinoame4() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        String result = operatieElementara.scaderePolinoame("70x^9-21x^7+11x^3-19", "-1x^9-1x^3-70").afisareInteger();
        assertEquals("71x^9-21x^7+12x^3+51", result);
    }

    @Test
    void inmultirePolinoame4() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        String result = operatieElementara.inmultirePolinoame("70x^9-21x^7+11x^3-19", "-1x^9-1x^3-70").afisareInteger();
        assertEquals("-70x^18+21x^16-81x^12+21x^10-4881x^9+1470x^7-11x^6-751x^3+1330", result);
    }

    @Test
    void impartirePolinoame4() {
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        OperatieElementara operatieElementara = new OperatieElementara(calculatorGUI);
        ArrayList<Polinom> polis;
        polis = operatieElementara.impartirePolinoame("70x^9-21x^7+11x^3-19", "-1x^9-1x^3-70");
        String result = polis.get(0).afisareInteger() + " | " + polis.get(1).afisareInteger();
        assertEquals("-70 | -21x^7-59x^3-4919", result);

    }

    @Test
    void derivarePolinoame4() {
        OperatieAvansata operatieAvansata = new OperatieAvansata();
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        String resultD1 = operatieAvansata.crearePolinom("deriv", "70x^9-21x^7+11x^3-19", calculatorGUI).afisareInteger();
        String resultD2 = operatieAvansata.crearePolinom("deriv", "-1x^9-1x^3-70", calculatorGUI).afisareInteger();
        assertEquals("630x^8-147x^6+33x^2", resultD1);
        assertEquals("-9x^8-3x^2", resultD2);
    }

    @Test
    void integrarePolinoame4() {
        OperatieAvansata operatieAvansata = new OperatieAvansata();
        CalculatorGUI calculatorGUI = new CalculatorGUI();
        String resultD1 = operatieAvansata.crearePolinom("integr", "70x^9-21x^7+11x^3-19", calculatorGUI).afisareDouble();
        String resultD2 = operatieAvansata.crearePolinom("integr", "-1x^9-1x^3-70", calculatorGUI).afisareDouble();
        assertEquals("7.0x^10-2.625x^8+2.75x^4-19.0x^1", resultD1);
        assertEquals("-0.1x^10-0.25x^4-70.0x^1", resultD2);

    }


}