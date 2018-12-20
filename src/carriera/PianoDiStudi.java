package carriera;

import java.util.ArrayList;

public class PianoDiStudi {
    private ArrayList<Esame> esami;

    public PianoDiStudi() {
        esami = new ArrayList<>();
    }

    public void aggiungiEsame(Esame esame) {
        esami.add(esame);
    }

    public void aggiungiEsame(Esame esame, int voto) {
        esame.setVoto(voto);
        esami.add(esame);
    }

    public ArrayList<Esame> getEsami() {
        return esami;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        String temp = "";

        for (Esame e:esami) {
            if(e.getVoto() == 0) {
                temp = e.getCorso() + "\n";
            }
            else {
                temp = e.getCorso() + " voto:" + e.getVoto() + "\n";
            }
            s.append(temp);
        }
        return s.toString();
    }
}
