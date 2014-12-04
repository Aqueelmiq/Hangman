import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;


class Graphic extends JComponent {

	private static final long serialVersionUID = 1L;
	private int num;
	private String display;
	
	public Graphic(int guess, String display) {
		num = guess;
		this.display=display;
	}

public void paint(Graphics g) {
	
	g.setColor(Color.red);
	g.drawString(display, 100, 300);
	g.setColor(Color.black);
	
	switch(num) {
		case 1:
			g.drawLine(150, 100, 120, 150); 
			break;
		case 2:
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150); 
			break;
		case 3:
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150);
			g.drawLine(150, 85, 150, 170); 
			break;
		case 4:
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150);
			g.drawLine(150, 85, 150, 170); 
			g.drawOval(132, 50, 35, 35);
			break;
		case 5:
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150);
			g.drawLine(150, 85, 150, 170); 
			g.drawOval(132, 50, 35, 35);
			g.drawOval(140, 60, 5, 5);
			break;
		case 6:
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150);
			g.drawLine(150, 85, 150, 170); 
			g.drawOval(132, 50, 35, 35);
			g.drawOval(140, 60, 5, 5);
			g.drawOval(155, 60, 5, 5);
			break;
		case 7:
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150);
			g.drawLine(150, 85, 150, 170); 
			g.drawOval(132, 50, 35, 35);
			g.drawOval(140, 60, 5, 5);
			g.drawOval(155, 60, 5, 5);
			g.drawOval(143, 70, 15, 5);
			break;
		case 8:
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150);
			g.drawLine(150, 85, 150, 170); 
			g.drawOval(132, 50, 35, 35);
			g.drawOval(140, 60, 5, 5);
			g.drawOval(155, 60, 5, 5);
			g.drawOval(143, 70, 15, 5);
			g.drawOval(132, 50, 35, 35);
			break;
		case 9:
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150);
			g.drawLine(150, 85, 150, 170); 
			g.drawOval(132, 50, 35, 35);
			g.drawOval(140, 60, 5, 5);
			g.drawOval(155, 60, 5, 5);
			g.drawOval(143, 70, 15, 5);
			g.drawOval(132, 50, 35, 35);
			g.drawLine(150, 170, 120, 250); 
			break;
		case 10:
			g.drawLine(150, 170, 180, 250);
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150);
			g.drawLine(150, 85, 150, 170); 
			g.drawOval(132, 50, 35, 35);
			g.drawOval(140, 60, 5, 5);
			g.drawOval(155, 60, 5, 5);
			g.drawOval(143, 70, 15, 5);
			g.drawOval(132, 50, 35, 35);
			g.drawLine(150, 170, 120, 250);
			break;
		case 11:
			g.drawLine(50, 25, 50, 250); 
			g.drawLine(150, 170, 180, 250);
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150);
			g.drawLine(150, 85, 150, 170); 
			g.drawOval(132, 50, 35, 35);
			g.drawOval(140, 60, 5, 5);
			g.drawOval(155, 60, 5, 5);
			g.drawOval(143, 70, 15, 5);
			g.drawOval(132, 50, 35, 35);
			g.drawLine(150, 170, 120, 250);
			break;
		case 12:
			g.drawLine(50, 25, 150, 25);
			g.drawLine(50, 25, 50, 250); 
			g.drawLine(150, 170, 180, 250);
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150);
			g.drawLine(150, 85, 150, 170); 
			g.drawOval(132, 50, 35, 35);
			g.drawOval(140, 60, 5, 5);
			g.drawOval(155, 60, 5, 5);
			g.drawOval(143, 70, 15, 5);
			g.drawOval(132, 50, 35, 35);
			g.drawLine(150, 170, 120, 250);
			break;
		case 13:
			g.drawLine(50, 25, 150, 25);
			g.drawLine(50, 25, 50, 250); 
			g.drawLine(150, 170, 180, 250);
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150);
			g.drawLine(150, 85, 150, 170); 
			g.drawOval(132, 50, 35, 35);
			g.drawOval(140, 60, 5, 5);
			g.drawOval(155, 60, 5, 5);
			g.drawOval(143, 70, 15, 5);
			g.drawOval(132, 50, 35, 35);
			g.drawLine(150, 170, 120, 250);
			g.drawLine(150, 25, 150, 50); 
			break;
		case 14:
			g.drawLine(50, 25, 150, 25);
			g.drawLine(50, 25, 50, 250); 
			g.drawLine(150, 170, 180, 250);
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150);
			g.drawLine(150, 85, 150, 170); 
			g.drawOval(132, 50, 35, 35);
			g.drawOval(140, 60, 5, 5);
			g.drawOval(155, 60, 5, 5);
			g.drawOval(143, 70, 15, 5);
			g.drawOval(132, 50, 35, 35);
			g.drawLine(150, 170, 120, 250);
			g.drawLine(150, 25, 150, 50);
			g.drawOval(132, 90, 35, 5);
			break;
		case 15:
			g.drawLine(50, 25, 150, 25);
			g.drawLine(50, 25, 50, 250); 
			g.drawLine(150, 170, 180, 250);
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150);
			g.drawLine(150, 85, 150, 170); 
			g.drawOval(132, 50, 35, 35);
			g.drawOval(140, 60, 5, 5);
			g.drawOval(155, 60, 5, 5);
			g.drawOval(143, 70, 15, 5);
			g.drawOval(132, 50, 35, 35);
			g.drawLine(150, 170, 120, 250);
			g.drawLine(150, 25, 150, 50);
			g.drawOval(132, 90, 35, 5);
			g.drawLine(25, 250, 75, 250);
			break;
		case 16:
			g.drawLine(50, 25, 150, 25);
			g.drawLine(50, 25, 50, 250); 
			g.drawLine(150, 170, 180, 250);
			g.drawLine(150, 100, 120, 150); 
			g.drawLine(150, 100, 180, 150);
			g.drawLine(150, 85, 150, 170); 
			g.drawOval(132, 50, 35, 35);
			g.drawOval(140, 60, 5, 5);
			g.drawOval(155, 60, 5, 5);
			g.drawOval(143, 70, 15, 5);
			g.drawOval(132, 50, 35, 35);
			g.drawLine(150, 170, 120, 250);
			g.drawLine(150, 25, 150, 50);
			g.drawOval(132, 90, 35, 5);
			g.drawLine(25, 250, 75, 250);
			g.drawLine(25, 250, 75, 250);
			break;
			default:
				break;
	}

  }
}

