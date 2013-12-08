/**
 * 
 */
package factory;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class Client2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fabrik ef=new SpezialFabrik();
		Artikel usb=SpezialFabrik.erzeuge("USB_Stick");
		ef.add(usb);
		Artikel maroni=SpezialFabrik.erzeuge("Maronireis");
		Artikel tkspinat=SpezialFabrik.erzeuge("Spinat");
		Artikel spinat=SpezialFabrik.erzeuge("TKSpinat");
		ef.add(spinat);
		ef.add(tkspinat);
		ef.add(maroni);
		ef.bezahlen();
		System.out.println(ef.toString());
		ef.verpacken();
		ef.verschicken();
		System.out.println(ef.toString());
	}

}
