/**
 * 
 */
package observer_alarm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

/**
 * MyController stellt die Verbindung zwischen den View-Komponenten und dem MyTimer dar
 * MyController stellt laut Observer-Pattern den Observer dar
 * @author Walter Rafeiner-Magor
 *
 */
public class MyController extends WindowAdapter implements ActionListener, IObserver{
	private MyPanel p;
	private MyFrame f;
	private MyAlarm a;
	private IObservable timer;
	private boolean ringing;
	/**
	 * Konstruktor
	 * Bekommt ein StartStoppable zur Steuerung
	 * @param timer
	 */
	public MyController(IObservable timer){
		this.timer=timer;
		a=new MyAlarm();
		p= new MyPanel(this);
		f= new MyFrame(p, "MyTimer", this);
	}
	/**
	 * Startet die Applikation
	 * @param args
	 */
	public static void main(String[] args) {
		MyTimerService timer=new MyTimerService(); // Erstellt einen neuen MyTimer
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
		else if(b==p.getjbRemove()){ // Remove-Button
			timer.removeObserver(this);
		}
		else if(b==p.getjbDeactivate()){ // Deactivate-Button
			p.settStatus("deactivated");
			p.settMessage("alarm cancled!");
			a.stop();
		}
	}
	@Override
	public void alarm() {
		p.settStatus("activated");
		p.settMessage("alarmed!");
		p.getjbRemove().setEnabled(true);
		a.start();
	}
	
}
