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
    @Test
    public void should_return_player2_given_the_player2_High_Card_higher_than_player1_High_Card_with_number_higher_than_T(){
        String player1[] = {"2H","3D","5S","8C","9S"};
        String player2[] = {"2H","3D","6S","7S","KH"};
        Assert.assertEquals("player2",new Game().getWinner(player1,player2));
    }
    @Test
    public void should_return_player1_given_the_player1_pair_card_than_player2_High_Card(){
        String player1[] = {"2H","3D","3S","5S","7C"};
        String player2[] = {"2D","4S","5H","7C","8H"};
        Assert.assertEquals("player1",new Game().getWinner(player1,player2));
    }
    @Test
    public void should_return_player1_given_the_player1_pair_card_higher_than_player2_pair_Card(){
        String player1[] = {"2H","3D","4S","7S","7C"};
        String player2[] = {"2D","3S","5H","5C","8H"};
        Assert.assertEquals("player1",new Game().getWinner(player1,player2));
    }
    @Test
    public void should_return_player2_given_the_player2_two_pair_card_than_player1_pair_Card(){
        String player1[] = {"2H","3D","4S","7S","7C"};
        String player2[] = {"2D","2S","5H","5C","8H"};
        Assert.assertEquals("player2",new Game().getWinner(player1,player2));
    }
    @Test
    public void should_return_player1_given_the_player1_Three_Of_A_Kind_higher_than_player2_Three_Of_A_Kind_Card(){
        String player1[] = {"8H","8D","8S","5S","7C"};
        String player2[] = {"2D","2S","2H","5C","9H"};
        Assert.assertEquals("player1",new Game().getWinner(player1,player2));
    }
    @Test
    public void should_return_player1_given_the_player1_Three_Of_A_Kind_higher_than_player2_Two_pairs_Card(){
        String player1[] = {"8H","8D","8S","5S","7C"};
        String player2[] = {"2D","2S","9H","9C","TH"};
        Assert.assertEquals("player1",new Game().getWinner(player1,player2));
    }
    @Test
    public void should_return_player2_given_the_player2_Straight_higher_than_player1_Straight_Card(){
        String player1[] = {"2H","3D","4S","5S","6C"};
        String player2[] = {"3H","4D","5S","6C","7D"};
        Assert.assertEquals("player2",new Game().getWinner(player1,player2));
    }
    @Test
    public void should_return_player2_given_the_player2_Straight_higher_than_player1_Three_Of_A_Kind_Card(){
        String player1[] = {"8H","8D","8S","5S","7C"};
        String player2[] = {"3H","4D","5S","6C","7D"};
        Assert.assertEquals("player2",new Game().getWinner(player1,player2));
    }
    @Test
    public void should_return_player1_given_the_player1_Flush_higher_than_player2_Straight_Card(){
        String player1[] = {"8H","3H","4H","6H","7H"};
        String player2[] = {"3H","4D","5S","6C","7D"};
        Assert.assertEquals("player1",new Game().getWinner(player1,player2));
    }
}
