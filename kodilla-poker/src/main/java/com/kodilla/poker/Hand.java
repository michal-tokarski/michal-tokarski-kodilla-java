package com.kodilla.poker;

import java.util.ArrayList;
import java.util.List;

public class Hand extends Analyzer {

    private String name;
    private List<Card> cardList;
    //private int handValue;

    public Hand(String name) {
        this.name = name;
        cardList = new ArrayList<>();
        //this.handValue = 0;
    }

    public void addRandomCard(Deck deck) {
        cardList.add(deck.getRandomCard());
    }

    public void addGivenCard(Card card) {
        cardList.add(card);
    }


    public void clearHand() {
        cardList.clear();
        //handValue = 0;
    }

    public List<Card> getCardList() {
        return cardList;
    }



    public String getName() {
        return name;
    }


    public Card getHighestCard () {

        Card highestCard = null;

        int maxRankValue = 0;
        int maxSuitValue = 0;
        for (Card c : getCardList()) {
            if (maxRankValue < c.getRank().getRankValue()) {
                maxRankValue = c.getRank().getRankValue();
                maxSuitValue = c.getSuit().getSuitValue();
                highestCard = c;
            } else if ( (maxRankValue == c.getRank().getRankValue())
                    && (maxSuitValue < c.getSuit().getSuitValue()) ) {
                maxSuitValue = c.getSuit().getSuitValue();
                highestCard = c;
            }
        }
        return highestCard;
    }

    public PokerCategory getPokerCategory (Hand argHand) {
        PokerCategory pokerCategory = null;
        pokerCategory = determinePokerCategory(argHand);
        return pokerCategory;
    }

}