package Lab_6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    JFileChooser fileChooser = new JFileChooser(); // TODO

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);

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


                    }catch(IOException ignored) {

                    }
                }
            }

        });

        saveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                int returnVal = fileChooser.showSaveDialog(frame);

                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    try {
                        ImageIO.write((BufferedImage) frame.canvas.image, "png", new File(fileToSave.getAbsolutePath()));

                    }catch(IOException ignored) {

                    }
                }
            }

        });

    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }


}

