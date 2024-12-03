package controlleur;

import model.JeuDeLaVie;
import vue.Fenetre;
import vue.Rendu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlleurJeu {
    private final JeuDeLaVie jeu;
    private final Rendu rendu;
    private final Timer timer;

    public ControlleurJeu(int lignes, int colonnes, int tailleCellule, int latence) {

        jeu = new JeuDeLaVie(lignes, colonnes);
        rendu = new Rendu(jeu.getGrille(), tailleCellule);

        initializePattern();

        timer = new Timer(latence, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jeu.prochaineGeneration();
                rendu.repaint();
            }
        });

        new Fenetre(rendu);
        timer.start();
    }

    public void initializePattern() {
        // Exemple : un oscillateur (motif Blinker)
        jeu.getGrille().setEtatCellule(10, 10, true);
        jeu.getGrille().setEtatCellule(10, 11, true);
        jeu.getGrille().setEtatCellule(10, 12, true);

        // Exemple : un planeur
        jeu.getGrille().setEtatCellule(5, 5, true);
        jeu.getGrille().setEtatCellule(6, 6, true);
        jeu.getGrille().setEtatCellule(6, 7, true);
        jeu.getGrille().setEtatCellule(5, 7, true);
        jeu.getGrille().setEtatCellule(4, 7, true);
    }

}
