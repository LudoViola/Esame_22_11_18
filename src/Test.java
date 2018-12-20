import GUI.MainScreen;
import carriera.Corso;
import gestione.GestioneCarrieraUniversitaria;
import studenti.Studente;
import studenti.StudenteMagistrale;
import studenti.StudenteTriennale;

public class Test {
    public static void main(String[] args) {
        GestioneCarrieraUniversitaria gestione = new GestioneCarrieraUniversitaria();
        Corso fisica1 = new Corso("Fisica 1", 9, "FIS1");
        Corso analisi1 = new Corso("Analisi 1", 9, "MAT1");
        Corso economia = new Corso("Economia", 6, "ECO");
        Corso fondamentiDiInformatica = new Corso("Fondamenti di Informatica", 12, "INF");
        Corso analisi2 = new Corso("Analisi 2", 9, "MAT1");
        Corso fisica2 = new Corso("Fisica 2", 9, "FIS1");

        Studente giuseppe = new StudenteTriennale("Giuseppe", "Verdi", "436102");
        Studente achille = new StudenteTriennale("Achille", "Mazzoldi", "436103");
        Studente manlio = new StudenteTriennale("Manlio", "Rossi", "436107");
        Studente eusebio = new StudenteTriennale("Eusebio", "Leopoldi", "436109");
        Studente maria = new StudenteTriennale("Maria", "Verdi", "436110");
        Studente filippo = new StudenteTriennale("Filippo", "Branduardi", "436113");
        Studente giovanni = new StudenteTriennale("Giovanni", "Bombino", "436125");
        Studente eleonora = new StudenteTriennale("Eleonora", "Pazzi", "436138");


        gestione.aggiungiCorso(fisica1);
        gestione.aggiungiCorso(fisica2);
        gestione.aggiungiCorso(analisi1);
        gestione.aggiungiCorso(analisi2);
        gestione.aggiungiCorso(economia);
        gestione.aggiungiCorso(fondamentiDiInformatica);

        gestione.aggiungiStudente(giuseppe);
        gestione.aggiungiStudente(achille);
        gestione.aggiungiStudente(manlio);
        gestione.aggiungiStudente(eusebio);
        gestione.aggiungiStudente(maria);
        gestione.aggiungiStudente(filippo);
        gestione.aggiungiStudente(giovanni);
        gestione.aggiungiStudente(eleonora);


        gestione.creaPianoDiStudi(achille,fisica1,analisi1);
        gestione.creaPianoDiStudi(giuseppe, fisica1, analisi1, fondamentiDiInformatica,economia, analisi2);
        gestione.creaPianoDiStudi(eusebio, fisica1, analisi1, fondamentiDiInformatica,fisica2);
        gestione.creaPianoDiStudi(manlio, fisica1, analisi1, fondamentiDiInformatica,economia, analisi2);
        gestione.creaPianoDiStudi(maria, fisica1, analisi1, fondamentiDiInformatica,economia, analisi2);
        gestione.creaPianoDiStudi(filippo, fisica1, fisica2,economia, analisi2);
        gestione.creaPianoDiStudi(giovanni, fisica1, analisi1, fondamentiDiInformatica,economia, analisi2);
        gestione.creaPianoDiStudi(eleonora, fisica1, analisi1, fisica2,economia, analisi2);

        gestione.assegnaVoto(giuseppe,fisica1, 18);
        gestione.assegnaVoto(giuseppe,analisi1, 30);
        gestione.assegnaVoto(giuseppe,analisi2, 30);
        gestione.assegnaVoto(giuseppe,fondamentiDiInformatica, 24);

        gestione.assegnaVoto(achille,fisica1,30);
        gestione.assegnaVoto(achille,analisi1,22);

        gestione.assegnaVoto(manlio,analisi1, 27);
        gestione.assegnaVoto(giovanni,analisi1, 21);
        gestione.assegnaVoto(eleonora,analisi1, 29);
        gestione.assegnaVoto(maria,analisi1, 18);

        gestione.assegnaVoto(eusebio,fisica2, 27);
        gestione.assegnaVoto(filippo,fisica2, 21);
        gestione.assegnaVoto(eleonora,fisica2, 29);


        MainScreen mainScreen = new MainScreen(gestione);
        mainScreen.setVisible(true);
    }
}
