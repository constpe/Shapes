import shapes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class MainView{
    MainView() {
        JPanel drawingPanel = new JPanel();
        drawingPanel.setBounds(120, 5, 500, 500);
        drawingPanel.setBackground(Color.WHITE);
        drawingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(null);
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

        optionsPanel.add(pointButton);
        optionsPanel.add(lineButton);
        optionsPanel.add(polygonButton);
        optionsPanel.add(rectButton);
        optionsPanel.add(squareButton);
        optionsPanel.add(triangleButton);
        optionsPanel.add(ellipseButton);
        optionsPanel.add(circleButton);

        JFrame mainFrame = new JFrame("Shapes viewer");
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(635, 540);
        mainFrame.setResizable(false);
        mainFrame.add(drawingPanel);
        mainFrame.add(optionsPanel);
        mainFrame.setVisible(true);

        Graphics g = drawingPanel.getGraphics();
        Graphics2D g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(2));

        pointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                shapes.Point point = new shapes.Point(10, 10);
                point.setColor(Color.BLUE);
                point.draw(g2D);
            }
        });

        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Line line = new Line(new shapes.Point(20, 10), new shapes.Point(130, 205));
                line.setColor(Color.RED);
                line.draw(g2D);
            }
        });

        polygonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                shapes.Point[] hexagon = {new shapes.Point(170, 10), new shapes.Point(250, 10), new shapes.Point(190, 60), new shapes.Point(110, 60)};
                shapes.Polygon polygon = new shapes.Polygon(hexagon);
                polygon.setColor(Color.GRAY);
                polygon.draw(g2D);
            }
        });

        rectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                shapes.Rectangle rect = new shapes.Rectangle(new shapes.Point(260, 10), new shapes.Point(480, 80));
                rect.setColor(Color.ORANGE);
                rect.draw(g2D);
            }
        });

        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Square square = new Square(new shapes.Point(10, 230), 130);
                square.setColor(Color.MAGENTA);
                square.draw(g2D);
            }
        });

        triangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Triangle triangle = new Triangle(new shapes.Point(150, 120), new shapes.Point(230, 210), new shapes.Point(200, 340));
                triangle.setColor(Color.PINK);
                triangle.draw(g2D);
            }
        });

        ellipseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Ellipse ellipse = new Ellipse(new shapes.Point(240, 210), 110, 220);
                ellipse.setColor(Color.BLUE);
                ellipse.draw(g2D);
            }
        });

        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Circle circle = new Circle(new shapes.Point(410, 280), 50);
                circle.setColor(Color.GREEN);
                circle.draw(g2D);
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
