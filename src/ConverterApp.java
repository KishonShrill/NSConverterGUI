import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterApp implements ActionListener {

    /* - - - - - Initiations - - - - - */
    //Frame and Panels
    JFrame jFrame = new JFrame("Main menu for the Number System Converter");
    JPanel header = new JPanel();
    JPanel footer = new JPanel();
    JPanel center = new JPanel();

    //Buttons - For the Main Menu
//    JButton convert = new JButton("Start");
//    JButton help = new JButton("Instructions");
//    JButton examples = new JButton("Examples");
//    JButton credits = new JButton("Credits");
//    JButton exit = new JButton("Exit");
    String[] numberSystem = {"BIN","OCT","DEC","HEX"};
    JComboBox nsComboBox;

    GridBagConstraints converter_bar = new GridBagConstraints();
//    GridBagConstraints title_bar = new GridBagConstraints();

    //SETUP (just like Processing)
    ConverterApp(){
        Setup();
        Design();
        ConverterHeader();
        jFrame.setVisible(true);
    }

    private void Setup() {
        //SETUP (just like Processing)
        jFrame.setLayout(new BorderLayout(10,0));
        jFrame.setSize(420, 630);
        jFrame.setResizable(false);
        jFrame.setTitle("Number System - Main Menu");
//      jFrame.pack();                      [somehow it minimizes the window]
        jFrame.setLocationRelativeTo(null); // this method will display the JFrame to center position of a screen
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void Design() {
        //Background Colors - Panels
        header.setBackground(Color.darkGray);
        footer.setBackground(Color.lightGray);

        //Setting Size - Panels
        header.setPreferredSize(new Dimension(0,120));
        footer.setPreferredSize(new Dimension(0, 25));

        //Setting Positions - Panels
        jFrame.add(header, BorderLayout.NORTH);
        jFrame.add(footer, BorderLayout.SOUTH);
        jFrame.add(center, BorderLayout.CENTER);
    }

    private void ConverterHeader() {
        header.setLayout(new BorderLayout());
        converter_bar.insets = new Insets(0,0,0,0);

        JPanel header_title = new JPanel();
        header_title.setPreferredSize(new Dimension(0,60));
        header_title.setLayout(new GridBagLayout());
        header_title.setBackground(Color.darkGray);
        header.add(header_title, BorderLayout.NORTH);


        JPanel header_content = new JPanel();
        header_content.setPreferredSize(new Dimension(0,50));
        header_content.setLayout(new GridBagLayout());
        header_content.setBackground(Color.white);
        header.add(header_content, BorderLayout.SOUTH);
            converter_bar.gridx = converter_bar.gridy = 0;
            converter_bar.weightx = 20;
            converter_bar.anchor = GridBagConstraints.WEST;

            nsComboBox = new JComboBox(numberSystem);
            nsComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
            nsComboBox.setPreferredSize(new Dimension(100,60));
            nsComboBox.addActionListener(this);
            nsComboBox.setSelectedIndex(0);
            header_content.add(nsComboBox, converter_bar);

            converter_bar.gridx = 1;
            converter_bar.gridy = 0;
            converter_bar.weightx = 70;
            converter_bar.anchor = GridBagConstraints.EAST;
            JTextArea TBConverted = new JTextArea("0");

//            do {
//                TBConverted = new JTextArea("0");
//            } while (TBConverted.getText().isEmpty());

            TBConverted.setFont(new Font("Arial", Font.BOLD, 25));
            header_content.add(TBConverted, converter_bar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nsComboBox) {
            System.out.println(nsComboBox.getSelectedIndex());
        }
    }
}

