import java.io.*;


public class MatAnw{
	public static void main (String[] args)throws IOException{
		
		FileWriter fwa = new FileWriter("aAUS.txt");
		FileWriter fwb = new FileWriter("bAUS.txt");
		LOG("FileWrtier erstellt");
		
		FileReader fra = new FileReader("a.txt");
		FileReader frb = new FileReader("b.txt");
		LOG("FileReader erstellt");
		
		BufferedReader bra = new BufferedReader(fra);
		BufferedReader brb = new BufferedReader(frb);
		LOG("BufferedReader erstellt");
		
		Mat a = new Mat(bra);
		Mat b = new Mat(brb);
		LOG("Mat (a und b) erstellt ");
		
		if(a.matAus(fwa) && b.matAus(fwb)){LOG("Mat (a und b) ausgegeben");};
		
		
		if((a.matMul(b)).crt != -3){
			LOG("Mat (a und b) multiplitziert und in c abgespeichert");
			Mat c = a.matMul(b);
			
			LOG("a*b ausgegeben");
			c.matAus(new FileWriter("c.txt"));
		}
		else{
			LOG("a und b waren nicht multiplizierbar");
		}
		
		
		
		

	}
	
	static void LOG(String a){
		System.out.println("[LOG] "+a);
	}
}
