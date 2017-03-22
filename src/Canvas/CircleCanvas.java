package Canvas;

import shapes.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class CircleCanvas extends BaseCanvas {
    public CircleCanvas(JPanel drawingPanel, Graphics2D g2D, Color color, ShapesList shapesList) {
        super(drawingPanel, g2D, color, shapesList);
    }

    private shapes.Point center;

    public void handleClick(MouseEvent mouseEvent) {
        if (center == null) {
            center = new shapes.Point(mouseEvent.getX(), mouseEvent.getY());
            center.setColor(color);
            center.draw(g2D);
        }
        else {
            Circle circle = new Circle(center, mouseEvent.getX() - center.getX());
            circle.setColor(color);
            circle.draw(g2D);
            shapesList.add(circle);

            center = null;
        }
    }

    public void handleMove(MouseEvent mouseEvent) {
        if (center != null) {
            setClear(g2D, drawingPanel.getWidth(), drawingPanel.getHeight());
            shapesList.draw(g2D);

            Circle circle = new Circle(center, Math.abs(mouseEvent.getX() - center.getX()));
            circle.setColor(color);
            circle.draw(g2D);
        }
    }
}
