import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {

    /* - - - - - Initiations - - - - - */
    //Frame and Panels
    JFrame jFrame = new JFrame("Main menu for the Number System Converter");
    JPanel header = new JPanel();
    JPanel footer = new JPanel();
    JPanel center = new JPanel();

    //Buttons - For the Main Menu
    JButton convert = new JButton("Start");
    JButton help = new JButton("Instructions");
    JButton examples = new JButton("Examples");
    JButton credits = new JButton("Credits");
    JButton exit = new JButton("Exit");

    GridBagConstraints main_menu = new GridBagConstraints();
    GridBagConstraints title_bar = new GridBagConstraints();

    MainMenu() {
        Setup();
        Design();
        Header();
        Footer();
        MainMenuButtons();
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
        header.setPreferredSize(new Dimension(0,200));
        footer.setPreferredSize(new Dimension(0, 25));

        //Setting Positions - Panels
        jFrame.add(header, BorderLayout.NORTH);
        jFrame.add(footer, BorderLayout.SOUTH);
        jFrame.add(center, BorderLayout.CENTER);
    }

    private void Header() {
        header.setLayout(new GridBagLayout());
        title_bar.insets = new Insets(0,0,2,0);

        JLabel title = new JLabel("Number System");
        title_bar.gridy = 0;
        title.setFont(new Font("Arial", Font.PLAIN, 38));
        title.setForeground(Color.WHITE);
        header.add(title, title_bar);

        JLabel description = new JLabel("Calculator Converter for Nerds!");
        title_bar.gridy = 1;
        description.setFont(new Font("Arial", Font.PLAIN, 20));
        description.setForeground(Color.lightGray);
        header.add(description, title_bar);
    }

    private void Footer() {
        footer.setLayout(new BorderLayout());

        JLabel leftLabel = new JLabel("@Chriscent Pingol");
        JLabel rightLabel = new JLabel("Version 2.1");


        leftLabel.setBorder(new EmptyBorder(0,10,0,0));
        rightLabel.setBorder(new EmptyBorder(0,0,0,10));

//        leftLabel.setFont(new Font("Arial", Font.PLAIN, 8));
//        rightLabel.setFont(new Font("Arial", Font.PLAIN, 8));

        footer.add(leftLabel, BorderLayout.WEST);
        footer.add(rightLabel, BorderLayout.EAST);
    }

    private void MainMenuButtons() {
        center.setLayout(new GridBagLayout());
        main_menu.insets = new Insets(7,5,7,5);

        main_menu.gridx = 0;
        main_menu.gridy = 0;
        convert.setPreferredSize(new Dimension(150,50));
        convert.setFont(new Font("Arial", Font.PLAIN, 20));
        convert.setFocusable(false);
        convert.addActionListener(this);
        center.add(convert, main_menu);

        main_menu.gridx = 0;
        main_menu.gridy = 1;
        help.setPreferredSize(new Dimension(150,50));
        help.setFont(new Font("Arial", Font.PLAIN, 20));
        help.setFocusable(false);
        help.addActionListener(this);
        center.add(help, main_menu);

        main_menu.gridx = 0;
        main_menu.gridy = 2;
        examples.setPreferredSize(new Dimension(150,50));
        examples.setFont(new Font("Arial", Font.PLAIN, 20));
        examples.setFocusable(false);
        examples.addActionListener(this);
        center.add(examples, main_menu);

        main_menu.gridx = 0;
        main_menu.gridy = 3;
        credits.setPreferredSize(new Dimension(150,50));
        credits.setFont(new Font("Arial", Font.PLAIN, 20));
        credits.setFocusable(false);
        credits.addActionListener(this);
        center.add(credits, main_menu);

        main_menu.gridx = 0;
        main_menu.gridy = 4;
        exit.setPreferredSize(new Dimension(150,50));
        exit.setFont(new Font("Arial", Font.PLAIN, 20));
        exit.setFocusable(false);
        exit.addActionListener(this);
        center.add(exit, main_menu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convert) {
            jFrame.dispose();
            new ConverterApp();
        } else if (e.getSource() == help) {
            showInstructionsPopup();
        } else if (e.getSource() == examples) {
            showExamplesPopup();
        } else if (e.getSource() == credits) {
            showCreditsPopup();
        }
    }

    private void showInstructionsPopup() {
        JDialog instructionsDialog = new JDialog(jFrame, "Instructions", true);
        instructionsDialog.setSize(400, 200);
        instructionsDialog.setLocationRelativeTo(jFrame);

        // Create a JPanel for the instructions content
        JPanel instructionsPanel = new JPanel();
        instructionsPanel.setLayout(new BorderLayout());

        // Create a JTextArea for the instructions text
        JTextArea instructionsText = new JTextArea();
        instructionsText.setText("""
                Here are the instructions...\s

                1.) Select a number system from the ComboBox.\s
                2.) Enter a number in the calculator.\s
                3.) Click the 'convert' button or press <Enter> to start converting.""");
        instructionsText.setFont(new Font("Arial", Font.PLAIN, 15));
        instructionsText.setEditable(false);
        instructionsText.setLineWrap(true);
        instructionsText.setWrapStyleWord(true);

        instructionsPanel.setBorder(new EmptyBorder(20,20,20,20));
        instructionsPanel.add(instructionsText, BorderLayout.CENTER);

        instructionsDialog.add(instructionsPanel);
        instructionsDialog.setVisible(true);
    }
    private void showExamplesPopup() {
        JDialog instructionsDialog = new JDialog(jFrame, "Examples", true);
        instructionsDialog.setSize(430, 600);
        instructionsDialog.setLocationRelativeTo(jFrame);

        // Create a JPanel for the instructions content
        JPanel instructionsPanel = new JPanel();
        instructionsPanel.setLayout(new BorderLayout());

        // Create a JTextArea for the instructions text
        JTextArea instructionsText = new JTextArea();
        instructionsText.setText("""
                Here are some examples of converting Number Systems

                \tOther systems to Decimal
                Converting 10101 with a base of 2 into decimal
                The converted base is . . : 21
                Base System . . . . . . . : 10

                \tDecimal to Other systems
                Converting 29 with a base of 10 into decimal
                The converted base is . . : 1D
                Base System . . . . . . . : 16

                \tOctal to Binary
                Converting 25 with a base of 8 into decimal
                The converted base is . . : 10101
                Base System . . . . . . . : 2

                \tBinary to Hexadecimal
                Converting 100011101 with a base of 2 into decimal
                The converted base is . . : 11D
                Base System . . . . . . . : 16

                \tHexadecimal to Binary
                Converting F3 with a base of 16 into decimal
                The converted base is . . : 11110011
                Base System . . . . . . . : 2

                """);

        instructionsText.setFont(new Font("Arial", Font.PLAIN, 15));
        instructionsText.setEditable(false);
        instructionsText.setLineWrap(true);
        instructionsText.setWrapStyleWord(true);

        instructionsPanel.setBorder(new EmptyBorder(20,20,20,20));
        instructionsPanel.add(instructionsText, BorderLayout.CENTER);

        instructionsDialog.add(instructionsPanel);
        instructionsDialog.setVisible(true);
    }
    private void showCreditsPopup() {
        JDialog instructionsDialog = new JDialog(jFrame, "Credits", true);
        instructionsDialog.setSize(400, 400);
        instructionsDialog.setLocationRelativeTo(jFrame);

        // Create a JPanel for the instructions content
        JPanel instructionsPanel = new JPanel();
        instructionsPanel.setLayout(new BorderLayout());

        // Create a JTextArea for the instructions text
        JTextArea instructionsText = new JTextArea();
        instructionsText.setText("""
                @author: Chriscent Pingol
                school id#: 2022-0362
                section: CS1
                version: 2.1505

                2 -> version number
                0.[15] -> coffee taken
                0.00[05] -> days without sleep""");

        instructionsText.setFont(new Font("Arial", Font.PLAIN, 18));
        instructionsText.setEditable(false);
        instructionsText.setLineWrap(true);
        instructionsText.setWrapStyleWord(true);

        instructionsPanel.setBorder(new EmptyBorder(20,20,20,20));
        instructionsPanel.add(instructionsText, BorderLayout.CENTER);

        instructionsDialog.add(instructionsPanel);
        instructionsDialog.setVisible(true);
    }
}
