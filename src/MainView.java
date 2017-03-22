import Canvas.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainView{
    private Color color;
    private BaseCanvas canvas;
    private ShapesList shapesList;
    private String fileName = "";
    private boolean isChanged = false;

    MainView() {
        String lookandfeel = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(lookandfeel);
        }
        catch (Exception e) {}

        JMenuBar menu = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("Save as");
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        menu.add(fileMenu);

        JPanel drawingPanel = new JPanel();
        drawingPanel.setBounds(120, 20, 500, 500);
        drawingPanel.setBackground(Color.WHITE);
        drawingPanel.setDoubleBuffered(true);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(null);
        optionsPanel.setBounds(0, 20, 120, 500);
        JButton pointButton = new JButton("Point");
        pointButton.setBounds(10, 20, 100, 20);
        JButton lineButton = new JButton("Line");
        lineButton.setBounds(10, 55, 100, 20);
        JButton polygonButton = new JButton("Polygon");
        polygonButton.setBounds(10, 90, 100, 20);
        JButton rectButton = new JButton("Rectangle");
        rectButton.setBounds(10, 125, 100, 20);
        JButton squareButton = new JButton("Square");
        squareButton.setBounds(10, 160, 100, 20);
        JButton triangleButton = new JButton("Triangle");
        triangleButton.setBounds(10, 195, 100, 20);
        JButton ellipseButton = new JButton("Ellipse");
        ellipseButton.setBounds(10, 230, 100, 20);
        JButton circleButton = new JButton("Circle");
        circleButton.setBounds(10, 265, 100, 20);
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(10, 300, 100, 20);
        JButton colorButton = new JButton("Color");
        colorButton.setBounds(10, 400, 100, 20);
        JColorChooser colorChooser = new JColorChooser(Color.BLACK);

        JPanel colorPanel = new JPanel();
        colorPanel.setBounds(10, 440, 100, 40);
        colorPanel.setBackground(Color.BLACK);
        colorPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        optionsPanel.add(pointButton);
        optionsPanel.add(lineButton);
        optionsPanel.add(polygonButton);
        optionsPanel.add(rectButton);
        optionsPanel.add(squareButton);
        optionsPanel.add(triangleButton);
        optionsPanel.add(ellipseButton);
        optionsPanel.add(circleButton);
        optionsPanel.add(clearButton);
        optionsPanel.add(colorButton);
        optionsPanel.add(colorChooser);
        optionsPanel.add(colorPanel);

        JFrame mainFrame = new JFrame("Shapes viewer");
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(635, 590);
        mainFrame.setResizable(false);
        mainFrame.setJMenuBar(menu);
        mainFrame.add(drawingPanel);
        mainFrame.add(optionsPanel);
        mainFrame.setVisible(true);

        Graphics g = drawingPanel.getGraphics();
        Graphics2D g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(2));

        color = Color.BLACK;
        shapesList = new ShapesList();

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser("D:/");
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.xml", "xml"));

                int userSelection = fileChooser.showOpenDialog(mainFrame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    fileName = fileChooser.getSelectedFile().toString();
                    XMLSerializer xmlSerializer = new XMLSerializer(shapesList);
                    try {
                        shapesList = xmlSerializer.deserialize(fileName);
                        g2D.setColor(Color.WHITE);
                        g2D.fillRect(1, 1, drawingPanel.getWidth() - 2, drawingPanel.getHeight() - 2);
                        g2D.setColor(color);
                        shapesList.draw(g2D);
                        isChanged = false;
                        canvas = null;
                    }
                    catch (IOException e) {
                        JOptionPane.showMessageDialog(mainFrame, "Cannot open file " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int choice = JOptionPane.YES_OPTION;

                if (fileName.equals(""))
                    saveAsItem.getActionListeners()[0].actionPerformed(actionEvent);
                else {
                    if (isChanged)
                        choice = JOptionPane.showConfirmDialog(mainFrame, "Are you sure you want to save changes to file " + fileName, "Save", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        XMLSerializer xmlSerializer = new XMLSerializer(shapesList);
                        try {
                            xmlSerializer.serialize(fileName);
                        }
                        catch (IOException e) {
                            JOptionPane.showMessageDialog(mainFrame, "Cannot save file " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        saveAsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser("D:/");
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.xml", "xml"));

                int userSelection = fileChooser.showSaveDialog(mainFrame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    fileName = fileChooser.getSelectedFile().toString() + ".xml";
                    XMLSerializer xmlSerializer = new XMLSerializer(shapesList);
                    try {
                        xmlSerializer.serialize(fileName);
                    }
                    catch (IOException e) {
                        JOptionPane.showMessageDialog(mainFrame, "Cannot save file " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        pointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                canvas = new PointCanvas(drawingPanel, g2D, color, shapesList);
                isChanged = true;
            }
        });

        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                canvas= new LineCanvas(drawingPanel, g2D, color, shapesList);
                isChanged = true;
            }
        });

        polygonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                canvas = new PolygonCanvas(drawingPanel, g2D, color, shapesList);
                isChanged = true;
            }
        });

        rectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                canvas = new RectCanvas(drawingPanel, g2D, color, shapesList);
                isChanged = true;
            }
        });

        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                canvas = new SquareCanvas(drawingPanel, g2D, color, shapesList);
                isChanged = true;
            }
        });

        triangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                canvas = new TriangleCanvas(drawingPanel, g2D, color, shapesList);
                isChanged = true;
            }
        });

        ellipseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                canvas = new EllipseCanvas(drawingPanel, g2D, color, shapesList);
                isChanged = true;
            }
        });

        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                canvas = new CircleCanvas(drawingPanel, g2D, color, shapesList);
                isChanged = true;
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                drawingPanel.repaint();
                shapesList.clear();
                canvas = null;
                isChanged = true;
            }
        });

        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                color = colorChooser.showDialog(mainFrame, "", Color.BLACK);
                colorPanel.setBackground(color);
                if (canvas != null)
                    canvas.changeColor(color);
            }
        });

        drawingPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (canvas != null)
                    canvas.handleClick(mouseEvent);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });

        drawingPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                if (canvas != null)
                    canvas.handleMove(mouseEvent);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainView();
            }
        });
    }
}
