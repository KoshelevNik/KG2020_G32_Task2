package window;

import javax.swing.*;

public class Window extends JFrame {

    public Window() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        add(new DrawPanel());
        setVisible(true);
    }
}
