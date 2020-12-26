package window;

import linedrawer.BresenhamLineDrawer;
import linedrawer.DDALineDrawer;
import linedrawer.LineDrawer;
import linedrawer.WuLineDrawer;
import pixeldrawer.GraphicsPixelDrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawPanel extends JPanel implements MouseMotionListener {
    private int x = 100;
    private int y = 100;

    public DrawPanel() {
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        LineDrawer lineDrawer = new WuLineDrawer(new GraphicsPixelDrawer(g, Color.BLACK));
        lineDrawer.drawLine(150, 100, x, y);
        LineDrawer lineDrawer1 = new BresenhamLineDrawer(new GraphicsPixelDrawer(g, Color.BLACK));
        lineDrawer1.drawLine(150, 120, x, y);
        LineDrawer lineDrawer2 = new DDALineDrawer(new GraphicsPixelDrawer(g, Color.BLACK));
        lineDrawer2.drawLine(150, 140, x, y);
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }
}
