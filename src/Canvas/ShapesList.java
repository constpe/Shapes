package Canvas;

import shapes.*;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class ShapesList implements Serializable{
    private ArrayList<BaseShape> shapesList = new ArrayList<>();

    public void add(BaseShape shape) {
        shapesList.add(shape);
    }

    public void remove(int i) {
        shapesList.remove(i);
    }

    public int size() {
        return shapesList.size();
    }

    public void clear() {
        shapesList.clear();
    }

    public void draw(Graphics2D g2D) {
        for (BaseShape shape : shapesList)
            shape.draw(g2D);
    }
}
