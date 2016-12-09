/**
 * 
 */
package observer_ticketshop;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

/**
 * @author uhs374h
 *
 */
public class Kunde implements IKunde {
	private String name;
	private TreeMap<Konzert,Integer> karten;
	private int kartenAnzahl;
	
	/* (non-Javadoc)
	 * @see ticketshop.IKunde#update(ticketshop.Konzert, int)
	 */
	@Override
	public void update(IShop s,Konzert k, int anzahl) {
		if( anzahl > kartenAnzahl){
			if(s.kartenReservieren(k, kartenAnzahl)){
				karten.put(k, kartenAnzahl);
				
			}
		}	
	}
	/**
	 * @param kartenAnzahl
	 */
	public Kunde(String name,int kartenAnzahl) {
		this.name=name;
		this.kartenAnzahl = kartenAnzahl;
		karten=new TreeMap<>();
	}
	/**
	 * @return the kartenAnzahl
	 */
	public int getKartenAnzahl() {
		return kartenAnzahl;
	}
	/**
	 * @param kartenAnzahl the kartenAnzahl to set
	 */
	public void setKartenAnzahl(int kartenAnzahl) {
		this.kartenAnzahl = kartenAnzahl;
	}
	public void printKarten(){
		NavigableSet<Konzert> k=karten.navigableKeySet();
		Iterator<Konzert> it=k.iterator();
		while(it.hasNext()){
			Konzert konzert=it.next();
			System.out.println(name+": "+konzert.getName()+" mit "+karten.get(konzert)+" Karten");
		}
	}
}
