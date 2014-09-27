package pingpongReihe;

import java.util.concurrent.ConcurrentHashMap;


/**
 * @author Walter Rafeiner-Magor 
 * WatchDogService: Steuerung der Ausführung mehrerer Threads
 * 
 * 
 */
public class WatchDogService extends Thread {
	public static final long LIFE=1000;		
	public static final long WD_SLEEPS=1000;
	// In dieser Map werden alle aktuellen Threads gespeichert
	private ConcurrentHashMap<Stoppable, Long> threads; 
	/**
	 * standard constructor
	 */
	public WatchDogService(){
		this.createHM();
	}
	/**
	 * constructor with a Stoppable
	 * @param s a stoppable
	 */
	public WatchDogService(Stoppable s){
		this(s,LIFE);
	}
	/**
	 * constructor with a Stoppable
	 * and a given period
	 * @param s a stoppable
	 * @param life time to live
	 */
	public WatchDogService(Stoppable s, Long life){
		this.createHM();
		register(s, life);
	}
	/**
	 * register a new Stoppable
	 * @param s a stoppable
	 */
	public void register(Stoppable s) {
		register(s,LIFE);
	}
	/**
	 * register a new Stoppable 
	 * with a given period
	 * @param s a stoppable
	 * @param life time to live
	 */
	public void register(Stoppable s, long life) { 
		threads.put(s,life);
	}
	/**
	 * unregister Stoppable
	 * @param s a stoppable
	 * @return whether s could be removed or not
	 */
	public boolean unRegister(Stoppable s) {
		return threads.remove(s)!=null ;	
	}
	/**
	 * is the Stoppable already registered?
	 * @param s a stoppable
	 * @return true or false
	 */
	public boolean isRegistered(Stoppable s) {
		return threads.containsKey(s);
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		long millis=System.currentTimeMillis();
		// while the map is not emtpy
		while (!threads.isEmpty()){
			// walk through the keys
			for(Stoppable s  : threads.keySet()) {
				// test whether the is up
				if(threads.get(s)<System.currentTimeMillis()-millis) {
					// stop it and remove it from the map
					s.stopping(); 
					threads.remove(s); 
				}
			}
			try {
				Thread.sleep(WD_SLEEPS);
			} catch (InterruptedException e) {}
		}
	}
	/**
	 * Creates a new Map 
	 */
	public void createHM(){
		if (threads==null)
			threads=new ConcurrentHashMap<Stoppable,Long>();
	}

}