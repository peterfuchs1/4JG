/**
 * 
 */
package timer;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

/**
 * @author Walter Rafeiner-Magor
 *
 */
@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	
	public MyFrame(MyPanel mPanel){
		this("Standard-Frame",mPanel);
	}
	public MyFrame(String title,MyPanel mPanel) {
		// ‹berschrift setzen
		this.setTitle(title);
		// Hintergrundfarbe setzen
		this.setBackground(Color.BLUE);
		// Schlieﬂe Anwendung, Falls der Frame geschlossen wurde
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(BorderLayout.CENTER,mPanel);
		
		this.pack();

		
		this.setVisible(true);
	}
}
