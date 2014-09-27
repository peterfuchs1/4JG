package pingpongReihe;

/***
 * PingPong Demo von Threads
 * @author Walter Rafeiner-Magor
 *
 */
public class PingPong_WatchDogService 
{ 

	/***
	 * Main
	 * @param args command line arguments
	 */
	public static void main(String[] args)
	{ 
		ThreadQueuing q=new ThreadQueue();
		// create serval threads
		PingPong p1=new PingPong(q,"ping1", 100); // 1/30 sec.
		PingPong p2=new PingPong(q,".",150,"\n"); // 1/20 sec mit Zeilenvorschub
		PingPong p3=new PingPong(q,"PONG2",200); // 1/10 sec.
		PingPong p4=new PingPong(q,"Ping3",100); // 1/10 sec.
		PingPong p5=new PingPong(q,"Pong4",100); // 1/10 sec.
		// create a watchdogservice
		WatchDogService w = new WatchDogService();
		w.register(p1, 1000);
		w.register(p3, 3000);
		w.register(p2, 8000);
		// start the watchdog service
		w.start();
		w.register(p4, 5000);
		w.register(p5, 6000);
		// register our threads in the queue
		// with the order of registration
		q.register(p1);
		q.register(p3);
		q.register(p4);
		q.register(p5);
		q.register(p2);
		// start all threads
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		}
}
