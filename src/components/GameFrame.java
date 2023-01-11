package components;

import java.awt.*;
import java.awt.event.*;

public class GameFrame extends Frame {
    final public static int SCREEN_WIDTH = 320;
    final public static int SCREEN_HEIGHT = 365;
    public boolean status;
    final public static int Matrix[][] = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
    private int[][] matrixStatus;
    private int counter;

    public GameFrame() {
        super();
        this.setBounds(100, 100, SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLayout(null);
        this.setBackground(new Color(230, 230, 230));
        this.setVisible(true);
        this.status = true;
        this.matrixStatus = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        this.counter = 9; // Remain Cell Count
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
        this.status = true;
        this.counter = 9; // Remain Cell Count
        this.matrixStatus = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void GameStart() {
        this.setVisible(true);
        this.status = true;
        this.counter = 9; // Remain Cell Count
        this.matrixStatus = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
    }

    public boolean checkCell(int x, int y) {
        if (matrixStatus[x][y] == 0)
            return true;
        else {
            return false;
        }
    }

    public void setCell(int x, int y) {
        matrixStatus[x][y] = this.status ? 1 : 2;
        this.counter--;
    }

    public int isWin() {
        for (int i = 0; i < 3; i++) {
            int current = matrixStatus[i][0];
            if (current == 0)
                continue;
            int j;
            for (j = 1; j < 3; j++) {
                if (matrixStatus[i][j] != current)
                    break;
            }
            if (j >= 3) {
                return current;
            }
        }

        for (int i = 0; i < 3; i++) {
            int current = matrixStatus[0][i];
            if (current == 0)
                continue;
            int j;
            for (j = 1; j < 3; j++) {
                if (matrixStatus[j][i] != current)
                    break;
            }
            if (j >= 3)
                return current;
        }

        if (matrixStatus[0][0] != 0 && matrixStatus[0][0] == matrixStatus[1][1]
                && matrixStatus[1][1] == matrixStatus[2][2]) {
            return matrixStatus[0][0];
        }
        if (matrixStatus[0][2] != 0 && matrixStatus[0][2] == matrixStatus[1][1]
                && matrixStatus[0][2] == matrixStatus[2][0]) {
            return matrixStatus[0][2];
        }
        /*
         * 00 01 02
         * 10 11 12
         * 20 21 22
         */
        return -1;
    }

    public void DisplayMessage(String txt) {
        MessageDialog dialog1 = new MessageDialog(this, "Message", true);
        int fs = 30;

        if (txt.length() > 6) {
            // DRAW GAME
            fs = 20;
        }
        dialog1.addContent(txt, fs);
        dialog1.setVisible(true);

        dialog1.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent event) {
                GameStart();
            }
        });
    }

    public boolean isDrawGame() {
        System.out.println("Counter : " + counter);

        return (counter == 0 ? true : false);
    }

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
    }
}
