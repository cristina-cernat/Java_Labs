package Lab_6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    JButton eraseBtn = new JButton("Erase");

    JFileChooser fileChooser = new JFileChooser();

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        add(eraseBtn);

        saveBtn.addActionListener(this::save);
        eraseBtn.addActionListener(this::erase);

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }

        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Reset");
                frame.canvas.graphics.setColor(Color.white);
                frame.canvas.graphics.fillRect(0, 0, DrawingPanel.W, DrawingPanel.H);
                frame.canvas.repaint();
            }

        });

        loadBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                int returnVal = fileChooser.showOpenDialog(frame);

                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    File fileToLoad = fileChooser.getSelectedFile();
                    try {
                        frame.canvas.image = ImageIO.read(fileToLoad);
                        frame.canvas.graphics = frame.canvas.image.createGraphics();
                        frame.canvas.repaint();


                    }catch(IOException e) {
                        System.err.println("Could not load." + e.toString());
                    }
                }
            }

        });

    }

    private void save(ActionEvent e) {

        int returnVal = fileChooser.showSaveDialog(frame);

        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                ImageIO.write((BufferedImage) frame.canvas.image,
                        "png", new File(fileToSave.getAbsolutePath()));

            }catch(IOException ex) {
                System.err.println("Could not save." + ex.toString());
            }
        }
    }

    private void erase(ActionEvent e) {

// TODO finish erase button


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                int x = event.getX();
                int y = event.getY();
                getClickedLine(x, y);
                repaint();
            }
        });
    }

    public void getClickedLine(int x, int y) {
        // hitbox sizes:

        int hitboxX = x - 40;
        int hitboxY = y - 40;

        int width = 40;
        int height = 40;

        for (RegularPolygon poly : frame.canvas.getShapeList()) {
            if(poly.intersects(hitboxX, hitboxY, width, height)) {
                System.out.println("intersects!");
                removeShape(poly);
            }
        }
    }

    public void removeShape(RegularPolygon shape) {
        Iterator<RegularPolygon> it = frame.canvas.getShapeList().iterator();
        while(it.hasNext()) {
            RegularPolygon selectedShape = it.next();
            if(selectedShape.equals(shape)) {
                it.remove();
                repaint();
            }
        }
    }

}

