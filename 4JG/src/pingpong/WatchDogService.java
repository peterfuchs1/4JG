package pingpong;

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
	 * @param pp
	 */
	public WatchDogService(Stoppable pp){
		this(pp,LIFE);
	}
	/**
	 * constructor with a Stoppable
	 * and a given period
	 * @param pp
	 * @param life
	 */
	public WatchDogService(Stoppable pp, Long life){
		this.createHM();
		register(pp, life);
	}
	/**
	 * register a new Stoppable
	 * @param s
	 */
	public void register(Stoppable s) {
		register(s,LIFE);
	}
	/**
	 * register a new Stoppable 
	 * with a given period
	 * @param s
	 * @param life
	 */
	public void register(Stoppable s, long life) { 
		threads.put(s,life);
	}
	/**
	 * unregister Stoppable
	 * @param s
	 * @return whether s could be removed or not
	 */
	public boolean unRegister(Stoppable s) {
		return threads.remove(s)!=null ;	
	}
	/**
	 * is the Stoppable already registered?
	 * @param s
	 * @return
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