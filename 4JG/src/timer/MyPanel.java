/**
 * 
 */
package timer;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class MyPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// center
	private JPanel anzeige;
	// east
	private JPanel buttons;
	///////////////
	// Buttons
	private JButton inc,dec,set,start,stopp;
	///////////////
	// TextFields
	private JTextField stunden,minuten,sekunden;
	//////////////
	// Labels
	private JLabel dp,dp2,sb;
	/**
	 * @param model
	 */
	public MyPanel(MyController controller) {
		//create new Font
        Font font = new Font("Courier", Font.BOLD,88);
        
		this.setLayout(new BorderLayout());
		///CENTER: Anzeige
		anzeige=new JPanel();
		stunden=new JTextField("00", 2);
		stunden.setEditable(false);
		stunden.setFont(font);
		anzeige.add(stunden);
		
		dp=new JLabel(":");
		dp.setFont(font);
		anzeige.add(dp);
		
		minuten=new JTextField("00",2);
		minuten.setEditable(false);
		minuten.setFont(font);
		anzeige.add(minuten);
		
		dp2=new JLabel(":");
		dp2.setFont(font);
		anzeige.add(dp2);
		
		sekunden=new JTextField("00",2);
		sekunden.setEditable(false);
		sekunden.setFont(font);
		anzeige.add(sekunden);

		this.add(anzeige,BorderLayout.CENTER);
		
		///EAST: Buttons
		buttons=new JPanel(new GridLayout(5,1));
		String label="set";
		set=new JButton(label);
		set.addActionListener(controller);
		buttons.add(set);

		label="inc";
		inc=new JButton(label);
		inc.addActionListener(controller);
		buttons.add(inc);
		
		label="dec";
		dec=new JButton(label);
		dec.addActionListener(controller);
		buttons.add(dec);
		
		label="start";
		start=new JButton(label);
		start.addActionListener(controller);
		buttons.add(start);		
		
		label="stopp";
		stopp=new JButton(label);
		// disable stoppButton @ start
		stopp.setEnabled(false);
		stopp.addActionListener(controller);
		buttons.add(stopp);		

		this.add(buttons,BorderLayout.EAST);
		sb=new JLabel("Start...");
		this.add(sb,BorderLayout.SOUTH);

	}
	/**
	 * refresh the display
	 */
	public void refresh(){
		this.repaint();
	}
	/**
	 * startTimer: disable/enable buttons
	 */
	public void startTimer(){
		inc.setEnabled(false);
		dec.setEnabled(false);
		start.setEnabled(false);
		stopp.setEnabled(true);
		set.setEnabled(false);
	}
	/**
	 * stoppTimer: disable/enable buttons
	 */
	public void stoppTimer(){
		inc.setEnabled(true);
		dec.setEnabled(true);
		start.setEnabled(true);
		stopp.setEnabled(false);
		set.setEnabled(true);
	}
	
	// getter und setter
	public void setStunden(String s){
		this.stunden.setText(s);
	}
	public void setMinuten(String m){
		this.minuten.setText(m);
	}
	public void setSekunden(String m){
		this.sekunden.setText(m);
	}	
	/**
	 * @return the inc
	 */
	public JButton getInc() {
		return inc;
	}
	/**
	 * @return the dec
	 */
	public JButton getDec() {
		return dec;
	}
	/**
	 * @return the set
	 */
	public JButton getSet() {
		return set;
	}
	/**
	 * @return the start
	 */
	public JButton getStart() {
		return start;
	}

	/**
	 * @return the stopp
	 */
	public JButton getStopp() {
		return stopp;
	}
	/**
	 * @param sb the sb to set
	 */
	public void setStatusbar(String s) {
		this.sb.setText(s);
	}

}