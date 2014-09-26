/**
 * 
 */
package pingpong;

/**
 * @author uhs374h
 *
 */
public class TestKlasse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PingPong_stop p1=new PingPong_stop("ping", 33); // 1/30 sec.
		PingPong_stop p2=new PingPong_stop(".",50,"\n"); // 1/20 sec mit Zeilenvorschub
		PingPong_stop p3=new PingPong_stop("PONG",100); // 1/10 sec.

		p1.start();
		p2.start();
		p3.start();
		new WatchDog_Generic<PingPong_stop>(p1).start();
		new WatchDog_Generic<PingPong_stop>(p2,2500).start();
		new WatchDog_Generic<PingPong_stop>(p3,2250).start();

		PingPong_stop p4=new PingPong_stop("ping", 33); // 1/30 sec.
		PingPong_stop p5=new PingPong_stop(".",50,"\n"); // 1/20 sec mit Zeilenvorschub
		PingPong_stop p6=new PingPong_stop("PONG",100); // 1/10 sec.
		p4.start();
		p5.start();
		p6.start();
		new WatchDog_stop(p4).start();
		new WatchDog_stop(p5,2500).start();
		new WatchDog_stop(p6,2250).start();

	}

}
