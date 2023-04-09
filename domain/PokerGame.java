package domain;

import java.lang.reflect.Array;
import java.util.*;

public class PokerGame {

    static ArrayList<String> list = new ArrayList<>();
    static HashMap<String, Integer> hm = new HashMap<>();

    // prepare decks
    static{
        String[] color = {"♦", "♤", "♡", "♧"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};


        for(String c : color){
            for(String n : number){
                list.add(c + n);
            }
        }

        list.add("joker");
        list.add("Joker");

        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        hm.put("joker", Integer.MAX_VALUE-1);
        hm.put("Joker", Integer.MAX_VALUE);

        hm.put("♡", 0);
        hm.put("♦", 1);
        hm.put("♧", 2);
        hm.put("♤", 3);
    }


    public PokerGame(){
        // shuffle
        Collections.shuffle(list);

        // distribute
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> p1 = new ArrayList<>();
        ArrayList<String> p2 = new ArrayList<>();
        ArrayList<String> p3 = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            String card = list.get(i);
            if(i <= 2){
                lord.add(card);
                continue;
            }

            if(i%3 == 0)
                p1.add(card);
            else if(i%3 == 1)
                p2.add(card);
            else
                p3.add(card);
        }

        // order
        order(lord);
        order(p1);
        order(p2);
        order(p3);

        // check
//        checkHand("lord", lord);
//        checkHand("player1", p1);
//        checkHand("player2", p2);
//        checkHand("player3", p3);
    }

    public void checkHand(String playerName, ArrayList<String> hand){
        StringBuilder s = new StringBuilder();

        s.append(playerName + ": ");

        for(String card : hand){
            s.append(card + " ");
        }

        System.out.println(s);
    }

    public void order(ArrayList<String> hand){
        Collections.sort(hand, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                int val1 = getVal(o1);
                int val2 = getVal(o2);

                return val1 == val2 ? hm.get(o1.substring(0, 1)) - hm.get(o2.substring(0, 1)) : val1 - val2;
            }
        });

    }

    public int getVal(String card){
        String num = card.substring(1);

        // joker, Joker
        if(card.length() == 5)
            return hm.get(card);

        if(hm.containsKey(num))
            return hm.get(num);
        else
            return Integer.parseInt(num);
    }

}
