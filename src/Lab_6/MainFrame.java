package Lab_6;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);

        this.add(configPanel, BorderLayout.NORTH);
        this.add(canvas, BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.SOUTH);

        setSize(800,600);
        setVisible(true);

        pack();
    }
}

