package pingpong;


/**
 * @author        Walter Rafeiner-Magor  WatchDog: Steuerung der Ausführung mittels externen Thread
 * @uml.dependency   supplier="pingpong.StoppableThread"
 */
public class WatchDog_stop extends Thread {
	public static final int DAUER=500; //Dauer in msec
	/**
	 * @uml.property   name="t"
	 * @uml.associationEnd   
	 */
	private StoppableThread t;
	private int dauer;
	/**
	 * Standard-Konstruktur 
	 * @param t Thread, der abgebrochen werden soll
	 */
	public WatchDog_stop(StoppableThread t) {
		this(t,DAUER);
	}
	/**
	 * Konstruktur mit Angabe der Ausführungsdauer
	 * @param t Thread, der abgebrochen werden soll
	 * @param dauer Länge der Ausführung in msec
	 */
	public WatchDog_stop(StoppableThread t, int dauer) {
		this.t=t;
		this.dauer=dauer;
	}
	/**
	 * Threadinhalt: Abbruch des referenzierten Threads
	 */
	@Override
	public void run() {
		try {
			sleep(dauer);
			t.stopping();
		} catch (InterruptedException e) {
		}
	}
}