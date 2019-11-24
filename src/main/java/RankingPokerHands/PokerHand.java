package RankingPokerHands;

import java.util.*;

class PokerHand {

    public enum Result {TIE, WIN, LOSS}

    /**
     * int @highestPokerHand
     * is one of combination:
     * 1 - High card, 2 - Pair, 3 - Two pairs, 4 - Three of a kind, 5 - Straight,
     * 6 - Flush, 7 - Full house, 8 - Four of a kind, 9 - Straight flush, 10 - Royal flush;
     */
    private int highestHandCombination;

    private int handWeight;

    PokerHand(String hand) {
        int result[] = calculateResult(hand.split(" ", 5));
        highestHandCombination = result[0];
        handWeight = result[1];
    }


    Result compareWith(PokerHand hand) {
        if (this.highestHandCombination == hand.highestHandCombination) {
            return (this.handWeight > hand.handWeight) ? Result.WIN :
                    (this.handWeight < hand.handWeight) ? Result.LOSS : Result.TIE;
        }

        return this.highestHandCombination > hand.highestHandCombination ? Result.WIN : Result.LOSS;
    }


    private int[] calculateResult(String[] hand) {
        int result[] = new int[2];

        TreeMap<Integer, Integer> valuesMap = new TreeMap<>();
        Map<Character, Integer> suitsMap = new HashMap<>();

        for (String card : hand) {
            int cardIndex = cardsValueStringToIntConverter(card);

            if (valuesMap.computeIfPresent(cardIndex, (key, value) -> value + 1) == null) {
                valuesMap.put(cardIndex, 1);
            }

            if (suitsMap.computeIfPresent(card.charAt(1), (key, value) -> value + 1) == null) {
                suitsMap.put(card.charAt(1), 1);
            }
        }

        result[1] = calculateHandWeight(valuesMap);
        result[0] = computeCombination(valuesMap,suitsMap);

        return result;
    }


    private int computeCombination(TreeMap<Integer, Integer> valuesMap , Map<Character, Integer> suitsMap){
        boolean straight = isStraight(valuesMap);
        boolean flush = suitsMap.containsValue(5);
        boolean aceIsPresented = valuesMap.containsValue(14);


        if (flush) {
            if (straight) {
                if (aceIsPresented) {
                    return 10;
                } else {
                    return 9;
                }
            } else {
                return 6;
            }
        }

        if (straight) {
            return 5;
        }

        boolean fourOfAKind = valuesMap.containsValue(4);

        if (fourOfAKind) {
            return 8;
        }

        boolean ThreeOfAKind = valuesMap.containsValue(3);
        boolean fullHouse = ThreeOfAKind && valuesMap.containsValue(2);

        if (fullHouse) {
            return 7;
        }

        if (ThreeOfAKind) {
            return 4;
        }

        return pairs(valuesMap) + 1;
    }


    private int calculateHandWeight(TreeMap<Integer, Integer> valuesMap) {
        int[] hand = new int[5];

        int i = 0;
        for (int key : valuesMap.keySet()){
            hand[i] = valuesMap.get(key) * 100 + key;
            i++;
        }

        Arrays.sort(hand);

        int sum = 0;
        int coefficient = 1;

        for (i = 0; i < 5; ++i){
            sum += hand[i] % 100 * coefficient;
            coefficient *= 10;
        }
        return sum;
    }


    private boolean isStraight(TreeMap<Integer, Integer> valuesMap) {
        if (valuesMap.size() < 5) {
            return false;
        }

        int prev = 0;
        for (int key : valuesMap.keySet()) {
            if (prev == 0) {
                prev = key;
            } else {
                if (key - prev > 1) {
                    return false;
                }
                prev = key;
            }
        }

        return true;
    }


    private int pairs(TreeMap<Integer, Integer> valuesMap) {
        int pairs = 0;
        for (int key : valuesMap.keySet()){
            if (valuesMap.get(key) == 2){
                pairs++;
            }
        }
        return pairs;
    }


    private int cardsValueStringToIntConverter(String card) {
        switch (card.substring(0, 1)) {
            case "T":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(card.substring(0, 1));
        }
    }
}