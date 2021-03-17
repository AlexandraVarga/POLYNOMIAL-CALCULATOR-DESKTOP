package model;


import java.util.*;

public class Polinom {

    String[] monomStr;
    ArrayList<Monom> monom = new ArrayList<Monom>();
    public int x;

    public Polinom(String[] monomStr, int x) {
        this.monomStr = monomStr;
        this.x = x;
        for (String s : monomStr) {
            //System.out.println(s);
            monom.add(new Monom(s));
        }
        for (Monom temp : monom) {
            //temp.afisareInt();
        }
        this.sortareDescrescator();
    }

    private Polinom(int x) {
        this.x = x;
    }

    private Polinom(Monom m, int x) {
        this.x = x;
        this.monom.add(m);
    }

    public Polinom adunarePolinom(Polinom poli2) {

        Polinom poli3 = new Polinom(x);
        for (int i = 0; i < this.monom.size(); i++) {

            int p1 = this.monom.get(i).getPutere();
            int c1 = this.monom.get(i).getCoeff();
            int i_pow = poli2.getIndexPutere(p1);

            if (i_pow == -1) {
                poli3.monom.add(new Monom(c1, p1));
            } else {

                int p3 = poli2.monom.get(i_pow).getPutere();
                int c3 = poli2.monom.get(i_pow).getCoeff();
                poli3.monom.add(new Monom(c1 + c3, p3));
                poli2.monom.remove(i_pow);
            }
        }

        for (int j = 0; j < poli2.monom.size(); j++) {
            int p2 = poli2.monom.get(j).getPutere();
            int c2 = poli2.monom.get(j).getCoeff();
            poli3.monom.add(new Monom(c2, p2));
        }
        return poli3;
    }

    //inmultesc polinom cu -1 apoi adun (acelasi algoritm)
    public Polinom scaderePolinom(Polinom poli2) {
        Polinom poli3;
        for (int i = 0; i < poli2.monom.size(); i++) {
            poli2.monom.get(i).coeficient = poli2.monom.get(i).coeficient * (-1);
        }
        poli3 = this.adunarePolinom(poli2);
        poli3.clean();
        return poli3;
    }

    public Polinom inmultirePolinom(Polinom poli2) {
        Polinom poli3 = new Polinom(x);
        for (int i = 0; i < this.monom.size(); i++) {
            Monom m1 = this.monom.get(i);
            for (int j = 0; j < poli2.monom.size(); j++) {
                Monom m2 = poli2.monom.get(j);
                Monom m3 = m1.inmultireMonom(m2);
                poli3.monom.add(m3);
            }
        }
        poli3.sortareDescrescator();
        return poli3;
    }

    public ArrayList<Polinom> impartirePolinom(Polinom impartitor) {
        ArrayList<Polinom> polis = new ArrayList<Polinom>();
        Polinom cat = new Polinom(x);
        Polinom rest = new Polinom(x);
        rest = this;
        if (rest.getGrad() < impartitor.getGrad()) {
            cat.monom.add(new Monom(0, 0));
        } else {
            while (rest.getGrad() >= impartitor.getGrad()) {
                Monom dm = cautaMaxim(rest);
                Monom im = cautaMaxim(impartitor);
                Monom m = dm.impartireMonom(im);
                Polinom pm = new Polinom(m, x);
                cat.monom.add(m);
                rest = rest.scaderePolinom(impartitor.inmultirePolinom(pm));
            }
        }
        if (rest.monom.isEmpty()) rest.monom.add(new Monom(0, 0));
        polis.add(cat);
        polis.add(rest);
        return polis;
    }

    public void derivarePolinom() {
        for (Monom value : this.monom) {
            value.derivareMonom();
        }
    }

    public void integrarePolinom() {
        for (Monom value : this.monom) {
            value.integrareMonom();
        }
    }

    public String afisareInteger() {

        this.monom.sort(Collections.reverseOrder(Monom.getCompByPutere()));

        String display_pol = "";
        for (int i = 0; i < monom.size(); i++) {
            if (monom.get(i).coeficient < 0) {
                display_pol += monom.get(i).getMonomInt();
            } else {
                if (monom.get(i).coeficient == 0) {
                    display_pol += "";
                } else {
                    display_pol += (i == 0) ? monom.get(i).getMonomInt() : "+" + monom.get(i).getMonomInt();
                }
            }
        }
        return display_pol;
    }

    public String afisareDouble() {

        this.monom.sort(Collections.reverseOrder(Monom.getCompByPutere()));

        String display_pol = "";
        for (int i = 0; i < monom.size(); i++) {
            if (monom.get(i).doubleCoef < 0) {
                display_pol += monom.get(i).getMonom();
            } else {
                display_pol += (i == 0) ? monom.get(i).getMonom() : "+" + monom.get(i).getMonom();

            }
        }
        return display_pol;
    }


    private void sortareDescrescator() {
        for (int i = 0; i < monom.size(); i++) {
            int putere = monom.get(i).getPutere();
            for (int j = i + 1; j < monom.size(); j++) {
                int temp_putere = monom.get(j).getPutere();
                if (putere == temp_putere) {
                    monom.get(i).adunareCoeficient(monom.get(j).getCoeff());
                    this.monom.remove(j);
                }
            }
        }
        this.monom.sort(Monom.getCompByPutere());
    }

    public int getGrad() {
        int c = -1;
        for (Monom value : monom) {
            if (c < value.getPutere()) c = value.getPutere();
        }
        return c;
    }

    private Monom cautaMaxim(Polinom pol) {
        int putere = pol.getGrad();
        int iP = pol.getIndexPutere(putere);
        return pol.monom.get(iP);
    }

    private int getIndexPutere(int putere) {
        for (int i = 0; i < monom.size(); i++) {
            Monom mon = monom.get(i);
            if (putere == mon.getPutere())
                return i;
        }
        return -1;
    }

    private void clean() {
        for (int i = 0; i < monom.size(); i++) {
            if (monom.get(i).coeficient == 0) monom.remove(i);
        }
    }
}
