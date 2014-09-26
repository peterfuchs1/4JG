package pingpong;



/**
 * PingPong Demo von Threads
 * @author   Walter Rafeiner-Magor
 * @uml.dependency   supplier="pingpong.StoppableThread"
 */
public class PingPong_stop extends StoppableThread 
{ 
	public static long DAUER=2500;
	private String word; 
	private int delay; 
	private String zusatz; 
	private boolean stopped=false;
	/***
	 * Standardkonstruktor
	 */
	public PingPong_stop() {
		this(DAUER,"PingPong",100,"");
	}
		
		/** 
		 * Konstruktor mit 2 Parameter
		 * @param word Name des Threads
		 * @param delay Wartezeit
		 */
		public PingPong_stop(String word, int delay){
		 
				this(DAUER,word,delay,"");
			 }
		public PingPong_stop(long dauer,String word, int delay){
			 
			this(dauer,word,delay,"");
		 }
		/***
	 * Konstruktor mit 3 Parameter
	 * @param word Name des Threads
	 * @param delay Wartezeit
	 * @param zusatz CariageReturn LineFeed
	 */
	public PingPong_stop(String word, int delay, String zusatz)
	{ 
		this(DAUER,word,delay,zusatz);
	}
	public PingPong_stop(long dauer,String word, int delay, String zusatz)
	{ 
		super (dauer);
		this.word = word;
		this.delay = delay;
		this.zusatz=zusatz;
	}
	/***
	 * Threadinhalt: Name des Threads wird nach Wartezeit auf Konsole gedruckt 
	 */
	@Override
	public void run()
	{ 
		try
		{ 
			while (!stopped) // until stopped is true
			{ 
				System.out.print(word + " "+zusatz);
				sleep(delay); //auf das naechste Mal warten
			}
		}
		catch(InterruptedException e)
		{ 
			System.out.println("Fertig "+ Thread.currentThread().getName());
		}
	}
	@Override
	public void stopping(){
		this.stopped=true;
	}
	/***
	 * Main
	 * @param args
	 */
	public static void main(String[] args)
	{ 
		PingPong_stop p1=new PingPong_stop("ping", 33); // 1/30 sec.
		PingPong_stop p2=new PingPong_stop(".",50,"\n"); // 1/20 sec mit Zeilenvorschub
		PingPong_stop p3=new PingPong_stop("PONG",100); // 1/10 sec.
		p1.start();
		p2.start();
		p3.start();
		
		try {
			Thread.sleep(3000);
			p1.stopping();
			p2.stopping();
			p3.stopping();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}