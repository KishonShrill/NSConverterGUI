import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConverterApp implements ActionListener {

    /* - - - - - Initiations - - - - - */
    //Frame and Panels
    JFrame jFrame = new JFrame("Main menu for the Number System Converter");
    JTabbedPane tabbedMenu = new JTabbedPane();
    JPanel firstTab = new JPanel();
    JPanel secondTab = new JPanel();
    JPanel firstHeader, firstFooter, firstCenter;
    JPanel secondHeader, secondFooter, secondCenter;

    //Buttons - For the Main Menu
    JButton play = new JButton("Convert");
//    JButton help = new JButton("Instructions");
//    JButton examples = new JButton("Examples");
//    JButton credits = new JButton("Credits");
//    JButton exit = new JButton("Exit");

    JLabel showBin, showBinAns, showOct, showOctAns , showDec, showDecAns, showHex, showHexAns;
    String[] numberSystem = {"BIN","OCT","DEC","HEX"};
    JComboBox nsComboBox;
    JTextArea TBConverted;

    GridBagConstraints converter_bar = new GridBagConstraints();
//    GridBagConstraints title_bar = new GridBagConstraints();

    /* - - - - - Instances - - - - - */
    NumberSystem CHANGEME = new NumberSystem();
    public static int numbersystemPicker;
    public String binOutput = "", octOutput = "", decOutput = "", hexOutput = "";

    //SETUP (just like Processing)
    ConverterApp(){
        Setup();
        firstDesign();
        secondDesign();
        ConverterHeader();
        ConverterContent();
        jFrame.setVisible(true);
    }

    private void Setup() {
        //SETUP (just like Processing)
        jFrame.setSize(420, 630);
        jFrame.setResizable(false);
        jFrame.setTitle("Number System - Converter");
        jFrame.setLocationRelativeTo(null); // this method will display the JFrame to center position of a screen
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // FIRST TAB
        firstTab.setLayout(new BorderLayout(10,0));
        secondTab.setLayout(new BorderLayout(10,0));

        //        firstTab.setSize(420, 630);

        tabbedMenu.add("Converter",firstTab);
        tabbedMenu.add("Thread", secondTab);
        jFrame.add(tabbedMenu);

    }

    private void firstDesign() {
        //Init
        firstHeader = new JPanel();
        firstFooter = new JPanel();
        firstCenter = new JPanel();

        //Background Colors - Panels
        firstHeader.setBackground(Color.darkGray);
        firstFooter.setBackground(Color.lightGray);

        //Setting Size - Panels
        firstHeader.setPreferredSize(new Dimension(0,120));
        firstFooter.setPreferredSize(new Dimension(0, 25));

        //Setting Positions - Panels
        firstTab.add(firstHeader, BorderLayout.NORTH);
        firstTab.add(firstFooter, BorderLayout.SOUTH);
        firstTab.add(firstCenter, BorderLayout.CENTER);
    }
    private void secondDesign() {
        //Init
        secondHeader = new JPanel();
        secondFooter = new JPanel();
        secondCenter = new JPanel();

        //Background Colors - Panels
        secondHeader.setBackground(Color.darkGray);
        secondFooter.setBackground(Color.lightGray);

        //Setting Size - Panels
        secondHeader.setPreferredSize(new Dimension(0,120));
        secondFooter.setPreferredSize(new Dimension(0, 25));

        //Setting Positions - Panels
        secondTab.add(secondHeader, BorderLayout.NORTH);
        secondTab.add(secondFooter, BorderLayout.SOUTH);
        secondTab.add(secondCenter, BorderLayout.CENTER);
    }

    private void ConverterHeader() {
        firstHeader.setLayout(new BorderLayout());
        converter_bar.insets = new Insets(0,0,0,0);

        JPanel header_title = new JPanel();
            header_title.setPreferredSize(new Dimension(0,60));
            header_title.setLayout(new GridBagLayout());
            header_title.setBackground(Color.darkGray);
        firstHeader.add(header_title, BorderLayout.NORTH);
                //TODO: Put some title wordings here



        JPanel header_content = new JPanel();
            header_content.setBorder(new EmptyBorder(0,10,0,10));
            header_content.setPreferredSize(new Dimension(0,50));
            header_content.setLayout(new GridBagLayout());
            header_content.setBackground(Color.white);
        firstHeader.add(header_content, BorderLayout.SOUTH);

            converter_bar.gridx = converter_bar.gridy = 0;
            converter_bar.weightx = 20;
            converter_bar.anchor = GridBagConstraints.WEST;
            nsComboBox = new JComboBox(numberSystem);
            nsComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
            nsComboBox.setPreferredSize(new Dimension(100,60));
            nsComboBox.setSelectedIndex(0);
            nsComboBox.addActionListener(this);
        header_content.add(nsComboBox, converter_bar);

            converter_bar.gridx = 1;
            converter_bar.gridy = 0;
            converter_bar.weightx = 70;
            converter_bar.anchor = GridBagConstraints.EAST;
            TBConverted = new JTextArea("0");
            TBConverted.setFont(new Font("Arial", Font.BOLD, 25));
        header_content.add(TBConverted, converter_bar);
    }

    private void ConverterContent() {
        JPanel binBox, octBox, decBox, hexBox, emptyBox, buttonBox;
        firstCenter.setLayout(new BorderLayout());

        JPanel center_content = new JPanel();
            center_content.setPreferredSize(new Dimension(0,140));
            center_content.setLayout(new BoxLayout(center_content, BoxLayout.PAGE_AXIS));
//            center_content.setBackground(Color.blue); //DELETE LATER!!!
        firstCenter.add(center_content, BorderLayout.NORTH);

        /* - - - - - - - - - - - The Output Area - - - - - - - - - - - */
        emptyBox = new JPanel();
            emptyBox.setPreferredSize(new Dimension(1, 10));
        center_content.add(emptyBox);

        binBox = new JPanel();
            binBox.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
            showBin = new JLabel("BIN:");
            showBin.setPreferredSize(new Dimension(40,20));
            showBinAns = new JLabel(String.valueOf(binOutput));
        binBox.add(showBin);
        binBox.add(showBinAns);
        center_content.add(binBox);

        octBox = new JPanel();
            octBox.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
            showOct = new JLabel("OCT:");
            showOct.setPreferredSize(new Dimension(40,20));
            showOctAns = new JLabel(String.valueOf(octOutput));
        octBox.add(showOct);
        octBox.add(showOctAns);
        center_content.add(octBox);

        decBox = new JPanel();
            decBox.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
            showDec = new JLabel("DEC:");
            showDec.setPreferredSize(new Dimension(40,20));
            showDecAns = new JLabel(String.valueOf(decOutput));
        decBox.add(showDec);
        decBox.add(showDecAns);
        center_content.add(decBox);

        hexBox = new JPanel();
            hexBox.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
            showHex = new JLabel("HEX:");
            showHex.setPreferredSize(new Dimension(40,20));
            showHexAns = new JLabel(String.valueOf(hexOutput));
        hexBox.add(showHex);
        hexBox.add(showHexAns);
        center_content.add(hexBox);

        buttonBox = new JPanel();
            buttonBox.setPreferredSize(new Dimension(1, 30));
            play.addActionListener(this);
        buttonBox.add(play);
        center_content.add(buttonBox);
    }
    
    private int nsPickerChanger(int numbersystemPicker) throws IllegalStateException {
        return switch (numbersystemPicker) {
            case 0 -> 2;
            case 1 -> 8;
            case 2 -> 10;
            case 3 -> 16;
            default -> throw new IllegalStateException("Unexpected value: " + numbersystemPicker);
        };
    }

    //SETTER & GETTER
    private int getNumbersystemPicker() {return this.numbersystemPicker;}
//    public void setBin(String bin) {this.binOutput = bin;}
//    public void setOct(String oct) {this.octOutput = oct;}
//    public void setDec(String dec) {this.decOutput = dec;}
//    public void setHex(String hex) {this.hexOutput = hex;}

    public static boolean isBinary(String data) {
        Pattern pattern = Pattern.compile("[01]+");
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
    public static boolean isOctal(String data) {
        Pattern pattern = Pattern.compile("[0-7]+");
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
    public static boolean isDecimal(String data) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }
    public static boolean isHexadecimal(String data) {
        Pattern pattern = Pattern.compile("[0-9A-Fa-f]+");
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nsComboBox) {numbersystemPicker = nsComboBox.getSelectedIndex();}

        if (e.getSource() == play) {
            CHANGEME.setUserInput(TBConverted.getText(), nsPickerChanger(getNumbersystemPicker()));

            binOutput = CHANGEME.convertToBIN(TBConverted.getText());
            showBinAns.setText(binOutput);

            octOutput = CHANGEME.convertToOCT(TBConverted.getText());
            showOctAns.setText(octOutput);

            decOutput = CHANGEME.convertToDEC(TBConverted.getText());
            showDecAns.setText(decOutput);
//
            hexOutput = CHANGEME.convertToHEX(TBConverted.getText());
            showHexAns.setText(hexOutput);

            //Setting JTextArea to '0' to ensure you can still click on the text area
            String input = TBConverted.getText();  // Get the text from the JTextArea
            if (input.isEmpty()) {
                input = "0";  // Set the input to "0" if it is empty
                TBConverted.setText(input);
            }

        }
    }
}

