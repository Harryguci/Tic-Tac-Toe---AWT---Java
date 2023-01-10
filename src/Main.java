import components.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.tools.DocumentationTool.Location;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        GameFrame mainFrame = new GameFrame("Tic tac toe");
        mainFrame.setLocation(50, 50);

        String[] items = { "Open file", "Open folder", "Close file", "Save" };
        MenuCustom menu = new MenuCustom("File", items);

        Label label1 = new Label("Test Label");
        label1.setBounds(20, 20, 100, 100);

        MenubarCustom menubar = new MenubarCustom();
        menubar.add(menu);
        ArrayList<Cell> cells = new ArrayList<Cell>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Color color;
                if ((i + j) % 2 == 0)
                    color = new Color(170, 170, 240);
                else
                    color = new Color(240, 170, 170);

                Cell temp = new Cell(i * 100, j * 100, color);
                cells.add(temp);
                cells.get(cells.size() - 1).addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // TODO Auto-generated method stub
                        // System.out.println("x : " + e.getComponent().getLocation().getX());
                        // System.out.println("y : " + e.getComponent().getLocation().getY());

                        int x = (int) (e.getComponent().getLocation().getX());
                        int y = (int) (e.getComponent().getLocation().getY());

                        x /= 100;
                        y /= 100;

                        // 0 1 2
                        // 3 4 5
                        // 6 7 8

                        cells.get(GameFrame.Matrix[x][y]).setBackground(Color.RED);
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

                });
                mainFrame.add(temp);
            }
        }

        mainFrame.setMenuBar(menubar);
    }
}