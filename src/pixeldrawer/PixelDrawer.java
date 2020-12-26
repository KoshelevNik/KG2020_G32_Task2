package pixeldrawer;

import java.awt.*;

public interface PixelDrawer {

    void drawPixel(int x, int y);

    void setColor(Color color);

    Color getColor();
}
