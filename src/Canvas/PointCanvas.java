package Canvas;

import shapes.*;
import shapes.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class PointCanvas extends  BaseCanvas {
    public PointCanvas(JPanel drawingPanel, Graphics2D g2D, Color color, ShapesList shapesList) {
        super(drawingPanel, g2D, color, shapesList);
    }

    public void handleClick(MouseEvent mouseEvent) {
        Point point = new Point(mouseEvent.getX(), mouseEvent.getY());
        point.setColor(color);
        point.draw(g2D);
        shapesList.add(point);
    }

    public void handleMove(MouseEvent mouseEvent) {}
}
