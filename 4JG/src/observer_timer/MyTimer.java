package observer_timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
/**
 * MyTimer stellt laut Observer-Pattern das Observable dar 
 * @author Walter Rafeiner-Magor
 *
 */
public class MyTimer implements IObservable, Runnable, StartStoppable {
	public static final long SECOND=1000;
	public static final long MINUTE=SECOND*60;
	private long interval;
	private String message;
	private LinkedList<IObserver> list;
	private boolean stopped;
	private boolean started;
	private Thread t;
	
	/**
	 * Standard-Konstruktor
	 */
	public MyTimer() {
		this(SECOND);
	}

	/**
	 * Konstruktor mit festgelegtem Intervall
	 * @param interval
	 */
	public MyTimer(long interval) {
		this.interval = interval;
		list = new LinkedList<IObserver>();
		stopped=false;
	}

	@Override
	public void addObserver(IObserver s) {
		list.add(s);
	}

	@Override
	public void removeObserver(IObserver s) {
		list.remove(s);
	}

	@Override
	public void notifyObservers() {
		for(IObserver os:list){
			os.update(message);
		}
	}
	/**
	 * Liest die aktuelle Zeit aus
	 * @return Zeit als String
	 */
	private String getTime(){
		Calendar calendar=GregorianCalendar.getInstance();
		SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
		fmt.setCalendar(calendar);
		return fmt.format(calendar.getTime());
	
	}
	
	@Override
	public void run() {
		while(!stopped){
			message=this.getTime();
			this.notifyObservers();
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {}
		}
	}

	@Override
	public void stopping() {
		if(!stopped){
			stopped=true;
			started=false;
		}
	}

	@Override
	public void starting() {
		if(!started) {
			stopped=false;
			t =new Thread(this);
			t.start();
			started=true;
		}
	}

	@Override
	public boolean isStopped() {
		return stopped;
	}

	@Override
	public boolean isStarted() {
		return started;
	}
	
	
}
