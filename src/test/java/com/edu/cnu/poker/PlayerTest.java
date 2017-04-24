package com.edu.cnu.poker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by dy on 2017-04-24.
 */
public class PlayerTest {

        @Test
        public void Player는_FIVE_CARD_HAND를_가진다(){
            Deck deck = new Deck(1);
            Hand hand = new Hand(deck, PokerType.FIVE);
            Player player = new Player(hand);
            assertThat(player.getHand(), is(hand));
        }
}
