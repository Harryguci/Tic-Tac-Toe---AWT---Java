package components;

import java.awt.*;
import java.awt.event.*;

public class MenubarCustom extends MenuBar {
    public MenubarCustom() {
        super();
    }

    public MenubarCustom(Menu[] menus) {
        super();

        for (int i = 0; i < menus.length; i++)
            this.add(menus[i]);
    }

    public static void main(String[] args) {
        GameFrame frame = new GameFrame("Test Frame");

        frame.setBounds(50, 50, 300, 600);

        String[] items = { "Open file", "Open folder", "Close file", "Save" };

        MenuCustom menu = new MenuCustom("File", items);
        Label label1 = new Label("Test Label");
        label1.setBounds(20, 20, 100, 100);

        MenubarCustom menubar = new MenubarCustom();
        menubar.add(menu);

        frame.setMenuBar(menubar);
        frame.add(label1);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
