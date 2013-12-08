/**
 * 
 */
package observer_radiosender;

/**
 * @author uhs374h
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Publisher p=new Publisher();
		p.addMusic("Musik0");
		p.addMusic("Musicx");
		p.addMusic("Musik1");
		p.addMusic("Musik2");
		p.addMusic("Musik3");
		p.addMusic("Musik4");
		p.addMusic("Musik5");
		p.addMusic("Musik6");
		p.addMusic("Musik7");
		p.addMusic("Musik8");
		p.addMusic("Musik9");
		Subscriber s1=new Subscriber("sub1");
		Subscriber s2=new Subscriber("sub2");
		p.addSubscriber(s1);
		p.addSubscriber(s2);
		p.notifySubscribers();
		p.removeMusic("Musik0");
		p.removeMusic("Musicx");
	}

}
