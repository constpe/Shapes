package shapes;

public class Triangle extends Polygon{
    public Triangle() {}

    public Triangle(Point point1, Point point2, Point point3) {
        points.add(point1);
        points.add(point2);
        points.add(point3);
        edgeAmount = 3;
    }
}
