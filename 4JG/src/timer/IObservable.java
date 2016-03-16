package timer;
/**
 * Interface IObservable
 * Observer-Pattern
 * @author Walter Rafeiner-Magor
 *
 */
public interface IObservable {
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
	 * notify all registered observers
	 * with a given status object
	 * @param o status
	 */
	void notifyObservers(Object o);
}
