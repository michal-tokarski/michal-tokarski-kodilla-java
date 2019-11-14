package com.kodilla.poker;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import static javafx.scene.paint.Color.DARKSEAGREEN;

public class Card {

    Rank rank;
    Suit suit;
    boolean isClicked;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static String getFilename(Suit suit, Rank rank) {
        StringBuilder filePath = new StringBuilder();
        //filePath.append(Poker_Main.IMG_PATH + "/cards/");
        filePath.append("/cards/");
        filePath.append(rank.getRankText() + "_of_");

        filePath.append(suit.getSuitText());

        // replace Jack to King with more graphical cards
        if (rank.getRankValue() > 10 && rank.getRankValue() < 14) {
            filePath.append("2");
        }

        filePath.append(".png");
        return filePath.toString();
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " OF " + suit;
    }


    ImageView getCardImage() {
        ImageView img = new ImageView(getFilename(getSuit(), getRank()));
        img.setPreserveRatio(true);
        img.setSmooth(true);
        img.setFitHeight(220.0);

        Color cardBorderColor = DARKSEAGREEN;

        img.setOnMouseClicked(e -> {
            isClicked = !isClicked;
            if (isClicked) {
                img.setStyle(" -fx-border-color: #CD5C5C ; -fx-border-width: 5px ; -fx-border-style: solid inside");
                img.setOpacity(0.4f);
            } else {
                img.setOpacity(1.0f);
            }
        });

        return img;
    }
}

enum Suit {

    CLUBS("clubs", 1),
    DIAMONDS("diamonds",2),
    HEARTS("hearts", 3),
    SPADES("spades", 4);

    private String suitText;
    private int suitValue;

    Suit(String suitText, int suitValue) {
        this.suitText = suitText;
        this.suitValue = suitValue;
    }

    public String getSuitText() {
        return suitText;
    }

    public int getSuitValue() {
        return suitValue;
    }
}

enum Rank {

    // * Manually eliminated some cards to make the game more interactive
    //TWO("2", 2),
    //THREE("3", 3),
    //FOUR("4", 4),
    //FIVE("5", 5),
    //SIX("6", 6),
    //SEVEN("7", 7),
    //EIGHT("8", 8),

    NINE("9", 9),
    TEN("10", 10),
    JACK("jack", 11),
    QUEEN("queen", 12),
    KING("king", 13),
    ACE("ace", 14);

    String rankText;
    int rankValue;

    Rank(String rankText, int rankValue) {
        this.rankText = rankText;
        this.rankValue = rankValue;
    }

    public String getRankText() {
        return rankText;
    }

    public int getRankValue() {
        return rankValue;
    }


}
