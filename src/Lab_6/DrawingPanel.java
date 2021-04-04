package Lab_6;


import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private List<RegularPolygon> shapeList = new ArrayList<RegularPolygon>();

    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                drawShape(event.getX(), event.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        int radius = (int) ((Math.random() * (25 - 5)) + 5);
        int sides = Integer.parseInt(frame.configPanel.sidesField.getValue().toString());

        // Generate random color
        Color color;
        if(Objects.requireNonNull(frame.configPanel.colorCombo.getSelectedItem()).toString().equals("Random")) {
            Random random = new Random();
            color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        }else {
            color = Color.black;
        }
        //

        RegularPolygon shape = new RegularPolygon(x, y, radius, sides);
        shape.setColor(color);
        shapeList.add(shape);

    }
    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(RegularPolygon poly : shapeList) {
            graphics.setColor(poly.getColor());
            graphics.fill(poly);
        }
        g.drawImage(image, 0, 0, this);
    }

    public List<RegularPolygon> getShapeList() {
        return shapeList;
    }

}

