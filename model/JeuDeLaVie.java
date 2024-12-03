package model;

public class JeuDeLaVie {
    private Grille grille;

    public JeuDeLaVie(int rows, int cols) {
        this.grille = new Grille(rows, cols);
    }

    public Grille getGrille() {
        return grille;
    }

    public void prochaineGeneration() {
        grille.update();
    }
}
