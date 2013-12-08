/**
 * 
 */
package factory;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fabrik ef=new ElektronikFabrik();
		Fabrik tkf=new TiefKuehlFabrik();
		Artikel usb=ElektronikFabrik.erzeuge("USB_Stick");
		ef.add(usb);
		System.out.println(ef.toString());
		Artikel maroni=TiefKuehlFabrik.erzeuge("Maronireis");
		tkf.add(maroni);
		tkf.bezahlen();
		System.out.println(tkf.toString());
		ef.bezahlen();
		System.out.println(ef.toString());
		ef.verpacken();
		ef.verschicken();
		tkf.verpacken();
		System.out.println(ef.toString());
		tkf.verschicken();
		System.out.println(tkf.toString());
	}

}
