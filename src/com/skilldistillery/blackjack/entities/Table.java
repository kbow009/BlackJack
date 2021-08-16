package com.skilldistillery.blackjack.entities;

import java.util.Scanner;

import com.skilldistillery.blackjack.app.BlackJackApp;

public class Table {
	Scanner sc = new Scanner(System.in);
	BlackjackHand player = new PlayersHand();
	BlackjackHand dealer = new DealersHand();
	Deck deck = new Deck();
	public boolean stillPlaying;
	public boolean newGame;

	public Table() {

	}

	public void startGame() {
		while (newGame = true) {

			System.out.println("Beginning new game!");
			deck.shuffle();
			System.out.println("The deck has been shuffled");
			player.clearCards();
			dealer.clearCards();

			Card card1 = deck.dealCard();
			System.out.println("Dealing card to player " + card1);
			player.addCard(card1);

			Card card2 = deck.dealCard();
			System.out.println("Dealing card to dealer ");
			dealer.addCard(card2);

			Card card3 = deck.dealCard();
			System.out.println("Dealing card to player " + card3);
			player.addCard(card3);
			Card card4 = deck.dealCard();
			System.out.println("Dealing card to dealer " + card4);
			dealer.addCard(card4);
			System.out.println(player);
			checkBlackjack();

			if (deck.checkDeckSize() < 7) {
				System.out.println("Shuffling deck");
				newGame = true;
				deck.shuffle();

			}

			while (player.isBust() == false && player.isBlackjack() == false) {
				hitOrStay();
			}

		}
	}

	private void hitOrStay() {
		int choice;
		System.out.println("1. Hit");
		System.out.println("2. Stay");
		choice = sc.nextInt();
		sc.nextLine();

		switch (choice) {
		case 1:
			Card card = deck.dealCard();
			System.out.println(card);
			player.addCard(card);
			System.out.println(player);
			checkBust();
			checkBlackjack();

			break;

		case 2:
			while (dealer.getHandValue() < 17) {
				Card card2 = deck.dealCard();
				System.out.println(card2);
				dealer.addCard(card2);
				System.out.println("Dealer Hit");
				checkBust();
				checkBlackjack();
			}
			dealerDisplay();
			break;

		default:
			System.out.println("Invalid Selection, Please choose 1 or 2");

		}
	}

	private void dealerDisplay() {
		if (player.isBust() == false && dealer.isBust() == false && player.isBlackjack() == false
				&& dealer.isBlackjack() == false) {
			if (player.getHandValue() == dealer.getHandValue()) {
				System.out.println(dealer);
				System.out.println("Push, its a tie. Do you want to play again? [Y] or [N]");
				String input = sc.next().toLowerCase();
				playAgain(input);
			} else if (player.getHandValue() > dealer.getHandValue()) {
				System.out.println(dealer);
				System.out.println("You win, your hand was higher. Do you want to play again? [Y] or [N]");
				String input = sc.next().toLowerCase();
				playAgain(input);
			} else if (player.getHandValue() < dealer.getHandValue()) {
				System.out.println(dealer);
				System.out.println("Dealer won, their hand was higher. Do you want to play again? [Y] or [N]");
				String input = sc.next().toLowerCase();
				playAgain(input);
			}

		}
	}

	private void displayTable() {
		System.out.println();
		System.out.println(player);
		System.out.println(dealer);
		System.out.println("Deck remaining : " + deck.checkDeckSize());

	}

	private void checkBust() {
		if (player.isBust() == true) {
			System.out.println("You busted. Do you want to play again? [Y] or [N]");
			String input = sc.next().toLowerCase();
			playAgain(input);
		} else if (dealer.isBust() == true) {

			System.out.println("Dealer busted. Do you want to play again? [Y] or [N]");
			String input = sc.next().toLowerCase();
			playAgain(input);
		}

	}

	private void checkBlackjack() {
		if (dealer.isBlackjack() == true && player.isBlackjack() == true) {
			displayTable();
			System.out.println("Push! Its a tie. Do you want to play again? [Y] or [N] ");
			String input = sc.next().toLowerCase();
			playAgain(input);
		} else if (player.isBlackjack() == true) {
			displayTable();
			System.out.println("Blackjack! You win! Do you want to play again? [Y] or [N]");
			String input = sc.next().toLowerCase();
			playAgain(input);
		} else if (dealer.isBlackjack() == true) {
			displayTable();
			System.out.println("Blackjack dealer wins! Do you want to play again? [Y] or [N]");
			String input = sc.next().toLowerCase();
			playAgain(input);

		}

	}

	private void playAgain(String input) {
		String yesOrNo = input;
		if (yesOrNo.equals("y")) {
			newGame = true;
			startGame();
		} else {
			newGame = false;
			System.out.println("Thank you for playing, Goodbye.");
			BlackJackApp app = new BlackJackApp();
			app.startMenu();

		}
	}
}
