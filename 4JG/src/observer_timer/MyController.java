/**
 * 
 */
package observer_timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

/**
 * MyController stellt die Verbindung zwischen den View-Komponenten und dem MyTimer dar
 * MyController stellt laut Observer-Pattern den Observer dar
 * @author Walter Rafeiner-Magor
 *
 */
public class MyController extends WindowAdapter implements ActionListener, IObserver{
	private MyPanel p;
	private StartStoppable timer;
	/**
	 * Konstruktor
	 * Bekommt ein StartStoppable zur Steuerung
	 * @param timer
	 */
	public MyController(StartStoppable timer){
		this.timer=timer;
		p= new MyPanel(this);
		new MyFrame(p, "MyTimer", this);
	}
	/**
	 * Startet die Applikation
	 * @param args
	 */
	public static void main(String[] args) {
		MyTimer timer=new MyTimer(); // Erstellt einen neuen MyTimer
		MyController c=new MyController(timer); // Startet die GUI
		timer.addObserver(c);		// Meldet sich beim Observable an
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		this.exitNow();
	}
	/**
	 * beendet die Applikation
	 * falls notwendig wird vorher noch der Thread gestoppt!
	 */
	private void exitNow(){
		timer.stopping();
		System.exit(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton) e.getSource();
		if(b==p.getJbExit()){ // Exit-Button
			this.exitNow();
		}
		else if(b==p.getJbStart()){ // Start-Button
			timer.starting();
			p.settStatus("running");
		}
		else if(b==p.getJbStop()){ // Stop-Button
			timer.stopping();
			p.settStatus("not running");
		}
	}
	@Override
	public void update(String times) {
		p.settMessage(times);
	}
	
}
