import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ZDatMsave {
		FileReader fr1;
		FileWriter fw1;
		PrintWriter pr1;
		BufferedReader br1;
		List<Maschine> dsliste;
		
		String dsn;
		int mod;
		
		
		ZDatMsave(){
		}	
		
		ZDatMsave(String dsn,int mod)throws IOException{
			dsn = this.dsn;
			mod = this.mod;
			
			if(mod == 1){ //lesende verarbeitung
				fr1 = new FileReader(dsn + ".TXT");
				br1 = new BufferedReader(fr1);
				dsliste = new LinkedList<Maschine>();
				
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
			
			pz = br1.readLine();					// erste Zeile in pz schreiben

			while (pz != null) {					// pz auf null überprüfen
				
				if(new Maschine(pz).getCrt()==1){ 	// prüfen ob pz den anforderungen von maschine entspricht
					dsliste.add(new Maschine(pz)); 	// Maschine der Liste hinzufügen
					i++; 							// zählen wieviele erfolgreich sind
				}
				
				pz = br1.readLine(); 				//nächste Zeile
			}
			
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
			int pruef=-1,a=0;
			Maschine temp1,temp2;
			
			if (iox == 1 || iox ==3) { 
				while (true) {
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
						}
						a++; // Zähler für index
					} else {break;}	
				}
			}
			
			
			if(iox==2){
				while(true){
					dbl1 = dsliste.get(a).getPreis();
					dbl2 = dsliste.get(a+1).getPreis();
					
					if(dbl1 != 0 && dbl2 != 0){
						if(dbl1>dbl2){
							temp1 = dsliste.get(a); // zwischenspeichern der beiden maschinen
							temp2 = dsliste.get(a + 1);
	
							dsliste.set(a, temp2); // Tauschen von feld a gegen wert von a+1
							dsliste.set((a + 1), temp1); // Tauschen von feld a+1 gegen wert von a
	
							anz_vergl++;
						}	
					}
					else{break;}
				}
				
			}
			
			
			
			return anz_vergl;//Anzahl der benötigten vergleiche
		}
		
		int sortDA(int iox){ //Sortieren Allter Knoten der dsliste nach direkter wahl
			int anz_vergl=0;
			List<Maschine> hlist = new LinkedList<Maschine>();
			
			for(int j=0;j<dsliste.size();j++){
				if(hlist.size()==0){
					dsliste.get(j);
				}
				
				
				
				
				
				
			}
			
			
			
			
			return anz_vergl;
		}
		
	

	
}
