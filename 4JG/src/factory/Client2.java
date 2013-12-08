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
		Artikel usb=ElektronikFabrik.erzeuge("USB_Stick");
		ef.add(usb);
		Artikel maroni=TiefKuehlFabrik.erzeuge("Maronireis");
		Artikel tkspinat=TiefKuehlFabrik.erzeuge("Spinat");
		Artikel spinat=GemueseFabrik.erzeuge("Spinat");
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
