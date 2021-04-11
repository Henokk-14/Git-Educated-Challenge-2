import javax.swing.JFrame;

public class App extends JFrame {

	public App() {
		super("Working Together Pt.3");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// create a jpanel and add it to the frame this.add(new DrawingPanel());
		this.add(new DrawingPanel());
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		
		new App();
		
	}

}
