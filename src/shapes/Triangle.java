package shapes;

import java.awt.*;

public class Triangle extends Polygon{
    public Triangle() {}

    public Triangle(Point point1, Point point2, Point point3) {
        points = new Point[3];
        points[0] = point1;
        points[1] = point2;
        points[2] = point3;
        edgeAmount = 3;
    }
}
