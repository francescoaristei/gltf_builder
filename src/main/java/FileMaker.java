import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model_builder.ModelBuilder;

// Java Swing GUI to build the graph model
public class FileMaker extends JPanel {
    private JButton load;
    private JTextArea tfileName;
    private JLabel lfileName;
    private JButton addA;
    private JButton addN;
    private JButton addNR;


    private JTextArea txcoordn;
    private JTextArea tycoordn;
    private JTextArea tzcoordn;
    private JTextArea tray;
    private JTextArea tcolorn;


    private JTextArea txcoorda1;
    private JTextArea tycoorda1;
    private JTextArea tzcoorda1;
    private JTextArea txcoorda2;
    private JTextArea tycoorda2;
    private JTextArea tzcoorda2;
    private JTextArea tcolora;


    private JTextArea txcoordnr;
    private JTextArea tycoordnr;
    private JTextArea tzcoordnr;
    private JTextArea theight;
    private JTextArea tdepth;
    private JTextArea twidth;
    private JTextArea tcolornr;

    private JLabel node;
    private JLabel lxcoordn;
    private JLabel lycoordn;
    private JLabel lzcoordn;
    private JLabel lray;
    private JLabel lcolorn;

    private JLabel arch;
    private JLabel lxcoorda1;
    private JLabel lycoorda1;
    private JLabel lzcoorda1;
    private JLabel lxcoorda2;
    private JLabel lycoorda2;
    private JLabel lzcoorda2;
    private JLabel lcolora;

    private JLabel noder;
    private JLabel lxcoordnr;
    private JLabel lycoordnr;
    private JLabel lzcoordnr;
    private JLabel lheight;
    private JLabel ldepth;
    private JLabel lwidth;
    private JLabel lcolornr;

    private DefaultListModel deflist;
    private JList list;
    private JLabel linfo;
    private JScrollPane listScroller;
    private JButton delete;
    private JButton back;
    private JTextArea info;

    private ModelBuilder builder;
    private static JFrame frame = new JFrame("InputGraphs");


    public FileMaker() {
        //construct components
        load = new JButton ("Create");
        addA = new JButton ("Add");
        addN = new JButton ("Add");
        addNR = new JButton("Add");

        txcoordn = new JTextArea (5, 5);
        tycoordn = new JTextArea (5, 5);
        tzcoordn = new JTextArea (5, 5);
        tray = new JTextArea (5, 5);
        tcolorn = new JTextArea(5,5);


        txcoorda1 = new JTextArea (5,5);
        tycoorda1 = new JTextArea (5, 5);
        tzcoorda1 = new JTextArea (5, 5);
        txcoorda2 = new JTextArea (5, 5);
        tycoorda2 = new JTextArea (5, 5);
        tzcoorda2 = new JTextArea (5, 5);
        tcolora = new JTextArea(5,5);


        txcoordnr = new JTextArea (5,5);
        tycoordnr = new JTextArea (5, 5);
        tzcoordnr = new JTextArea (5, 5);
        theight = new JTextArea (5, 5);
        twidth = new JTextArea (5, 5);
        tdepth = new JTextArea (5, 5);
        tcolornr = new JTextArea(5,5);


        tfileName = new JTextArea(5,5);


        node = new JLabel ("Spherical Node");
        lxcoordn = new JLabel ("Coord x");
        lycoordn = new JLabel ("Coord y");
        lzcoordn = new JLabel ("Coord z");
        lray = new JLabel ("Ray");
        lcolorn = new JLabel("Color");


        arch = new JLabel ("Edge");
        lxcoorda1 = new JLabel ("Coord x");
        lycoorda1 = new JLabel ("Coord y");
        lzcoorda1 = new JLabel ("Coord z");
        lxcoorda2 = new JLabel ("Coord x");
        lycoorda2 = new JLabel ("Coord y");
        lzcoorda2 = new JLabel ("Coord z");
        lcolora = new JLabel("Color");

        noder = new JLabel ("Paral Node");
        lxcoordnr = new JLabel ("Coord x");
        lycoordnr = new JLabel ("Coord y");
        lzcoordnr = new JLabel ("Coord z");
        lheight = new JLabel ("Height");
        lwidth = new JLabel ("Width");
        ldepth = new JLabel ("Depth");
        lcolornr = new JLabel("Color");

        info = new JTextArea("");
        deflist = new DefaultListModel();
        list = new JList(deflist);
        listScroller = new JScrollPane(list);
        delete = new JButton("Delete");
        back = new JButton("Back");


        linfo = new JLabel("Info");


        lfileName = new JLabel("File Name");


        builder = new ModelBuilder();

        //adjust size and set layout
        setPreferredSize (new Dimension (1400, 350));
        setLayout (null);

        //add components
        add (load);
        add (txcoordn);
        add (tycoordn);
        add (tzcoordn);
        add (tray);
        add(tcolorn);

        add (txcoorda1);
        add (tycoorda1);
        add (tzcoorda1);
        add (txcoorda2);
        add (tycoorda2);
        add (tzcoorda2);
        add(tcolora);

        add (txcoordnr);
        add (tycoordnr);
        add (tzcoordnr);
        add (theight);
        add (twidth);
        add (tdepth);
        add(tcolornr);

        add (node);
        add (lxcoordn);
        add (lycoordn);
        add (lzcoordn);
        add (lray);
        add(lcolorn);

        add(lfileName);

        add (arch);
        add (lxcoorda1);
        add (lycoorda1);
        add (lzcoorda1);
        add (lxcoorda2);
        add (lycoorda2);
        add (lzcoorda2);
        add(lcolora);

        add (noder);
        add (lxcoordnr);
        add (lycoordnr);
        add (lzcoordnr);
        add (lwidth);
        add (lheight);
        add (ldepth);
        add(lcolornr);

        add (addA);
        add (addN);
        add(addNR);

        //add(info);
        add(listScroller);
        add(linfo);
        add(delete);
        add(back);

        add(tfileName);

        //set component bounds (only needed by Absolute Positioning)
        load.setBounds (1150, 310, 100, 20);
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GoogleDriveService.fileCreator(builder,tfileName.getText());
                    tfileName.setText("");
                    deflist.removeAllElements();
                    builder.deleteAll();

                }catch (Exception ex) {
                }
            }
        });


        txcoordn.setBounds (10, 60, 160, 20);
        tycoordn.setBounds (10, 105, 160, 20);
        tzcoordn.setBounds (10, 150, 160, 20);
        tray.setBounds (10, 195, 165, 20);



        tcolorn.setBounds (10, 240, 165, 20);


        txcoorda1.setBounds (190, 60, 160, 20);
        tycoorda1.setBounds (190, 105, 160, 20);
        tzcoorda1.setBounds (190, 150, 160, 20);
        tcolora.setBounds (190, 195, 160, 20);
        txcoorda2.setBounds (360, 60, 160, 20);
        tycoorda2.setBounds (360, 105, 160, 20);
        tzcoorda2.setBounds (360, 150, 160, 20);


        txcoordnr.setBounds (540, 60, 160, 20);
        tycoordnr.setBounds (540, 105, 160, 20);
        tzcoordnr.setBounds (540, 150, 160, 20);
        tcolornr.setBounds (540, 195, 160, 20);
        theight.setBounds (710, 60, 160, 20);
        twidth.setBounds (710, 105, 160, 20);
        tdepth.setBounds (710, 150, 160, 20);

        tfileName.setBounds (975, 310, 165, 20);


        node.setBounds (10, 10, 100, 25);
        lxcoordn.setBounds (10, 35, 100, 25);
        lycoordn.setBounds (10, 80, 100, 25);
        lzcoordn.setBounds (10, 125, 100, 25);
        lray.setBounds (10, 170, 100, 25);
        lcolorn.setBounds (10, 215, 100, 25);


        arch.setBounds (190, 10, 100, 25);
        lxcoorda1.setBounds (190, 35, 100, 25);
        lycoorda1.setBounds (190, 80, 100, 25);
        lzcoorda1.setBounds (190, 125, 100, 25);
        lxcoorda2.setBounds (360, 35, 100, 25);
        lycoorda2.setBounds (360, 80, 100, 25);
        lzcoorda2.setBounds (360, 125, 100, 25);
        lcolora.setBounds (190, 170, 100, 25);


        noder.setBounds (540, 10, 100, 25);
        lxcoordnr.setBounds (540, 35, 100, 25);
        lycoordnr.setBounds (540, 80, 100, 25);
        lzcoordnr.setBounds (540, 125, 100, 25);
        lheight.setBounds (710, 35, 100, 25);
        lwidth.setBounds (710, 80, 100, 25);
        ldepth.setBounds (710, 125, 100, 25);
        lcolornr.setBounds (540, 170, 100, 25);

        lfileName.setBounds(975,285,100,25);

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(5);
        listScroller.setBounds(890,60,250,150);
        linfo.setBounds(890,35,100,25);
        delete.setBounds(1150,60,100,25);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list.getSelectedIndex();
                if(index != -1 && deflist.getSize()>0) {
                    String elem = (String) deflist.get(index);
                    deflist.remove(index);
                    if (elem.charAt(0) == 'E')
                        builder.deleteEdge(elem);
                    else if (elem.charAt(0) == 'P')
                        builder.deletePNode(elem);
                    else
                        builder.deleteSNode(elem);
                }
            }
        });

        back.setBounds(1150,190,100,20);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                builder.deleteAll();
                deflist.removeAllElements();
                MainGUI.createAndShowGUI();
                frame.dispose();
            }
        });


        addA.setBounds (190, 230, 100, 25);
        addA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                float x1a = Float.parseFloat(txcoorda1.getText());
                float y1a = Float.parseFloat(tycoorda1.getText());
                float z1a = Float.parseFloat(tzcoorda1.getText());
                float x2a = Float.parseFloat(txcoorda2.getText());
                float y2a = Float.parseFloat(tycoorda2.getText());
                float z2a = Float.parseFloat(tzcoorda2.getText());

               String text;
               if(!(tcolora.getText().equals("")))
                    text = tcolora.getText();
               else
                  text = "";

               String descr = "EDGE " + "("+ "x1: " + x1a + "," + " y1: " + y1a + "," + " z1: " + z1a + "," +
                            "x2: " + x2a + "," + " y2" + y2a + "," + " z2" + z2a + "," + text + ")";
                builder.addEdge(x1a,y1a,z1a,x2a,y2a,z2a,null,descr,text);
                deflist.addElement(descr);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Type the right data");
                    ex.printStackTrace();
                }
                txcoorda1.setText("");
                tycoorda1.setText("");
                tzcoorda1.setText("");
                txcoorda2.setText("");
                tycoorda2.setText("");
                tzcoorda2.setText("");
                tcolora.setText("");
            }
        });

        addNR.setBounds (540, 230, 100, 25);
        addNR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    float xnr = Float.parseFloat(txcoordnr.getText());
                    float ynr= Float.parseFloat(tycoordnr.getText());
                    float znr = Float.parseFloat(tzcoordnr.getText());
                    float h = Float.parseFloat(theight.getText());
                    float w = Float.parseFloat(twidth.getText());
                    float d = Float.parseFloat(tdepth.getText());

                    String text;
                    if(!(tcolornr.getText().equals("")))
                        text = tcolornr.getText();
                    else
                        text = "";

                    String descr = "PAR NODE " + "("+ "x: " + xnr + "," + " y: " + ynr + "," + " z: " + znr + "," +
                            "h: " + h + "," + " w:" + w + "," + " d:" + d + "," + text + ")";
                    builder.addPNode(xnr,ynr,znr,h,w,d,null,descr,text);
                    deflist.addElement(descr);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Type the right data");
                    ex.printStackTrace();
                }
                txcoordnr.setText("");
                tycoordnr.setText("");
                tzcoordnr.setText("");
                theight.setText("");
                twidth.setText("");
                tdepth.setText("");
                tcolornr.setText("");
            }
        });

        addN.setBounds (10, 275, 100, 25);
        addN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    float x = Float.parseFloat(txcoordn.getText());
                    float y = Float.parseFloat(tycoordn.getText());
                    float z = Float.parseFloat(tzcoordn.getText());
                    double r = Double.parseDouble(tray.getText());


               String text;
               if(!(tcolorn.getText().equals("")))
                    text = tcolorn.getText();
                else
                 text = "";

                    String descr = "SPH NODE " + "("+ "x: " + x + "," + " y: " + y + "," + " z: " + z + "," +
                            "r: " + r + "," + text + ")";
                    builder.addSNode(x,y,z,r,null,descr,text);
                    deflist.addElement(descr);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Type the right data");
                    ex.printStackTrace();
                }
                txcoordn.setText("");
                tycoordn.setText("");
                tzcoordn.setText("");
                tray.setText("");
                tcolorn.setText("");
            }
        });
    }


    public static void runGUI () {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI(){
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new FileMaker());
        frame.pack();
        frame.setVisible (true);
    }
}
