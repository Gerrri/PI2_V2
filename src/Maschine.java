public class Maschine {
	private int manr; // Maschinennummer
	private double preis; // Maschinen anschaffungspreis
	private String mabez; // Bezeichnung
	private String stao; // Standort
	private int crt = 1; // Kontrollwert
	//private boolean status;

	Maschine() {

	}

	/*
	 * Maschine(int e_manr, double e_preis, String e_mabez,String e_stao,int
	 * e_crt){ if (set_manr(e_manr) || set_preis(e_preis) || set_mabez(e_mabez)
	 * || set_stao(e_stao)==true){ crt=1; } else{crt=3;} }
	 */

	Maschine(String s_CSV) {
		String[] s = s_CSV.split(";");

		if (set_manr(Integer.parseInt(s[0])) && set_preis(Double.parseDouble(s[1])) && set_mabez(s[2]) && set_stao(s[3]) == true) {
			crt = 1;
		}
		else{
			crt = 2;
		}
	}

	// Getter!
	public int getManr() {
		return manr;
	}

	public double getPreis() {
		return preis;
	}

	public String getMabez() {
		return mabez;
	}

	public String getStao() {
		return stao;
	}

	public int getCrt() {
		return crt;
	}

	// Setter
	// Check ob eingabe werte korrekt sind

	boolean set_manr(int manr) {
		if (manr >= 1) {
			this.manr = manr;
			return true;
		} else
			return false;
	}

	boolean set_preis(double preis) {
		if (preis > 1) {
			this.preis = preis;
			return true;
		} else
			return false;
	}

	boolean set_mabez(String mabez) {
		if (mabez.charAt(0) >= 'A' && mabez.charAt(0) <= 'Z') {
			this.mabez = mabez;
			return true;
		} else
			return false;
	}

	boolean set_stao(String stao) {
		if (stao.charAt(0) >= 'A' && stao.charAt(0) <= 'Z') {
			this.stao = stao;
			return true;
		} else
			return false;
	}
	
	//Andere
	void ausMasch(){
		System.out.println("Maschinen Nr: " + manr + "\nPreis: " + preis + "\nMaschinen Bezeichnung: " + mabez + "\nStandort: " + stao);
	}
	
	String ausMaschCSV(){
	    String csvGen = manr + ";" + preis + ";" + mabez + ";" + stao;
	    return csvGen;
	}
	
	double abschreibung(int laufz){
		return (preis/laufz);
	}
}
