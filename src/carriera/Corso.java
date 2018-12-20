package carriera;

public class Corso {
    private String nomeCorso;
    private int cfu;
    private String codIdentificativo;

    public Corso(String nomeCorso, int cfu, String codIdentificativo) {
        this.nomeCorso = nomeCorso;
        this.cfu = cfu;
        this.codIdentificativo = codIdentificativo;
    }

    public String getNomeCorso() {
        return nomeCorso;
    }

    public int getCfu() {
        return cfu;
    }

    @Override
    public String toString() {
        return "Corso{" +
                "nomeCorso='" + nomeCorso + '\'' +
                ", cfu=" + cfu +
                ", codIdentificativo='" + codIdentificativo + '\'' +
                '}';
    }
}
