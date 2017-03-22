package shapes;

import java.awt.*;
import java.util.ArrayList;

public class Polygon extends BaseShape{
    public Polygon() {}

    public Polygon(Point point) {
        points.add(point);
        edgeAmount = 1;
    }

    ArrayList<Point> points = new ArrayList<>();
    int edgeAmount;

    public void add(Point point) {
        points.add(point);
        edgeAmount++;
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        int[] xVertex = new int[points.size()];
        int[] yVertex = new int[points.size()];

        for (int i = 0; i < points.size(); i++)
        {
            xVertex[i] = points.get(i).x;
            yVertex[i] = points.get(i).y;
        }

        g.drawPolygon(xVertex, yVertex, edgeAmount);
    }
}
