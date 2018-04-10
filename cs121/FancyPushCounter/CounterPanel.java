import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CounterPanel extends JPanel {
	
	/* Instance Variables */
	private JButton upButton, downButton;
	private JLabel displayLabel;
	private int value;
	
	/* Constructor */
	
	public CounterPanel() {
		this.value = 0;
		
		CounterButtonListener cbl = new CounterButtonListener();
		
		upButton = new JButton("Up");
		upButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		upButton.addActionListener(cbl);
		
		
		downButton = new JButton("Down");
		downButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		downButton.addActionListener(cbl);
		
		displayLabel = new JLabel(Integer.toString(this.value));
		displayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		/* Chnge default layout from FlowLayout to BoxLayout */
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(upButton);
		this.add(displayLabel);
		this.add(downButton);
	}
	
	private class CounterButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			
			if (b == upButton) {
				value++;	
			} else {
				value--;
			}
			displayLabel.setText(Integer.toString(value));
			
		}
		
	}
	
	

}
