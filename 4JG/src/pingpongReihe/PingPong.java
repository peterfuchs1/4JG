package pingpongReihe;
/***
 * PingPong Demo von Threads
 * @author Walter Rafeiner-Magor
 *
 */
public class PingPong extends Thread implements Stoppable
{ 
	private ThreadQueuing q;
	private String word; 
	private int delay; 
	private String zusatz; 
	private boolean stopped;
	/***
	 * 
	 * Standardkonstruktor
	 * @param q	the queue
	 */
	public PingPong(ThreadQueuing q) {
		this(q,"PingPong",100,"");
	}
	/***
	 * Konstruktor mit 2 Parameter
	 * @param q	the queue
	 * @param word Name des Threads
	 * @param delay Wartezeit
	 */
	public PingPong(ThreadQueuing q,String word, int delay)
	{ 
		this(q,word,delay,"");
	}
	/***
	 * Konstruktor mit 3 Parameter
	 * @param q	the queue
	 * @param word Name des Threads
	 * @param delay Wartezeit
	 * @param zusatz CariageReturn LineFeed
	 */
	public PingPong(ThreadQueuing q,String word, int delay, String zusatz)
	{ 	
		super(word);
		this.q=q;
		this.word = word;
		this.delay = delay;
		this.zusatz=zusatz;
		this.stopped=false;
	}
	/***
	 * Threadinhalt: Name des Threads wird nach Wartezeit auf Konsole gedruckt 
	 */
	@Override
	public void run()
	{ 
		try
		{ 
			while (!stopped) // forever
			{ 
				q.isOpen(this);// ask the queue, whether it's open or go sleeping
				System.out.print(word + " "+zusatz);
				Thread.sleep(delay); //let's sleep a little bit
				q.finished(); // tell the queue, that we've finished our work
			}
			q.unRegister(this);	// let's say good bye to the queue
		}
		catch(InterruptedException e)
		{ 
			System.out.println("\nThread ["+ Thread.currentThread().getName()+"] ist beendet!");
		}
	}

	@Override
	public void stopping() {
		this.stopped=true;
		
	}
}