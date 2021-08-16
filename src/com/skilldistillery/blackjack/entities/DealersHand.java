package com.skilldistillery.blackjack.entities;

public class DealersHand extends BlackjackHand {

	@Override
	public String toString() {
		return "DealersHand" + hand + " totals to " + getHandValue();

	}

}
