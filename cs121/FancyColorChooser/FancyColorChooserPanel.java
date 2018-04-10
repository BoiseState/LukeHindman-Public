import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FancyColorChooserPanel extends JPanel {
	
	/* Instance variables */
	private ControlPanel inputGrid;
	private JPanel displayPanel;
	private JButton updateDisplayButton;
	
	/* Constructor */
	public FancyColorChooserPanel() {
		
		/* Change the default layout from FlowLayout to BorderLayout */
		this.setLayout(new BorderLayout());
		
		/* Create the GUI components */
		inputGrid = new ControlPanel();
		displayPanel = new JPanel();
		displayPanel.setPreferredSize(new Dimension(300,300));
		updateDisplayButton = new JButton("Update Color");
		updateDisplayButton.addActionListener(new DisplayUpdateActionListener());
		
		/* Add components to panel */
		
		this.add(inputGrid,BorderLayout.SOUTH);
		this.add(displayPanel,BorderLayout.CENTER);
		this.add(updateDisplayButton, BorderLayout.EAST);
		
	}
	
	private class DisplayUpdateActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			displayPanel.setBackground(inputGrid.getColor());
			
		}
		
	}
	
	

}
