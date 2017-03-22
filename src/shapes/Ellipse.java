package shapes;

import java.awt.*;

public class Ellipse extends BaseShape{
    public Ellipse() {}

    public Ellipse(Point center, int width, int height) {
        this.topLeft = new Point(center.x - width / 2, center.y - height / 2);
        this.width = width;
        this.height = height;
    }

    Point topLeft;
    int width;
    int height;

    @Override
    public void draw(Graphics2D  g) {
        g.setColor(color);
        g.drawOval(topLeft.x, topLeft.y, width, height);
    }
}
