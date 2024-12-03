package model;

public class JeuDeLaVie {
    private Grille grille;

    public JeuDeLaVie(int lignes, int colonnes) {
        this.grille = new Grille(lignes, colonnes);
    }

    public Grille getGrille() {
        return grille;
    }

    public void prochaineGeneration() {
        grille.maj();
    }
}
