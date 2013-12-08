package observer_ticketshop;

public interface IShop {
	void addObserver(IKunde o, Konzert k);
	void removeObserver(IKunde o,Konzert k);
	void notifyObservers(Konzert k);
	public boolean kartenReservieren(Konzert k, int anzahl);
}
