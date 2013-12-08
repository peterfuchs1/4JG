package factory;

public class USB_Stick extends ComputerProdukt {

	public USB_Stick(int nummer, String bezeichnung, double preis) {
		super(nummer, bezeichnung,preis,1,Einheiten.STK);
	}
	public USB_Stick(){
		this(1, "USB_16_GB", 9.99);
	}
}
