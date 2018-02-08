import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

/**
 * A starting point for creating a new graphical program
 * @author CS121 instructors
 */
@SuppressWarnings("serial")
public class MiniFigBlueprintDriver extends JPanel
{
	public final int INITIAL_WIDTH = 600;
	public final int INITIAL_HEIGHT = 450;
	public enum Position {UpperLeft, LowerLeft, UpperRight, LowerRight};
	
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
		
		
		/* Mark the points on MiniFig that are available via accessor methods */
		int pointDiameter = 8;
		page.setColor(Color.WHITE);
		
		Point topMidPoint = bob.getTopMidPoint();
		page.fillOval(topMidPoint.x - pointDiameter / 2, topMidPoint.y - pointDiameter / 2, pointDiameter, pointDiameter);
		placeText(page,topMidPoint.x,topMidPoint.y,"getTopMidPoint()",Position.UpperRight);
		
		Point capPoint = bob.getCapPoint();
		page.fillOval(capPoint.x - pointDiameter / 2, capPoint.y - pointDiameter / 2, pointDiameter, pointDiameter);
		placeText(page,capPoint.x,capPoint.y,"getCapPoint()",Position.UpperRight);
		
		Point rightShoulderPoint = bob.getRightShoulderPoint();
		page.fillOval(rightShoulderPoint.x - pointDiameter / 2, rightShoulderPoint.y - pointDiameter / 2, pointDiameter, pointDiameter);
		placeText(page,rightShoulderPoint.x,rightShoulderPoint.y,"getRightShoulderPoint()",Position.UpperLeft);
		
		Point leftShoulderPoint = bob.getLeftShoulderPoint();
		page.fillOval(leftShoulderPoint.x - pointDiameter / 2, leftShoulderPoint.y - pointDiameter / 2, pointDiameter, pointDiameter);
		placeText(page,leftShoulderPoint.x,leftShoulderPoint.y,"getLeftShoulderPoint()",Position.UpperRight);
		
		Point rightHandCenterPoint = bob.getRightHandCenterPoint();
		page.fillOval(rightHandCenterPoint.x - pointDiameter / 2, rightHandCenterPoint.y - pointDiameter / 2, pointDiameter, pointDiameter);
		placeText(page,rightHandCenterPoint.x,rightHandCenterPoint.y,"getRightHandCenterPoint()",Position.UpperLeft);
		
		Point leftHandCenterPoint = bob.getLeftHandCenterPoint();
		page.fillOval(leftHandCenterPoint.x - pointDiameter / 2, leftHandCenterPoint.y - pointDiameter / 2, pointDiameter, pointDiameter);
		placeText(page,leftHandCenterPoint.x,leftHandCenterPoint.y,"getLeftHandCenterPoint()",Position.LowerRight);
		
		Point baseMidPoint = bob.getBaseMidPoint();
		page.fillOval(baseMidPoint.x - pointDiameter / 2, baseMidPoint.y - pointDiameter / 2, pointDiameter, pointDiameter);
		placeText(page,baseMidPoint.x,baseMidPoint.y,"getBaseMidPoint()",Position.LowerRight);
		
		/* Draw a box around MiniFig to test height and width */
		//page.drawRect(mid - bob.getWidth()/2, top, bob.getWidth(), bob.getHeight());


		
	}
	
	private void placeText(Graphics g, int x, int y, String msg, Position p) {
		g.setFont(new Font("Monospaced", Font.BOLD, 12));
		
		
		FontMetrics metrics = g.getFontMetrics();
		int msgWidth = metrics.stringWidth(msg);
		int msgHeight = metrics.getHeight();
		
		Point p1 = new Point(x,y);
		Point p2 = new Point();
		Point p3 = new Point();
		Point p4 = new Point();
		
		if (p == Position.UpperRight) {
			p2.x = p1.x+15;
			p2.y = p1.y-msgHeight;
			p3.x = p2.x+15;
			p3.y = p2.y;
			p4.x = p3.x;
			p4.y = p3.y;
		} else if (p == Position.LowerRight) {
			p2.x = p1.x+15;
			p2.y = p1.y+msgHeight;
			p3.x = p2.x+15;
			p3.y = p2.y;
			p4.x = p3.x;
			p4.y = p3.y;
		} else if (p == Position.UpperLeft) {
			p2.x = p1.x-15;
			p2.y = p1.y-msgHeight;
			p3.x = p2.x-15;
			p3.y = p2.y;
			p4.x = p3.x - msgWidth ;
			p4.y = p3.y;
		} else if (p == Position.LowerLeft) {
			p2.x = p1.x-15;
			p2.y = p1.y+msgHeight;
			p3.x = p2.x-15;
			p3.y = p2.y;
			p4.x = p3.x - msgWidth ;
			p4.y = p3.y;
		} 

		
		Color savedColor = g.getColor();
		g.setColor(Color.black);
		g.drawLine(p1.x,p1.y, p2.x, p2.y);
		g.drawLine(p2.x,p2.y, p3.x, p3.y);
		g.drawString(msg, p4.x, p4.y);
		
		g.setColor(savedColor);
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
