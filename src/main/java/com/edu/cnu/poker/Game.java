package com.edu.cnu.poker;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dy on 2017-04-25.
 */
@Data
public class Game {
        private Deck deck;
        private List<Player> playerList;

        public Game(int numberOfPlayers){
                deck = new Deck(1);
                this.playerList = new ArrayList<Player>();
                for(int i=0; i<numberOfPlayers; i++){
                        playerList.add(i, new Player(new Hand(deck, PokerType.FIVE)));
                }
        }

}
