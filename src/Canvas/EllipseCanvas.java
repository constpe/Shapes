package Canvas;

import shapes.Line;
import shapes.Ellipse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class EllipseCanvas extends BaseCanvas {
    public EllipseCanvas(JPanel drawingPanel, Graphics2D g2D, Color color, ShapesList shapesList) {
        super(drawingPanel, g2D, color, shapesList);
    }

    private shapes.Point center;
    private shapes.Point xBorder;
    private shapes.Point yBorder;
    private int width;

    public void handleClick(MouseEvent mouseEvent) {
        if (center == null) {
            center = new shapes.Point(mouseEvent.getX(), mouseEvent.getY());
            center.setColor(color);
            center.draw(g2D);
        }
        else if (xBorder == null){
            xBorder = new shapes.Point(mouseEvent.getX(), mouseEvent.getY());
            width = Math.abs((xBorder.getX() - center.getX()) * 2);
            Ellipse ellipse = new Ellipse(center, width, 0);
            ellipse.setColor(color);
            ellipse.draw(g2D);
        }
        else {
            Ellipse ellipse = new Ellipse(center, width, Math.abs((mouseEvent.getY() - center.getY()) * 2));
            ellipse.setColor(color);
            ellipse.draw(g2D);
            shapesList.add(ellipse);

            center = null;
            xBorder = null;
            width = 0;
        }
    }

    public void handleMove(MouseEvent mouseEvent) {
        if (center != null && xBorder == null) {
            setClear(g2D, drawingPanel.getWidth(), drawingPanel.getHeight());
            shapesList.draw(g2D);

            width = Math.abs((mouseEvent.getX() - center.getX()) * 2);
            Ellipse ellipse = new Ellipse(center, width, 0);
            ellipse.setColor(color);
            ellipse.draw(g2D);
        }
        else if (xBorder != null) {
            setClear(g2D, drawingPanel.getWidth(), drawingPanel.getHeight());
            shapesList.draw(g2D);

            yBorder = new shapes.Point(mouseEvent.getX(), mouseEvent.getY());
            Ellipse ellipse = new Ellipse(center, width, Math.abs((mouseEvent.getY() - center.getY()) * 2));
            ellipse.setColor(color);
            ellipse.draw(g2D);
        }
    }
}
