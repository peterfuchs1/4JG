package timer;
/**
 * Interface Observer
 * Observer-Pattern
 * @author Walter Rafeiner-Magor
 *
 */
public interface IObserver {
	/**
	 * send a alarm 
	 * @param times 
	 */
	public void update(IObservable ob, Object o);
}

