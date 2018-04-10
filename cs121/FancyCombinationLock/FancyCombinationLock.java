import javax.swing.JFrame;

public class FancyCombinationLock {

	public static void main(String[] args) {
		JFrame frame = new JFrame ("Fancy Combination Lock");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new FancyCombinationLockPanel());
		
		frame.pack();
		frame.setVisible(true);

	}

}
