package factory;

public class GemueseFabrik extends Fabrik {
	public GemueseFabrik(){
		this.fabArt="Gemueseprofukte";
	}

	public static Artikel erzeuge(String produkt) {
		Artikel ret=null;
		switch(produkt){
		case "Spinat":
			ret= new Spinat(43, "frischer Spinat", 2.49,250,Einheiten.G); break;
		}	
		return ret;
	}
}
