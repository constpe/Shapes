package shapes;

import java.awt.*;

public class Rectangle extends Polygon{
    public Rectangle(){}

    public Rectangle(Point point1, Point point2) {
        points.add(point1);
        points.add(point1.add(point2.x - point1.x, 0));
        points.add(point2);
        points.add(point1.add(0, point2.y - point1.y));
        edgeAmount = 4;
    }
}
