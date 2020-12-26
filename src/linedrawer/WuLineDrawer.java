package linedrawer;

import pixeldrawer.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {

    private final PixelDrawer pixelDrawer;

    public WuLineDrawer(PixelDrawer pixelDrawer) {
        this.pixelDrawer = pixelDrawer;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {

        int red = pixelDrawer.getColor().getRed();
        int blue = pixelDrawer.getColor().getBlue();
        int green = pixelDrawer.getColor().getGreen();
        double dx = x2 - x1;
        double dy = y2 - y1;
        if (Math.abs(dx) > Math.abs(dy)) {
            if (x1 > x2) {
                int v = x1;
                x1 = x2;
                x2 = v;
                y1 = y2;
            }
            double gradient = dy / dx;
            double interY = y1 + gradient;
            for (int i = x1; i <= x2; i++) {
                pixelDrawer.setColor(new Color(red, green, blue, (int) (fractionalPart(interY) * 255)));
                pixelDrawer.drawPixel(i, (int) interY + 1);
                pixelDrawer.setColor(new Color(red, green, blue, 255 - (int) (fractionalPart(interY) * 255)));
                pixelDrawer.drawPixel(i, (int) interY);
                interY += gradient;
            }
        } else {
            if (y1 > y2) {
                x1 = x2;
                int v = y1;
                y1 = y2;
                y2 = v;
            }
            double gradient = dx / dy;
            double interX = x1 + gradient;
            for (int i = y1; i <= y2; i++) {
                pixelDrawer.setColor(new Color(red, green, blue, (int) (fractionalPart(interX) * 255)));
                pixelDrawer.drawPixel((int) interX + 1, i);
                pixelDrawer.setColor(new Color(red, green, blue, 255 - (int) (fractionalPart(interX) * 255)));
                pixelDrawer.drawPixel((int) interX, i);
                interX += gradient;
            }
        }
    }

    private double fractionalPart(double number) {
        return number - (int) number;
    }
}
