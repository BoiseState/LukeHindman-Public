import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel{
	
	/* Instance variables */
	CounterPanel redCounter, greenCounter, blueCounter;
	
	/* Constructor */
	public ControlPanel() {
		
		this.setLayout(new GridLayout(1,3,3,3));
		this.setBackground(Color.orange);
		
		redCounter = new CounterPanel(255);
		redCounter.setBorderColor(Color.red);
		redCounter.setValue(32);
		
		greenCounter = new CounterPanel(255);
		greenCounter.setBorderColor(Color.green);
		greenCounter.setValue(128);
		
		blueCounter = new CounterPanel(255);
		blueCounter.setBorderColor(Color.blue);
		blueCounter.setValue(192);
		
		/* Add counters to panel ColorControlPanel */
		this.add(redCounter);
		this.add(greenCounter);
		this.add(blueCounter);
		
	}
	
	public Color getColor() {
		return new Color(redCounter.getValue(),greenCounter.getValue(), blueCounter.getValue());
	}

}
