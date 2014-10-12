package observer_timer;
/**
 * Interface IObservable
 * Observer-Pattern
 * @author Walter Rafeiner-Magor
 *
 */
public interface IObservable {
	/**
	 * add a new observer
	 * @param s
	 */
	void addObserver(IObserver s);
	/**
	 * remove a existing observer
	 * @param s
	 */
	void removeObserver(IObserver s);
	/**
	 * notify all registered observers
	 */
	void notifyObservers();
}
