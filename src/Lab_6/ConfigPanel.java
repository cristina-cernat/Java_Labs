package Lab_6;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {

        label = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);

        String [] c = {"Black", "Random"};
        colorCombo = new JComboBox(c);
        this.add(new JLabel("Number of sides:"));

        this.add(new JLabel("sides"));
        this.add(sidesField);

        this.add(new JLabel("colors"));
        this.add(colorCombo);
    }
}

