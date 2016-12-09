package observer_timer;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * MyPanel
 * Zur Steuerung eines Mytimers
 * @author Walter Rafeiner-Magor
 *
 */
public class MyPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 590710930042658100L;
	private JLabel tStatus;
	private JLabel tMessage;
	private JButton jbStop;
	private JButton jbStart;
	private JButton jbExit;
	/**
	 * MyPanel stellt den Status des MyTimers dar
	 * kann den Timer starten und stoppen
	 * @param myController ActionListener
	 */
	public MyPanel(MyController myController) {
		this.setLayout(new GridLayout(2, 3));
		JLabel jlTimer= new JLabel("Timerstatus:");
		this.add(jlTimer);
		this.tStatus=new JLabel("not available",JLabel.CENTER);
		this.add(tStatus);
		this.tMessage=new JLabel("no message",JLabel.CENTER);
		this.add(tMessage);
		this.jbStop=new JButton("Stopping");
		this.jbStart=new JButton("Starting");
		this.jbExit=new JButton("Exit");
		this.jbStop.addActionListener(myController);
		this.jbStart.addActionListener(myController);
		this.jbExit.addActionListener(myController);
		this.add(jbStop);
		this.add(jbStart);
		this.add(jbExit);
	}
	// GETTER UND SETTER
	/**
	 * @return the tStatus
	 */
	public JLabel gettStatus() {
		return tStatus;
	}

	/**
	 * @param tStatus the tStatus to set
	 */
	public void settStatus(String tStatus) {
		this.tStatus.setText(tStatus);
	}

	/**
	 * @return the tMessage
	 */
	public JLabel gettMessage() {
		return tMessage;
	}

	/**
	 * @param tMessage the tMessage to set
	 */
	public void settMessage(String message) {
		this.tMessage.setText(message);
	}

	/**
	 * @return the jbStop
	 */
	public JButton getJbStop() {
		return jbStop;
	}

	/**
	 * @return the jbStart
	 */
	public JButton getJbStart() {
		return jbStart;
	}

	/**
	 * @return the jbExit
	 */
	public JButton getJbExit() {
		return jbExit;
	}
	
}
