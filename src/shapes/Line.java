package shapes;

import java.awt.*;

public class Line extends BaseShape{
    public Line(){}

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    Point point1;
    Point point2;

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.drawLine(point1.x, point1.y, point2.x, point2.y);
    }
}
