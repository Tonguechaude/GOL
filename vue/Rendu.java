package vue;

import model.Grille;

import javax.swing.*;
import java.awt.*;

public class Rendu extends JPanel {
    private final Grille grille;
    private final int tailleCellule;

    public Rendu(Grille grid, int tailleCellule) {
        this.grille = grid;
        this.tailleCellule = tailleCellule;
        setPreferredSize(new Dimension(grid.getColonnes() * tailleCellule, grid.getLignes() * tailleCellule));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < grille.getLignes(); i++) {
            for (int j = 0; j < grille.getColonnes(); j++) {
                if (grille.getCellule(i, j).estVivante()) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j * tailleCellule, i * tailleCellule, tailleCellule, tailleCellule);
                g.setColor(Color.GRAY);
                g.drawRect(j * tailleCellule, i * tailleCellule, tailleCellule, tailleCellule);
            }
        }
    }
}
