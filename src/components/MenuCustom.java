package components;

import java.awt.*;

public class MenuCustom extends Menu {
    public MenuCustom(String name) {
        super(name);
    }

    public MenuCustom(String name, String[] items) {
        super(name);
        MenuItem[] MenuItems = new MenuItem[items.length];
        for (int i = 0; i < items.length; i++) {
            MenuItems[i] = new MenuItem(items[i]);
            this.add(MenuItems[i]);
        }
    }

    public static void main(String[] args) {
        String[] items = {
                "Open", "Save", "Close"
        };
        MenuCustom demo = new MenuCustom("File", items);
    }
}
