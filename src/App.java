import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;


import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class App extends JPanel {

	public App() {
        super(new BorderLayout());
		
        JPanel DrawingPanel = new JPanel();
        FlowLayout layout = new FlowLayout();
        DrawingPanel.setLayout(layout);
        
        
        
    }
	
	public float[] convertRGBtoHSV(int R, int B, int G) {
		float[] hsb = Color.RGBtoHSB(17,23,33,null);
        
        float hue = hsb[0];
         
        float saturation = hsb[1];
         
        float brightness = hsb[2];
         
        System.out.println("RGB [" + 17 + "," + 23 + "," + 33 + "] converted to HSB [" + hue + "," + saturation + "," + brightness + "]" );
        return hsb;
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
