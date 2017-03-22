package Canvas;

import shapes.*;
import shapes.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class LineCanvas extends BaseCanvas {
    public LineCanvas(JPanel drawingPanel, Graphics2D g2D, Color color, ShapesList shapesList) {
        super(drawingPanel, g2D, color, shapesList);
    }

    private shapes.Point point1;
    private shapes.Point point2;

    public void handleClick(MouseEvent mouseEvent) {
        if (point1 == null) {
            point1 = new shapes.Point(mouseEvent.getX(), mouseEvent.getY());
            point1.setColor(color);
            point1.draw(g2D);
        }
        else {
            point2 = new shapes.Point(mouseEvent.getX(), mouseEvent.getY());
            Line line = new Line(point1, point2);
            line.setColor(color);
            line.draw(g2D);
            shapesList.add(line);

            point1 = null;
            point2 = null;
        }
    }

    public void handleMove(MouseEvent mouseEvent) {
        if (point1 != null) {
            setClear(g2D, drawingPanel.getWidth(), drawingPanel.getHeight());
            shapesList.draw(g2D);

            point2 = new Point(mouseEvent.getX(), mouseEvent.getY());
            Line line = new Line(point1, point2);
            line.setColor(color);
            line.draw(g2D);
        }
    }
}
