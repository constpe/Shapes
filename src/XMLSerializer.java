import Canvas.ShapesList;

import java.io.*;
import java.io.IOException;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XMLSerializer {
    private ShapesList shapesList;

    public XMLSerializer(ShapesList shapesList) {
        this.shapesList = shapesList;
    }

    public void serialize(String fileName) throws IOException{
        XStream xs = new XStream();
        FileOutputStream out = new FileOutputStream(fileName);
        xs.toXML(shapesList, out);
    }

    public ShapesList deserialize(String fileName) throws IOException {
        XStream xs = new XStream(new DomDriver());
        FileInputStream fis = new FileInputStream(fileName);
        ShapesList shapesList = new ShapesList();
        xs.fromXML(fis, shapesList);
        return shapesList;
    }
}
