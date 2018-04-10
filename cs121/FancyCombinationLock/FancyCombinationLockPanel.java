import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FancyCombinationLockPanel extends JPanel {
	
	/* Instance variables */
	private final int maxValue = 10;
	
	/* CodePanel instance variables */	
	private JPanel codePanel;
	private int code0,code1,code2;
	private JTextField codeField0, codeField1, codeField2;
	private JButton setCodeButton;
	private JButton testCodeButton;
	
	/* TumberPanel instance variables */
	private TumblerPanel tumbler;
	private JLabel lockStatusLabel;
	
	public FancyCombinationLockPanel() {
		
		/* Setup the code panel */
		this.codePanel = new JPanel();
		this.codeField0 = new JTextField();
		this.codeField1 = new JTextField();
		this.codeField2 = new JTextField();
		
		Random rand = new Random();

		codeField0.setText(Integer.toString(rand.nextInt(maxValue + 1)));
		codeField1.setText(Integer.toString(rand.nextInt(maxValue + 1)));
		codeField2.setText(Integer.toString(rand.nextInt(maxValue + 1)));
		
		setCodeButton = new JButton("Set Code");
		setCodeButton.addActionListener(new SetCodeButtonListener());
		
		testCodeButton = new JButton("Test Code");
		testCodeButton.addActionListener(new TestCodeButtonListener());
		
		codePanel.add(codeField0);
		codePanel.add(codeField1);
		codePanel.add(codeField2);
		codePanel.add(setCodeButton);
		codePanel.add(testCodeButton);
		
		/* Setup the TumblerPanel */
		tumbler = new TumblerPanel(maxValue);
		
		/* Setup the status label */
		lockStatusLabel = new JLabel("Status: Unlocked");

		
		/* Setup the layout of this panel and add GUI components */
		this.setLayout(new BorderLayout());
		this.add(codePanel, BorderLayout.NORTH);
		this.add(tumbler,BorderLayout.CENTER);
		this.add(lockStatusLabel,BorderLayout.SOUTH);

	}
	
	private class TestCodeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (tumbler.getFirstValue() == code0 &&
					tumbler.getSecondValue() == code1 &&
					tumbler.getThirdValue() == code2) {
				
				codeField0.setText(Integer.toString(code0));
				codeField0.setEnabled(true);
				codeField1.setText(Integer.toString(code1));
				codeField1.setEnabled(true);
				codeField2.setText(Integer.toString(code2));
				codeField2.setEnabled(true);
				
				setCodeButton.setEnabled(true);
				
				lockStatusLabel.setText("Status: Unlocked");
			}
			
		}
		
	}
	
	private class SetCodeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				code0 = Integer.parseInt(codeField0.getText());
				code1 = Integer.parseInt(codeField1.getText());
				code2 = Integer.parseInt(codeField2.getText());
				
				codeField0.setText("*");
				codeField0.setEnabled(false);
				codeField1.setText("*");
				codeField1.setEnabled(false);
				codeField2.setText("*");
				codeField2.setEnabled(false);
				
				setCodeButton.setEnabled(false);
				
				lockStatusLabel.setText("Status: Locked");
				
			} catch (Exception ex) {
				System.out.println("Invalid input in field, please enter Integer values");
			}

			
		}
		
	}
	
	
	
	

}
