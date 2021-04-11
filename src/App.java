import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class App extends JPanel {
	
	Color lightMode = Color.white;
	Color darkMode = Color.getHSBColor(convertRGBtoHSV(25,25,25)[0],convertRGBtoHSV(25,25,25)[1],convertRGBtoHSV(25,25,25)[2]);
	Color greyMode = Color.getHSBColor(convertRGBtoHSV(40,40,40)[0],convertRGBtoHSV(40,40,40)[1],convertRGBtoHSV(40,40,40)[2]);
	Color buttonColor = Color.getHSBColor(convertRGBtoHSV(60,60,60)[0],convertRGBtoHSV(60,60,60)[1],convertRGBtoHSV(60,60,60)[2]);
	
	public float[] convertRGBtoHSV(int R, int B, int G) {
		float[] hsb = Color.RGBtoHSB(R,G,B,null);
        
        float hue = hsb[0];
         
        float saturation = hsb[1];
         
        float brightness = hsb[2];
         
        System.out.println("RGB [" + R + "," + G + "," + B + "] converted to HSB [" + hue + "," + saturation + "," + brightness + "]" );
        return hsb;
	}

	public App() {
        super(new BorderLayout());
		
        // CREATING JFRAME
        JPanel DrawingPanel = new JPanel();
        BorderLayout layout = new BorderLayout();
        DrawingPanel.setLayout(layout);
        
        // CREATING TEXT LABEL
        JLabel TitleText = new JLabel("Git Educated Challenge 2");
        
        // CREATING BUTTONS
        JRadioButton darkModeButton = new JRadioButton("Dark Mode");
        JButton statusButton = new JButton("Status");
        JButton addButton = new JButton("Add");
        JButton commitButton = new JButton("Commit");
        JButton pushButton = new JButton("Push");
        JButton clButton = new JButton("Clear Input");
        
        // SETTING BUTTONS
        statusButton.setBackground(buttonColor);
        statusButton.setForeground(Color.white);
        addButton.setBackground(buttonColor);
        addButton.setForeground(Color.white);
        commitButton.setBackground(buttonColor);
        commitButton.setForeground(Color.white);
        pushButton.setBackground(buttonColor);
        pushButton.setForeground(Color.white);
        clButton.setBackground(buttonColor);
        clButton.setForeground(Color.white);
        
        // CREATING TITLE TEXT
        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.setBackground(darkMode);
        titlePanel.add(TitleText);
        TitleText.setForeground(Color.white);
        
        // DARK MODE BUTTON
        JPanel northPanel = new JPanel(new GridLayout());
        northPanel.setBackground(darkMode);
        northPanel.add(darkModeButton);
        darkModeButton.setBackground(darkMode);
        darkModeButton.setForeground(Color.white);
        darkModeButton.setSelected(true);
        
        
        // RADIO BUTTONS
        JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.setBackground(darkMode);
        southPanel.add(statusButton);
        southPanel.add(addButton);
        southPanel.add(commitButton);
        southPanel.add(pushButton);
        southPanel.add(clButton);
        
        // TEXT BOXES AND OUTPUT
        JPanel centerPanel = new JPanel(new GridLayout());
        JPanel eastPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel leftSide = new JPanel(new GridLayout());
        JPanel rightSide = new JPanel(new GridLayout());
        // CREATING JTEXTAREAS
        JTextArea inputFrame = new JTextArea("Enter Input Here");
        inputFrame.setEditable(true);
        inputFrame.setLineWrap(true);  
        inputFrame.setWrapStyleWord(true);  
        inputFrame.setForeground(Color.white);
        inputFrame.setBackground(greyMode);

        JTextArea outputFrame = new JTextArea("Output...");
        outputFrame.setEditable(false);
        outputFrame.setLineWrap(true);  
        outputFrame.setWrapStyleWord(true);  
        outputFrame.setForeground(Color.white);
        outputFrame.setBackground(greyMode);
        
        // CREATING JSPLITPANE
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftSide, rightSide);
        splitPane.setResizeWeight(0.52);
        leftSide.add(inputFrame);
        rightSide.add(outputFrame);
        centerPanel.add(splitPane);
        
        centerPanel.setBackground(greyMode);
        eastPanel.setBackground(darkMode);
        westPanel.setBackground(darkMode);
        
        // ADDING PANEL TO JFRAME
        DrawingPanel.setBackground(darkMode);
        add(titlePanel,BorderLayout.NORTH);
        DrawingPanel.add(northPanel,BorderLayout.NORTH);
        DrawingPanel.add(southPanel,BorderLayout.SOUTH);
        DrawingPanel.add(centerPanel,BorderLayout.CENTER);
        DrawingPanel.add(eastPanel,BorderLayout.EAST);
        DrawingPanel.add(westPanel,BorderLayout.WEST);
        
        add(DrawingPanel);
        
    }
	
	private static void createAndShowGUI(Runnable t) {
        //Create and set up the window.
        JFrame frame = new JFrame("Working Together Pt.3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JComponent newContentPane = new App();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        
        
        
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setResizable(false);
        frame.pack();
        
        frame.setVisible(true);
    }
	
	
	@Override  
    public Dimension getPreferredSize() {  
        return new Dimension(800,500);  // CHANGES JFRAME DIMENSIONS
    }  

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               createAndShowGUI(this);
            }
        });
    }

}