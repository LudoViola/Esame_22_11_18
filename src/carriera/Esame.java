package carriera;

import java.util.Objects;

public class Esame implements Comparable<Esame> {
    private Corso corso;
    private int voto;

    public Esame(Corso corso) {
        this.corso = corso;
        setVoto(0);
    }


    public void setVoto(int voto) {
        this.voto = voto;
    }

    public int getVoto() {
        return voto;
    }

    public Corso getCorso() {
        return corso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Esame esame = (Esame) o;
        return Objects.equals(corso, esame.corso);
    }

    @Override
    public int compareTo(Esame o) {
        return Integer.compare(this.voto,o.voto);
    }
}
