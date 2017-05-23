import java.io.*;
import java.util.*;

public class Mat {
	double a[][];
	int crt;
	

	Mat(){
	}
	
	Mat(BufferedReader br1)throws IOException{
		String pz;
		int n=0,m=0;
		List<String> MatList = new LinkedList<String>();
		crt = 1;
		pz = br1.readLine();
		
		while(pz != null){						//BR zu Liste
			MatList.add(pz);
			pz = br1.readLine();
		}
		
		n = MatList.size();						//Zeilen
		m = MatList.get(0).split(";").length;	//Spalten
		
		a= new double[n][m];					//double Matrix erstellen
		
		
		for(int i=0;i<n;i++){					// befüllen der Matrix
			if((MatList.get(i).split(";").length) == m){
				for(int j=0;j<m;j++){
					a[i][j] = Double.parseDouble((MatList.get(i).split(";"))[j]);
				}
			}
			
			else{
				crt = -1;
			}
		}
	}
	
	boolean matAus(FileWriter fx){		
		boolean stat=true; // Wofür diesen boolean?
		int n,m;
		String temp1 ="";
		//List<String> AusMatList = new LinkedList<String>();
		PrintWriter pr1= new PrintWriter(fx);
		
		n=a.length;
			for(int i=0;i<n;i++){			//Aufzählung zeilen
				m=a[i].length;
				for(int j=0;j<m;j++){		//Aufzählung Spalten
					temp1 = temp1 + a[i][j];
					if(j<(m-1)){
						temp1=temp1+";";	// Semikolen wenn nicht letztes element in Zeile
					}
				}
				pr1.println(temp1);
				temp1 ="";
			}
			pr1.close();
		return stat;
	}
	
	
	Mat matMul(Mat c){
		Mat erg = new Mat();;

		double b[][];
		double aus[][];
		int m,n;
		
		
		b = c.a;
		
		if(b.length == a[0].length){			// prüfung ob 
			
			n=a.length;
			m=b[0].length;
			MatAnw.LOG("n : "+n);
			
			aus = new double[n][m];// aus nach zeilen a und spalten b erstellen
			
			for(int i=0;i<n;i++){			//a Zeilen durchgehen
				
				if(i==0){MatAnw.LOG("m : "+m);}
				
				for(int j=0;j<m;j++){	// b spalten durchgehen
					
					for(int k=0;k < b.length;k++){
						
						aus[i][j] += a[i][k]*b[k][j];

					}
				}
			}
			erg.a = aus;
		}
		
		else{
			erg.crt = -3;
		}
		
		return erg;
	}
	
	
	
	
	
	
	
}
