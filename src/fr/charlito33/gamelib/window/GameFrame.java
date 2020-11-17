package fr.charlito33.gamelib.window;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame(String title, int width, int height) {
        super(title);

        setSize(width, height);
        setLocationRelativeTo(null);
        super.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void setResizable(boolean resizable) {
        System.err.println("Error : You cannot change the resizable property !");
    }
}
