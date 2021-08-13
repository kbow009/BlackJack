package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
// list of cards 52
	private List<Card> deck ;
	public Deck(){
		 deck = new ArrayList<>(52);
		 for (Suit suit: Suit.values()) {
			 for(Rank rank : Rank.values()) {
				 deck.add(new Card(suit, rank));
			 }
		}
	 }
	 public int checkDeckSize(){
		 System.out.println(deck.size());
		return deck.size();
	 }
	//dealCArd method
	 public Card dealCard() {
		 
		return deck.remove(0);
		 
	 }
	 public void shuffle() {
		 Collections.shuffle(deck);
		 
	 }
}
