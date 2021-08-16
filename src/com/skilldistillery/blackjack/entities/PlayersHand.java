package com.skilldistillery.blackjack.entities;

public class PlayersHand extends BlackjackHand{

	@Override
	public String toString() {
		return "PlayersHand " + hand + ", totals to " + getHandValue();
	}


}
