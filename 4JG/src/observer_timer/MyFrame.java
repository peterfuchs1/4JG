package observer_timer;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -236882586644137170L;

	public MyFrame(MyPanel p, String header, MyController myController){
		this.addWindowListener(myController);
		this.setTitle(header);
		this.getContentPane().add(p,BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
//		this.pack();
		this.setSize(440, 100);
		this.setResizable(false);
		this.setVisible(true);
	}
}
