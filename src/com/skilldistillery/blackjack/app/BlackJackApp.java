package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class BlackJackApp {
	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.startMenu();
	}

	private void startMenu() {
		Deck deck = new Deck();
		Scanner sc = new Scanner(System.in);
		try {
			
		System.out.println("How many cards would you like?");
		int numCards = sc.nextInt();
		sc.nextLine();
		
		
		List<Card> hand = new ArrayList<>();
		for(int numReq = 0; numReq < numCards; numReq++) {
			hand.add(deck.dealCard());
			
		}
		for (Card card : hand) {
			
		}
		} catch (Exception e) {
		
		}
		
		
	sc.close();	
	}
}
