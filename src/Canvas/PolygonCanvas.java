package Canvas;

import shapes.*;
import shapes.Polygon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class PolygonCanvas extends BaseCanvas {
    public PolygonCanvas(JPanel drawingPanel, Graphics2D g2D, Color color, ShapesList shapesList) {
        super(drawingPanel, g2D, color, shapesList);
    }

    private shapes.Point startPoint;
    private shapes.Point currPoint;
    private shapes.Point nextPoint;
    private Polygon polygon;
    private int edgesAmount;

    public void handleClick(MouseEvent mouseEvent) {
        if (startPoint == null && mouseEvent.getButton() == MouseEvent.BUTTON1) {
            startPoint = new shapes.Point(mouseEvent.getX(), mouseEvent.getY());
            startPoint.setColor(color);
            startPoint.draw(g2D);
            currPoint = startPoint;

            polygon = new Polygon(startPoint);
            edgesAmount = 1;
        }
        else if (mouseEvent.getButton() == MouseEvent.BUTTON1){
            nextPoint = new shapes.Point(mouseEvent.getX(), mouseEvent.getY());
            Line line = new Line(currPoint, nextPoint);
            line.setColor(color);
            line.draw(g2D);
            shapesList.add(line);

            currPoint = nextPoint;
            polygon.add(currPoint);
            edgesAmount++;
        }
        else if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
            Line line = new Line(currPoint, startPoint);
            line.setColor(color);
            line.draw(g2D);

            for (int i = edgesAmount - 1; i > 0; i--) {
                shapesList.remove(shapesList.size() - 1);
            }

            setClear(g2D, drawingPanel.getWidth(), drawingPanel.getHeight());
            polygon.setColor(color);
            polygon.draw(g2D);
            shapesList.add(polygon);

            startPoint = null;
            currPoint = null;

            shapesList.draw(g2D);
        }
    }

    public void handleMove(MouseEvent mouseEvent) {
        if (currPoint != null) {
            setClear(g2D, drawingPanel.getWidth(), drawingPanel.getHeight());
            shapesList.draw(g2D);

            nextPoint = new shapes.Point(mouseEvent.getX(), mouseEvent.getY());
            Line line = new Line(currPoint, nextPoint);
            line.setColor(color);
            line.draw(g2D);
        }
    }

}

