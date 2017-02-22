package shapes;

import java.awt.*;

public class Polygon extends BaseShape{
    public Polygon() {}

    public Polygon(Point[] points) {
        this.points = points;
        this.edgeAmount = points.length;
    }

    Point[] points;
    int edgeAmount;

    public void draw(Graphics2D g) {
        g.setColor(color);
        int[] xVertex = new int[points.length];
        int[] yVertex = new int[points.length];

        for (int i = 0; i < points.length; i++)
        {
            xVertex[i] = points[i].x;
            yVertex[i] = points[i].y;
        }

        g.drawPolygon(xVertex, yVertex, edgeAmount);
    }
}
