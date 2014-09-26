package pingpong;
/***
 * PingPong Demo von Threads
 * @author Walter Rafeiner-Magor
 *
 */
public class PingPong_WatchDog 
{ 

	/***
	 * Main
	 * @param args
	 */
	public static void main(String[] args)
	{ 
		PingPong p1=new PingPong("ping", 33); // 1/30 sec.
		PingPong p2=new PingPong(".",50,"\n"); // 1/20 sec mit Zeilenvorschub
		PingPong p3=new PingPong("PONG",100); // 1/10 sec.
		p1.start();
		p2.start();
		p3.start();
		new WatchDog(p1,2000).start();
		new WatchDog(p2,2500).start();
		new WatchDog(p3,2250).start();
	}
}
