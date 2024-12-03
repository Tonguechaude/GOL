package model;

import java.util.ArrayList;
import java.util.List;

public class Motif {
    private final String nom;
    private final List<int[]> cellulesVivantes;

    public Motif(String nom, List<int[]> cellulesVivantes) {
        this.nom = nom;
        this.cellulesVivantes = cellulesVivantes;
    }

    public static Motif getMotifParNom(String nomMotif) {
        for (Motif motif : getMotifsPredefinis()) {
            if (motif.getNom().equalsIgnoreCase(nomMotif)) {
                return motif;
            }
        }
        throw new IllegalArgumentException("Motif introuvable : " + nomMotif);
    }

    public String getNom() {
        return nom;
    }

    public List<int[]> getCellulesVivantes() {
        return cellulesVivantes;
    }

    // Liste de motifs prédéfinis
    public static List<Motif> getMotifsPredefinis() {
        List<Motif> motifs = new ArrayList<>();

        // Oscillateur (Blinker)
        motifs.add(new Motif("Blinker", List.of(
                new int[]{10, 10}, new int[]{10, 11}, new int[]{10, 12}
        )));

        // Planeur (Glider)
        motifs.add(new Motif("Glider", List.of(
                new int[]{5, 5}, new int[]{6, 6}, new int[]{6, 7},
                new int[]{5, 7}, new int[]{4, 7}
        )));

        // Bloc (Still life)
        motifs.add(new Motif("Bloc", List.of(
                new int[]{15, 15}, new int[]{15, 16},
                new int[]{16, 15}, new int[]{16, 16}
        )));

        // R-pentomino
        motifs.add(new Motif("R-pentomino", List.of(
                new int[]{10, 10}, new int[]{10, 11}, new int[]{11, 11},
                new int[]{11, 12}, new int[]{12, 10}
        )));

        // Diehard
        motifs.add(new Motif("Diehard", List.of(
                new int[]{10, 10}, new int[]{10, 11}, new int[]{11, 11},
                new int[]{11, 12}, new int[]{12, 10}
        )));

        // Acorn
        motifs.add(new Motif("Acorn", List.of(
                new int[]{5, 5}, new int[]{6, 6}, new int[]{6, 7},
                new int[]{7, 7}, new int[]{8, 6}
        )));

        // Glider Gun !TODO ne marche pas
        motifs.add(new Motif("Glider-Gun", List.of(
                // Partie fixe du Glider Gun
                new int[]{15, 1}, new int[]{15, 2}, new int[]{16, 1}, new int[]{16, 2},
                new int[]{13, 3}, new int[]{14, 3}, new int[]{11, 4}, new int[]{12, 4},
                new int[]{13, 5}, new int[]{14, 5}, new int[]{12, 6}, new int[]{13, 6},
                new int[]{14, 6}, new int[]{15, 7}, new int[]{16, 7}, new int[]{17, 7},
                new int[]{17, 8}, new int[]{18, 8}, new int[]{16, 9}, new int[]{18, 9},
                new int[]{13, 10}, new int[]{14, 10}, new int[]{13, 11}, new int[]{14, 11},
                new int[]{14, 12}, new int[]{15, 13}, new int[]{16, 13}, new int[]{17, 13},
                new int[]{14, 14}, new int[]{15, 14}, new int[]{16, 14},

                // Partie mobile qui génère un glider à chaque itération
                new int[]{23, 7}, new int[]{23, 8}, new int[]{24, 7}, new int[]{24, 8},
                new int[]{21, 9}, new int[]{22, 9}, new int[]{21, 10}, new int[]{22, 10},
                new int[]{21, 11}, new int[]{22, 11}
        )));

        // Géniteur


        // RANDOM
        motifs.add(getMotifAleatoire(100,98));

        return motifs;
    }

    public static Motif getMotifAleatoire(int lignes, int colonnes) {
        List<int[]> cellulesVivantes = new ArrayList<>();

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                if (Math.random() < 0.5) {
                    cellulesVivantes.add(new int[]{i, j});
                }
            }
        }

        return new Motif("Motif Aleatoire", cellulesVivantes);
    }


}
