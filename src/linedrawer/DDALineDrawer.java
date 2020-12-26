package linedrawer;

import pixeldrawer.PixelDrawer;

public class DDALineDrawer implements LineDrawer {

    private final PixelDrawer pixelDrawer;

    public DDALineDrawer(PixelDrawer pixelDrawer) {
        this.pixelDrawer = pixelDrawer;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        double L = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
        double dx = (x2 - x1) / L;
        double dy = (y2 - y1) / L;
        double x = x1;
        double y = y1;
        for (int i = 0; i <= L; i++) {
            x += dx;
            y += dy;
            pixelDrawer.drawPixel((int) x, (int) y);
        }
    }
}
