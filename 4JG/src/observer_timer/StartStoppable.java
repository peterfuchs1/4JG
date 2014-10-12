/**
 * 
 */
package observer_timer;

/**
 * @author uhs374h
 *
 */
public interface StartStoppable extends Runnable {
	/**
	 * stop the Thread
	 */
	public void stopping();
	/**
	 * start the Thread
	 */
	public void starting();
	/**
	 * is the Thread stopped?
	 * @return stopped
	 */
	public boolean isStopped();
	/**
	 * is the Thread started?
	 * @return started
	 */
	public boolean isStarted();
}
