package fr.charlito33.gamelib.window;

import fr.charlito33.gamelib.render.GameGraphics;
import fr.charlito33.gamelib.utils.RepeatedTask;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private GameGraphics gameGraphics;

    public GamePanel() {
        RepeatedTask task = new RepeatedTask(() -> {
            if (gameGraphics != null) {
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (gameGraphics != null) {
            gameGraphics.paint(this, g);
        }
    }

    public void setGraphics(GameGraphics g) {
        gameGraphics = g;
        g.setGamePanel(this);
    }
}


