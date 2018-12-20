package GUI;

import carriera.Corso;
import eccezioni.CorsoNotFoundException;
import gestione.GestioneCarrieraUniversitaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IscrittiUnCorsoScreen extends JPanel implements ActionListener{

    private ButtonGroup group;
    private ArrayList<JRadioButton> buttons;
    private JButton backButton1;
    private JTextArea jTextField;
    private GestioneCarrieraUniversitaria gestione;

    public IscrittiUnCorsoScreen(GestioneCarrieraUniversitaria gestione) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        this.gestione = gestione;

        JPanel pannelloRadio = new JPanel();
        pannelloRadio.setLayout(new GridLayout(gestione.getCorsi().size(),1));
        pannelloRadio.setBackground(Color.BLACK);
        pannelloRadio.setForeground(Color.ORANGE);


        group = new ButtonGroup();
        buttons = new ArrayList<>();

        for (Corso c: gestione.getCorsi()) {
            JRadioButton jRadioButton = new JRadioButton(c.getNomeCorso());
            jRadioButton.setActionCommand(c.getNomeCorso());
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
        jTextField.setBackground(Color.BLACK);
        jTextField.setForeground(Color.ORANGE);
        jTextField.setFont(font1);

        JPanel pannelloTesto = new JPanel();
        pannelloTesto.setBackground(Color.BLACK);
        pannelloTesto.add(jTextField);




        backButton1 = new JButton("BACK");
        backButton1.setBackground(Color.BLACK);
        backButton1.setForeground(Color.ORANGE);
        backButton1.setPreferredSize(new Dimension(getWidth(),120));

        add(backButton1, BorderLayout.NORTH);
        add(pannelloRadio, BorderLayout.WEST);
        add(pannelloTesto, BorderLayout.CENTER);

    }

    private void aggiungiListeners(ActionListener listener) {
        for (JRadioButton b:buttons ) {
            b.addActionListener(listener);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Corso temp = null;
        for (Corso c: gestione.getCorsi()) {
            if(c.getNomeCorso().equals(e.getActionCommand())) {
                temp = c;
            }
        }
            try {
                jTextField.setText(gestione.mostraIscrittiAlCorso(temp));
            } catch (CorsoNotFoundException e1) {
                JOptionPane.showMessageDialog(this,e1.getMessage(),"ATTENZIONE",JOptionPane.ERROR_MESSAGE);
            }
        //jTextField.setText("ciao ciao");
    }

    public JButton getBackButton1() {
        return backButton1;
    }
}
