package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
	private List<Carta> cartas = new ArrayList<Carta>();
	private int cartasUsadas;
	private int qtdDecks = 8;
	private int qtdCartas = qtdDecks * 52;
	private int limiteEmbaralhar = (int) (qtdDecks * 0.1);

	public Baralho() {
		String[] naipes = { "Copas", "Espadas", "Ouros", "Paus" };
		String[] valores = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		for (int i = 0; i < qtdDecks; i++) {
			for (String naipe : naipes) {
				for (String valor : valores) {
					cartas.add(new Carta(valor, naipe));
				}
			}
		}

		cartasUsadas = 0;
	}

	public void embaralhar() {
		Collections.shuffle(cartas);
	}

	public Carta tirarCarta() {
		confereLimite();
		cartasUsadas++;
		return cartas.remove(cartas.size() - 1);
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public int getCartasUsadas() {
		return cartasUsadas;
	}

	private void confereLimite() {
		if (cartasUsadas <= limiteEmbaralhar) {
			embaralhar();
			cartasUsadas = 0;
		}
	}

	public int getQtdDecks() {
		return qtdDecks;
	}

	public int getQtdCartas() {
		return qtdCartas;
	}

	public int getLimiteEmbaralhar() {
		return limiteEmbaralhar;
	}
	

}
