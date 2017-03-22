package shapes;

import java.awt.*;

public class Circle extends Ellipse{
    public Circle(Point center, int radius) {
        this.topLeft = center.add(-radius, -radius);
        this.width = radius * 2;
        this.height = radius * 2;
    }
}
