package pingpong;

/**
 * @author Walter Rafeiner-Magor
 *  WatchDog: Steuerung der Ausführung mittels externen Thread
 */
public class WatchDog extends Thread {
	public static final int DAUER=500; //Dauer in msec
	private Thread t;
	private int dauer;
	/**
	 * Standard-Konstruktur 
	 * @param t Thread, der abgebrochen werden soll
	 */
	public WatchDog(Thread t) {
		this(t,DAUER);
	}
	/**
	 * Konstruktur mit Angabe der Ausführungsdauer
	 * @param t Thread, der abgebrochen werden soll
	 * @param dauer Länge der Ausführung in msec
	 */
	public WatchDog(Thread t, int dauer) {
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
			t.interrupt();
		} catch (InterruptedException e) {
		}
	}
}