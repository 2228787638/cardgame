package com.example.cardgame;

import java.util.*;

public class Game {
    public String getWinner(String[] player1, String[] player2){
        Arrays.sort(player1);
        Arrays.sort(player2);
        switch (isCardType(player1,player2)){
            case "Pair": return getPairwinner(player1,player2)==true?"player1":"player2";
            case "HighCard": return getHighCardWinner(player1,player2)==true?"player1":"player2";
        }
        return null;
    }

    public String getCardNumber(String str){
        return str.substring(0,1);
    }
    public int changeCharToNumber(String firstNumber){
        switch(firstNumber){
            case "T": return 10;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            case "A": return 14;
            default: return Integer.parseInt(firstNumber);
        }
    }
    public boolean getHighCardWinner(String[] player1, String[] player2){
        boolean isPlayerWiner = false;
        for(int i=0;i<5;i++){
            if(getCardNumber(player1[i]).equals(getCardNumber(player2[i]))){
                continue;
            }else{
                isPlayerWiner = changeCharToNumber(getCardNumber(player1[i]))>changeCharToNumber(getCardNumber(player2[i]));
            }
        }
        return isPlayerWiner;
    }
    public boolean getPairwinner(String[] player1, String[] player2){
        boolean isPlayerWiner = false;
        Map<String,Integer> pairCountPlayer1 = new HashMap();
        Map<String,Integer> pairCountPlayer2 = new HashMap();
        for(int i=0;i<5;i++){
            if(pairCountPlayer1.containsKey(getCardNumber(player1[i]))) {
                pairCountPlayer1.put(getCardNumber(player1[i]), pairCountPlayer1.get(getCardNumber(player1[i])) + 1);
            }else{
                pairCountPlayer1.put(getCardNumber(player1[i]), 1);
            }
            if(pairCountPlayer2.containsKey(getCardNumber(player2[i]))) {
                pairCountPlayer2.put(getCardNumber(player2[i]), pairCountPlayer2.get(getCardNumber(player2[i])) + 1);
            }else{
                pairCountPlayer2.put(getCardNumber(player2[i]), 1);
            }
        }

        if(pairCountPlayer1.values().size()==4&&
                pairCountPlayer2.values().size()==5){
            isPlayerWiner = true;
        }
        return isPlayerWiner;
    }

    public String isCardType(String[] player1,String[] player2){
        Map<String,Integer> pairCountPlayer1 = new HashMap();
        Map<String,Integer> pairCountPlayer2 = new HashMap();
        for(int i=0;i<5;i++){
            if(pairCountPlayer1.containsKey(getCardNumber(player1[i]))) {
                pairCountPlayer1.put(getCardNumber(player1[i]), pairCountPlayer1.get(getCardNumber(player1[i])) + 1);
            }else{
                pairCountPlayer1.put(getCardNumber(player1[i]), 1);
            }
            if(pairCountPlayer2.containsKey(getCardNumber(player2[i]))) {
                pairCountPlayer2.put(getCardNumber(player2[i]), pairCountPlayer2.get(getCardNumber(player2[i])) + 1);
            }else{
                pairCountPlayer2.put(getCardNumber(player2[i]), 1);
            }
        }
        if(pairCountPlayer1.values().size()==4||pairCountPlayer2.values().size()==4){
            return "Pair";
        }else{
            return "HighCard";
        }
    }
}
