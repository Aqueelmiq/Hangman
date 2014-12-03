import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

class Graphic extends JComponent {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void paint(Graphics g) {
    g.drawRect (10, 10, 200, 200);  
  }
}

