package observer_timer;
/**
 * Interface Observer
 * Observer-Pattern
 * @author Walter Rafeiner-Magor
 *
 */
public interface IObserver {
	/**
	 * send a new message as a string 
	 * @param times 
	 */
	public void update(String times);
}
