package pingpong;
/***
 * PingPong Demo von Threads
 * @author Walter Rafeiner-Magor
 *
 */
public class CopyOfPingPong_WatchDog_sauber 
{ 

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
		new WatchDog_stop(p1).start();
		new WatchDog_stop(p2,2500).start();
		new WatchDog_stop(p3,2250).start();
		

		}

		
		
		
		
	


	
}
