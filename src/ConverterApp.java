import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ConverterApp {

    /* - - - - - Initiations - - - - - */
    JFrame jFrame = new JFrame("Main menu for the Number System Converter");

    //SETUP (just like Processing)
    ConverterApp(){
        Setup();
        Converter();
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

    private void Converter(){
        //Creating Divs - Panels
        JPanel header = new JPanel();
        JPanel asideLeft = new JPanel();
        JPanel asideRight = new JPanel();
        JPanel footer = new JPanel();
        JPanel center = new JPanel();

        //Background Colors - Panels
        header.setBackground(Color.darkGray);
        asideLeft.setBackground((Color.pink));
        asideRight.setBackground((Color.GREEN));
        footer.setBackground(Color.lightGray);

        //Setting Size - Panels
        header.setPreferredSize(new Dimension(0,50));
        asideLeft.setPreferredSize(new Dimension(50, 50));
        asideRight.setPreferredSize(new Dimension(50, 50));
        footer.setPreferredSize(new Dimension(0, 50));

        //Setting Positions - Panels
        jFrame.add(header, BorderLayout.NORTH);
        jFrame.add(asideLeft, BorderLayout.WEST);
        jFrame.add(asideRight, BorderLayout.EAST);
        jFrame.add(footer, BorderLayout.SOUTH);
        jFrame.add(center, BorderLayout.CENTER);

        /* - - - - EXPERIMENT - - - - */
        JLabel label = new JLabel("");
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        label.setBorder(border);
        label.setPreferredSize(new Dimension(200, 50));
        label.setText("Hello World Swing");

        center.add(label, BorderLayout.CENTER);
        /* - - - - EXPERIMENT - - - - */


//        jFrame.add(label);
    }
}

