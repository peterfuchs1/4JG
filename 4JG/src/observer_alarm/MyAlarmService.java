package observer_alarm;

import java.util.concurrent.ConcurrentHashMap;


/**
 * AlarmService: stellt laut Observer-Pattern das Observable oder Subject dar
 * Jeder Client, der sich anmeldet bekommt nach fester (3s) oder mitgebener Zeit
 * einen Alarm.
 * Dieser Alarm ist solange gültig, bis der Client sich wieder vom Service abmeldet
 * @author Walter Rafeiner-Magor
 * @version 1.1 
 */
public class MyAlarmService extends Thread implements IObservable, Stoppable{
	public static final long LIFE=3000;		
	public static final long WD_SLEEPS=1000;
	private boolean stopped;
	private long millis;
	// In dieser Map werden alle aktuellen Observer gespeichert
	private ConcurrentHashMap<IObserver, Long> os; 
	/**
	 * standard constructor
	 */
	public MyAlarmService(){
		this.createHM();
	}
	
	/**
	 * register a new IObserver
	 * @param s
	 */
	@Override
	public void addObserver(IObserver s) {
		addObserver(s,LIFE);
	}
	/**
	 * register a new IObserver 
	 * with a given period
	 * @param s
	 * @param life
	 */
	@Override
	public void addObserver(IObserver s, long life) { 
		os.put(s,life);
	}
	/**
	 * unregister IObserver
	 * @param s
	 * @return whether s could be removed or not
	 */
	@Override
	public void removeObserver(IObserver s) {
		os.remove(s);	
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		millis=System.currentTimeMillis();
		// loop until we shall stop
		while (!stopped){
			notifyObservers();
			try {
				Thread.sleep(WD_SLEEPS);
			} catch (InterruptedException e) {}
		}
	}
	/**
	 * Creates a new Map 
	 */
	public void createHM(){
		if (os==null)
			os=new ConcurrentHashMap<IObserver,Long>();
		stopped=false;
		// start our alarm service ...
		this.start();
	}


	@Override
	public void notifyObservers() {
			// walk through the keys
			for(IObserver s  : os.keySet()) {
				// test whether the duration is reached or not
				if(os.get(s)<System.currentTimeMillis()-millis) {
					// alarm our client
					s.alarm();  
				}
			}		
	}

	@Override
	public void stopping() {
		stopped=true;
	}

	@Override
	public boolean isStopped() {
		// TODO Auto-generated method stub
		return stopped;
	}
}