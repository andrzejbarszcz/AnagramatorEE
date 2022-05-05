package anagramator.bean;

import anagramator.logika.Anagramator;

public class AnagramatorBean {

    private String slowoWejsciowe;
    private String[] wyjsciowaListaSlow;
   
	public String getSlowoWejsciowe() {
		return slowoWejsciowe;
	}

	public void setSlowoWejsciowe(String slowoWejsciowe) {
		this.slowoWejsciowe = slowoWejsciowe;
	}

	public String[] getWyjsciowaListaSlow() {
		wyjsciowaListaSlow = Anagramator.szukajSlow(slowoWejsciowe);
		return wyjsciowaListaSlow;
	}

	public void setWyjsciowaListaSlow(String[] wyjsciowaListaSlow) {
		this.wyjsciowaListaSlow = wyjsciowaListaSlow;
	}
	
}
