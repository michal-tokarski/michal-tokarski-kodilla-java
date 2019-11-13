package com.kodilla.poker;

import javafx.application.Platform;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.stream.Collectors;

public class Game {

    // Game settings :
    // ====================================================================================

    // Deck settings :
    private Deck deck;
    private int numberOfDecks = 1;

    // Hand settings :
    private int handSize = 5;

    // Usernames settings :
    final String dealerName = "Dealer";
    final String playerName = "Player";

    // Credits settings :
    public int initialCredits = 10000;

    // Dealer variables :
    private Hand dealerHand;
    public Analyzer.PokerCategory dealerPokerCategory;
    public Card dealerHighestCard;
    public int dealerInitialCredits;
    public int dealerCreditsBalance;
    public int dealerCurrentBet;
    public int dealerTotalBet;
    public int dealerOutstandingBet;
    public int dealerGamesWon;

    // Player variables :
    private Hand playerHand;
    public Analyzer.PokerCategory playerPokerCategory;
    public Card playerHighestCard;
    public int playerInitialCredits;
    public int playerCreditsBalance;
    public int playerCurrentBet;
    public int playerTotalBet;
    public int playerOutstandingBet;
    public int playerGamesWon;

    // Common variables :
    public int potValue;
    public String gameWinner;
    public String gameMessage;
    public String actionMessage;

    // Steering variables :
    public String actionOwner;
    public String gamePhase;
    public Boolean dealerIsDone;
    public Boolean playerIsDone;

    // Appearance variables :
    public String backgroundYGrey = "#808080";
    public String backgroundYellow = "#FFFF00";

    // Game-state settings :
    public GameState state;

    enum GameState {

        GAME_OPENING(1, "1/6 - New Game"),
        BETTING_FIRST_ROUND(2, "2/6 - Betting first round"),
        CARD_SWAPPING(3, "3/6 - Card swapping"),
        BETTING_SECOND_ROUND(4, "4/6 - Betting second round"),
        SHOWDOWN(5, "5/6 - Showdown"),
        GAME_CLOSURE(6, "6/6 - Game Over");

        int stateID;
        String stateName;

        GameState(int stateID, String stateName) {
            this.stateID = stateID;
            this.stateName = stateName;
        }
    }


    public Game() {
        this.deck = new Deck(numberOfDecks);
        this.dealerHand = new Hand(dealerName);
        this.playerHand = new Hand(playerName);
    }

    // Initialize procedures :
    // ====================================================================================

    public void initializePokerCategory() {
        dealerPokerCategory = null;
        playerPokerCategory = null;
        Poker_Main.label_Dealer_PokerCategory_Value.setText(String.valueOf(dealerPokerCategory));
        Poker_Main.label_Player_PokerCategory_Value.setText(String.valueOf(playerPokerCategory));
    }

    public void initializeHighestCard() {
        dealerHighestCard = null;
        playerHighestCard = null;
        Poker_Main.label_Dealer_HighestCard_Value.setText(String.valueOf(dealerHighestCard));
        Poker_Main.label_Player_HighestCard_Value.setText(String.valueOf(playerHighestCard));
    }

    public void initializeInitialCredits() {
        dealerInitialCredits = initialCredits;
        playerInitialCredits = initialCredits;
        Poker_Main.label_Dealer_InitialCredits_Value.setText(String.valueOf(dealerInitialCredits));
        Poker_Main.label_Player_InitialCredits_Value.setText(String.valueOf(playerInitialCredits));
    }

    public void initializeCreditsBalance() {
        dealerCreditsBalance = dealerInitialCredits;
        playerCreditsBalance = playerInitialCredits;
        Poker_Main.label_Dealer_InitialCredits_Value.setText(String.valueOf(dealerCreditsBalance));
        Poker_Main.label_Player_InitialCredits_Value.setText(String.valueOf(playerCreditsBalance));
    }

    public void initializeTotalBet() {
        dealerTotalBet = 0;
        playerTotalBet = 0;
        Poker_Main.label_Dealer_TotalBet_Value.setText(String.valueOf(dealerTotalBet));
        Poker_Main.label_Player_TotalBet_Value.setText(String.valueOf(playerTotalBet));
    }

    public void initializeOutstandingBet() {
        dealerOutstandingBet = 0;
        playerOutstandingBet = 0;
        Poker_Main.label_Dealer_OutstandingBet_Value.setText(String.valueOf(dealerOutstandingBet));
        Poker_Main.label_Player_OutstandingBet_Value.setText(String.valueOf(playerOutstandingBet));
    }

    public void initializeGamesWon() {
        dealerGamesWon = 0;
        playerGamesWon = 0;
        Poker_Main.label_Dealer_GamesWon_Value.setText(String.valueOf(dealerGamesWon));
        Poker_Main.label_Player_GamesWon_Value.setText(String.valueOf(playerGamesWon));
    }

    public void initializePotValue() {
        potValue = 0;
        Poker_Main.label_Common_PotValue_Value.setText(String.valueOf(potValue));
    }

    public void initializeGameWinner() {
        gameWinner = "";
        Poker_Main.label_Common_GameWinner_Value.setText(gameWinner);

    }

    public void initializeActionOwner() {
        actionOwner = playerName;
    }

    public void initializeGamePhase() {
        gamePhase = "Phase 1";
    }

    public void initializeIsDone() {
        dealerIsDone = false;
        playerIsDone = false;
    }

    public void initializeGameMessage() {
        actionMessage = "";
        gameMessage = "";
        Poker_Main.label_Common_GameMessage.setText(gameMessage);
    }


    // Update procedures :
    // ====================================================================================

    public void updatePokerCategory(String user, Hand userHand) {

        if (user.equals(dealerName)) {
            dealerPokerCategory = dealerHand.getPokerCategory(dealerHand);
            Poker_Main.label_Dealer_PokerCategory_Value.setText(String.valueOf(dealerPokerCategory));
        } else if (user.equals(playerName)) {
            playerPokerCategory = playerHand.getPokerCategory(playerHand);
            Poker_Main.label_Player_PokerCategory_Value.setText(String.valueOf(playerPokerCategory));
        }

    }

    public void updateHighestCard(String user, Hand userHand) {

        if (user.equals(dealerName)) {
            dealerHighestCard = dealerHand.getHighestCard();
            Poker_Main.label_Dealer_HighestCard_Value.setText(String.valueOf(dealerHighestCard));
        } else if (user.equals(playerName)) {
            playerHighestCard = playerHand.getHighestCard();
            Poker_Main.label_Player_HighestCard_Value.setText(String.valueOf(playerHighestCard));
        }

    }

    public void updateCreditsBalance(String user, int creditsAmount) {

        if (user.equals(dealerName)) {
            dealerCreditsBalance = dealerCreditsBalance + creditsAmount;
            Poker_Main.label_Dealer_CreditsBalance_Value.setText(String.valueOf(dealerCreditsBalance));
        } else if (user.equals(playerName)) {
            playerCreditsBalance = playerCreditsBalance + creditsAmount;
            Poker_Main.label_Player_CreditsBalance_Value.setText(String.valueOf(playerCreditsBalance));
        }

    }

    public void updateTotalBet(String user, int currentBet) {

        if (user.equals(dealerName)) {
            dealerTotalBet = dealerTotalBet + currentBet;
            Poker_Main.label_Dealer_TotalBet_Value.setText(String.valueOf(dealerTotalBet));
        } else if (user.equals(playerName)) {
            playerTotalBet = playerTotalBet + currentBet;
            Poker_Main.label_Player_TotalBet_Value.setText(String.valueOf(playerTotalBet));
        }

    }

    public void updateOutstandingBet() {

        // calculate Outstanding Bet :
        if (dealerTotalBet > playerTotalBet) {
            dealerOutstandingBet = 0;
            playerOutstandingBet = dealerTotalBet - playerTotalBet;
        } else if (dealerTotalBet < playerTotalBet) {
            dealerOutstandingBet = playerTotalBet - dealerTotalBet;
            playerOutstandingBet = 0;
        } else {
            dealerOutstandingBet = 0;
            playerOutstandingBet = 0;
        }

        // update labels with values :
        Poker_Main.label_Dealer_OutstandingBet_Value.setText(String.valueOf(dealerOutstandingBet));
        Poker_Main.label_Player_OutstandingBet_Value.setText(String.valueOf(playerOutstandingBet));

        // set red font in label if there is Outsanding Bet :
        if (dealerOutstandingBet > 0) {
            Poker_Main.label_Dealer_OutstandingBet_Value.setTextFill(Color.web("#FF0000")); // red font
            Poker_Main.label_Player_OutstandingBet_Value.setTextFill(Color.web("#FFFFFF")); // white font
        } else if (playerOutstandingBet > 0) {
            Poker_Main.label_Dealer_OutstandingBet_Value.setTextFill(Color.web("#FFFFFF")); // white font
            Poker_Main.label_Player_OutstandingBet_Value.setTextFill(Color.web("#FF0000")); // red font
        } else {
            Poker_Main.label_Dealer_OutstandingBet_Value.setTextFill(Color.web("#FFFFFF")); // white font
            Poker_Main.label_Player_OutstandingBet_Value.setTextFill(Color.web("#FFFFFF")); // white font
        }

        // source of color codes :
        // https://docs.oracle.com/javafx/2/api/javafx/scene/paint/Color.html

    }


    public void updateGamesWon(String user) {

        if (user.equals(dealerName)) {
            dealerGamesWon++;
            Poker_Main.label_Dealer_GamesWon_Value.setText(String.valueOf(dealerGamesWon));
        } else if (user.equals(playerName)) {
            playerGamesWon++;
            Poker_Main.label_Player_GamesWon_Value.setText(String.valueOf(playerGamesWon));
        }

    }

    public void updatePotValue(String user, int Amount) {

        potValue = potValue + Amount;
        Poker_Main.label_Common_PotValue_Value.setText(String.valueOf(potValue));

    }


    public String determineGameWinner() {

        // Compare Poker Categories :
        if (dealerHand.getPokerCategory(dealerHand).catValue > playerHand.getPokerCategory(playerHand).catValue) {
            gameWinner = dealerName;
        } else if (dealerHand.getPokerCategory(dealerHand).catValue < playerHand.getPokerCategory(playerHand).catValue) {
            gameWinner = playerName;

        // If equal Poker Categories then compare Highest Cards :
        } else if (dealerHand.getPokerCategory(dealerHand).catValue == playerHand.getPokerCategory(playerHand).catValue) {

            Card dealerHighestCard = new Card(dealerHand.getHighestCard().getRank(), dealerHand.getHighestCard().getSuit());
            Card playerHighestCard = new Card(playerHand.getHighestCard().getRank(), playerHand.getHighestCard().getSuit());

            // 2-card presudoHand created in order to use the 'getHighestCard()' method
            Hand pseudoHand = new Hand("pseudoHand");
            pseudoHand.addGivenCard(dealerHighestCard);
            pseudoHand.addGivenCard(playerHighestCard);

            if (pseudoHand.getHighestCard() == dealerHighestCard) {
                gameWinner = dealerName;
            } else if (pseudoHand.getHighestCard() == playerHighestCard) {
                gameWinner = playerName;
            }
        }
        return gameWinner;
    }

    public void updateGameWinner(String gameWinner) {

        Poker_Main.label_Common_GameWinner_Value.setText(gameWinner);

        if (gameWinner.equals(dealerName)) {
            Poker_Main.label_Common_GameWinner_Value.setTextFill(Color.web("#FF0000")); // red font
        } else if (gameWinner.equals(playerName)) {
            Poker_Main.label_Common_GameWinner_Value.setTextFill(Color.web("#7CFC00")); // green font
        }

    }

    private void updateGameMessage(String gameMessage) {
        Poker_Main.label_Common_GameMessage.setText(gameMessage);
        Poker_Main.label_Common_GameMessage.setTextFill(Color.web("#FFFF00")); // yellow font
    }


    // Gameflow procedures :
    // ====================================================================================

    public void startPlay() {

        // User values :
        initializePokerCategory();
        initializeHighestCard();
        initializeInitialCredits();
        initializeCreditsBalance();
        initializeTotalBet();
        initializeOutstandingBet();
        initializeGamesWon();

        // Common values :
        initializePotValue();
        initializeGameWinner();
        initializeGameMessage();

        // Game flow :
        newDeal();

        // Steering variables :
        initializeActionOwner();
        initializeGamePhase();
        initializeIsDone();

        // Message
        actionMessage = "Place your bet";
        gameMessage = gamePhase + " - " + actionOwner + " : " + actionMessage;
        updateGameMessage(gameMessage);

    }

    public void newGame(String user) {

        // User values :
        initializePokerCategory();
        initializeHighestCard();
        // initializeInitialCredits();  // this value is continued in a new game
        // initializeCreditsBalance();  // this value is continued in a new game
        initializeTotalBet();
        initializeOutstandingBet();
        // initializeGamesWon();        // this value is continued in a new game

        // Common values :
        initializePotValue();
        initializeGameWinner();
        initializeGameMessage();

        // Game flow :
        newDeal();

        // Steering variables :
        initializeActionOwner();
        initializeGamePhase();
        initializeIsDone();

        // Message
        gameMessage = gamePhase + " - " + actionOwner + " : " + "Place your bet";
        updateGameMessage(gameMessage);

    }


    public void newDeal() {

        // Restore full deck :
        deck.reset();

        // Clear all hands :
        dealerHand.clearHand();
        playerHand.clearHand();

        // Clear all card images :
        Poker_Main.flowpane_Dealer_Hand_CardImages.getChildren().clear();
        Poker_Main.flowpane_Player_Hand_CardImages.getChildren().clear();

        // Deal each party a new hand :
        for (int i = 0; i < handSize; i++) {
            dealerHand.addRandomCard(deck);
            playerHand.addRandomCard(deck);
        }

        // Update card images :
        for (int i = 0; i < handSize; i++) {
            Poker_Main.flowpane_Dealer_Hand_CardImages.getChildren().add(dealerHand.getCardList().get(i).getCardImage());
            Poker_Main.flowpane_Player_Hand_CardImages.getChildren().add(playerHand.getCardList().get(i).getCardImage());
        }

        // Update poker categories :
        Poker_Main.label_Dealer_PokerCategory_Value.setText(String.valueOf(dealerHand.getPokerCategory(dealerHand)));
        Poker_Main.label_Player_PokerCategory_Value.setText(String.valueOf(playerHand.getPokerCategory(playerHand)));

        // Update Poker Category :
        updatePokerCategory(dealerName, dealerHand);
        updatePokerCategory(playerName, playerHand);
        // Update Highest Card :
        updateHighestCard(dealerName, dealerHand);
        updateHighestCard(playerName, playerHand);

        // Update highest cards :
        Poker_Main.label_Dealer_HighestCard_Value.setText(String.valueOf(dealerHand.getHighestCard().toString()));
        Poker_Main.label_Player_HighestCard_Value.setText(String.valueOf(playerHand.getHighestCard().toString()));

    }

    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public void entryBet(String user) {

        // check if input is numeric :
        if (user.equals(dealerName)) {
            if (isNumeric(Poker_Main.textfield_Dealer_PlaceBet_Amount.getText())) {
                dealerCurrentBet = Integer.parseInt(Poker_Main.textfield_Dealer_PlaceBet_Amount.getText());
            }
        } else if (user.equals(playerName)) {
            if (isNumeric(Poker_Main.textfield_Player_PlaceBet_Amount.getText())) {
                playerCurrentBet = Integer.parseInt(Poker_Main.textfield_Player_PlaceBet_Amount.getText());
            }
        }

        // check if sufficient Credits Balance :
        if (user.equals(dealerName)) {
            if (dealerCreditsBalance < dealerTotalBet + dealerCurrentBet) {
                gameMessage = user + " : " + "Not sufficient credits to make this bet";
                updateGameMessage(gameMessage);
                return;
            }
        } else if (user.equals(playerName)) {
            if (playerCreditsBalance < playerTotalBet + playerCurrentBet) {
                gameMessage = user + " : " + "Not sufficient credits to make this bet";
                updateGameMessage(gameMessage);
                return;
            }
        }

        // update Total Bet :
        if (user.equals(dealerName)) {
            updateTotalBet(dealerName, dealerCurrentBet);
        } else if (user.equals(playerName)) {
            updateTotalBet(playerName, playerCurrentBet);
        }

        // update Credits Balance :
        if (user.equals(dealerName)) {
            updateCreditsBalance(dealerName,-1*dealerCurrentBet);
        } else if (user.equals(playerName)) {
            updateCreditsBalance(playerName,-1*playerCurrentBet);
        }

        // update Pot Value :
        if (user.equals(dealerName)) {
            updatePotValue(dealerName, dealerCurrentBet);
        } else if (user.equals(playerName)) {
            updatePotValue(playerName, playerCurrentBet);
        }

        // clear Current Bet :
        if (user.equals(dealerName)) {
            dealerCurrentBet = 0;
            Poker_Main.textfield_Dealer_PlaceBet_Amount.setText(String.valueOf(dealerCurrentBet));
        } else if (user.equals(playerName)) {
            playerCurrentBet = 0;
            Poker_Main.textfield_Player_PlaceBet_Amount.setText(String.valueOf(playerCurrentBet));
        }

        // update Outstanding Bet :
        updateOutstandingBet();


        // update Game Message :
        if (dealerOutstandingBet > 0) {
            gameMessage = dealerName + " - " + "Phase 1 : Put additional bet";
        } else if (playerOutstandingBet > 0) {
            gameMessage = playerName + " - " + "Phase 1 : Put additional bet";
        } else {
            gameMessage = actionOwner + " - " + "Phase 2 : Swap cards";
        }
        updateGameMessage(gameMessage);

        // Steering variables :
        if (user.equals(dealerName)) {
            actionOwner = playerName;
            dealerIsDone = true;
        } else if (user.equals(playerName)) {
            actionOwner = dealerName;
            playerIsDone = true;
        }

        if (dealerIsDone && playerIsDone) {
            gamePhase = "Phase 2";
            actionMessage = "Select cards for swap";
        } else {
            gamePhase = "Phase 1";
            actionMessage = "Place your bet";
        }

        // Message
        gameMessage = gamePhase + " - " + actionOwner + " : " + actionMessage;
        updateGameMessage(gameMessage);

    }


    public void swapCards(String user) {

        if (user.equals(dealerName)) {

            // collect all cards that have been clicked
            List<Card> collect = dealerHand.getCardList().stream().filter(card -> card.isClicked).collect(Collectors.toList());
            System.out.println("Dealer - cards clicked : " + collect);

            // jump out if more than 3 cards have been clicked
            if (collect.size() > 3) {
                gameMessage = user + " : " + "Maximum 3 cards can be selected for swap - unselect" + (collect.size() - 3) + "cards";
                updateGameMessage(gameMessage);
                return;
            }

            // remove the clicked cards and replace them with new ones
            for (Card c : collect) {
                dealerHand.getCardList().remove(c);
                dealerHand.addRandomCard(deck);
            }
            Poker_Main.flowpane_Dealer_Hand_CardImages.getChildren().clear();

            for (int i = 0; i < handSize; i++) {
                Poker_Main.flowpane_Dealer_Hand_CardImages.getChildren().add(dealerHand.getCardList().get(i).getCardImage());
            }

            // for test purposes :
            System.out.println("Dealerhand - after swap : " + dealerHand.getCardList());

            // Update Poker Category :
            updatePokerCategory(dealerName, dealerHand);
            // Update Highest Card :
            updateHighestCard(dealerName, dealerHand);

        } else if (user.equals(playerName)) {

            // collect all cards that have been clicked
            List<Card> collect = playerHand.getCardList().stream().filter(card -> card.isClicked).collect(Collectors.toList());
            System.out.println("Player - cards clicked : " + collect);

            // jump out of method if more than 3 cards have been clicked
            if (collect.size() > 3) {
                gameMessage = user + " : " + "Maximum 3 cards can be selected for swap - unselect" + (collect.size() - 3) + "cards";
                return;
            }

            // remove the clicked cards and replace them with new ones
            for (Card c : collect) {
                playerHand.getCardList().remove(c);
                playerHand.addRandomCard(deck);
            }
            Poker_Main.flowpane_Player_Hand_CardImages.getChildren().clear();

            for (int i = 0; i < handSize; i++) {
                Poker_Main.flowpane_Player_Hand_CardImages.getChildren().add(playerHand.getCardList().get(i).getCardImage());
            }

            // for test purposes :
            System.out.println("Playerhand - after swap : " + playerHand.getCardList());

            // Update Poker Category :
            updatePokerCategory(playerName, playerHand);
            // Update Highest Card :
            updateHighestCard(playerName, playerHand);

        }

        // Steering variables :
        if (user.equals(dealerName)) {
            actionOwner = playerName;
            dealerIsDone = true;
        } else if (user.equals(playerName)) {
            actionOwner = dealerName;
            playerIsDone = true;
        }

        if (dealerIsDone && playerIsDone) {
            gamePhase = "Phase 3";
            actionMessage = "Raise your bet or Call or Fold";
        } else {
            gamePhase = "Phase 2";
            actionMessage = "Select cards for swap";
        }

        // Message
        gameMessage = gamePhase + " - " + actionOwner + " : " + actionMessage;
        updateGameMessage(gameMessage);

    }

    public void stand(String user) {

        // change Action Ownership :
        if (user.equals(dealerName)) {
            actionOwner = playerName;
        } else if (user.equals(playerName)) {
            actionOwner = dealerName;
        }

        // update Game Message :
        gameMessage = actionOwner + " - " + "Phase 3 : Raise bet / Call / Fold";
        updateGameMessage(gameMessage);

    }

    public void raiseBet(String user) {

        // check if input is numeric :
        if (user.equals(dealerName)) {
            if (isNumeric(Poker_Main.textfield_Dealer_PlaceBet_Amount.getText())) {
                dealerCurrentBet = Integer.parseInt(Poker_Main.textfield_Dealer_RaiseBet_Amount.getText());
            }
        } else if (user.equals(playerName)) {
            if (isNumeric(Poker_Main.textfield_Player_PlaceBet_Amount.getText())) {
                playerCurrentBet = Integer.parseInt(Poker_Main.textfield_Player_RaiseBet_Amount.getText());
            }
        }

        // check if sufficient Credits Balance :
        if (user.equals(dealerName)) {
            if (dealerCreditsBalance < dealerTotalBet + dealerCurrentBet) {
                gameMessage = user + " : " + "Not sufficient credits to make this bet";
                updateGameMessage(gameMessage);
                return;
            }
        } else if (user.equals(playerName)) {
            if (playerCreditsBalance < playerTotalBet + playerCurrentBet) {
                gameMessage = user + " : " + "Not sufficient credits to make this bet";
                updateGameMessage(gameMessage);
                return;
            }
        }

        // update Total Bet :
        if (user.equals(dealerName)) {
            updateTotalBet(dealerName, dealerCurrentBet);
        } else if (user.equals(playerName)) {
            updateTotalBet(playerName, playerCurrentBet);
        }

        // update Credits Balance :
        if (user.equals(dealerName)) {
            updateCreditsBalance(dealerName,-1*dealerCurrentBet);
        } else if (user.equals(playerName)) {
            updateCreditsBalance(playerName,-1*playerCurrentBet);
        }

        // update Pot Value :
        if (user.equals(dealerName)) {
            updatePotValue(dealerName, dealerCurrentBet);
        } else if (user.equals(playerName)) {
            updatePotValue(playerName, playerCurrentBet);
        }

        // clear Current Bet :
        if (user.equals(dealerName)) {
            dealerCurrentBet = 0;
            Poker_Main.textfield_Dealer_RaiseBet_Amount.setText(String.valueOf(dealerCurrentBet));
        } else if (user.equals(playerName)) {
            playerCurrentBet = 0;
            Poker_Main.textfield_Player_RaiseBet_Amount.setText(String.valueOf(playerCurrentBet));
        }

        // update Outstanding Bet :
        updateOutstandingBet();


        // change Action Ownership :
        if (user.equals(dealerName)) {
            actionOwner = playerName;
        } else if (user.equals(playerName)) {
            actionOwner = dealerName;
        }

        // update Game Message :
        if (dealerOutstandingBet > 0) {
            gameMessage = dealerName + " - " + "Phase 1 : Put additional bet";
        } else if (playerOutstandingBet > 0) {
            gameMessage = playerName + " - " + "Phase 1 : Put additional bet";
        } else {
            gameMessage = actionOwner + " - " + "Phase 2 : Swap cards";
        }
        updateGameMessage(gameMessage);

    }

    public void call(String user) {

        // update Total Bet :
        if (user.equals(dealerName)) {
            updateTotalBet(dealerName, dealerOutstandingBet);
        } else if (user.equals(playerName)) {
            updateTotalBet(playerName, playerOutstandingBet);
        }

        // determine Game Winner :
        gameWinner = determineGameWinner();
        // update Game Winner :
        updateGameWinner(gameWinner);
        updateGamesWon(gameWinner);

        // update CreditsBalance :
        if (gameWinner.equals(dealerName)) {
            updateCreditsBalance(dealerName, potValue);
        } else if (gameWinner.equals(playerName)) {
            updateCreditsBalance(playerName, potValue);
        }

        // update Games Won :
        if (gameWinner.equals(dealerName)) {
            updateGamesWon(dealerName);
        } else if (gameWinner.equals(playerName)) {
            updateGamesWon(playerName);
        }

        // update Game Message :
        gameMessage = "The winner is - " + gameWinner + " ; " + "Press New Game or Exit Play";
        updateGameMessage(gameMessage);

    }

    public void fold(String user) {

        // set Game Winner :
        if (user.equals(dealerName)) {
            gameWinner = playerName;
        } else if (user.equals(playerName)) {
            gameWinner = dealerName;
        }
        // update Game Winner :
        updateGameWinner(gameWinner);
        updateGamesWon(gameWinner);

        // update CreditsBalance :
        if (user.equals(dealerName)) {
            updateCreditsBalance(playerName, potValue);
        } else if (user.equals(playerName)) {
            updateCreditsBalance(dealerName, potValue);
        }

        // update Games Won :
        if (user.equals(dealerName)) {
            updateGamesWon(playerName);
        } else if (user.equals(playerName)) {
            updateGamesWon(dealerName);
        }

        // update Game Message :
        gameMessage = "The winner is - " + gameWinner + " ; " + "Press New Game or Exit Play";
        updateGameMessage(gameMessage);

    }

    public void exitPlay() {

        Platform.exit();
        System.exit(0);

    }
}
