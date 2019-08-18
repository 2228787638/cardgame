package com.example.cardgame;

import java.util.*;

public class Game {
    public String getWinner(String[] player1, String[] player2){
        Arrays.sort(player1);
        Arrays.sort(player2);
        switch (isCardType(player1,player2)){
            case "FullHouse": return getFullHouseWinner(player1,player2)==true?"player1":"player2";
            case "Flush": return getFlushwinner(player1,player2)==true?"player1":"player2";
            case "Straight": return getStraightwinner(player1,player2)==true?"player1":"player2";
            case "ThreeOfAKind": return getThreeOfAKindrwinner(player1,player2)==true?"player1":"player2";
            case "Pair": return getPairwinner(player1,player2)==true?"player1":"player2";
            case "HighCard": return getHighCardWinner(player1,player2)==true?"player1":"player2";
        }
        return null;
    }

    public String getCardNumber(String str){
        return str.substring(0,1);
    }
    public String getFlushColor(String str){
        return str.substring(1,2);
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
        }else if(pairCountPlayer1.values().size()==4&&
                pairCountPlayer2.values().size()==4){
            if(changeCharToNumber(getKey(pairCountPlayer1,2))>changeCharToNumber(getKey(pairCountPlayer2,2))){
                isPlayerWiner = true;
            }
        }
        return isPlayerWiner;
    }
    public boolean getThreeOfAKindrwinner(String[] player1, String[] player2){
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

        if(pairCountPlayer1.values().size()<pairCountPlayer2.values().size()){
            isPlayerWiner = true;
        }else if(pairCountPlayer1.values().size()==pairCountPlayer2.values().size()){
            if(pairCountPlayer1.values().contains(3)&&pairCountPlayer2.values().contains(3))
            {
                isPlayerWiner = changeCharToNumber(getKey(pairCountPlayer1,3))
                        >changeCharToNumber(getKey(pairCountPlayer2,3))?true:false;
            }else if(pairCountPlayer1.values().contains(3)&&pairCountPlayer2.values().contains(2)
            &&!pairCountPlayer2.values().contains(3)){
                isPlayerWiner=true;
            }else if(pairCountPlayer2.values().contains(3)&&pairCountPlayer1.values().contains(2)
                    &&!pairCountPlayer1.values().contains(3)){
                isPlayerWiner=false;
            }
        }
        return isPlayerWiner;
    }
    public boolean getStraightwinner(String[] player1, String[] player2){
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
        if((pairCountPlayer1.values().size()==5&&pairCountPlayer2.values().size()==5)&&isStraight(pairCountPlayer1)&&isStraight(pairCountPlayer2)){
            if(changeCharToNumber(getCardNumber(player1[4]))>changeCharToNumber(getCardNumber(player2[4]))) isPlayerWiner=true;
        }else{
            return pairCountPlayer1.values().size()>pairCountPlayer2.values().size();
        }
        return isPlayerWiner;
    }

    public boolean getFlushwinner(String[] player1, String[] player2){
        boolean isPlayerWiner = false;
        if(isFlush(player1)&&isFlush(player2)){
            isPlayerWiner = changeCharToNumber(getCardNumber(player1[4]))>changeCharToNumber(getCardNumber(player2[4]));
        }else{
            isPlayerWiner = isFlush(player1);
        }
        return isPlayerWiner;
    }
    public boolean getFullHouseWinner(String[] player1, String[] player2){
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
        if(pairCountPlayer1.values().contains(3)&&pairCountPlayer1.values().contains(2)) isPlayerWiner=true;

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
        if((pairCountPlayer1.values().contains(3)&&pairCountPlayer1.values().contains(2))||
                (pairCountPlayer2.values().contains(3)&&pairCountPlayer2.values().contains(2))){
            return "FullHouse";
        }else if(isFlush(player1)||isFlush(player2)){
            return "Flush";
        }else if((pairCountPlayer1.values().size()==5||pairCountPlayer2.values().size()==5)&&
                (isStraight(pairCountPlayer1)||isStraight(pairCountPlayer2))) {
            return "Straight";
        }else if(pairCountPlayer1.values().size()==3||pairCountPlayer2.values().size()==3) {
            if(pairCountPlayer1.values().contains(3))return "ThreeOfAKind";
            else return "Pair";
        }else if(pairCountPlayer1.values().size()==4||pairCountPlayer2.values().size()==4){
            return "Pair";
        }else{
            return "HighCard";
        }
    }

    public String getKey(Map<String,Integer> map,int value){
        String key = null;
        for(String getKey: map.keySet()){
            if(map.get(getKey).equals(value)){
                key = getKey;
            }
        }
        return key;
    }

    public boolean isStraight(Map<String,Integer> pairCountPlayer){
        int before = 0;
        for(String getKey: pairCountPlayer.keySet()){
            if(before==0){
                before = changeCharToNumber(getKey);
                continue;
            }
            if(before != changeCharToNumber(getKey)-1){
                return false;
            }
            before = changeCharToNumber(getKey);
        }
        return true;
    }

    public boolean isFlush(String[] player){
        int flushColorCount[] = new int[200];
        for(int i=0;i<player.length;i++){
            flushColorCount[player[i].charAt(1)]++;
            if(flushColorCount[player[i].charAt(1)]==5){
                return true;
            }
        }
        return false;
    }
}
