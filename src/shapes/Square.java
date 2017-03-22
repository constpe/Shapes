package shapes;

public class Square extends Rectangle{
    public Square(){}

    public Square(Point point1, int side) {
        points.add(point1);
        points.add(point1.add(side, 0));
        points.add(point1.add(side, side));
        points.add(point1.add(0, side));
        edgeAmount = 4;
    }
}
