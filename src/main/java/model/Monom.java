package model;

import javax.swing.*;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Monom {

    public String monom;
    public int putere;
    public int coeficient;
    public double doubleCoef;
    private String[] buffer;

    public Monom(String monom) {
        if (validareMonom(monom)) {
            this.monom = monom;
        }
        doubleCoef = coeficient;
    }

    public Monom(int coeficient, int putere) {
        this.putere = putere;
        this.coeficient = coeficient;
        doubleCoef = coeficient;
        this.monom = format();
    }

    public Monom(double doubleCoef, int coeficient, int putere) {
        this.putere = putere;
        this.coeficient = coeficient;
        this.doubleCoef = doubleCoef;
        this.monom = format();
    }

    public void adunareCoeficient(int x) {
        this.coeficient += x;
        this.doubleCoef = coeficient;
    }

    public Monom inmultireMonom(Monom mon1) {
        Monom ret;
        double c = this.doubleCoef * mon1.doubleCoef;
        int d = (int) c;
        int p = this.getPutere() + mon1.getPutere();
        ret = new Monom(c, d, p);
        return ret;
    }

    public Monom impartireMonom(Monom divizor) {
        Monom ret;
        double c = this.doubleCoef / divizor.doubleCoef;
        int d = (int) c;
        int p = this.getPutere() - divizor.getPutere();
        ret = new Monom(c, d, p);
        return ret;
    }

    ///derivata monom
    public void derivareMonom() {
        if (putere != 0) {
            doubleCoef = doubleCoef * putere;
            coeficient = (int) doubleCoef;
            putere -= 1;
        } else {
            // (ct)' = 0
            doubleCoef = 0;
            coeficient = 0;
        }
    }

    //integrala monom
    public void integrareMonom() {
        putere++;
        doubleCoef = doubleCoef / putere;
        coeficient = (int) doubleCoef;
    }

    ///Validare MONOM daca este introdus dupa pattern-ul stabilit

    private boolean validareMonom(String monom) {
        // Verificam daca exista caractere ciudate - cu exceptia lui ^
        if (!monom.matches("^[a-zA-Z0-9\\^\\*\\- ]*")) return false;
        Pattern polyFormat = Pattern.compile("\\^");
        Matcher m = polyFormat.matcher(monom);
        String s = new String();
        while (m.find()) {
            s = m.group();
        }
        if (s.isEmpty()) {
            // nu contine ^ =>
            buffer = monom.split("[a-zA-Z]");
            if (buffer.length == 0) {
                coeficient = 1;
                putere = 1;
            } else {
                coeficient = (!buffer[0].isEmpty()) ? Integer.parseInt(buffer[0]) : 1;
                putere = (buffer[0] == monom) ? 0 : 1;
            }
        } else {
            // contine ^ =>
            buffer = monom.split("\\^");
            try {
                String nrStr = new String();
                for (int i = 0; i < buffer[0].length(); i++) {
                    char c = buffer[0].charAt(i);
                    if (c == 45) nrStr += c;
                    if (c > 47 && c < 58) nrStr += c;
                }
                coeficient = (nrStr.isEmpty()) ? 1 : Integer.parseInt(nrStr);
                putere = Integer.parseInt(buffer[1]);
            } catch (NumberFormatException e) { //
                JOptionPane.showMessageDialog(null, "Format polinom invalid!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return true;
    }

    public static Comparator<Monom> getCompByPutere() {
        Comparator<Monom> comp = new Comparator<Monom>() {
            @Override
            public int compare(Monom s1, Monom s2) {
                return Integer.compare(s1.putere, s2.putere);
            }
        };
        return comp;
    }

    private String format() {
        String container = new String(this.doubleCoef + "x^" + this.putere);
        return container;
    }

    public String getMonom() {
        return (putere == 0) ? Double.toString(doubleCoef) : (doubleCoef + "x^" + putere);
    }

    public String getMonomInt() {
        //constanta derivata => 0
        if (putere == 0 && coeficient == 0 && doubleCoef == 0)
            return "";
        return (putere == 0) ? Integer.toString((int) doubleCoef) : ((int) doubleCoef + "x^" + putere);
    }

    public int getCoeff() {
        return this.coeficient;
    }

    public int getPutere() {
        return this.putere;
    }
}
