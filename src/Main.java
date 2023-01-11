import components.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
// import javax.tools.DocumentationTool.Location;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start Game!");

        GameFrame mainFrame = new GameFrame("Tic tac toe");
        mainFrame.setLocation(50, 50);

        String[] items = { "Open file", "Open folder", "Close file", "Save" };
        MenuCustom menu = new MenuCustom("File", items);

        MenubarCustom menubar = new MenubarCustom();
        menubar.add(menu);

        ArrayList<Cell> cells = new ArrayList<Cell>();
        final int[][] TEMP = { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } };
        final Color ColorCell_1 = new Color(170, 170, 240);
        final Color ColorCell_2 = new Color(150, 150, 220);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Color color;
                if (TEMP[i][j] == 0)
                    color = ColorCell_1;
                else
                    color = ColorCell_2;

                Cell currentCell = new Cell(i * 100, j * 100, color);
                cells.add(currentCell);
                cells.get(cells.size() - 1).addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int x = (int) (e.getComponent().getLocation().getX());
                        int y = (int) (e.getComponent().getLocation().getY());

                        x /= 100;
                        y /= 100;

                        if (mainFrame.checkCell(x, y)) {
                            cells.get(GameFrame.Matrix[x][y])
                                    .setBackground(mainFrame.status ? new Color(200, 200, 200) : Color.CYAN);
                            cells.get(GameFrame.Matrix[x][y]).setXO(mainFrame.status);
                            if (mainFrame.status) {
                                System.out.println("X");
                            } else
                                System.out.println("O");

                            mainFrame.setCell(x, y);
                            mainFrame.status = !mainFrame.status;
                            mainFrame.setVisible(true);
                            int is_win = mainFrame.isWin();
                            if (is_win != -1 && is_win != 0) {
                                if (is_win == 1) {
                                    mainFrame.DisplayMessage("X win");
                                    mainFrame.setVisible(true);
                                } else {
                                    mainFrame.DisplayMessage("O win");
                                    mainFrame.setVisible(true);
                                }
                                mainFrame.GameStart();

                                for (int i = 0; i < 10; i++) {
                                    cells.get(i).reset();
                                    int k = i % 3;
                                    int q = i / 3;
                                    int c = TEMP[k][q];

                                    Color color;
                                    if (c == 0)
                                        color = ColorCell_1;
                                    else
                                        color = ColorCell_2;

                                    cells.get(i).setBackground(color);
                                    cells.get(i).setVisible(true);
                                }

                            }
                            if (mainFrame.isDrawGame()) {
                                mainFrame.DisplayMessage("DRAW GAME");

                                for (int i = 0; i < 10; i++) {
                                    cells.get(i).reset();
                                    int k = i % 3;
                                    int q = i / 3;
                                    int c = TEMP[k][q];

                                    Color color;
                                    if (c == 0)
                                        color = ColorCell_1;
                                    else
                                        color = ColorCell_2;

                                    cells.get(i).setBackground(color);
                                    cells.get(i).setVisible(true);
                                }
                                mainFrame.GameStart();
                            }
                        }
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
                mainFrame.add(currentCell);
            }
        }

        mainFrame.setMenuBar(menubar);
    }
}