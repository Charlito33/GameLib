package fr.charlito33.gamelib.render;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Drawable {
    private List<Integer> boundsX;
    private List<Integer> boundsY;

    private Color color;

    private boolean removeAfterUsed;

    public Drawable(Color color, boolean removeAfterUsed) {
        boundsX = new ArrayList<>();
        boundsY = new ArrayList<>();

        this.color = color;
        this.removeAfterUsed = removeAfterUsed;
    }

    public Drawable(Color color) {
        this(color, false);
    }

    public Drawable addBounds(int... bounds) {
        for (int i = 0; i < bounds.length; i += 2) {
            addBounds(bounds[i], bounds[i + 1]);
        }

        return this;
    }

    public Drawable addBounds(int boundX, int boundY) {
        boundsX.add(boundX);
        boundsY.add(boundY);

        return this;
    }

    public Drawable updateBounds(int id, int newBoundX, int newBoundY) {
        boundsX.set(id, newBoundX);
        boundsY.set(id, newBoundY);

        return this;
    }

    public boolean isCorrect() {
        return boundsX.size() == boundsY.size();
    }

    public List<Integer> getBoundsX() {
        return boundsX;
    }

    public List<Integer> getBoundsY() {
        return boundsY;
    }

    public Color getColor() {
        return color;
    }

    public boolean isRemovedAfterUsed() {
        return removeAfterUsed;
    }
}
