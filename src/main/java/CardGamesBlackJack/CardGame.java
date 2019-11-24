package CardGamesBlackJack;

import java.util.ArrayList;
import java.util.Arrays;

public class CardGame {

    public static String[] getBlackJackWinners(String[] player1, String[] player2, String[] player3, String[] croupier, String... cards) {
        int[] scores = new int[] {countHand(croupier), countHand(player1), countHand(player2), countHand(player3)};
        boolean[] blackJack = new boolean[] {
                (croupier.length == 2 && scores[0] == 21),
                (player1.length == 2 && scores[1] == 21),
                (player2.length == 2 && scores[2] == 21),
                (player3.length == 2 && scores[3] == 21)
        };

        int croupierTakeCard = 0;
        if (scores[0] <= scores[1] && scores[0] <= scores[2] && scores[0] <= scores[3]) {

            ArrayList<String> croupierHand = new ArrayList<>(Arrays.asList(croupier));
            while ((scores[0] == 17 && isAceInHand(croupier)) || (scores[0] < 17) && cards.length > croupierTakeCard) {
                croupierHand.add(cards[croupierTakeCard]);
                croupier = croupierHand.toArray(new String[0]);
                scores[0] = countHand(croupier);
                croupierTakeCard++;
            }
        }

        ArrayList<String> winners = new ArrayList<>();

        for (int i=1; i<=3; i++){
            if (((scores[i] > scores[0] || scores[0] > 21) && scores[i] <= 21 ) ||
                    (blackJack[i] && !blackJack[0])) {
                winners.add("Player " + i);
            }
        }

        System.out.println((winners.toArray(new String[0]).length));
        return winners.toArray(new String[0]);
    }

    private static boolean isAceInHand(String... cards) {
        for (String card : cards) {
            if (card.equals("A")) {
                return true;
            }
        }
        return false;
    }

    private static int countHand(String... cards) {
        int score = 0;
        int countA = 0;
        for (String card : cards) {
            switch (card) {
                case "2":
                    score += 2;
                    break;
                case "3":
                    score += 3;
                    break;
                case "4":
                    score += 4;
                    break;
                case "5":
                    score += 5;
                    break;
                case "6":
                    score += 6;
                    break;
                case "7":
                    score += 7;
                    break;
                case "8":
                    score += 8;
                    break;
                case "9":
                    score += 9;
                    break;
                case "10":
                    score += 10;
                    break;
                case "J":
                    score += 10;
                    break;
                case "Q":
                    score += 10;
                    break;
                case "K":
                    score += 10;
                    break;
                case "A":
                    countA++;
                    break;
            }
        }

        if (countA > 0){
            if (countA > 1) {
                score += (countA - 1);
            }
            score += (score + 11 <= 21)? 11 : 1;
        }

        return score;
    }
}

class Launcher {
    public static void main(String[] args) {
//        System.out.println(CardGame.getBlackJackWinners(
//                new String[]{"J", "2", "K"},
//                new String[]{"A", "5", "A", "5", "7"},
//                new String[]{"J", "A"},
//                new String[]{"2", "Q"},
//                "4", "10", "Q", "K", "2", "8", "9", "8", "9", "4", "K", "7", "10", "A", "4", "9", "5", "A", "Q", "Q", "3"));
//
//        System.out.println(CardGame.getBlackJackWinners(
//                new String[]{"6", "A", "2", "Q", "3"},
//                new String[]{"5", "8"},
//                new String[]{"6", "Q", "2"},
//                new String[]{"3", "10"},
//                "A", "4", "10", "5", "4", "A", "Q", "2", "6", "A", "5", "7", "9", "Q", "2", "8", "9", "A", "K", "2", "8"));
//
//        System.out.println(CardGame.getBlackJackWinners(
//                new String[]{"6", "A", "2", "Q", "3"},
//                new String[]{"10", "10"},
//                new String[]{"10", "Q", "10"},
//                new String[]{"10"},
//                "4", "3", "5", "4", "A", "Q", "2", "6", "A", "5", "7", "9", "Q", "2", "8", "9", "A", "K", "2", "8"));


        System.out.println(Arrays.toString(CardGame.getBlackJackWinners(
                new String[]{"J", "7"},    //17
                new String[]{"J", "8"},    //18
                new String[]{"J", "9"},    //19
                new String[]{"A", "6"},    //17 -> 20
                "3", "6", "A", "8", "9", "A", "3", "Q", "5", "2", "3", "8", "6", "J", "K", "2", "8", "7", "7", "K", "Q")));

    }
}