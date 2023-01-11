package components;

import java.awt.*;
import java.awt.event.*;

public class MessageDialog extends Dialog {
    MessageDialog(Frame frame, String title, boolean model) {
        super(frame, title, model);
        this.setBounds(100, 100, 200, 200);
        this.setLayout(null);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void addContent(String content, int size) {
        Label label = new Label(content, Label.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, size));
        label.setBounds(0, 0, 200, 200);
        this.add(label);
    }
}
