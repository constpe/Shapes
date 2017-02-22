package shapes;

import java.awt.*;

public abstract class BaseShape {
    Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    abstract void draw(Graphics2D g);
}
