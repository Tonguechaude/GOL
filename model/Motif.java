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

        return motifs;
    }
}
