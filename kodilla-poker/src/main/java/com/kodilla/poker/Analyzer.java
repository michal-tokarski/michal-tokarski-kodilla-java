package com.kodilla.poker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Analyzer {

    private List<Rank> rankList;
    private List<Suit> suitList;

    enum PokerCategory {

    /*
    Poker categories from highest to lowest :
    1. High card (nothing) // rower
    2. One pair // para
    3. Two pairs // dwie pary
    4. Three of a kind // trojka
    5. Straight // strit
    6. Flush // kolor
    7. Full house (three + pair) // max
    8. Four of a kind // kareta
    9. Straight flush // maly poker
    10. Royal flush // duzy poker
     */

        HIGH_CARD("High Card", 1, "Rower"),
        ONE_PAIR("One Pair", 2, "Para"),
        TWO_PAIRS("Two Pairs", 3, "Dwie pary"),
        THREE_OF_A_KIND("Three of a Kind", 4, "Trojka"),
        STRAIGHT("Straight", 5, "Strit"),
        FLUSH("Flush", 6, "Kolor"),
        FULL_HOUSE("Full House", 7, "Max"),
        FOUR_OF_A_KIND("Four of a Kind", 8, "Kareta"),
        STRAIGHT_FLUSH("Straight Flush", 9, "Maly poker"),
        ROYAL_FLUSH("Royal Flush", 10, "Duzy poker");

        String catName;
        String catName2;
        int catValue;

        PokerCategory (String catName, int catValue, String catName2) {
            this.catName = catName;
            this.catName2 = catName2;
            this.catValue = catValue;
        }

    }


    public int[] produceRankList(Hand argHand) {

        int rankList[] = new int[argHand.getCardList().size()];
        int i = 0;
        for (Card c : argHand.getCardList()) {
            rankList[i] = c.getRank().getRankValue();
            i++;
        }
        return rankList;
    }


    public int getMaxRank(Hand argHand) {

        int[] rankList = produceRankList(argHand);
        int maxRank = rankList[0];

        for (int i = 0; i < rankList.length; i++)
            if (rankList[i] > maxRank)
                maxRank = rankList[i];

        return maxRank;
    }


    public int calculateLongestRankSequence(Hand argHand) {

        int[] rankList = produceRankList(argHand);

        final HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int r : rankList) {
            hashSet.add(r);
        }

        int longestRankSequence = 0;
        for (int r : rankList) {
            int length = 1;
            for (int j = r - 1; hashSet.contains(j); --j) {
                hashSet.remove(j);
                ++length;
            }
            for (int j = r + 1; hashSet.contains(j); ++j) {
                hashSet.remove(j);
                ++length;
            }
            longestRankSequence = Math.max(longestRankSequence, length);
        }
        return longestRankSequence;
    }


    public int countUniqueRanks(Hand argHand) {

        int[] rankList = produceRankList(argHand);

        Arrays.sort(rankList);
        int uniqueRanks = 1;
        for (int i = 0; i < rankList.length - 1; i++) {
            if (rankList[i] != rankList[i + 1]) {
                uniqueRanks++;
            }
        }
        return uniqueRanks;
    }


    public int[] produceUniqueRankList(Hand argHand) {

        int[] rankList = produceRankList(argHand);

        Arrays.sort(rankList);
        int[] uniqueRankList = IntStream.of(rankList).distinct().toArray();
        return uniqueRankList;
    }


    public int[] produceSuitList(Hand argHand) {

        int suitList[] = new int[argHand.getCardList().size()];
        int i = 0;
        for (Card c : argHand.getCardList()) {
            suitList[i] = c.getSuit().getSuitValue();
            i++;
        }
        return suitList;
    }


    public int countUniqueSuits(Hand argHand) {

        int[] suitList = produceSuitList(argHand);

        Arrays.sort(suitList);
        int uniqueSuits = 1;
        for (int i = 0; i < suitList.length - 1; i++) {
            if (suitList[i] != suitList[i + 1]) {
                uniqueSuits = uniqueSuits + 1;
            }
        }
        return uniqueSuits;
    }


    public int[] produceUniqueSuitList(Hand argHand) {

        int[] suitList = produceSuitList(argHand);

        Arrays.sort(suitList);
        int[] uniqueSuitList = IntStream.of(suitList).distinct().toArray();
        return uniqueSuitList;
    }


    public int[] produceRankOccurenceList(Hand argHand) {

        int[] rankList = produceRankList(argHand);
        int[] uniqueRankList = produceUniqueRankList(argHand);

        int[] rankOccurenceList = new int[uniqueRankList.length];

        for (int a = 0; a < uniqueRankList.length ; a++) {
            rankOccurenceList[a] = 0;
            for (int b = 0; b < rankList.length ; b++) {
                if (uniqueRankList[a] == rankList[b]) {
                    rankOccurenceList[a] = rankOccurenceList[a]+1;
                }
            }
        }
        return rankOccurenceList;
    }


    public int countRankOccurences(Hand argHand, int argRankOccurence) {

        int rankOccurences;
        int[] rankOccurencesList = produceRankOccurenceList(argHand);

        rankOccurences = 0;
        for (int i = 0; i < rankOccurencesList.length ; i++) {
            if (rankOccurencesList[i] == argRankOccurence) {
                rankOccurences++;
            }
        }
        return rankOccurences;
    }


    public PokerCategory determinePokerCategory(Hand argHand) {

        PokerCategory pokerCategory = null;

        // Royal flush
        if
            (calculateLongestRankSequence(argHand) == 5
            && countUniqueSuits(argHand) == 1
            && getMaxRank(argHand) == 14) {

                pokerCategory = PokerCategory.ROYAL_FLUSH;

        // Straight flush
        } else if
            (calculateLongestRankSequence(argHand) == 5
            && countUniqueSuits(argHand) == 1
            && getMaxRank(argHand) < 14) {

                pokerCategory = PokerCategory.STRAIGHT_FLUSH;

        // Four of a Kind
        } else if
            (countRankOccurences(argHand, 4) == 1) {

                pokerCategory = PokerCategory.FOUR_OF_A_KIND;

        // Full House
        } else if
            (countRankOccurences(argHand, 3) == 1
            && countRankOccurences(argHand, 2) == 1) {

                pokerCategory = PokerCategory.FULL_HOUSE;

        // Flush
        } else if
            (calculateLongestRankSequence(argHand) <= 4
            && countUniqueSuits(argHand) == 1) {

                pokerCategory = PokerCategory.FLUSH;

        // Straight
        } else if
            (calculateLongestRankSequence(argHand) == 5
            && countUniqueSuits(argHand) >= 2) {

                pokerCategory = PokerCategory.STRAIGHT;

        // Three of a Kind
        } else if
            (countRankOccurences(argHand, 3) == 1
            && countRankOccurences(argHand, 2) == 0) {

                pokerCategory = PokerCategory.THREE_OF_A_KIND;

        // Two Pairs
        } else if
            (countRankOccurences(argHand, 2) == 2) {

                pokerCategory = PokerCategory.TWO_PAIRS;

        // One Pair
        } else if
            (countRankOccurences(argHand, 2) == 1
            && countUniqueRanks(argHand) == 4) {

                pokerCategory = PokerCategory.ONE_PAIR;

        // High-Card aka Nothing
        } else if
            (countUniqueRanks(argHand) == 5) {

                pokerCategory = PokerCategory.HIGH_CARD;
        }

        return pokerCategory;
    }
}


