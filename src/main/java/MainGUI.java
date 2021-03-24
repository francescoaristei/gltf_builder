import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainGUI extends JPanel {
    private JButton create;
    private JButton load;
    public static JFrame jframe = new JFrame("MainGUI");

    public MainGUI() {
        //construct components
        create = new JButton ("NEW FILE");
        load = new JButton ("LOAD FILE");

        //adjust size and set layout
        setPreferredSize (new Dimension (624, 334));
        setLayout (null);

        //add components
        add (create);
        add (load);

        //set component bounds (only needed by Absolute Positioning)
        create.setBounds (235, 85, 140, 25);
        load.setBounds (235, 195, 140, 25);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        jframe.dispose();
                        FileMaker.runGUI();
                    }
                });
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileLoader.loadModel();
            }
        });
    }

    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI(){
        jframe.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        jframe.getContentPane().add (new MainGUI());
        jframe.pack();
        jframe.setVisible (true);
    }
}
