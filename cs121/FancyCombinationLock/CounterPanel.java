import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CounterPanel extends JPanel{
	
	/* Instance variables */
	private final int minValue = 0;
	private int value;
	private int maxValue;
	private JButton upButton;
	private JButton downButton;
	private JLabel displayLabel;
	//private JTextField displayField;
	
	/* Constructor */
	public CounterPanel(int maxValue) {
		this.value = minValue;
		this.maxValue = maxValue;
		this.upButton = new JButton("Up");
		this.upButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.downButton = new JButton("Down");
		this.downButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.displayLabel = new JLabel(Integer.toString(this.value));
		this.displayLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		/* Change the default layout from FlowLayout to BoxLayout */
		this.setLayout( new BoxLayout(this,BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
		
		/* Create a new CounterPanelListenerButton and add it to the buttons */
		CounterPanelButtonListener cpbl = new CounterPanelButtonListener();
		this.upButton.addActionListener(cpbl);
		this.downButton.addActionListener(cpbl);
		
		/* Add components to panel to panel */
		this.add(upButton);
		this.add(displayLabel);
		this.add(downButton);
		
		updateButtonState();
		
	}
	
	/* Useful Methods */
	
	/**
	 * Return the current value of the CounterPanel
	 * @return value of counter
	 */
	public int getValue() {
		return this.value;
	}
	
	/**
	 * Update the CounterPanel to the specified value
	 * @param value The value to set the counterPanel to.
	 */
	public void setValue(int value) {
		if (value >= minValue && value <= maxValue) {
			this.value = value;
			this.displayLabel.setText(Integer.toString(value));
		}
		updateButtonState();
		displayLabel.setText(Integer.toString(value));
		
	}
	
	private void updateButtonState() {
		if (value == maxValue) {
			upButton.setEnabled(false);
		} else {
			upButton.setEnabled(true);
		}
		
		if (value == minValue) {
			downButton.setEnabled(false);
		} else {
			downButton.setEnabled(true);
		}
	}
	
	public void setBorderColor(Color c) {
		this.setBorder(BorderFactory.createLineBorder(c, 4));
	}
	
	/* Define the ActionListener for the counter panel buttons */
	
	private class CounterPanelButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			
			if (b == upButton) {
				setValue(value + 1);
			} else {
				setValue(value - 1);
			}

			
			
		}
		
	}
	

}
