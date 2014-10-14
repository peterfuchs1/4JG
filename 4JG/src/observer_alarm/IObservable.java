package observer_alarm;
/**
 * Interface IObservable
 * Observer-Pattern
 * @author Walter Rafeiner-Magor
 *
 */
public interface IObservable extends Stoppable{
	/**
	 * add a new observer
	 * @param s observer
	 */
	void addObserver(IObserver s);
	/**
	 * remove a existing observer
	 * @param s observer
	 */
	void removeObserver(IObserver s);
	/**
	 * notify all registered observers
	 */
	void notifyObservers();
	/**
	 * add a new observer 
	 * @param s observer
	 * @param life duration
	 */
	void addObserver(IObserver s, long life);
}
