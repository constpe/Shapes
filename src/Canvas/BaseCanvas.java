package Canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class BaseCanvas {
    public BaseCanvas(JPanel drawingPanel, Graphics2D g2D, Color color, ShapesList shapesList) {
        this.drawingPanel = drawingPanel;
        this.g2D = g2D;
        this.color = color;
        this.shapesList = shapesList;
    }

    JPanel drawingPanel;
    Graphics2D g2D;
    Color color;
    ShapesList shapesList;

    public abstract void handleClick(MouseEvent mouseEvent);

    public abstract void handleMove(MouseEvent mouseEvent);

    public void changeColor(Color color) {
        this.color = color;
    }

    void setClear(Graphics2D g2D, int width, int height) {
        Color prevColor = g2D.getColor();
        g2D.setColor(Color.WHITE);
        g2D.fillRect(0, 0, width, height);
        g2D.setColor(prevColor);
    }
}
