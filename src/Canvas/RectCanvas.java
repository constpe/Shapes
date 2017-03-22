package Canvas;

import shapes.*;
import shapes.Point;
import shapes.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class RectCanvas extends BaseCanvas{
    public RectCanvas(JPanel drawingPanel, Graphics2D g2D, Color color, ShapesList shapesList) {
        super(drawingPanel, g2D, color, shapesList);
    }

    private shapes.Point topLeft;

    public void handleClick(MouseEvent mouseEvent) {
        if (topLeft == null) {
            topLeft = new Point(mouseEvent.getX(), mouseEvent.getY());
        }
        else {
            Rectangle rect = new Rectangle(topLeft, new Point(mouseEvent.getX(), mouseEvent.getY()));
            rect.setColor(color);
            shapesList.add(rect);
            rect.draw(g2D);

            topLeft = null;
        }
    }

    public void handleMove(MouseEvent mouseEvent) {
        if (topLeft != null) {
            setClear(g2D, drawingPanel.getWidth(), drawingPanel.getHeight());
            shapesList.draw(g2D);

            Rectangle rect = new Rectangle(topLeft, new Point(mouseEvent.getX(), mouseEvent.getY()));
            rect.setColor(color);
            rect.draw(g2D);
        }
    }
}
