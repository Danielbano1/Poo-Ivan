package model;

public class Carta {
	private String naipe;
	private int valor;

	Carta (String valor, String naipe){
		if("JQK".contains(valor))
			this.valor = 10;
		
		else if(valor.equals("A"))
			this.valor = 1;
		
		else
			this.valor = Integer.parseInt(valor);
		
		
		
		this.naipe = naipe;
	}

	public String getNaipe() {
		return naipe;
	}

	public int getValor() {
		return valor;
	}
	
	
}
