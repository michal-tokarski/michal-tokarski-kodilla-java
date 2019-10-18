package com.kodilla.poker;

public class GameLogic {

    private Deck deck;
    private int numberOfDecks = 1;

    private int handSize = 5;

    private Hand dealerHand;
    private Hand playerHand;

    private String dealerName = "Dealer (Bank)";
    private String playerName = "Player (Myself)";

    public GameLogic() {
        this.deck = new Deck(numberOfDecks);
        this.dealerHand = new Hand(dealerName);
        this.playerHand = new Hand(playerName);
    }

    public void newGame() {
        deck.reset();

        // Clear hands :
        dealerHand.clearHand();
        playerHand.clearHand();

        // Clear card images :
        Poker_Main.flowpane_Dealer_Hand.getChildren().clear();
        Poker_Main.flowpane_Player_Hand.getChildren().clear();

        // Deal new hand to each party :
        for (int i=0 ; i < handSize ; i++) {
            dealerHand.addRandomCard(deck);
            playerHand.addRandomCard(deck);
        }

        // Get card images :
        for (int i=0 ; i < handSize ; i++) {
            Poker_Main.flowpane_Dealer_Hand.getChildren().add(dealerHand.getCardList().get(i).getCardImage());
            Poker_Main.flowpane_Player_Hand.getChildren().add(playerHand.getCardList().get(i).getCardImage());
        }

        // Get poker categories :
        Poker_Main.label_Dealer_PokerCategory.setText(String.valueOf(dealerHand.getPokerCategory(dealerHand)));
        Poker_Main.label_Player_PokerCategory.setText(String.valueOf(playerHand.getPokerCategory(playerHand)));

        // Get highest cards :
        Poker_Main.label_Dealer_HighestCard.setText(String.valueOf(dealerHand.getHighestCard().toString()));
        Poker_Main.label_Player_HighestCard.setText(String.valueOf(playerHand.getHighestCard().toString()));

    }

    public void bet() {
        // ....................
    }

    public void swapCards() {
        // ....................
    }

    public void stand() {
        // ....................
    }

    public void raise() {
        // ....................
    }

    public void call() {
        // ....................
    }

    public void quitGame() {
        // ....................
    }

}
