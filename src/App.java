import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;


public class App extends JPanel {
	
	Color lightMode = Color.white;
	Color darkMode = Color.getHSBColor(convertRGBtoHSV(13,13,13)[0],convertRGBtoHSV(13,13,13)[1],convertRGBtoHSV(13,13,13)[2]);
	
	public float[] convertRGBtoHSV(int R, int B, int G) {
		float[] hsb = Color.RGBtoHSB(17,23,33,null);
        
        float hue = hsb[0];
         
        float saturation = hsb[1];
         
        float brightness = hsb[2];
         
        System.out.println("RGB [" + 17 + "," + 23 + "," + 33 + "] converted to HSB [" + hue + "," + saturation + "," + brightness + "]" );
        return hsb;
	}

	public App() {
        super(new BorderLayout());
		
        // CREATING JFRAME
        JPanel DrawingPanel = new JPanel();
        BorderLayout layout = new BorderLayout();
        DrawingPanel.setLayout(layout);
        
        // CREATING BUTTONS
        JRadioButton darkModeButton = new JRadioButton("Dark Mode");
        JRadioButton addButton = new JRadioButton("Add");
        JRadioButton commitButton = new JRadioButton("Commit");
        JRadioButton pushButton = new JRadioButton("Push");
        JRadioButton sButton = new JRadioButton("S");
        
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
        southPanel.add(addButton);
        southPanel.add(commitButton);
        southPanel.add(pushButton);
        southPanel.add(sButton);
        
        // TEXT BOXES AND OUTPUT
        JPanel centerPanel = new JPanel(new FlowLayout());
        JPanel leftSide = new JPanel();
        JPanel rightSide = new JPanel();
        JTextField inputFrame = new JTextField("Enter Input Here");
        inputFrame.setEditable(true);
        JTextField outputFrame = new JTextField("Output Comes Here");
        outputFrame.setEditable(false);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftSide, rightSide);
        leftSide.add(inputFrame);
        rightSide.add(outputFrame);
        centerPanel.add(splitPane);
        centerPanel.setBackground(darkMode);
        
        // ADDING PANEL TO JFRAME
        DrawingPanel.setBackground(darkMode);
        
        DrawingPanel.add(northPanel,BorderLayout.NORTH);
        DrawingPanel.add(southPanel,BorderLayout.SOUTH);
        DrawingPanel.add(centerPanel,BorderLayout.CENTER);
        
        
        this.add(DrawingPanel);
        
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
        return new Dimension(800,600);  //
    }  

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               createAndShowGUI(this);
            }
        });
    }

}
