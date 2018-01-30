import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Color;

/**
 * A starting point for creating a new graphical program
 * @author CS121 instructors
 */
@SuppressWarnings("serial")
public class MiniFig extends JPanel
{
	
	private final int DEFAULT_HEIGHT = 450;
	private final int DEFAULT_WIDTH = 300;
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param page Our graphics canvas.
	 */
	public void paintComponent (Graphics page)
	{
		Color backgroundColor = Color.WHITE;
		Color headColor = new Color(255,227,48);
		Color shirtColor = new Color(7,60,145);
		Color beltColor = new Color (104,3,33);
		Color legColor = Color.BLACK;
		Color footColor = Color.DARK_GRAY;
		Color armColor = new Color (14, 250, 20);
		Color handColor = new Color(255,227,48);
		Color handHoleColor = backgroundColor;
		
		int mid = getWidth() / 2;
		int top = 50;
		
		double scaleFactor = Math.min(getWidth()/(double)DEFAULT_WIDTH,getHeight()/(double)DEFAULT_HEIGHT );
		
		/* Set the background color */
		page.setColor(backgroundColor);
		page.fillRect(0, 0, getWidth(), getHeight());
		
		/* Head */
		int knobWidth = (int) (40 * scaleFactor);
		int knobHeight = (int) (16 * scaleFactor);
		int knobHeightPadded = knobHeight + 2; // extend knob below head to hide curved border
		int knobXOffset = mid - knobWidth / 2;
		int knobYOffset = top;
		int knobCurve = Math.min(5, (int) (5 * scaleFactor));
		page.setColor(headColor);
		page.fillRoundRect(knobXOffset,knobYOffset,knobWidth,knobHeightPadded,knobCurve,knobCurve); //head knob
		page.setColor(Color.BLACK);
		page.drawRoundRect(knobXOffset,knobYOffset,knobWidth,knobHeightPadded,knobCurve,knobCurve); //head knob
		
		System.out.println("knob width,height: " + knobWidth + "," + knobHeight); 
		
		int headWidth = (int) (84 * scaleFactor);
		int headHeight = (int) (75 * scaleFactor);
		int headXOffset = mid - headWidth / 2;
		int headYOffset = top + knobHeight;
		int headCurve = Math.min(28, (int) (28 * scaleFactor));
		page.setColor(headColor);
		page.fillRoundRect(headXOffset,headYOffset,headWidth,headHeight,headCurve,headCurve); //head
		page.setColor(Color.BLACK);
		page.drawRoundRect(headXOffset,headYOffset,headWidth,headHeight,headCurve,headCurve); //head
		
		int neckWidth = (int) (54 * scaleFactor);
		int neckHeight = (int) (10 * scaleFactor);
		int neckXOffset = mid - neckWidth / 2;
		int neckYOffset = headYOffset + headHeight;
		page.setColor(headColor);
		page.fillRect(neckXOffset,neckYOffset,neckWidth,neckHeight); //neck
		page.setColor(Color.BLACK);
		page.drawRect(neckXOffset,neckYOffset,neckWidth,neckHeight); //neck
		
		int eyeSpacing = (int) (30 * scaleFactor);
		int eyeDiameter = (int) (10 * scaleFactor);
		int distFromTopOfHead = (int) (28 * scaleFactor); 
		int leftEyeXOffset = mid - (eyeSpacing / 2 + eyeDiameter / 2);
		int rightEyeXOffset = mid + (eyeSpacing / 2 - eyeDiameter / 2);
		int EyeYOffset = headYOffset + distFromTopOfHead;
		page.fillOval(leftEyeXOffset, EyeYOffset, eyeDiameter, eyeDiameter); // right eye
		page.fillOval(rightEyeXOffset, EyeYOffset, eyeDiameter, eyeDiameter); // left eye
		
		int mouthOvalDiameter = (int) (40 * scaleFactor);
		int mountDistFromTopOfHead = (int) (18 * scaleFactor);
		int mouthXOffset = mid - mouthOvalDiameter / 2;
		int mouthYOffset = headYOffset + mountDistFromTopOfHead;
		page.drawArc(mouthXOffset,mouthYOffset,mouthOvalDiameter,mouthOvalDiameter,225,90); // mouth
		
		/* Torso */
		Polygon torso = new Polygon();
		int torsoShoulderWidth = (int) (90 * scaleFactor);
		int torsoWaistWidth = (int) (130 * scaleFactor);
		int torsoHeight = (int) (114 * scaleFactor);
		int torsoShoulderYOffset = neckYOffset + neckHeight;
		int torsoWaistYOffset = neckYOffset + neckHeight + torsoHeight;
		torso.addPoint(mid - torsoShoulderWidth / 2, torsoShoulderYOffset ); //right shoulder point
		torso.addPoint(mid + torsoShoulderWidth / 2, torsoShoulderYOffset); //left shoulder point
		torso.addPoint(mid + torsoWaistWidth / 2, torsoWaistYOffset ); //left waist point
		torso.addPoint(mid - torsoWaistWidth / 2, torsoWaistYOffset ); //right waist point

		
		int beltWidth = (int) (120 * scaleFactor);
		int beltHeight = (int) (20 * scaleFactor);
		int beltXOffset = mid - beltWidth/2;
		int beltYOffset = torsoWaistYOffset;
		page.setColor(beltColor);
		page.fillRect(beltXOffset,beltYOffset, beltWidth, beltHeight); // belt
		

		/* Legs */
		int lowerLegWidth = (int) (60 * scaleFactor);
		int legSpacing = (int) (10 * scaleFactor);
		int legLength = (int) (94 * scaleFactor);
		int footHeight = (int) (28 * scaleFactor);
		int upperLegYOffset = beltYOffset + beltHeight;
		int lowerLegYOffset = upperLegYOffset + legLength;
		
		Polygon rightLeg = new Polygon();
		int rightLegXOffset = mid - beltWidth/2;
		int rightLegInseamXOffset = mid - (legSpacing / 2);
		int rightLegLowerXOffset = mid - (legSpacing / 2 + lowerLegWidth);
		rightLeg.addPoint(rightLegXOffset, upperLegYOffset);
		rightLeg.addPoint(rightLegInseamXOffset, upperLegYOffset);
		rightLeg.addPoint(rightLegInseamXOffset, lowerLegYOffset);
		rightLeg.addPoint(rightLegLowerXOffset, lowerLegYOffset);
		page.setColor(legColor);	
		page.fillPolygon(rightLeg);  //right leg
		page.setColor(Color.BLACK);
		page.drawPolygon(rightLeg);  //right leg
		
		int rightFootXOffset = rightLegLowerXOffset;
		int rightFootYOffset = lowerLegYOffset;
		int rightFootWidth = lowerLegWidth;
		page.setColor(footColor);
		page.fillRect(rightFootXOffset, rightFootYOffset, rightFootWidth, footHeight); // right foot
		page.setColor(Color.BLACK);
		page.drawRect(rightFootXOffset, rightFootYOffset, rightFootWidth, footHeight); // right foot
		
		Polygon leftLeg = new Polygon();
		int leftLegXOffset = mid + beltWidth/2;
		int leftLegInseamXOffset = mid + (legSpacing / 2);
		int leftLegLowerXOffset = mid + (legSpacing / 2 + lowerLegWidth);
		leftLeg.addPoint(leftLegXOffset, upperLegYOffset);
		leftLeg.addPoint(leftLegInseamXOffset, upperLegYOffset);
		leftLeg.addPoint(leftLegInseamXOffset, lowerLegYOffset);
		leftLeg.addPoint(leftLegLowerXOffset, lowerLegYOffset);
		page.setColor(legColor);	
		page.fillPolygon(leftLeg);  //left leg
		page.setColor(Color.BLACK);
		page.drawPolygon(leftLeg);  //left leg
		
		int leftFootXOffset = leftLegInseamXOffset;
		int leftFootYOffset = lowerLegYOffset;
		int leftFootWidth = lowerLegWidth;
		page.setColor(footColor);
		page.fillRect(leftFootXOffset, leftFootYOffset, leftFootWidth, footHeight); // left foot
		page.setColor(Color.BLACK);
		page.drawRect(leftFootXOffset, leftFootYOffset, leftFootWidth, footHeight); // left foot
		
		int legDividerWidth = (int) (12 * scaleFactor);
		int legDividerHeight = (int) (54 * scaleFactor);
		int legDividerXOffset = mid - legDividerWidth / 2;
		int legDividerYOffset = beltYOffset + beltHeight;
		page.setColor(footColor);
		page.fillRect(legDividerXOffset, legDividerYOffset, legDividerWidth, legDividerHeight);
		page.setColor(Color.BLACK);
		page.drawRect(legDividerXOffset, legDividerYOffset, legDividerWidth, legDividerHeight);
		
		/* Arms */
		int armUpperWidth = (int) (31 * scaleFactor);
		int armUpperHeight = (int) (20 * scaleFactor); 
		int armCuffWidth = (int) (35 * scaleFactor);
		
		int armShoulderYOffset = torsoShoulderYOffset+ (int) (8 * scaleFactor);
		int armElbowYOffset = armShoulderYOffset + (int) (58 * scaleFactor);
		int armUpperCuffYOffset = armElbowYOffset + (int) (34 * scaleFactor);
		int armLowerCuffYOffset = armElbowYOffset + (int) (38 * scaleFactor);
		
		Point rightArmAnchor = new Point(mid - (torsoShoulderWidth / 2 + armUpperWidth ),
				armShoulderYOffset);
		Point rightArmSleeve = new Point(rightArmAnchor.x - (int) (2 * scaleFactor),
				rightArmAnchor.y + armUpperHeight - (int) (2 * scaleFactor));
		Point rightArmElbow = new Point(rightArmAnchor.x - (int) (18 * scaleFactor), 
				armElbowYOffset);
		Point rightArmCuffOuter = new Point(rightArmAnchor.x - (int) (24 * scaleFactor), 
				armUpperCuffYOffset);
		Point rightArmCuffInner = new Point(rightArmCuffOuter.x + armCuffWidth,
				armLowerCuffYOffset);
		Point rightArmPit = new Point(rightArmAnchor.x + armUpperWidth , 
				rightArmAnchor.y);

		Polygon rightArm = new Polygon();
		rightArm.addPoint(rightArmSleeve.x, rightArmSleeve.y);
		rightArm.addPoint(rightArmElbow.x , rightArmElbow.y);
		rightArm.addPoint(rightArmCuffOuter.x, rightArmCuffOuter.y);
		rightArm.addPoint(rightArmCuffInner.x, rightArmCuffInner.y);
		rightArm.addPoint(rightArmPit.x, rightArmPit.y);
		
		
		page.setColor(armColor);
		page.fillPolygon(rightArm);
		page.setColor(Color.BLACK);
		page.drawPolygon(rightArm);
		page.setColor(armColor);
		page.fillArc(rightArmAnchor.x, rightArmAnchor.y, armUpperWidth * 2, armUpperHeight * 2,90,90);
		page.setColor(Color.BLACK);
		page.drawArc(rightArmAnchor.x, rightArmAnchor.y, armUpperWidth * 2, armUpperHeight * 2,90,80);


		Point leftArmAnchor = new Point(mid + (torsoShoulderWidth / 2 - armUpperWidth),
				armShoulderYOffset);
		Point leftArmSleeve = new Point(leftArmAnchor.x  + armUpperWidth * 2 + (int) (2 * scaleFactor),
				leftArmAnchor.y + armUpperHeight - (int) (2 * scaleFactor) );
		Point leftArmElbow = new Point(leftArmAnchor.x + armUpperWidth*2 + (int) (18 * scaleFactor), 
				armElbowYOffset);
		Point leftArmCuffOuter = new Point(leftArmAnchor.x + armUpperWidth*2 + (int) (24 * scaleFactor),
				armUpperCuffYOffset);
		Point leftArmCuffInner = new Point(leftArmAnchor.x + armUpperWidth + (int) (20 * scaleFactor),
				armLowerCuffYOffset);
		Point leftArmPit = new Point(leftArmAnchor.x + armUpperWidth, 
				leftArmAnchor.y);
		
		Polygon leftArm = new Polygon();
		leftArm.addPoint(leftArmSleeve.x, leftArmSleeve.y);
		leftArm.addPoint(leftArmElbow.x, leftArmElbow.y);
		leftArm.addPoint(leftArmCuffOuter.x, leftArmCuffOuter.y);
		leftArm.addPoint(leftArmCuffInner.x, leftArmCuffInner.y);
		leftArm.addPoint(leftArmPit.x,leftArmPit.y );
		
		page.setColor(armColor);
		page.fillPolygon(leftArm);
		page.setColor(Color.BLACK);
		page.drawPolygon(leftArm);
		page.setColor(armColor);
		page.fillArc(leftArmAnchor.x, leftArmAnchor.y, armUpperWidth * 2, armUpperHeight * 2,90,-90);
		page.setColor(Color.BLACK);
		page.drawArc(leftArmAnchor.x, leftArmAnchor.y, armUpperWidth * 2, armUpperHeight * 2,90,-80);

		page.setColor(shirtColor);
		page.fillPolygon(torso);
		page.setColor(Color.BLACK);
		page.drawPolygon(torso);
		
		
		/* Draw Wrist and Hands */
		int wristLength = (int) (15 * scaleFactor);
		// Calculate width of cuff using Pathagorian Theorem */
		double cuffWidth = Math.sqrt( Math.pow(Math.abs(rightArmCuffOuter.x - rightArmCuffInner.x),2) +
				Math.pow(Math.abs(rightArmCuffOuter.y - rightArmCuffInner.y),2));
		
		
		double rightCuffSlope = ((double) rightArmCuffOuter.y - rightArmCuffInner.y) / (rightArmCuffOuter.x - rightArmCuffInner.x);
		double rightCuffAngle = Math.atan(rightCuffSlope);
				
		Point rightWristCuffOuter = new Point();
		/* Distance from outer cuff edge to outer wrist edge (1/5 cuffWidth) */
		double rightWristDist1 = cuffWidth / 5.0;
		rightWristCuffOuter.x = (int) (rightArmCuffOuter.x - (rightWristDist1 * (rightArmCuffOuter.x - rightArmCuffInner.x)) / cuffWidth);
		rightWristCuffOuter.y = (int) (rightArmCuffOuter.y - (rightWristDist1 * (rightArmCuffOuter.y - rightArmCuffInner.y)) / cuffWidth);
		
		Point rightWristCuffInner = new Point();
		/* Distance from outer cuff edge to inner wrist edge (4/5 cuffWidth) */
		double rightWristDist2 = 4 * cuffWidth / 5.0; 
		rightWristCuffInner.x = (int) (rightArmCuffOuter.x - (rightWristDist2 * (rightArmCuffOuter.x - rightArmCuffInner.x)) / cuffWidth);
		rightWristCuffInner.y = (int) (rightArmCuffOuter.y - (rightWristDist2 * (rightArmCuffOuter.y - rightArmCuffInner.y)) / cuffWidth);
		
		Point rightWristHandOuter = new Point();
		rightWristHandOuter.x = (int)(rightWristCuffOuter.x + wristLength * Math.cos(rightCuffAngle + Math.PI/2.0));
		rightWristHandOuter.y = (int)(rightWristCuffOuter.y + wristLength * Math.sin(rightCuffAngle + Math.PI/2.0));
		
		Point rightWristHandInner = new Point();
		rightWristHandInner.x = (int)(rightWristCuffInner.x + wristLength * Math.cos(rightCuffAngle + Math.PI/2.0));
		rightWristHandInner.y = (int)(rightWristCuffInner.y + wristLength * Math.sin(rightCuffAngle + Math.PI/2.0));
		
		Polygon rightWrist = new Polygon();
		rightWrist.addPoint(rightWristCuffOuter.x, rightWristCuffOuter.y);
		rightWrist.addPoint(rightWristCuffInner.x, rightWristCuffInner.y);
		rightWrist.addPoint(rightWristHandInner.x, rightWristHandInner.y);
		rightWrist.addPoint(rightWristHandOuter.x, rightWristHandOuter.y);
		
		page.setColor(handColor);
		page.fillPolygon(rightWrist);
		page.setColor(Color.BLACK);
		page.drawPolygon(rightWrist);
		

		
		/* Left hand */
		
		double leftCuffSlope = ((double)leftArmCuffOuter.y - leftArmCuffInner.y) / (leftArmCuffOuter.x - leftArmCuffInner.x);
		double leftCuffAngle = Math.atan(leftCuffSlope);
				
		Point leftWristCuffOuter = new Point();
		/* Distance from outer cuff edge to outer wrist edge (1/5 cuffWidth) */
		double leftWristDist1 = cuffWidth / 5.0;
		leftWristCuffOuter.x = (int) (leftArmCuffOuter.x - (leftWristDist1 * (leftArmCuffOuter.x - leftArmCuffInner.x)) / cuffWidth);
		leftWristCuffOuter.y = (int) (leftArmCuffOuter.y - (leftWristDist1 * (leftArmCuffOuter.y - leftArmCuffInner.y)) / cuffWidth);
		
		Point leftWristCuffInner = new Point();
		/* Distance from outer cuff edge to inner wrist edge (4/5 cuffWidth) */
		double leftWristDist2 = 4 * cuffWidth / 5.0; 
		leftWristCuffInner.x = (int) (leftArmCuffOuter.x - (leftWristDist2 * (leftArmCuffOuter.x - leftArmCuffInner.x)) / cuffWidth);
		leftWristCuffInner.y = (int) (leftArmCuffOuter.y - (leftWristDist2 * (leftArmCuffOuter.y - leftArmCuffInner.y)) / cuffWidth);
		
		Point leftWristHandOuter = new Point();
		leftWristHandOuter.x = (int)(leftWristCuffOuter.x + wristLength * Math.cos(leftCuffAngle + Math.PI / 2.0  )) + 1;
		leftWristHandOuter.y = (int)(leftWristCuffOuter.y + wristLength * Math.sin(leftCuffAngle + Math.PI / 2.0 ));
		
		Point leftWristHandInner = new Point();
		leftWristHandInner.x = (int)(leftWristCuffInner.x + wristLength * Math.cos(leftCuffAngle + Math.PI / 2.0 )) + 1;
		leftWristHandInner.y = (int)(leftWristCuffInner.y + wristLength * Math.sin(leftCuffAngle + Math.PI / 2.0 ));
		
		Polygon leftWrist = new Polygon();
		leftWrist.addPoint(leftWristCuffOuter.x, leftWristCuffOuter.y);
		leftWrist.addPoint(leftWristCuffInner.x, leftWristCuffInner.y);
		leftWrist.addPoint(leftWristHandInner.x, leftWristHandInner.y);
		leftWrist.addPoint(leftWristHandOuter.x, leftWristHandOuter.y);
		
		page.setColor(handColor);
		page.fillPolygon(leftWrist);
		page.setColor(Color.BLACK);
		page.drawPolygon(leftWrist);
		
		int handDiameter = (int) (45 * scaleFactor);
		int handHoleDiameter = (int) (30 * scaleFactor);
		//Left hand
		int leftHandXShift = (int) (-30 * scaleFactor);
		int leftHandYShift = (int) (-1 * scaleFactor);
		page.setColor(handColor);
		page.fillArc(leftWristHandOuter.x + leftHandXShift, leftWristHandOuter.y + leftHandYShift, handDiameter, handDiameter,-45,290);
		page.setColor(Color.BLACK);
		page.drawArc(leftWristHandOuter.x + leftHandXShift, leftWristHandOuter.y + leftHandYShift, handDiameter, handDiameter,-45,290);
		page.setColor(handHoleColor);
		page.fillOval(leftWristHandOuter.x + leftHandXShift + ((handDiameter - handHoleDiameter) / 2), leftWristHandOuter.y + leftHandYShift + ((handDiameter - handHoleDiameter) / 2), handHoleDiameter, handHoleDiameter);
		page.setColor(Color.BLACK);
		page.drawArc(leftWristHandOuter.x + leftHandXShift + ((handDiameter - handHoleDiameter) / 2), leftWristHandOuter.y + leftHandYShift + ((handDiameter - handHoleDiameter) / 2), handHoleDiameter, handHoleDiameter,-45,290);
		
		//Right Hand
		int rightHandXShift = (int) (-16 * scaleFactor);
		int rightHandYShift = (int) (-1 * scaleFactor);
		page.setColor(handColor);
		page.fillArc(rightWristHandOuter.x +rightHandXShift, rightWristHandOuter.y + rightHandYShift, handDiameter, handDiameter,-60,290);
		page.setColor(Color.BLACK);
		page.drawArc(rightWristHandOuter.x +rightHandXShift , rightWristHandOuter.y + rightHandYShift, handDiameter, handDiameter,-60,290);
		page.setColor(handHoleColor);
		page.fillOval(rightWristHandOuter.x  +rightHandXShift  + ((handDiameter - handHoleDiameter) / 2), rightWristHandOuter.y + rightHandYShift + ((handDiameter - handHoleDiameter) / 2), handHoleDiameter, handHoleDiameter);
		page.setColor(Color.BLACK);
		page.drawArc(rightWristHandOuter.x +rightHandXShift + ((handDiameter - handHoleDiameter) / 2), rightWristHandOuter.y +  rightHandYShift + ((handDiameter - handHoleDiameter) / 2), handHoleDiameter, handHoleDiameter,-60,290);
		

	}


	/**
	 * Constructor (panel initialization)
	 */
	public MiniFig()
	{
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
	}


	/**
	 * Sets up a JFrame and the BlankCanvas panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("BlankCanvas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MiniFig());
		frame.pack();
		frame.setVisible(true);
	}
}
