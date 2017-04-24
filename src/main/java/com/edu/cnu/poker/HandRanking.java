package com.edu.cnu.poker;

public enum HandRanking {
    ROYAL_STRAIGHT_FLUSH(9),
    STRAIGHT_FULSH(8),
    FOUR_CARD(7),
    FULL_HOUSE(6),
    FLUSH(5),
    STRAIGHT(4),
    TRIPLE(3),
    TWO_PAIR(2),
    ONE_PAIR(1),
    NOTHING(0); //High card

    private int rankOfHand;

    HandRanking(int rankOfHand) {
        this.rankOfHand = rankOfHand;
    }
    public int getRankOfHand() {
        return this.rankOfHand;
    }
}
