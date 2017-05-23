import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ZDatM {
		FileReader fr1;
		FileWriter fw1;
		PrintWriter pr1;
		BufferedReader br1;
		List<Maschine> dsliste;
		int anzahl_dsliste;
		
		String dsn; //[kor]nicht nötig!
		int mod;	//[kor]nicht nötig!
		
		
		ZDatM(){
		}	
		
		ZDatM(String dsn,int mod)throws IOException{
			this.dsn = dsn;	//[kor]nicht nötig!
			this.mod = mod; //[kor]nicht nötig!
			
			if(mod == 1){ //lesende verarbeitung
				fr1 = new FileReader(dsn);
				br1 = new BufferedReader(fr1);
				dsliste = new LinkedList<Maschine>();
				anzahl_dsliste = einlesen();
				
				fw1=null;
				pr1=null;
			}
			
			else if(mod == 2){ //schreibende verarbeitung
				fw1 = new FileWriter(dsn + ".TXT", true);
				pr1 = new PrintWriter(fw1);
				
				fr1=null;
				br1=null;
				dsliste=null;
			}
		}
		
		// Einlesen der korrekten Datensätze aus fr1
		int einlesen()throws IOException{
			String pz;
			int i=0;
			int falsche_dsliste=0;
			
			pz = br1.readLine();					// erste Zeile in pz schreiben

			while (pz != null) {					// pz auf null überprüfen
				
				if(new Maschine(pz).getCrt()==1){ 	// prüfen ob pz den anforderungen von maschine entspricht
					dsliste.add(new Maschine(pz)); 	// Maschine der Liste hinzufügen
					i++; 							// zählen wieviele erfolgreich sind
				}
				
				falsche_dsliste++;
				pz = br1.readLine(); 				//nächste Zeile
			}
			
			falsche_dsliste = falsche_dsliste - i;
			System.out.println("[LOG][einlesen()]Anzahl Aussortierter Zeilen: "+falsche_dsliste);
			return i; 								// Anzahl der Korrekt eingefügten Datensätze zurückgeben
		}
		
		//Schreiben aller knoten in die dsliste
		void list2Dat(){
			
			for (int a = 0; a < dsliste.toArray().length; a++)
			{
				pr1.println(dsliste.get(a).ausMaschCSV()); 	//bestücken der txt datei nach Schema der Klasse Maschine
			}
			pr1.close();	 								//schließt den printwriter
			
		}
		
		// dsliste sortieren nach Bubble-Sort
		int bubble(int iox){
			int anz_vergl=0;
			double dbl1,dbl2;
			String stelle_a=null,stelle_a1=null;
			int pruef=-1;
			Maschine temp1,temp2;
			int test=0;
			
			if (iox == 1 || iox ==3) { 
				while(true){
					test=0;
					for(int a=0;(a+1)<dsliste.size();a++){
						
						switch(iox){
						case 1: 	stelle_a = dsliste.get(a).getMabez(); // Eintrag an stelle a von mabez wird zwischengespeichert
									stelle_a1 = dsliste.get(a + 1).getMabez();
									break;
									
						case 3:		stelle_a = dsliste.get(a).getStao(); // Eintrag an stelle a von stao wird zwischengespeichert
									stelle_a1 = dsliste.get(a + 1).getStao();
									break;
						}			
					
						if (stelle_a != null && stelle_a1 != null) {
							pruef = stelle_a.compareTo(stelle_a1); // vergleich des strings an stelle a mit dem an stelle a+1
		
							if (pruef > 0) {
								temp1 = dsliste.get(a); // zwischenspeichern der beiden maschinen
								temp2 = dsliste.get(a + 1);
		
								dsliste.set(a, temp2); // Tauschen von feld a gegen wert von a+1
								dsliste.set((a + 1), temp1); // Tauschen von feld a+1 gegen wert von a
		
								anz_vergl++;
								test++;
							}
						}
					}
					if(test==0){break;}
						
					
				}
			}
			
			
			if(iox==2){
			while(true){
				test=1;
				for(int a=0;(a+1)<dsliste.size();a++){
						dbl1 = dsliste.get(a).getPreis();
						dbl2 = dsliste.get(a+1).getPreis();
						
					
					if(dbl1 != 0 && dbl2 != 0){
						if(dbl1>dbl2){
							temp1 = dsliste.get(a); // zwischenspeichern der beiden maschinen
							temp2 = dsliste.get(a + 1);
	
							dsliste.set(a, temp2); // Tauschen von feld a gegen wert von a+1
							dsliste.set((a + 1), temp1); // Tauschen von feld a+1 gegen wert von a
	
							anz_vergl++;
							test++;
						}
					}
					

				}
				if(test==1){break;}
			}
			}
			
			
			System.out.println("######## SORTIERT ! #########");
			List_Ausgabe(dsliste);
			return anz_vergl;//Anzahl der benötigten vergleiche
		}
		
		
		
		int sortDA(int iox){ //Sortieren Allter Knoten der dsliste nach direkter wahl
			int anz_vergl=0;
			List<Maschine> hlist = new LinkedList<Maschine>();
			String stelle_ds=null,stelle_hl_hint=null;
			double wert_ds=0, wert_hl_hint=0;
			int pruef;
		
			
			for(int j=0;j<(dsliste.size());j++){
				if(hlist.size()==0){				// FAll 1 -> Liste Leer
					hlist.add(dsliste.get(0));
				}
				
				else if (iox == 1 || iox ==3) {
					
					
					switch(iox){
						case 1: 	stelle_ds = dsliste.get(j).getMabez(); // Eintrag an stelle j von mabez wird zwischengespeichert
									stelle_hl_hint = hlist.get(hlist.size()-1).getMabez();
									break;
									
						case 3:		stelle_ds = dsliste.get(j).getStao(); // Eintrag an stelle j von stao wird zwischengespeichert
									stelle_hl_hint = hlist.get(hlist.size()-1).getStao();
									break;
					}
					
					
					
					pruef = stelle_ds.compareTo(stelle_hl_hint);
					if(stelle_ds.equals(stelle_hl_hint)){
						hlist.add(dsliste.get(j));
					}
					
					else if(pruef > 0){
						hlist.add(dsliste.get(j));
					}
					
					
					else if (pruef <0 && iox==1){
						int[] vgl = new int[hlist.size()];
						for(int i=0;i<hlist.size();i++){
						
							vgl[i] = stelle_ds.compareTo(hlist.get(i).getMabez());
						}
						int stelle=0;
						for (int k=0; k<vgl.length;k++){
							if(vgl[k]>0){
							stelle ++;
							}
						}
						hlist.add(stelle, dsliste.get(j));
					}
					
					else if (pruef <0 && iox==3){
						int[] vgl = new int[hlist.size()];
						for(int i=0;i<hlist.size();i++){
						
							vgl[i] = stelle_ds.compareTo(hlist.get(i).getStao());
						}
						int stelle=0;
						for (int k=0; k<vgl.length;k++){
							if(vgl[k]>0){
							stelle ++;
							}
						}
						hlist.add(stelle, dsliste.get(j));
					}
					
					
					
				}
					
				else if (iox == 2) { 
					
					wert_ds = dsliste.get(j).getPreis(); // Eintrag an stelle j von preis wird zwischengespeichert
					wert_hl_hint = hlist.get(hlist.size()-1).getPreis();
					if (wert_hl_hint == wert_ds){
						hlist.add(dsliste.get(j));
					}
					else if(wert_hl_hint < wert_ds){
						hlist.add(dsliste.get(j));
					}
					
					else if (wert_hl_hint > wert_ds){
							double[] vgl = new double[hlist.size()];
							for(int i=0;i<hlist.size();i++){
								vgl[i] = hlist.get(i).getPreis() - dsliste.get(j).getPreis();
							}
							int stelle=0;
							for (int k=0; k<vgl.length;k++){
								if(vgl[k]<=0){
									stelle++;
								}
							}
							hlist.add(stelle, dsliste.get(j));
						}
					}
				anz_vergl++;
				}
					
			
		
		dsliste = hlist;
		return anz_vergl;
		}	
		

		static void List_Ausgabe(List<Maschine> Maschine_List) {
			int n = Maschine_List.size();

			System.out.println("\n###### LISTE START ######");
			for (int j = 0; j < n; j++) {
				System.out.println("[" + (j) + "] " + Maschine_List.get(j).ausMaschCSV());
			}
			System.out.println("###### LISTE ENDE ######\n");
		}
		
		public List<Maschine> getDsliste() {
			return dsliste;
		}

		public void setDsliste(List<Maschine> dsliste) {
			this.dsliste = dsliste;
		}
		
		
		

		public String getDsn() {
			return dsn;
		}

		public void setDsn(String dsn) {
			this.dsn = dsn;
		}
		
		
		

		public int getMod() {
			return mod;
		}

		public void setMod(int mod) {
			this.mod = mod;
		}
		
		

	
}
