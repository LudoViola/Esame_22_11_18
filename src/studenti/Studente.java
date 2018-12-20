package studenti;


import carriera.Corso;
import carriera.Esame;
import carriera.PianoDiStudi;

public abstract class Studente {
    private String nome;
    private String cognome;
    private String matricola;
    private PianoDiStudi pianoDiStudi;

    public Studente(String nome, String cognome, String matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        pianoDiStudi =new PianoDiStudi();
    }

    public String getMatricola() {
        return matricola;
    }

    public void popolaPianoDiStudi(Corso... corsos) {
        for (Corso c:corsos) {
            Esame esame = new Esame(c);
            pianoDiStudi.aggiungiEsame(esame);
        }
    }

    public PianoDiStudi getPianoDiStudi() {
        return pianoDiStudi;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", matricola='" + matricola + '\'' +
                ", Piano Di Studi\n" + pianoDiStudi +
                '}';
    }

    public String getNome() {
        return cognome + " " + nome;
    }

    public String toString(boolean check) {
        String s = "";
        if(check) {
          s = cognome +" " + nome + " " + matricola;
        }
        return  s;
    }
}
