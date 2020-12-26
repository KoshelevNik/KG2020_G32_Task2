package pixeldrawer;

import java.awt.*;

public class GraphicsPixelDrawer implements PixelDrawer {
    private final Graphics g;
    private Color color;

    public GraphicsPixelDrawer(Graphics g, Color color) {
        this.g = g;
        this.color = color;
    }

    @Override
    public void drawPixel(int x, int y) {
        g.setColor(color);
        g.drawRect(x, y, 1, 1);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
