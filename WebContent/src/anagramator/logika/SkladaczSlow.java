package anagramator.logika;

class SkladaczSlow {
	
	public static String[] zlozSlowa(char[][] litery) {
		
		int liczbaSlow = litery.length;
		String[] slowa = new String[liczbaSlow];
		
		for(int i = 0; i < liczbaSlow; i++) {
			slowa[i] = String.valueOf(litery[i]);
		}
		
		return slowa;
	}
	
	public static String[] zlozSlowaBlank(String[] slowaZblankiem) {
		
		int liczbaSlow = (slowaZblankiem.length * 35);
		String[] slowaBezBlanka = new String[liczbaSlow];
		
		//tworzy zbior znakow i w pêtli zastepuje nimi blank
		int[] angielskieZnaki = new int[26];
		for(int i = 97; i<123; i++) angielskieZnaki[i-97] = i;
		int[] polskieZnaki = {261,263,281,322,324,243,347,378,380};
		int[] wszystkieZnaki = new int[35];
		for(int i = 0; i < 26; i++) wszystkieZnaki[i] = angielskieZnaki[i];
		for(int i = 0; i < 9; i++) wszystkieZnaki[i+26] = polskieZnaki[i];
		char[] wszystkieZnakiChar = new char[35];
		for(int i = 0; i<35; i++) wszystkieZnakiChar[i] = (char)wszystkieZnaki[i];
		
		for(int i = 0; i < wszystkieZnakiChar.length; i ++) {
						for(int j = 0; j < slowaZblankiem.length; j++) {
				slowaBezBlanka[(i*slowaZblankiem.length)+j] = slowaZblankiem[j].replace('?',wszystkieZnakiChar[i]);
			}
		}
		 	
		return slowaBezBlanka;
		
	}
	
}