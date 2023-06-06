import javax.swing.*;
import java.awt.*;

public class MainMenu {

    /* - - - - - Instances - - - - - */
    //Frame and Panels
    JFrame jFrame = new JFrame("Main menu for the Number System Converter");
    JPanel header = new JPanel();
    JPanel footer = new JPanel();
    JPanel center = new JPanel();

    //Buttons - For the Main Menu
    JButton Convert = new JButton("Start");
    JButton Help = new JButton("Instructions");
    JButton Examples = new JButton("Examples");
    JButton Credits = new JButton("Credits");
    JButton Exit = new JButton("Exit");

    GridBagConstraints main_menu = new GridBagConstraints();

    MainMenu() {
        Setup();
        Design();
        Header();
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
//        header.setLayout(new );
    }

    private void MainMenuButtons() {
        center.setLayout(new GridBagLayout());
        main_menu.insets = new Insets(7,5,7,5);

        main_menu.gridx = 0;
        main_menu.gridy = 0;
        Convert.setPreferredSize(new Dimension(150,50));
        Convert.setFont(new Font("Arial", Font.PLAIN, 20));
        Convert.setFocusable(false);
        center.add(Convert, main_menu);

        main_menu.gridx = 0;
        main_menu.gridy = 1;
        Help.setPreferredSize(new Dimension(150,50));
        Help.setFont(new Font("Arial", Font.PLAIN, 20));
        Help.setFocusable(false);
        center.add(Help, main_menu);

        main_menu.gridx = 0;
        main_menu.gridy = 2;
        Examples.setPreferredSize(new Dimension(150,50));
        Examples.setFont(new Font("Arial", Font.PLAIN, 20));
        Examples.setFocusable(false);
        center.add(Examples, main_menu);

        main_menu.gridx = 0;
        main_menu.gridy = 3;
        Credits.setPreferredSize(new Dimension(150,50));
        Credits.setFont(new Font("Arial", Font.PLAIN, 20));
        Credits.setFocusable(false);
        center.add(Credits, main_menu);

        main_menu.gridx = 0;
        main_menu.gridy = 4;
        Exit.setPreferredSize(new Dimension(150,50));
        Exit.setFont(new Font("Arial", Font.PLAIN, 20));
        Exit.setFocusable(false);
        center.add(Exit, main_menu);
    }
}
