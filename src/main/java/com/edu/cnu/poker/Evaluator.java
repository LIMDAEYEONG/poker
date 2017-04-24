package com.edu.cnu.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cse on 2017-04-17.
 */
public class Evaluator {
    public HandRanking evaluate(List<Card> cardList) {
        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>();
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        for (Card card : cardList) {
            if (tempMap.containsKey(card.getSuit())) {
                Integer count = tempMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getSuit(), count);
            } else {
                tempMap.put(card.getSuit(), new Integer(1));
            }

            if (countMap.containsKey(card.getRank())) {
                Integer count = countMap.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                countMap.put(card.getRank(), count);
            } else {
                countMap.put(card.getRank(), new Integer(1));
            }

        }

        /* Straight Flush */
        for (Suit key : tempMap.keySet()) {
            if (tempMap.get(key) == 5) {
                return HandRanking.FLUSH;
            }
        }
        /* Four Card */
        for(Integer key : countMap.keySet()){
            if(countMap.get(key) == 4) {
                return HandRanking.FOUR_CARD;
            }
        }

        /* Full house */
        for (Integer key1 : countMap.keySet()) {
            if (countMap.get(key1) == 2) {
                for (Integer key2 : countMap.keySet()) {
                    if (countMap.get(key2) == 3 && key1 != key2) {
                        return HandRanking.FULL_HOUSE;
                    }
                }
            }
        }

        /* Flush */
        for (Suit key : tempMap.keySet()) {
            if (tempMap.get(key) == 5) {
                return HandRanking.FLUSH;
            }
        }

        /* Straight*/


        /* Triple */
        for(Integer key : countMap.keySet()){
            if(countMap.get(key) == 3){
                return HandRanking.TRIPLE;
            }
        }

        /* Two pair*/
        for (Integer key1 : countMap.keySet()) {
            if (countMap.get(key1) == 2) {
                for (Integer key2 : countMap.keySet()) {
                    if (countMap.get(key2) == 2 && key1 != key2) {
                        return HandRanking.TWO_PAIR;
                    }
                }
            }
        }

        /* One pair*/
        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) == 2) {
                return HandRanking.ONE_PAIR;

            }
            for (Integer key1 : countMap.keySet()) {
                if (countMap.get(key1) == 2) {
                    for (Integer key2 : countMap.keySet()) {
                        if (countMap.get(key2) == 2 && key1 != key2) {
                            return HandRanking.TWO_PAIR;
                        }
                    }
                }
            }
        }
        return HandRanking.NOTHING;
    }
}
