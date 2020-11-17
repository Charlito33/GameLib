package fr.charlito33.gamelib.render;

import fr.charlito33.gamelib.math.ListsUtils;
import fr.charlito33.gamelib.window.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameGraphics {
    private GamePanel gamePanel;
    private final List<Drawable> renderList;
    private ShaderProgram shader;

    public GameGraphics() {
        renderList = new ArrayList<>();
        shader = null;
    }

    public void setGamePanel(GamePanel gp) {
        gamePanel = gp;
    }

    public List<Drawable> getRenderList() {
        return renderList;
    }

    public void paint(GamePanel gamePanel, Graphics g) {
        if (gamePanel == this.gamePanel) {
            //Paint default Background
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);

            //Render
            for (int index = 0; index < renderList.size(); index++) {
                Drawable drawable = renderList.get(index);

                if (drawable.isCorrect()) {
                    if (shader != null) {
                        g.setColor(shader.fragment(drawable.getColor()));
                    } else {
                        g.setColor(drawable.getColor());
                    }

                    int[] boundsX = ListsUtils.toArrayInt(drawable.getBoundsX());
                    int[] boundsY = ListsUtils.toArrayInt(drawable.getBoundsY());

                    if (shader != null) {
                        for (int i = 0; i < boundsX.length; i++) {
                            int result[] = shader.vertex(boundsX[i], boundsY[i]);
                            boundsX[i] = result[0];
                            boundsY[i] = result[1];
                        }
                    }

                    g.fillPolygon(boundsX, boundsY, drawable.getBoundsX().size());

                    if (drawable.isRemovedAfterUsed()) {
                        renderList.remove(drawable);
                    }
                }
            }
        }
    }

    public void add(Drawable drawable) {
        renderList.add(drawable);
    }

    public void setShader(ShaderProgram shader) {
        this.shader = shader;
    }
}
