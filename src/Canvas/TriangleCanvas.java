package Canvas;
import shapes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class TriangleCanvas extends BaseCanvas {
    public TriangleCanvas(JPanel drawingPanel, Graphics2D g2D, Color color, ShapesList shapesList) {
        super(drawingPanel, g2D, color, shapesList);
    }

    private shapes.Point point1;
    private shapes.Point point2;
    private shapes.Point point3;
    private shapes.Point currPoint;

    public void handleClick(MouseEvent mouseEvent) {
        if (point1 == null) {
            point1 = new shapes.Point(mouseEvent.getX(), mouseEvent.getY());
            currPoint = point1;
            point1.setColor(color);
            point1.draw(g2D);
        }
        else if (point2 == null){
            point2 = new shapes.Point(mouseEvent.getX(), mouseEvent.getY());
            currPoint = point2;
            Line line = new Line(point1, point2);
            line.setColor(color);
            line.draw(g2D);
            shapesList.add(line);
        }
        else {
            shapesList.remove(shapesList.size() - 1);

            point3 = new shapes.Point(mouseEvent.getX(), mouseEvent.getY());
            Triangle triangle = new Triangle(point1, point2, point3);
            triangle.setColor(color);
            triangle.draw(g2D);

            shapesList.add(triangle);

            point1 = null;
            point2 = null;
            point3 = null;
            currPoint = null;
        }
    }

    public void handleMove(MouseEvent mouseEvent) {
        if (currPoint != null) {
            setClear(g2D, drawingPanel.getWidth(), drawingPanel.getHeight());
            shapesList.draw(g2D);

            shapes.Point nextPoint = new shapes.Point(mouseEvent.getX(), mouseEvent.getY());
            Line line = new Line(currPoint, nextPoint);
            line.setColor(color);
            line.draw(g2D);
        }
    }
}
