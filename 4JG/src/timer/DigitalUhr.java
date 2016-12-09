package timer;

import java.awt.Toolkit;


public class DigitalUhr {
	private int minuten;
	private int stunden;
	private int sekunden;
	private Zustand zustand;
	
	public long value(){
		return sekunden+(minuten+stunden*60)*60;
	}
	/**
	 * @return the sekunden
	 */
	public String getSekunden() {
		return toDigits(sekunden);
	}

	/**
	 * @return the minuten
	 */
	public String getMinuten() {
		return toDigits(minuten);
	}

	/**
	 * @return the stunden
	 */
	public String getStunden() {
		return toDigits(stunden);
	}

	/**
	 * @param minuten the minuten to set
	 */
	public void setMinuten(int minuten) {
		this.minuten = minuten;
	}

	/**
	 * @param stunden the stunden to set
	 */
	public void setStunden(int stunden) {
		this.stunden = stunden;
	}

	/**
	 * @param sekunden the sekunden to set
	 */
	public void setSekunden(int sekunden) {
		this.sekunden = sekunden;
	}

	/**
	 * @return the zustand
	 */
	public Zustand getZustand() {
		return zustand;
	}



	/**
	 * Konstruktor
	 */
	public DigitalUhr() {
		this.sekunden =0;
		this.minuten = 0;
		this.stunden = 0;
		this.zustand = Zustand.StundenEinstellen;
	}

	/**
	 * internal routine for changing values the changing process depends on the
	 * state 'zustand'
	 * 
	 * @param value
	 */
	private void change(int value) {
		switch (zustand) {
		case SekundenEinstellen:
			this.sekunden+=value;
			this.sekunden = (this.sekunden  >= 0) ? this.sekunden % 60 : 60+ this.sekunden;
			break;
		case MinutenEinstellen:
			this.minuten+=value;
			this.minuten = (this.minuten  >= 0) ? this.minuten % 60 : 60+ this.minuten;
			break;
		case StundenEinstellen:
			this.stunden+=value;
			this.stunden = (this.stunden >= 0) ? this.stunden % 24 : 24+this.stunden;
			break;
		default:
			// keine neue Anzeige
			return;
		}
	}

	/**
	 * change the state
	 */
	public void set() {
		zustand = zustand.next();

	}

	/**
	 * increment
	 */
	public void inc() {
		this.change(1);
	}

	/**
	 * decrement
	 */
	public void dec() {
		this.change(-1);
	}

	/**
	 * make a piep
	 */
	public void piep() {
		Toolkit.getDefaultToolkit().beep();
	}

	public static String toDigits(int value) {
		return (value < 10) ? "0" + value : "" + value;
	}


}
