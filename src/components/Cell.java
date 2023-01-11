package components;

import java.awt.*;
import java.awt.event.*;

public class Cell extends Panel implements MouseListener {
    static final int CELL_WIDTH = 100;
    static final int CELL_HEIGHT = 100;

    public Cell() {
        super();
        this.setLayout(null);
    }

    public Cell(int x, int y, Color color) {
        super();
        this.setBounds(x + 10, y + 35, CELL_WIDTH, CELL_HEIGHT);
        this.setBackground(color);
    }

    public Cell(int x, int y) {
        super();
        this.setBounds(x + 10, y + 35, CELL_WIDTH, CELL_HEIGHT);
        this.setBackground(new Color(230, 230, 230));
    }

    public void setCell(int x, int y, Color color) {
        this.setBounds(x + 10, y + 35, CELL_WIDTH, CELL_HEIGHT);
        this.setBackground(color);
    }

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        frame.setBounds(50, 50, 320, 335);
        frame.setLayout(null);
        Cell cell1 = new Cell(0, 0, Color.GRAY);
        Cell cell2 = new Cell(100, 0, Color.BLUE);
        Cell cell3 = new Cell(200, 0, Color.GRAY);
        cell1.setXO(false);
        frame.add(cell1);
        frame.add(cell2);
        frame.add(cell3);
        frame.setVisible(true);
    }

    public void reset() {
        this.setBackground(Color.WHITE);
        removeAll();
    }

    public void setXO(boolean value) {
        // true : X
        // false: O
        Label label;

        if (value) {
            label = new Label("X", Label.CENTER);
        } else {
            label = new Label("O", Label.CENTER);
        }
        label.setFont(new Font("Arial", Font.BOLD, 50));
        label.setBounds(50, 50, 50, 50);
        label.setForeground(Color.WHITE);

        add(label);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        this.setBackground(Color.RED);
        System.out.println("Clicked " + e.getX() + " " + e.getY());

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
