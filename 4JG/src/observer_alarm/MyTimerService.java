package observer_alarm;

import java.util.concurrent.ConcurrentHashMap;


/**
 * @author Walter Rafeiner-Magor 
 * WatchDogService: Steuerung der Ausführung mehrerer Threads
 * 
 * 
 */
public class MyTimerService extends Thread implements IObservable, Stoppable{
	public static final long LIFE=3000;		
	public static final long WD_SLEEPS=1000;
	private boolean stopped;
	private boolean started;
	private long millis;
	// In dieser Map werden alle aktuellen Observer gespeichert
	private ConcurrentHashMap<IObserver, Long> os; 
	/**
	 * standard constructor
	 */
	public MyTimerService(){
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
		// while the map is not emtpy
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

		this.start();
	}


	@Override
	public void notifyObservers() {
			// walk through the keys
			for(IObserver s  : os.keySet()) {
				// test whether the is up
				if(os.get(s)<System.currentTimeMillis()-millis) {
					// stop it and remove it from the map
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