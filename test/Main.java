import fr.charlito33.gamelib.render.*;
import fr.charlito33.gamelib.utils.RepeatedTask;
import fr.charlito33.gamelib.window.GameFrame;
import fr.charlito33.gamelib.window.GamePanel;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //Create Frame + Panel
        GameFrame gameFrame = new GameFrame("Game", 480, 320);
        GamePanel gamePanel = new GamePanel();

        //Add panel to frame and show the frame
        gameFrame.add(gamePanel);
        gameFrame.setVisible(true);

        //Create GameGraphics (The main component for drawing)
        GameGraphics gameGraphics = new GameGraphics();

        //Add graphics to panel
        gamePanel.setGraphics(gameGraphics);

        //Let's draw a simple rectangle !
        Drawable rectangle = new Drawable(Color.red);
        rectangle.addBounds(0, 0) //First bound pos (x, y)
                .addBounds(100, 0) //Second bound pos...
                .addBounds(100, 100) //Third...
                .addBounds(0, 100);

        //Let's draw a triangle but with other method
        Drawable triangle = new Drawable(Color.white);
        triangle.addBounds(0, 0, 100, 50, 100, 100); //Like add bounds but format (bx0, by0, bx1, by1, ...)

        //Add Drawables to the graphics
        gameGraphics.add(rectangle); //Warning Order is Important
        gameGraphics.add(triangle); //So Rectangle will draw first and the triangle next

        //Let's introduce shaders !
        //Create the Shader Runnable (The code with the methods)
        ShaderRunnable shaderRunnable = new ShaderRunnable() {
            @Override
            public int[] vertex(int x, int y) { //Define the "vertex" shader, gives you the pos x and y of the bound
                return new int[]{x+10, y+10}; //And you return it with your modifications in format : {x, y}
            }

            @Override
            public Color fragment(Color color) { //Create the "fragment" shader, gives you the Color
                return new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()); //And you return it with your modifications
            }

            //It's not needed to Override all methods
        };

        //Create the Shader Program
        ShaderProgram shaderProgram = new ShaderProgram(shaderRunnable);

        //Finally, add shader to Game Graphics
        gameGraphics.setShader(shaderProgram);

        //Introducing Direct Drawer
        DirectDrawer directDrawer = new DirectDrawer(gameGraphics);

        //Let's create a task who will execute at 60 frames per seconds; See wiki for more information
        RepeatedTask repeatedTask = new RepeatedTask(() -> {
            //And now you can directly draw a Polygon
            directDrawer.draw(Color.CYAN,50, 50,
                                                 75, 50,
                                                 50, 75);

            /*
                /!\ This code is like to :
                - Create new Drawable with Color
                - Add Bounds
                - Add to render list (Same as "normal" drawables)
                -> But when you render it, it will delete

                So the order is important too !
             */
        }); //The Repeated Task auto-run, so you don't need to use a method like repeatedTask.run(); See wiki for more information
    }
}
