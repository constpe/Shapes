package shapes;

public class Square extends Rectangle{
    public Square(){}

    public Square(Point point1, int side) {
        points = new Point[4];
        points[0] = point1;
        points[1] = point1.add(side, 0);
        points[2] = point1.add(side, side);
        points[3] = point1.add(0, side);
        edgeAmount = 4;
    }
}
