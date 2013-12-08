package factory;

public class TiefKuehlFabrik extends Fabrik {
	public TiefKuehlFabrik(){
		this.fabArt="Tiefkuehlprofukte";
	}

	public static Artikel erzeuge(String produkt) {
		Artikel ret=null;
		switch(produkt){
		case "Maronireis":
			ret= new Maronireis(123, "Maronireis", 0.99,250,Einheiten.G); break;
		case "Spinat":
			ret= new TKSpinat(443, "Tiefkuehl Spinat", 1.49,250,Einheiten.G); break;
		}	
		return ret;
	}
}
