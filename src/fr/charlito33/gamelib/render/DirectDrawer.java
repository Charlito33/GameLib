package fr.charlito33.gamelib.render;

import java.awt.*;

public class DirectDrawer {
    private GameGraphics gameGraphics;

    public DirectDrawer(GameGraphics gameGraphics) {
        this.gameGraphics = gameGraphics;
    }

    public void draw(Color color, int... bounds) {
        Drawable drawable = new Drawable(color, true);
        drawable.addBounds(bounds);

        gameGraphics.add(drawable);
    }
}
