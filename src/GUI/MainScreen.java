package GUI;

import gestione.GestioneCarrieraUniversitaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame implements ActionListener {
    private final int LARGHEZZA = 700;
    private final int ALTEZZA = 500;

    private GestioneCarrieraUniversitaria gestione;

    private JPanel pannelloOpzioni;
    private JTextField jTextField;


    public MainScreen(GestioneCarrieraUniversitaria gestione) throws HeadlessException {
        this.gestione = gestione;
        setTitle("Gesione Università");
        setSize(LARGHEZZA,ALTEZZA);
        setResizable(false);
        setLayout(new BorderLayout());

        pannelloOpzioni = new JPanel();
        pannelloOpzioni.setLayout(new GridLayout(2,2));

        JButton elencoStudenti = new JButton("ELENCO STUDENTI ISCRITTI");
        elencoStudenti.setActionCommand("1");
        elencoStudenti.addActionListener(this);
        elencoStudenti.setBackground(Color.ORANGE);
        elencoStudenti.setForeground(Color.BLACK);
        pannelloOpzioni.add(elencoStudenti);

        JButton iscrittiAlCorso = new JButton("ELENCO STUDENTI ISCRITTI AD UN CORSO");
        iscrittiAlCorso.setActionCommand("2");
        iscrittiAlCorso.addActionListener(this);
        iscrittiAlCorso.setBackground(Color.ORANGE);
        iscrittiAlCorso.setForeground(Color.BLACK);
        pannelloOpzioni.add(iscrittiAlCorso);

        JButton mediaPonderataStudente = new JButton("MEDIA PONDERATA PER STUDENTE");
        mediaPonderataStudente.setActionCommand("3");
        mediaPonderataStudente.addActionListener(this);
        mediaPonderataStudente.setBackground(Color.ORANGE);
        mediaPonderataStudente.setForeground(Color.BLACK);
        pannelloOpzioni.add(mediaPonderataStudente);

        JButton media_complessiva_esame = new JButton("MEDIA COMPLESSIVA ESAME");
        media_complessiva_esame.setActionCommand("4");
        media_complessiva_esame.addActionListener(this);
        media_complessiva_esame.setBackground(Color.ORANGE);
        media_complessiva_esame.setForeground(Color.BLACK);
        pannelloOpzioni.add(media_complessiva_esame);

        add(pannelloOpzioni, BorderLayout.CENTER);

        Font font1 = new Font("SansSerif", Font.BOLD, 25);

        jTextField = new JTextField();
        jTextField.setEditable(false);
        jTextField.setBackground(Color.BLACK);
        jTextField.setForeground(Color.ORANGE);
        jTextField.setFont(font1);
        jTextField.setHorizontalAlignment(SwingConstants.CENTER);
        jTextField.setPreferredSize(new Dimension(LARGHEZZA,245));
        jTextField.setText("GESTIONE CARRIERA UNIVERSITARIA");

        add(jTextField, BorderLayout.NORTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = Integer.parseInt(e.getActionCommand());
        switch(i) {
            case 1:
                ElencoStudentiScreen elencoStudentiScreen = new ElencoStudentiScreen(gestione.elencoStudenti(),gestione.getListaStudenti());
                changeVisibility(false);
                this.add(elencoStudentiScreen);
                elencoStudentiScreen.getBackButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {
                        elencoStudentiScreen.setVisible(false);
                        MainScreen.this.changeVisibility(true);
                    }
                });
                break;
            case 2:
                IscrittiUnCorsoScreen iscrittiUnCorsoScreen = new IscrittiUnCorsoScreen(gestione);
                changeVisibility(false);
                this.add(iscrittiUnCorsoScreen);
                iscrittiUnCorsoScreen.getBackButton1().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {
                        iscrittiUnCorsoScreen.setVisible(false);
                        MainScreen.this.changeVisibility(true);
                    }
                });
                break;
            case 3:
                MediaPonderataScreen mediaPonderataScreen = new MediaPonderataScreen(gestione);
                changeVisibility(false);
                this.add(mediaPonderataScreen);
                mediaPonderataScreen.getBackButton1().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {
                        mediaPonderataScreen.setVisible(false);
                        MainScreen.this.changeVisibility(true);
                    }
                });
                break;
            case 4:
                MediaComplessivaCorsoScreen mediaComplessivaCorsoScreen = new MediaComplessivaCorsoScreen(gestione);
                changeVisibility(false);
                this.add(mediaComplessivaCorsoScreen);
                mediaComplessivaCorsoScreen.getBackButton1().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {
                        mediaComplessivaCorsoScreen.setVisible(false);
                        MainScreen.this.changeVisibility(true);
                    }
                });
                break;
        }

    }

    private void changeVisibility(boolean check) {
            this.jTextField.setVisible(check);
            this.pannelloOpzioni.setVisible(check);
    }
}
