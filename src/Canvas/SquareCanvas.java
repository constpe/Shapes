package Canvas;

import shapes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class SquareCanvas extends BaseCanvas{
    public SquareCanvas(JPanel drawingPanel, Graphics2D g2D, Color color, ShapesList shapesList) {
        super(drawingPanel, g2D, color, shapesList);
    }

    private shapes.Point topLeft;

    public void handleClick(MouseEvent mouseEvent) {
        if (topLeft == null) {
            topLeft = new shapes.Point(mouseEvent.getX(), mouseEvent.getY());
        }
        else {
            Square square = new Square(topLeft, mouseEvent.getX() - topLeft.getX());
            square.setColor(color);
            shapesList.add(square);
            square.draw(g2D);

            topLeft = null;
        }
    }

    public void handleMove(MouseEvent mouseEvent) {
        if (topLeft != null) {
            setClear(g2D, drawingPanel.getWidth(), drawingPanel.getHeight());
            shapesList.draw(g2D);

            shapes.Square square = new shapes.Square(topLeft, mouseEvent.getX() - topLeft.getX());
            square.setColor(color);
            square.draw(g2D);
        }
    }
}
