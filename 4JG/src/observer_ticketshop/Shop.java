/**
 * 
 */
package observer_ticketshop;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author uhs374h
 *
 */
public class Shop implements IShop {
	private TreeMap<Konzert, LinkedList<IKunde>> warteliste;
	private LinkedList<Konzert> konzerte;
	/* (non-Javadoc)
	 * @see ticketshop.IShop#addObserver(ticketshop.IKunde, ticketshop.Konzert)
	 */
	@Override
	public void addObserver(IKunde o, Konzert k) {
		if( konzertBekannt(k)){
			LinkedList<IKunde> list=warteliste.get(k);
			list.add(o);
		}
	}
	/**
	 * 
	 * @param k
	 * @return
	 */
	public boolean konzertBekannt(Konzert k){
		boolean ret=false;
		Iterator<Konzert> it=konzerte.iterator();
		while(it.hasNext()){
			ret=it.next().equals(k);
			if(ret) break;		
		}
		return ret;
	}
	/**
	 * 
	 */
	public Shop() {
		warteliste= new TreeMap<>();
		konzerte=new LinkedList<>();
	}
	/* (non-Javadoc)
	 * @see ticketshop.IShop#removeObserver(ticketshop.IKunde, ticketshop.Konzert)
	 */
	@Override
	public void removeObserver(IKunde o, Konzert k) {
		if(warteliste.containsKey(k)){
			LinkedList<IKunde> list=warteliste.get(k);
			Iterator<IKunde> it=list.iterator();
			while(it.hasNext()){
				if(it.next().equals(o))
					it.remove();
			}
		}

	}
	public synchronized boolean kartenReservieren(Konzert k, int anzahl){
		boolean ret=false;
		int frei=k.getFrei();
		if (frei>=anzahl){
			frei-=anzahl;
			k.setFrei(frei);
			ret=true;
		}
		return ret;	
	}
	/* (non-Javadoc)
	 * @see ticketshop.IShop#notyObservers()
	 */
	@Override
	public void notifyObservers(Konzert k) {
		if(warteliste.containsKey(k)){
			int anzahl=k.getFrei();
			LinkedList<IKunde> list=warteliste.get(k);
			Iterator<IKunde> it=list.iterator();
			while(it.hasNext()){
				it.next().update(this,k, anzahl);
			}
		}

	}
	public void addKonzert(Konzert k){
		if(!konzertBekannt(k)){
			konzerte.add(k);
			warteliste.put(k, new LinkedList<IKunde>());
		}
	}
	public void removeKonzert(Konzert k){
		Iterator<Konzert> it=konzerte.iterator();
		while(it.hasNext()){
			if(it.next().equals(k))
				return;		
		}
		
	}
}
