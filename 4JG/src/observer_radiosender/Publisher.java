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
public class Publisher implements IPublisher{
	private LinkedList<String> liste;
	private LinkedList<ISubscriber> observer;
	public void addMusic(String name){
		if(!musicBekannt(name))
			liste.add(name);
	}
	public boolean musicBekannt(String name){
		boolean ret=false;
		Iterator<String> it=liste.iterator();
		while(it.hasNext()){
			ret=it.next().equals(name);
			if(ret) break;
		}
		return ret;
	}
	@Override
	public void addSubscriber(ISubscriber s) {
		observer.add(s);
		
	}
	@Override
	public void removeSubscriber(ISubscriber s) {
		Iterator<ISubscriber> it=observer.iterator();
		while(it.hasNext()){
			ISubscriber o=it.next();
			if(o.equals(s))
				it.remove();
		}
		
	}
	@Override
	public void notifySubscribers() {
		Iterator<ISubscriber> it=observer.iterator();
		while(it.hasNext()){
				it.next().update(this);
		}
	}
	@Override
	public LinkedList<String> getTop10() {
		LinkedList<String> top=new LinkedList<>();
		for(int i=0;i<10;i++){
			top.add(liste.get(i));
		}
		return top;
	}
	/**
	 * 
	 */
	public Publisher() {
		liste=new LinkedList<>();
		observer=new LinkedList<>();
				
	}
	public void removeMusic(String name) {
		Iterator<String> it=liste.iterator();
		while(it.hasNext()){
			if(it.next().equals(name))
				it.remove();
		}
		
	}
	
}
