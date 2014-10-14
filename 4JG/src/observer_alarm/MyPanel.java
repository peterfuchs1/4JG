package observer_alarm;

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

	private JLabel tStatus;
	private JLabel tMessage;
	private JButton jbDeactivate;
	private JButton jbRemove;
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
		this.tStatus=new JLabel("waiting",JLabel.CENTER);
		this.add(tStatus);
		this.tMessage=new JLabel("no alarm",JLabel.CENTER);
		this.add(tMessage);
		this.jbDeactivate=new JButton("Deactivate");
		this.jbRemove=new JButton("Remove");
		this.jbExit=new JButton("Exit");
		this.jbDeactivate.addActionListener(myController);
		this.jbRemove.setEnabled(false);
		this.jbRemove.addActionListener(myController);
		this.jbExit.addActionListener(myController);
		this.add(jbDeactivate);
		this.add(jbRemove);
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
	public JButton getjbDeactivate() {
		return jbDeactivate;
	}

	/**
	 * @return the jbStart
	 */
	public JButton getjbRemove() {
		return jbRemove;
	}

	/**
	 * @return the jbExit
	 */
	public JButton getJbExit() {
		return jbExit;
	}
	
}
