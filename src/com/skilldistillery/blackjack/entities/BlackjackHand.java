package com.skilldistillery.blackjack.entities;

import java.util.List;

public class BlackjackHand extends Hand {
	 
	 
	public BlackjackHand() {
		super();
		
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;

		}
		return false;
	}

	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		}
		return false;
	}

	@Override
	public int getHandValue() {
		int value = 0;

		for (Card card : hand) {
			value += card.getValue();

		}
		return value;
	}
}
