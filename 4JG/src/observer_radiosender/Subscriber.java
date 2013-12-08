/**
 * 
 */
package observer_radiosender;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author uhs374h
 *
 */
public class Subscriber implements ISubscriber {
	private String name;
	/* (non-Javadoc)
	 * @see radiosender.ISubscriber#update(radiosender.IPublisher)
	 */
	@Override
	public void update(IPublisher p) {
		LinkedList<String> liste=p.getTop10();
		Iterator<String> it=liste.iterator();
		int i=1;
		while(it.hasNext()){
			System.out.println(name+": "+(i++)+".Platz: "+it.next());
		}

	}
	/**
	 * @param name
	 */
	public Subscriber(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
}
