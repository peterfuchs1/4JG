/**
 * 
 */
package observer_alarm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * MyAlarm kann ein Audiofile (wav,au,aiff) in einer Endlosschleife
 * abspielen.
 * Das Abspielen kann durch stop, start und close 
 * von aussen beeinflusst werden.
 * @author Walter Rafeiner-Magor
 * @version 1.1
 */
public class MyAlarm {
	public static final String ALARM = "alarm.wav";
	private String soundName;
	private AudioInputStream audioInputStream;
	private Clip clip;
	private boolean ringing;
	/**
	 * Standardkonstruktor
	 */
	public MyAlarm() {
		this(ALARM);
	}
	/**
	 * Konstruktor mit alarm-file
	 * @param soundName
	 */
	public MyAlarm(String soundName) {
		this.soundName = soundName;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(
					new File(soundName).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);		            
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		ringing = false;
	}
	/**
	 * startet Alarm
	 */
	public void start() {
		if (!ringing) {
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
			ringing = true;
		}
	}
	/**
	 * stoppt den Alarm
	 */
	public void stop() {
		if(ringing) {
			clip.stop();
			clip.setFramePosition(0);
			ringing=false;
		}
	}
	/**
	 * beendet den audioclip
	 */
	public void close() {
		clip.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		this.close();
	}

}
