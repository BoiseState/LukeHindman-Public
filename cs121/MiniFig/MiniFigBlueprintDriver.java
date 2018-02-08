import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

/**
 * A starting point for creating a new graphical program
 * @author CS121 instructors
 */
@SuppressWarnings("serial")
public class MiniFigBlueprintDriver extends JPanel
{
	public final int INITIAL_WIDTH = 800;
	public final int INITIAL_HEIGHT = 600;
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param page Our graphics canvas.
	 */
	public void paintComponent (Graphics page)
	{
		
		/* This is the anchor point for the MiniFig (x,y) -> (mid,top) */
		int mid = getWidth() / 2;
		int top = 50;
		
		/* Create a new MiniFig object */
		MiniFig bob = new MiniFig(page,mid,top);
		
		
		/* Create a new Color object and update the MiniFig's color */
		Color blueprintBlue = new Color (28, 100, 157);
		page.setColor(blueprintBlue);
		page.fillRect(0, 0, getWidth(), getHeight());
		
		bob.setHeadColor(blueprintBlue);
		bob.setTorsoColor(blueprintBlue);
		bob.setBeltColor(blueprintBlue);
		bob.setArmColor(blueprintBlue);
		bob.setLegColor(blueprintBlue);
		bob.setHandColor(blueprintBlue);
		bob.setHandHoleColor(blueprintBlue);
		bob.setFootColor(blueprintBlue);
		bob.setEyeColor(Color.WHITE);
		bob.setOutlineColor(Color.WHITE);
		

		/* Draw the MiniFig */
		bob.draw();
		
		/* Draw a box around MiniFig to test height and width */
		//page.drawRect(mid - bob.getWidth()/2, top, bob.getWidth(), bob.getHeight());


		
	}


	/**
	 * Constructor (panel initialization)
	 */
	public MiniFigBlueprintDriver()
	{
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
	}


	/**
	 * Sets up a JFrame and the MiniFigDriver panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MiniFigDriver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MiniFigBlueprintDriver());
		frame.pack();
		frame.setVisible(true);
	}
}
