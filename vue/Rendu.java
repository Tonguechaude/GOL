package vue;

import model.Grille;

import javax.swing.*;
import java.awt.*;

public class Rendu extends JPanel {
    private final Grille grille;
    private final int tailleCellule;

    public Rendu(Grille grille, int tailleCellule) {
        this.grille = grille;
        this.tailleCellule = tailleCellule;
        setPreferredSize(new Dimension(grille.getColonnes() * tailleCellule, grille.getLignes() * tailleCellule));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < grille.getLignes(); i++) {
            for (int j = 0; j < grille.getColonnes(); j++) {
                if (grille.getCellule(i, j).estVivante()) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(j * tailleCellule, i * tailleCellule, tailleCellule, tailleCellule);
                g.setColor(Color.GRAY);
                g.drawRect(j * tailleCellule, i * tailleCellule, tailleCellule, tailleCellule);
            }
        }
    }
}
