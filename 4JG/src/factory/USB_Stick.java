package factory;

public class USB_Stick extends ComputerProdukt {

	public USB_Stick(int nummer, String bezeichnung, double preis) {
		super(nummer, bezeichnung,preis,1,Einheiten.STK);
	}

}
