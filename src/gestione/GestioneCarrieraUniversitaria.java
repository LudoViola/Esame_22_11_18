package gestione;

import carriera.PianoDiStudi;
import eccezioni.*;
import carriera.Corso;
import carriera.Esame;
import studenti.Studente;
import studenti.StudenteTriennale;

import java.util.*;


public class GestioneCarrieraUniversitaria {
    private Map<String, Studente> listaStudenti;
    private ArrayList<Corso> corsi;

    public GestioneCarrieraUniversitaria() {
        listaStudenti = new HashMap<>();
        corsi = new ArrayList<>();
    }

    public void aggiungiStudente(Studente studente) {
        listaStudenti.put(studente.getMatricola(), studente);
    }

    public void aggiungiCorso(Corso corso) {
        corsi.add(corso);
    }

    public void creaPianoDiStudi(Studente studente, Corso... corsos) {
        try {
            for (Corso c:corsos) {
                if(!(corsi.contains(c))) {
                    throw new CorsoNotFoundException();
                }
            }
            if (!(listaStudenti.containsKey(studente.getMatricola()))) {
                throw new StudenteNonPresenteException();
            }

            listaStudenti.get(studente.getMatricola()).popolaPianoDiStudi(corsos);

        }catch (StudenteNonPresenteException e) {
            System.out.println(e.getMessage());
        } catch (CorsoNotFoundException e) {
            e.printStackTrace();
        }

    }
    
    public void assegnaVoto(Studente studente, Corso corso, int voto) {
        try {
            if (!(listaStudenti.containsKey(studente.getMatricola()))) {
                throw new StudenteNonPresenteException();
            }
            if (voto > 31 || voto < 18) {
                throw new VotoNonValidoException();
            }
            Esame esame = new Esame(corso);
            if (!(studente.getPianoDiStudi().getEsami().contains(esame))) {
                throw new EsameNotFoundException();
            }
            for (Esame e: studente.getPianoDiStudi().getEsami()) {
                if(e.equals(esame)) {
                    e.setVoto(voto);
                }
            }
        } catch (VotoNonValidoException | EsameNotFoundException | StudenteNonPresenteException e) {
            e.printStackTrace();
        }
    }

    public String mostraIscrittiAlCorso(Corso corso) throws CorsoNotFoundException{
        StringBuilder builder = new StringBuilder();
            if(!(corsi.contains(corso))) {
                throw new CorsoNotFoundException();
            }
            String title = "Studenti Iscitti al corso di " + corso.getNomeCorso() + "\n";
            builder.append(title);
            String temp = "";
            for (Studente s : listaStudenti.values()) {
                Esame esame = new Esame(corso);
                if (s.getPianoDiStudi().getEsami().contains(esame)) {
                    temp = s.getNome() + "\n";
                    builder.append(temp);
                }
            }
            if (temp.equals("")) {
                builder.append("Nessuno studente è iscritto al corso");
            }

        return builder.toString();
    }

    public double calcolaMediaPonderata(Studente s) throws StudenteNonPresenteException,PianoDiStudiVuotoException {
        double mediaPonderata = 0;
            double tot = 0;
            double totCfu = 0;
            if (!(listaStudenti.containsKey(s.getMatricola()))) {
                throw new StudenteNonPresenteException();
            }
            if (s.getPianoDiStudi().getEsami().isEmpty()) {
                throw new PianoDiStudiVuotoException();
            }
        boolean check = true;
        for (Esame e:s.getPianoDiStudi().getEsami()) {
            if(e.getVoto() != 0) {
                check = false;
            }
        }
            if(check) {
                throw new PianoDiStudiVuotoException("Nessun Esame Superato");
            }


            if(s instanceof StudenteTriennale && s.getPianoDiStudi().getEsami().size() > 2) {
                ArrayList<Esame> esamiMenoVotiPeggiori = new ArrayList<>(s.getPianoDiStudi().getEsami());

                esamiMenoVotiPeggiori.removeIf(e -> e.getVoto() == 0);
                esamiMenoVotiPeggiori.sort(Esame::compareTo);
                if(esamiMenoVotiPeggiori.size()>2) {
                    for (int i = 0; i < esamiMenoVotiPeggiori.size(); i++) {
                        if (i < 2) {
                            if(i==1) {
                                esamiMenoVotiPeggiori.remove(i-1);
                            }
                            else {
                                esamiMenoVotiPeggiori.remove(i);
                            }
                        }
                    }
                    for (Esame e : esamiMenoVotiPeggiori) {
                        if (e.getVoto() != 0) {
                            tot += (e.getVoto() * e.getCorso().getCfu());
                            totCfu += e.getCorso().getCfu();
                        }
                    }
                }else {
                    for (Esame e : s.getPianoDiStudi().getEsami()) {
                        if (e.getVoto() != 0) {
                            tot += (e.getVoto() * e.getCorso().getCfu());
                            totCfu += e.getCorso().getCfu();
                        }
                    }
                }
            }
            else {
                for (Esame e : s.getPianoDiStudi().getEsami()) {
                    if (e.getVoto() != 0) {
                        tot += (e.getVoto() * e.getCorso().getCfu());
                        totCfu += e.getCorso().getCfu();
                    }
                }
            }
            mediaPonderata = tot/totCfu;

        
        
        return  mediaPonderata;
    }

    public double mediaComplessivaEsame(Corso corso) throws CorsoNotFoundException, ArithmeticException {
        double tot = 0;
        int counter = 0;

                if (!(corsi.contains(corso))) {
                    throw new CorsoNotFoundException();
                }
                for (Studente s : listaStudenti.values()) {
                    Esame esame = new Esame(corso);
                    for (Esame e : s.getPianoDiStudi().getEsami()) {
                        if (e.equals(esame) && e.getVoto() != 0) {
                            tot += e.getVoto();
                            counter++;
                        }
                    }

                }
                if (counter == 0){
                    throw new ArithmeticException("Nessuno studente ha superato l'esame");
            }
            tot /= counter;


            return tot;
    }

    @Override
    public String toString() {
        return "Gestione Carriera Universitaria\n" +
                "Lista Studenti\n" + listaStudenti.values() ;
    }

    public ArrayList<String> elencoStudenti() {
        ArrayList<String> elenco = new ArrayList<>();
        for (Studente s: listaStudenti.values()
             ) {
            elenco.add(s.toString(true));
        }
        return elenco;
    }

    public Map<String, Studente> getListaStudenti() {
        return listaStudenti;
    }

    public ArrayList<Corso> getCorsi() {
        return corsi;
    }
}

