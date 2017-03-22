package shapes;

import java.awt.*;

public class Point extends BaseShape{
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;

    Point add(int xValue, int yValue) {
        return new Point(this.x + xValue, this.y + yValue);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.drawLine(this.x, this.y, this.x, this.y);
    }
}
