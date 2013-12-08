package factory;

public class TiefKuehlFabrik extends Fabrik {
	public TiefKuehlFabrik(){
		this.fabArt="Tiefkuehlprofukte";
	}

	public static Artikel erzeuge(String produkt) {
		Artikel ret=null;
		if(produkt.equals("Maronireis")){
			ret= new Maronireis(123, "Maronireis", 9.99,250,Einheiten.G);
		}	
		return ret;
	}
}
