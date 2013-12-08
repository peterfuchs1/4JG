/**
 * 
 */
package observer_radiosender;

import java.util.LinkedList;

/**
 * @author uhs374h
 *
 */
public interface IPublisher {
	void addSubscriber(ISubscriber s);
	void removeSubscriber(ISubscriber s);
	void notifySubscribers();
	LinkedList<String> getTop10();
}
