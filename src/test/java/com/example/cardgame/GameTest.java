package com.example.cardgame;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTest {
    @Test
    public void should_return_player1_given_the_player1_High_Card_higher_than_player2_High_Card_without_number_higher_than_T(){
        String player1[] = {"2H","3D","6S","7S","9C"};
        String player2[] = {"2H","3D","6S","7S","8C"};
        Assert.assertEquals("player1",new Game().getWinner(player1,player2));

    }

}
