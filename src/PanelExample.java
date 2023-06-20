import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class PanelExample {
    private JFrame jFrame;

    public PanelExample() {
        setup();
        createPanels();
    }

    private void setup() {
        jFrame = new JFrame("Panel Example");
        jFrame.setSize(420, 630);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
    }

    private void createPanels() {
        JPanel contentPane = new JPanel(new BorderLayout());

        JPanel mainThreadPanel = new JPanel();
        mainThreadPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0; // Column width weight
        constraints.weighty = 1.0; // Row height weight

        // First Row
        JPanel secondHeader = new JPanel();
        secondHeader.setBackground(Color.RED);
        secondHeader.setPreferredSize(new Dimension(0, 100)); // Set the height to 100 pixels
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3; // Span across all columns
        constraints.weighty = 0.1; // Adjust the row height weight
        mainThreadPanel.add(secondHeader, constraints);

        // Second Row
        JPanel threaderContent = new JPanel();
        threaderContent.setLayout(new GridLayout(1, 3, 10, 0)); // Set horizontal gap between columns
        threaderContent.setBackground(Color.GREEN);

        // Add margin between the columns
        int columnMargin = 10;
        EmptyBorder columnBorder = new EmptyBorder(0, columnMargin, 0, columnMargin);
        threaderContent.setBorder(columnBorder);

        // Columns
        JPanel col1 = new JPanel();
        col1.setBackground(Color.BLUE);
        threaderContent.add(col1);

        JPanel col2 = new JPanel();
        col2.setBackground(Color.YELLOW);
        threaderContent.add(col2);

        JPanel col3 = new JPanel();
        col3.setBackground(Color.ORANGE);
        threaderContent.add(col3);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3; // Span across all columns
        constraints.weighty = 0.9; // Adjust the row height weight
        mainThreadPanel.add(threaderContent, constraints);

        contentPane.add(mainThreadPanel, BorderLayout.CENTER);
        jFrame.setContentPane(contentPane);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PanelExample();
        });
    }
}
