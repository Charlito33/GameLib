package fr.charlito33.gamelib.render;

import java.awt.*;

public class ShaderProgram {
    private ShaderRunnable runnable;

    public ShaderProgram(ShaderRunnable runnable) {
        this.runnable = runnable;
    }

    public int[] vertex(int x, int y) {
        return runnable.vertex(x, y);
    }

    public Color fragment(Color color) {
        return runnable.fragment(color);
    }
}
