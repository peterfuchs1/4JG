package pingpong;

import java.util.LinkedList;

/***
 * PingPong Demo von Threads
 * @author Walter Rafeiner-Magor
 *
 */
public class PingPong_WatchDogService 
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
		WatchDogService w = new WatchDogService(p1);
		w.register(p3, 2500);
		w.register(p2, 3800);
		w.start();
		PingPong p4=new PingPong("PONG4",100); // 1/10 sec.
		p4.start();
		w.register(p4);
		System.out.println("p4 is registered: "+w.isRegistered(p4));

		}

		
		
		
		
	


	
}
