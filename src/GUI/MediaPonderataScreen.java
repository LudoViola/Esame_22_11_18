package GUI;

import eccezioni.PianoDiStudiVuotoException;
import eccezioni.StudenteNonPresenteException;
import gestione.GestioneCarrieraUniversitaria;
import studenti.Studente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MediaPonderataScreen extends JPanel implements ActionListener{

    private ButtonGroup group;
    private ArrayList<JRadioButton> buttons;
    private JButton backButton1;
    private JTextArea jTextField;
    private GestioneCarrieraUniversitaria gestione;

    public MediaPonderataScreen(GestioneCarrieraUniversitaria gestione) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        this.gestione = gestione;

        JPanel pannelloRadio = new JPanel();
        pannelloRadio.setLayout(new GridLayout(gestione.getCorsi().size(),1));
        pannelloRadio.setBackground(Color.BLACK);
        pannelloRadio.setForeground(Color.ORANGE);


        group = new ButtonGroup();
        buttons = new ArrayList<>();

        for (Studente s: gestione.getListaStudenti().values()) {
            JRadioButton jRadioButton = new JRadioButton(s.getNome());
            jRadioButton.setActionCommand(s.getNome());
            jRadioButton.addActionListener(this);
            jRadioButton.setBackground(Color.BLACK);
            jRadioButton.setForeground(Color.ORANGE);

            group.add(jRadioButton);
            buttons.add(jRadioButton);
            pannelloRadio.add(jRadioButton);
        }

       // aggiungiListeners(this);

        Font font1 = new Font("SansSerif", Font.PLAIN, 18);

        jTextField = new JTextArea();
        jTextField.setEditable(false);
        jTextField.setLineWrap(true);
        jTextField.setWrapStyleWord(true);
        jTextField.setBackground(Color.BLACK);
        jTextField.setForeground(Color.ORANGE);
        jTextField.setFont(font1);

        JPanel pannelloTesto = new JPanel();
        pannelloTesto.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(jTextField);
        pannelloTesto.setBackground(Color.BLACK);
        pannelloTesto.add(scrollPane, BorderLayout.CENTER);


        backButton1 = new JButton("BACK");
        backButton1.setBackground(Color.BLACK);
        backButton1.setForeground(Color.ORANGE);
        backButton1.setPreferredSize(new Dimension(getWidth(),120));

        add(backButton1, BorderLayout.NORTH);
        add(pannelloRadio, BorderLayout.WEST);
        add(pannelloTesto, BorderLayout.CENTER);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Studente temp = null;
        for (Studente s:gestione.getListaStudenti().values()) {
            if(s.getNome().equals(e.getActionCommand())) {
                temp = s;
            }
        }
        DecimalFormat format = new DecimalFormat("#.##");
        try {
            assert temp != null;
            String s = "La media ponderata di:\n" + temp.getNome() + "\n\n" + format.format(gestione.calcolaMediaPonderata(temp)) ;
            jTextField.setText(s);
        } catch (StudenteNonPresenteException | PianoDiStudiVuotoException e1) {
            JOptionPane.showMessageDialog(this,e1.getMessage(),"ATTENZIONE",JOptionPane.ERROR_MESSAGE);
        }

    }

    public JButton getBackButton1() {
        return backButton1;
    }
}
