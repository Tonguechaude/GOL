package controlleur;

import model.JeuDeLaVie;
import model.Motif;
import vue.Fenetre;
import vue.Rendu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlleurJeu implements ActionListener {

    private final JeuDeLaVie jeu;
    private final Rendu rendu;
    private final Fenetre fenetre;
    private Timer timer;
    private final int[] vitesses = {1, 2, 10, 100};
    private int indexVitesse = 0; // Index dans le tableau des vitesses


    public ControlleurJeu(int lignes, int colonnes, int tailleCellule) {
        jeu = new JeuDeLaVie(lignes, colonnes);
        rendu = new Rendu(jeu.getGrille(), tailleCellule);

        // Liste des motifs
        var motifs = Motif.getMotifsPredefinis();
        var nomsMotifs = motifs.stream().map(Motif::getNom).toList();

        // Fenêtre avec contrôles
        fenetre = new Fenetre(rendu, nomsMotifs, this);

        // Initialisation du timer
        int delaisInit = 1000 / vitesses[indexVitesse]; // Le délai de départ correspond à vitesses[0]
        timer = new Timer(delaisInit, e -> {
            jeu.prochaineGeneration();
            rendu.repaint();
        });

        // Initialiser la grille avec le motif Glider par défaut
        appliquerMotif("Glider");
    }

    // Méthode pour appliquer un motif donné
    private void appliquerMotif(String nomMotif) {
        Motif motif = Motif.getMotifParNom(nomMotif);
        jeu.getGrille().clear();
        assert motif != null;
        for (int[] cellule : motif.getCellulesVivantes()) {
            jeu.getGrille().setEtatCellule(cellule[0], cellule[1], true);
        }
        rendu.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == fenetre.getBoutonVitesse()) {
            // Gestion de la vitesse
            indexVitesse = (indexVitesse + 1) % vitesses.length; // Passer au multiplicateur suivant
            int nouvelleVitesse = vitesses[indexVitesse];
            timer.setDelay(1000 / nouvelleVitesse); // Ajuste le délai du timer
            fenetre.getBoutonVitesse().setText("Vitesse : ×" + nouvelleVitesse); // Met à jour le texte du bouton
        } else if (source == fenetre.getBoutonLancer()) {
            // Lancer le jeu
            timer.start();
        } else if (source == fenetre.getBoutonPause()) {
            // Mettre en pause
            timer.stop();
        } else if (source == fenetre.getBoutonReinitialiser()) {
            // Réinitialiser la grille
            jeu.getGrille().clear();
            rendu.repaint();
        } else if (source == fenetre.getChoixMotif()) {
            // Initialiser un motif choisi
            String nomMotif = (String) fenetre.getChoixMotif().getSelectedItem();
            Motif motif = Motif.getMotifParNom(nomMotif);
            jeu.getGrille().clear(); // Vider la grille avant d'appliquer le motif
            assert motif != null;
            for (int[] cellule : motif.getCellulesVivantes()) {
                jeu.getGrille().setEtatCellule(cellule[0], cellule[1], true);
            }
            rendu.repaint();
        } else if (source == fenetre.getBoutonInverserCouleurs()) {
            // Inverser les couleurs
            rendu.inverserCouleurs();
        }
    }

    public JeuDeLaVie getJeu() {
        return jeu;
    }
}
