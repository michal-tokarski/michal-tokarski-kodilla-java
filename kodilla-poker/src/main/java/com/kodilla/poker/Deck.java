package com.kodilla.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> deck;
    private int index;
    private int numDecks;

    public Card getRandomCard () {
        Random random = new Random();
        int generatedNumber = random.nextInt(deck.size());
        Card generatedCard = deck.get(generatedNumber);
        deck.remove(generatedNumber);
        return generatedCard;
    }

    public Deck(int numDecks) {
        this.numDecks = numDecks;
        reset();
    }

    private void addCard(Card card) {
        deck.add(card);
    }

    public int getSizeOfDeck() {
        return deck.size();
    }

    public int getNumberOfCardsRemaining() {
        return deck.size() - index;
    }

    public Card dealCard() {
        if (index >= deck.size())
            return null;
        else
            return deck.get(index++);
    }

    private void shuffle() {
        Collections.shuffle(deck);
    }

    public void reset() {
        deck = new ArrayList<>();
        index = 0;

        for (int i = 0; i < numDecks; i++) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    Card card = new Card(rank, suit);
                    addCard(card);
                }
            }
        }

        shuffle();
    }
}