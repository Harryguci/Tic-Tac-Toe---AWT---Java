package components;

import java.awt.*;
import java.awt.event.*;

public class GameFrame extends Frame {
    final public static int SCREEN_WIDTH = 320;
    final public static int SCREEN_HEIGHT = 365;
    final public static int Matrix[][] = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };

    public GameFrame() {
        super();
        this.setBounds(100, 100, SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLayout(null);
        this.setBackground(new Color(230, 230, 230));
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public GameFrame(String name) {
        super(name);
        this.setBounds(100, 100, SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLayout(null);
        this.setBackground(new Color(230, 230, 230));
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
    }
}
