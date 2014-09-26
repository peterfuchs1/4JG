package pingpong;
/***
 * PingPong Demo von Threads
 * @author Walter Rafeiner-Magor
 *
 */
public class PingPong extends Thread implements Stoppable
{ 
	private String word; 
	private int delay; 
	private String zusatz; 
	private boolean stopped;
	/***
	 * Standardkonstruktor
	 */
	public PingPong() {
		this("PingPong",100,"");
	}
	/***
	 * Konstruktor mit 2 Parameter
	 * @param word Name des Threads
	 * @param delay Wartezeit
	 */
	public PingPong(String word, int delay)
	{ 
		this(word,delay,"");
	}
	/***
	 * Konstruktor mit 3 Parameter
	 * @param word Name des Threads
	 * @param delay Wartezeit
	 * @param zusatz CariageReturn LineFeed
	 */
	public PingPong(String word, int delay, String zusatz)
	{ 	
		super(word);
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
				System.out.print(word + " "+zusatz);
				Thread.sleep(delay); //auf das naechste Mal warten
			}
		}
		catch(InterruptedException e)
		{ 
			System.out.println("\nThread ["+ Thread.currentThread().getName()+"] ist beendet!");
		}
	}
	/***
	 * Main
	 * @param args
	 */
	public static void main(String[] args)
	{ 
		new PingPong("ping", 33).start(); // 1/30 sec.
		new PingPong(".",50,"\n").start(); // 1/20 sec mit Zeilenvorschub
		new PingPong("PONG",100).start(); // 1/10 sec.
	}
	@Override
	public void stopping() {
		this.stopped=true;
		
	}
}