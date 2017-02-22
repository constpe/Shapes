package shapes;

import java.awt.*;

public class Rectangle extends Polygon{
    public Rectangle(){}

    public Rectangle(Point point1, Point point2) {
        points = new Point[4];
        points[0] = point1;
        points[1] = point1.add(point2.x - point1.x, 0);
        points[2] = point2;
        points[3] = point1.add(0, point2.y - point1.y);
        edgeAmount = 4;
    }
}
