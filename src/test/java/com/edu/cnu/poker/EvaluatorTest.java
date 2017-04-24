package com.edu.cnu.poker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by cse on 2017-04-17.
 */
public class EvaluatorTest {

    @Test
    public void SUIT가_5개가동일하면_플러쉬다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(4, Suit.CLUBS),
                new Card(8, Suit.CLUBS),
                new Card(13, Suit.CLUBS),
                new Card(2, Suit.CLUBS)
        );
        HandRanking result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRanking.FLUSH));
    }

    @Test
    public void 숫자가_2개가동일하면_원페어다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.DIAMONDS),
                new Card(2, Suit.HEARTS),
                new Card(7, Suit.DIAMONDS),
                new Card(9, Suit.SPADES),
                new Card(12, Suit.CLUBS)
        );
        HandRanking result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRanking.ONE_PAIR));
    }

    @Test
    public void 숫자가_4개가동일하면_포카드다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(4,Suit.DIAMONDS),
                new Card(4, Suit.HEARTS),
                new Card(4, Suit.DIAMONDS),
                new Card(4, Suit.SPADES),
                new Card(12, Suit.CLUBS)
        );
        HandRanking result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRanking.FOUR_CARD));
    }



}