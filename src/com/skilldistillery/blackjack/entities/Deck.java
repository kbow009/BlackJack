package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		cards = createDeck();
	}

	private List<Card> createDeck() {

		List<Card> deck = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(suit, rank));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public Card dealCard() {

		return cards.remove(0);

	}

	public void shuffle() {
		List<Card> shuffCards = new ArrayList<Card>();
		Collections.shuffle(cards);
		shuffCards.addAll(cards);
		this.cards = shuffCards;

	}
}
