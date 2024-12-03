package model;

public class Cellule {

    private boolean estVivant;
    
    public Cellule (boolean estVivant) {
        this.estVivant = estVivant;
    }

    public boolean estVivante() {
        return estVivant;
    }

    public void setEstVivant(boolean estVivant) {
        this.estVivant = estVivant;
    }
}
