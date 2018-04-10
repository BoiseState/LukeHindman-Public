import javax.swing.JFrame;

public class FancyColorChooser {

	public static void main(String[] args) {
		JFrame frame = new JFrame ("Fancy Color Chooser");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new FancyColorChooserPanel());
		
		frame.pack();
		frame.setVisible(true);

	}

}
