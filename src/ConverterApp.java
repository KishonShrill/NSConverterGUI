import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ConverterApp implements ActionListener {

    /* - - - - - Initiations - - - - - */
    //Frame and Panels
    JFrame jFrame = new JFrame("Main menu for the Number System Converter");
    JTabbedPane tabbedMenu = new JTabbedPane();
    JPanel center_dialogue, cd_marginNorth, cd_marginSouth, cd_marginEast, cd_marginWest, tab_bin, tab_oct, tab_dec, tab_hex;
    JPanel firstTab = new JPanel();
    JPanel secondTab = new JPanel();
    JPanel firstHeader, firstFooter, firstCenter;
    JPanel secondHeader, secondFooter, threaderContent, contentPane, mainThreadPanel;
    JButton play = new JButton("Convert");
    JLabel showBin, showBinAns, showOct, showOctAns , showDec, showDecAns, showHex, showHexAns;
    String[] numberSystem = {"BIN","OCT","DEC","HEX"};
    String[] columnNames;
    JTable data_sheetBIN, data_sheetOCT, data_sheetDEC, data_sheetHEX;
    DefaultTableModel dataModelBIN, dataModelOCT, dataModelDEC, dataModelHEX;
    JComboBox nsComboBox;
    JTextArea TBConverted;
    GridBagConstraints converter_bar = new GridBagConstraints();
    GridBagConstraints constraints = new GridBagConstraints();
    NumberSystem instanceNumberSystem = new NumberSystem();

    /* - - - - - Instances - - - - - */
    public static int comboBoxNumberSystem;
    public String binOutput = "", octOutput = "", decOutput = "", hexOutput = "";

    //SETUP (just like Processing)
    ConverterApp(){
        Setup();
        firstTabDesign();
        ConverterHeader();
        ConverterContent();

        secondTabDesign();
        jFrame.setVisible(true);
    }

    private void Setup() {
        ImageIcon icon = createImageIcon("/res/middle.gif");
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResource("/res/calculator.gif"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //SETUP (just like Processing)
        jFrame.setSize(420, 630);
        jFrame.setResizable(false);
        jFrame.setTitle("Number System - Converter");
        jFrame.setIconImage(image);
        jFrame.setLocationRelativeTo(null); // this method will display the JFrame to center position of a screen
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // FIRST TAB
        firstTab.setLayout(new BorderLayout(10,0));
        secondTab.setLayout(new BorderLayout(10,0));
        tabbedMenu.addTab("Converter", icon, firstTab);
        tabbedMenu.addTab("Thread", icon, secondTab);
        jFrame.add(tabbedMenu);
    }
    private void firstTabDesign() {
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
    private void secondTabDesign() {
        //setup
        contentPane = new JPanel(new BorderLayout());
        mainThreadPanel = new JPanel();
        mainThreadPanel.setLayout(new GridBagLayout());
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0; // Column width weight
        constraints.weighty = 1.0; // Row height weight

        //Header
        secondHeader = new JPanel();
            secondHeader.setBackground(Color.darkGray);
            secondHeader.setPreferredSize(new Dimension(0, 100)); // Set the height to 100 pixels
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 3; // Span across all columns
            constraints.weighty = 0.1; // Adjust the row height weight
        mainThreadPanel.add(secondHeader, constraints);
        
        //Content of Thread Conversions
        threaderContent = new JPanel();
            threaderContent.setLayout(new GridLayout(1, 3, 10, 10)); // Set horizontal gap between columns
            threaderContent.setBackground(Color.white);


        // Adding margin between the columns
        int columnMargin = 10;
        int rowMargin = 10;
        EmptyBorder threaderBorder = new EmptyBorder(rowMargin, columnMargin, rowMargin, columnMargin);
        threaderContent.setBorder(threaderBorder);

        // Columns for bin, oct, and hex
        JPanel colBin = new JPanel();
        colBin.setBackground(Color.BLUE);
        threaderContent.add(colBin);

        JPanel colOct = new JPanel();
        colOct.setBackground(Color.YELLOW);
        threaderContent.add(colOct);

        JPanel colHex = new JPanel();
        colHex.setBackground(Color.ORANGE);
        threaderContent.add(colHex);

            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.gridwidth = 3; // Span across all columns
            constraints.weighty = 0.9; // Adjust the row height weight
        mainThreadPanel.add(threaderContent, constraints);
        secondTab.add(mainThreadPanel, BorderLayout.CENTER);

        //Footer
        secondFooter = new JPanel();
        secondFooter.setBackground(Color.lightGray);
        secondFooter.setPreferredSize(new Dimension(0, 25));
        secondTab.add(secondFooter, BorderLayout.SOUTH);


//        secondTab.add(secondHeader, BorderLayout.NORTH);
//        secondTab.add(threaderContent, BorderLayout.SOUTH);
    }
    private void ConverterHeader() {
        firstHeader.setLayout(new BorderLayout());
        converter_bar.insets = new Insets(0,0,0,0);

        JPanel header_title = new JPanel();
            header_title.setPreferredSize(new Dimension(0,60));
            header_title.setLayout(null);
            header_title.setBackground(Color.darkGray);
        firstHeader.add(header_title, BorderLayout.NORTH);

        JLabel title = new JLabel("Number System");

            int frameWidth = jFrame.getPreferredSize().width;

            title.setBounds((frameWidth/2)+10, 17, 420, 38);
            title.setFont(new Font("Arial", Font.PLAIN, 38));
            title.setForeground(Color.WHITE);
        header_title.add(title);


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
        TBConverted = new NoSpaceTextArea();
        TBConverted = new JTextArea("0");
        TBConvertedSpecialFeature();
            TBConverted.setFont(new Font("Arial", Font.BOLD, 25));
        header_content.add(TBConverted, converter_bar);
    }
    private void ConverterContent() {
        JPanel binBox, octBox, decBox, hexBox, emptyBox, buttonBox;
        firstCenter.setLayout(new BorderLayout());

        JPanel center_content = new JPanel();
            center_content.setPreferredSize(new Dimension(0,140));
            center_content.setLayout(new BoxLayout(center_content, BoxLayout.PAGE_AXIS));
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
        
        /* - - - - - - - - - - - The Output Area - - - - - - - - - - - */
        center_dialogue = new JPanel();
            center_dialogue.setPreferredSize(new Dimension(0,140));
            center_dialogue.setLayout(new BorderLayout());
        firstCenter.add(center_dialogue);

        cd_marginNorth = new JPanel();
        cd_marginNorth.setPreferredSize(new Dimension(0,20));
        center_dialogue.add(cd_marginNorth, BorderLayout.NORTH);

        cd_marginSouth = new JPanel();
        cd_marginSouth.setPreferredSize(new Dimension(0,20));
        center_dialogue.add(cd_marginSouth, BorderLayout.SOUTH);

        cd_marginEast = new JPanel();
        cd_marginEast.setPreferredSize(new Dimension(20,0));
        center_dialogue.add(cd_marginEast, BorderLayout.EAST);

        cd_marginWest = new JPanel();
        cd_marginWest.setPreferredSize(new Dimension(20,0));
        center_dialogue.add(cd_marginWest, BorderLayout.WEST);

        JTabbedPane results = new JTabbedPane();

        tab_bin = new JPanel();
        tab_oct = new JPanel();
        tab_dec = new JPanel();
        tab_hex = new JPanel();
        tab_bin.setLayout(new BorderLayout());
        tab_oct.setLayout(new BorderLayout());
        tab_dec.setLayout(new BorderLayout());
        tab_hex.setLayout(new BorderLayout());

        //Setting the Default Table
        columnNames = new String[]{"Division", "Quotient", "Remainder", "Digit #"};
        dataModelBIN = new DefaultTableModel(new Object[][]{}, columnNames);
        data_sheetBIN = new JTable(dataModelBIN);
        data_sheetBIN.setPreferredScrollableViewportSize(new Dimension(500, 70));
        data_sheetBIN.setFillsViewportHeight(true);
        JScrollPane scrollPaneBIN = new JScrollPane(data_sheetBIN);
        tab_bin.add(scrollPaneBIN, BorderLayout.CENTER);

        dataModelOCT = new DefaultTableModel(new Object[][]{}, columnNames);
        data_sheetOCT = new JTable(dataModelOCT);
        data_sheetOCT.setPreferredScrollableViewportSize(new Dimension(500, 70));
        data_sheetOCT.setFillsViewportHeight(true);
        JScrollPane scrollPaneOCT = new JScrollPane(data_sheetOCT);
        tab_oct.add(scrollPaneOCT, BorderLayout.CENTER);

        dataModelDEC = new DefaultTableModel(new Object[][]{}, columnNames);
        data_sheetDEC = new JTable(dataModelDEC);
        data_sheetDEC.setPreferredScrollableViewportSize(new Dimension(500, 70));
        data_sheetDEC.setFillsViewportHeight(true);
        JScrollPane scrollPaneDEC = new JScrollPane(data_sheetDEC);
        tab_dec.add(scrollPaneDEC, BorderLayout.CENTER);

        dataModelHEX = new DefaultTableModel(new Object[][]{}, columnNames);
        data_sheetHEX = new JTable(dataModelHEX);
        data_sheetHEX.setPreferredScrollableViewportSize(new Dimension(500, 70));
        data_sheetHEX.setFillsViewportHeight(true);
        JScrollPane scrollPaneHEX = new JScrollPane(data_sheetHEX);
        tab_hex.add(scrollPaneHEX, BorderLayout.CENTER);

            results.addTab("BIN", tab_bin);
            results.addTab("OCT", tab_oct);
            results.addTab("DEC", tab_dec);
            results.addTab("HEX", tab_hex);
        center_dialogue.add(results, BorderLayout.CENTER);

    }

    private int nsPickerChanger(int value) throws IllegalStateException {
        return switch (value) {
            case 0 -> 2;
            case 1 -> 8;
            case 2 -> 10;
            case 3 -> 16;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
    }

    //
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nsComboBox) {comboBoxNumberSystem = nsComboBox.getSelectedIndex();}

        if (e.getSource() == play || e.getSource() == TBConverted) {
            instanceNumberSystem.setUserInput(TBConverted.getText(), nsPickerChanger(getNumberSystemPicker()));
            instanceNumberSystem.setConvert(nsPickerChanger(getNumberSystemPicker()));
            binOutput = instanceNumberSystem.convertToBIN(TBConverted.getText());
            octOutput = instanceNumberSystem.convertToOCT(TBConverted.getText());
            decOutput = instanceNumberSystem.convertToDEC(TBConverted.getText());
            hexOutput = instanceNumberSystem.convertToHEX(TBConverted.getText());
            showBinAns.setText(binOutput);
            showOctAns.setText(octOutput);
            showDecAns.setText(decOutput);
            showHexAns.setText(hexOutput);

            //Setting JTextArea to '0' to ensure you can still click on the text area
            String input = TBConverted.getText();  // Get the text from the JTextArea
            if (input.isEmpty()) {
                input = "0";  // Set the input to "0" if it is empty
                TBConverted.setText(input);
            }

            //Storing data in table and updating table content after every button click
            DataArranger dataArrangerBIN = new DataArranger(Integer.parseInt(decOutput),2);
            Object[][] dataArrayBIN = dataArrangerBIN.getDataArray();
            dataModelBIN.setDataVector(dataArrayBIN, columnNames);
            tab_bin.revalidate();
            tab_bin.repaint();

            DataArranger dataArrangerOCT = new DataArranger(Integer.parseInt(decOutput),8);
            Object[][] dataArrayOCT = dataArrangerOCT.getDataArray();
            dataModelOCT.setDataVector(dataArrayOCT, columnNames);
            tab_oct.revalidate();
            tab_oct.repaint();

            DataArranger dataArrangerDEC = new DataArranger(Integer.parseInt(decOutput),10);
            Object[][] dataArrayDEC = dataArrangerDEC.getDataArray();
            dataModelDEC.setDataVector(dataArrayDEC, columnNames);
            tab_dec.revalidate();
            tab_dec.repaint();

            DataArranger dataArrangerHEX = new DataArranger(Integer.parseInt(decOutput),16);
            Object[][] dataArrayHEX = dataArrangerHEX.getDataArray();
            dataModelHEX.setDataVector(dataArrayHEX, columnNames);
            tab_hex.revalidate();
            tab_hex.repaint();
        }
    }
    public void TBConvertedSpecialFeature() {
        TBConverted.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    play.doClick(); // Simulate a click on the "Play" button
                    e.consume(); // Consume the event to prevent adding a new line
                }
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    nsComboBox.showPopup(); // Open the JComboBox popup
                }
            }
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F') || (Character.isDigit(c)))) {
                    e.consume(); // Consume the event to prevent entering the character
                }
            }
        });
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getSource() == TBConverted) {
                        e.consume(); // Consume the "Tab" key event
                    }
                }
                return false;
            }
        });
    }

    //SETTER, GETTER, & MISC
    private int getNumberSystemPicker() {return this.comboBoxNumberSystem;}
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ConverterApp.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}

