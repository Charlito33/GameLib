package fr.charlito33.gamelib.render;

import java.awt.*;

public interface ShaderRunnable {
    default int[] vertex(int x, int y) {
        return new int[]{x, y};
    }

    default Color fragment(Color color) {
        return color;
    };
}
