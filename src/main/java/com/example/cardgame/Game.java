package com.example.cardgame;

import java.util.Arrays;

public class Game {
    public String getWinner(String[] player1, String[] player2){
        Arrays.sort(player1);
        Arrays.sort(player2);
        boolean isPlayerWiner = false;
        for(int i=0;i<5;i++){
            if(getCardNumber(player1[i]).equals(getCardNumber(player2[i]))){
                continue;
            }else{
                isPlayerWiner = Integer.parseInt(getCardNumber(player1[i]))>Integer.parseInt(getCardNumber(player2[i]));
            }
        }
        return isPlayerWiner==true?"player1":"player2";
    }

    public String getCardNumber(String str){
        return str.substring(0,1);
    }
}
