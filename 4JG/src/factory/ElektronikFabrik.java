package factory;

public class ElektronikFabrik extends Fabrik {
	public ElektronikFabrik(){
		this.fabArt="Elektronikprodukte";
	}
	public static Artikel erzeuge(String produkt) {
		Artikel ret=null;
		if(produkt.equals("USB_Stick")){
			ret= new USB_Stick(1, "USB_16_GB", 9.99);

		}
		return ret;
	}

}
