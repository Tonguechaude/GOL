package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class Fenetre extends JFrame {
    private final JButton boutonVitesse = new JButton("Vitesse : ×1");
    private final JComboBox<String> choixMotif;
    private final JButton boutonLancer = new JButton("Lancer");
    private final JButton boutonPause = new JButton("Pause");
    private final JButton boutonReinitialiser = new JButton("Réinitialiser");
    private final JButton boutonInverserCouleurs = new JButton("Inverser les couleurs");

    public Fenetre(JPanel gamePanel, List<String> nomsMotifs, ActionListener actionListener) {
        setTitle("Jeu de la Vie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panneau de contrôle
        JPanel controles = new JPanel();
        choixMotif = new JComboBox<>(nomsMotifs.toArray(new String[0]));
        choixMotif.addActionListener(actionListener);
        boutonLancer.addActionListener(actionListener);
        boutonPause.addActionListener(actionListener);
        boutonReinitialiser.addActionListener(actionListener);
        boutonVitesse.addActionListener(actionListener);
        boutonInverserCouleurs.addActionListener(actionListener);


        controles.add(new JLabel("Motif :"));
        controles.add(choixMotif);
        controles.add(boutonVitesse);
        controles.add(boutonLancer);
        controles.add(boutonPause);
        controles.add(boutonReinitialiser);
        controles.add(boutonInverserCouleurs);

        // Organisation de la fenêtre
        setLayout(new BorderLayout());
        add(gamePanel, BorderLayout.CENTER);
        add(controles, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JButton getBoutonVitesse() {
        return boutonVitesse;
    }

    public JComboBox<String> getChoixMotif() {
        return choixMotif;
    }

    public JButton getBoutonLancer() {
        return boutonLancer;
    }

    public JButton getBoutonPause() {
        return boutonPause;
    }

    public JButton getBoutonReinitialiser() {
        return boutonReinitialiser;
    }

    public JButton getBoutonInverserCouleurs() {
        return boutonInverserCouleurs;
    }
}
