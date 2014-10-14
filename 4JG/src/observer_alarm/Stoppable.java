/**
 * 
 */
package observer_alarm;

/**
 * @author uhs374h
 *
 */
public interface Stoppable extends Runnable {
	/**
	 * stop the Thread
	 */
	public void stopping();
	/**
	 * is the Thread stopped?
	 * @return stopped
	 */
	public boolean isStopped();

}
