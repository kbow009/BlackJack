package com.skilldistillery.blackjack.app;

import java.util.Objects;
import java.util.Scanner;
import java.util.List;
import com.skilldistillery.blackjack.entities.*;

public class BlackJackApp {
	Table table = new Table();
	Scanner sc = new Scanner(System.in);
	int selection;

	public static void main(String[] args) {

		BlackJackApp app = new BlackJackApp();
		app.startMenu();
	}

	public void startMenu() {

		System.out.println("**** 🃏 Welcome to Blackjack! 🃏 ****");
		System.out.println("Would you like to play? * 1. Yes  ::  2.  No *");
		selection = sc.nextInt();
		switch (selection) {

		case 1:
			table.startGame();
			break;
		case 2:
			System.out.println("Leaving table. ");
			break;
		default:
			System.out.println("Invalid Selection, Please choose 1 or 2");

		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(sc, selection, table);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlackJackApp other = (BlackJackApp) obj;
		return Objects.equals(sc, other.sc) && selection == other.selection && Objects.equals(table, other.table);
	}
}