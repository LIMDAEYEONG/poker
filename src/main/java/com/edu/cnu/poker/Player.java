package com.edu.cnu.poker;

/**
 * Created by dy on 2017-04-24.
 */
import lombok.Data;

@Data
public class Player {
    private Hand hand;

    public Player(Hand hand){
        this.hand = hand;
    }


}
