/**
 * 
 */
package observer_ticketshop;

/**
 * @author uhs374h
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Konzert k1=new Konzert("Konzert1",100,100);
		Konzert k2=new Konzert("Konzert2",100,50);
		Shop s=new Shop();
		s.addKonzert(k1);
		s.addKonzert(k2);
		Kunde c1=new Kunde("Kunde1",2);
		Kunde c2=new Kunde("Kunde2",40);
		Kunde c3=new Kunde("Kunde3",40);
		s.addObserver(c1, k1);
		s.addObserver(c1, k2);
		s.addObserver(c2, k1);
		s.addObserver(c2, k2);
		s.addObserver(c3, k1);
		s.addObserver(c3, k2);
		s.notifyObservers(k1);
		s.notifyObservers(k2);
		c1.printKarten();
		c2.printKarten();
		c3.printKarten();
	}

}
