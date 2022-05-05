package anagramator.logika;

public class SmallTools {
	
	
	public static char[] usunElement(char[] t, int nr){
		char[] wynik = new char[t.length - 1];
		for(int i = 0; i < nr; i++) wynik[i] = t[i];
		for(int i = nr+1; i < t.length; i++) wynik[i-1] = t[i];
		return wynik;
	}
 	
	public static char[] zlaczTablice(char[] t1, char[] t2){
		char[] wynik = new char[t1.length + t2.length];
		for(int i = 0; i < t1.length; i++) wynik[i] = t1[i];
		for(int i = 0; i < t2.length; i++) wynik[i + t1.length] = t2[i];
		return wynik;
	}
	
	public static char[] dodajElementDoTablicy(char[] t1, char ch){
		char[] wynik = new char[t1.length + 1];
		for(int i = 0; i < t1.length; i++) wynik[i] = t1[i];
		wynik[t1.length] = ch;
		return wynik;
	}
	
	public static char[] zamienMiejscamiOstatnieElementy(char[] t){
		char temp = t[t.length-2];
		t[t.length - 2] = t[t.length - 1]; 
		t[t.length - 1] = temp;
		return t;
	}
	
	public static int silnia(int i) {
		int silnia;
		if (i <= 1)
			return 1;
		if (i == 2)
			return 2;
		silnia = silnia(i - 1) * i;
		return silnia;
	}
	
	
}
