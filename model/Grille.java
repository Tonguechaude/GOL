package model;

public class Grille {
    private final int lignes;
    private final int colonnes;
    private Cellule[][] cellules;

    public Grille(int ligne, int colonne) {
        this.lignes = ligne;
        this.colonnes = colonne;
        this.cellules = new Cellule[ligne][colonne];

        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                cellules[i][j] = new Cellule(false);
            }
        }
    }

    public void setEtatCellule(int ligne, int colonne, boolean estVivant) {
        if (ligne >= 0 && ligne < lignes && colonne >= 0 && colonne < colonnes) {
            cellules[ligne][colonne].setEstVivant(estVivant);
        }
    }

    public Cellule getCellule(int ligne, int colonne) {
        if (ligne >= 0 && ligne < lignes && colonne >= 0 && colonne < colonnes) {
            return cellules[ligne][colonne];
        }
        return new Cellule(false);
    }

    public void update() {
        Cellule[][] nouvelleGrille = new Cellule[lignes][colonnes];

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                int voisinesEnVies = compterVoisineEnVie(i, j);
                boolean enVie = cellules[i][j].estVivante()
                        ? (voisinesEnVies == 2 || voisinesEnVies == 3)
                        : (voisinesEnVies == 3);

                nouvelleGrille[i][j] = new Cellule(enVie);
            }
        }
        cellules = nouvelleGrille;
    }

    private int compterVoisineEnVie(int ligne, int colonne) {
        int compteur = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                if (getCellule(ligne + i, colonne + j).estVivante()) {
                    compteur++;
                }
            }
        }
        return compteur;
    }

    public int getLignes() {
        return lignes;
    }

    public int getColonnes() {
        return colonnes;
    }

    public Cellule[][] getCellules() {
        return cellules;
    }

}
