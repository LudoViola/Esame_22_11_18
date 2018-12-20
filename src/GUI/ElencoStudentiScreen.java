package GUI;

import studenti.Studente;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class ElencoStudentiScreen extends JPanel implements ListSelectionListener {

    private JButton backButton;

    private Map<String,Studente> studenti;

    private JList<String> elenco_studenti;

    private ArrayList<Studente> studenteArrayList;

    public ElencoStudentiScreen(ArrayList<String> elenco, Map<String,Studente> studenti) {
        this.studenteArrayList = new ArrayList<>();
        studenteArrayList.addAll(studenti.values());
        this.studenti = studenti;

        setLayout(new BorderLayout());

        String[] elenco1 = new String[elenco.size()];
        int i = 0;
        for (String s:elenco) {
            elenco1[i] = s;
            i++;
        }

        Font font1 = new Font("SansSerif", Font.BOLD, 21);


        elenco_studenti = new JList<>(elenco1);
        elenco_studenti.setBackground(Color.ORANGE);
        elenco_studenti.setForeground(Color.BLACK);
        elenco_studenti.setFont(font1);
        elenco_studenti.addListSelectionListener(this);

        add(elenco_studenti,BorderLayout.CENTER);

        backButton = new JButton("BACK");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.ORANGE);
        backButton.setPreferredSize(new Dimension(getWidth(),120));
        add(backButton, BorderLayout.NORTH);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int index = elenco_studenti.getSelectedIndex();

        JOptionPane.showMessageDialog(this, studenteArrayList.get(index), studenteArrayList.get(index).getNome(),JOptionPane.INFORMATION_MESSAGE);

    }

    public JButton getBackButton() {
        return backButton;
    }
}
