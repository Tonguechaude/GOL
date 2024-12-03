package vue;

import javax.swing.*;

public class Fenetre extends JFrame {
    public Fenetre(JPanel gamePanel) {
        setTitle("Jeu de la Vie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(gamePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
