import java.io.*;
import java.util.List;


public class ZDatAnw {
	
	public static void main (String[] args)throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int auswahl=0;
		//List<Maschine> MaschListe = new LinkedList<Maschine>();
		ZDatM lesenZDatM = new ZDatM("test2.TXT",1);
		ZDatM schreibenZDatM;
		
		
		
		
		//System.out.println("[LOG] testZDatM.einlesen() [Ausgeführt]");
		
		
		
		
		
		do{
			System.out.println("\n#########Menu Start##########");
			System.out.println("[1 + ENTER] - Liste Ausgeben!");
			System.out.println("[2 + ENTER] - Liste zu Datei!");
			System.out.println("[3 + ENTER] - Bubble-Sort +  Ausgabe");
			System.out.println("[4 + ENTER] - Direkte Auswahl");
			System.out.println("[0 + ENTER] - BEENDEN");
			System.out.println("#########Menu Ende ##########\n");
			auswahl = Integer.parseInt(in.readLine());
			
			
			switch(auswahl){
			case 1 ://MaschListe = lesenZDatM.getDsliste(); --- ER WOLLTE KINE GETTER -.-"
					List_Ausgabe(lesenZDatM.dsliste);
					break;
					
			case 2 :schreibenZDatM = new ZDatM("list2Dat.txt",2);
					schreibenZDatM.dsliste = lesenZDatM.dsliste;
					schreibenZDatM.list2Dat();
					break;
					
			case 3 :int aus_3;
					System.out.println("Welcher Wert soll sortiert werden ?");
					System.out.println("[1 + Enter] - mabez");
					System.out.println("[2 + Enter] - preis");
					System.out.println("[3 + Enter] - stao");
					aus_3 = Integer.parseInt(in.readLine());
					
					lesenZDatM.bubble(aus_3);
					break;
					
			case 4 : int aus_4;
					 System.out.println("Welcher Wert soll sortiert werden ?");
					 System.out.println("[1 + Enter] - mabez");
					 System.out.println("[2 + Enter] - preis");
					 System.out.println("[3 + Enter] - stao");
					 aus_4 = Integer.parseInt(in.readLine());
					 
					 lesenZDatM.sortDA(aus_4);
					 
					 break;
			};
		}while(auswahl!=0);
		
		
		
		
		
	}
	
	static void List_Ausgabe(List<Maschine> Maschine_List) {
		int n = Maschine_List.size();

		System.out.println("\n###### LISTE START ######");
		for (int j = 0; j < n; j++) {
			System.out.println("[" + (j) + "] " + Maschine_List.get(j).ausMaschCSV());
		}
		System.out.println("###### LISTE ENDE ######\n");
	}
	
	
}
