package CardGamesBlackJack;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class BlackJackExampleTest {
    @Test
    public void exampleTest1() {
        assertArrayEquals(new String[]{"Player 1"},
                CardGame.getBlackJackWinners(
                        new String[]{"J", "A"},
                        new String[]{"8", "J", "7"},
                        new String[]{"2", "4", "K", "10"},
                        new String[]{"K", "8"},
                        "10", "6", "A", "8", "9", "A", "3", "Q", "5", "2", "3", "8", "6", "J", "K", "2", "8", "7", "7", "K", "Q"));
    }

    @Test
    public void exampleTest2() {
        assertArrayEquals(new String[]{"Player 2", "Player 3"},
                CardGame.getBlackJackWinners(
                        new String[]{"J", "2", "K"},
                        new String[]{"A", "5", "A", "5", "7"},
                        new String[]{"J", "A"},
                        new String[]{"2", "Q"},
                        "4", "10", "Q", "K", "2", "8", "9", "8", "9", "4", "K", "7", "10", "A", "4", "9", "5", "A", "Q", "Q", "3"));
    }

    @Test
    public void exampleTest3() {
        assertArrayEquals(new String[]{},
                CardGame.getBlackJackWinners(
                        new String[]{"6", "A", "2", "Q", "3"},
                        new String[]{"5", "8"},
                        new String[]{"6", "Q", "2"},
                        new String[]{"3", "10"},
                        "A", "4", "10", "5", "4", "A", "Q", "2", "6", "A", "5", "7", "9", "Q", "2", "8", "9", "A", "K", "2", "8"));
    }

    @Test
    public void exampleTest4() {
        assertArrayEquals(new String[]{"Player 2", "Player 3"},
                CardGame.getBlackJackWinners(
                        new String[]{"6", "A"},
                        new String[]{"10", "8"},
                        new String[]{"2", "7", "Q", "2"},
                        new String[]{"10"},
                        "3", "4", "10", "5", "4", "A", "Q", "2", "6", "A", "5", "7", "9", "Q", "2", "8", "9", "A", "K", "2", "8"));
    }

    @Test
    public void exampleTest11() {
        assertArrayEquals(new String[]{"Player 2", "Player 3"},
                CardGame.getBlackJackWinners(
                        new String[]{"A", "A", "A", "K"},   //13
                        new String[]{"A", "A", "K", "9"},   //21
                        new String[]{"A", "K", "8", "2"},   //21
                        new String[]{"A", "A", "A", "A"})); //14
    }

    @Test
    public void exampleTest12() {
        assertArrayEquals(new String[]{},
                CardGame.getBlackJackWinners(
                        new String[]{"Q", "K"},         //20
                        new String[]{"J", "10"},        //20
                        new String[]{"J", "9", "10"},   //29
                        new String[]{"J", "Q"}));       //20
    }

    @Test
    public void exampleTest13() {
        assertArrayEquals(new String[]{},
                CardGame.getBlackJackWinners(
                        new String[]{"A", "10"},        //21
                        new String[]{"A", "Q"},         //21
                        new String[]{"A", "K"},         //21
                        new String[]{"A", "10"}));      //21
    }

    @Test
    public void exampleTest14() {
        assertArrayEquals(new String[]{"Player 1"},
                CardGame.getBlackJackWinners(
                        new String[]{"A", "10"},        //21
                        new String[]{"A", "10", "J"},   //21
                        new String[]{"9", "2", "10"},   //21
                        new String[]{"J", "A", "10"})); //21
    }

    @Test
    public void exampleTest15() {
        assertArrayEquals(new String[]{},
                CardGame.getBlackJackWinners(
                        new String[]{"J", "J", "Q"},   //30
                        new String[]{"Q", "K", "J"},   //30
                        new String[]{"10", "9", "8"},  //27
                        new String[]{"10", "5"}));     //15
    }

    @Test
    public void exampleTest16() {
        assertArrayEquals(new String[]{"Player 1"},
                CardGame.getBlackJackWinners(
                        new String[]{"10", "8"},       //18
                        new String[]{"J", "6"},        //16
                        new String[]{"J", "7"},        //17
                        new String[]{"10", "7"}));     //17
    }

    @Test
    public void exampleTest21() {
        assertArrayEquals(new String[]{},
                CardGame.getBlackJackWinners(
                        new String[]{"J", "7"},    //17
                        new String[]{"J", "8"},    //18
                        new String[]{"J", "9"},    //19
                        new String[]{"A", "6"},    //17 -> 20
                        "3", "6", "A", "8", "9", "A", "3", "Q", "5", "2", "3", "8", "6", "J", "K", "2", "8", "7", "7", "K", "Q"));
    }

    @Test
    public void exampleTest22() {
        assertArrayEquals(new String[]{"Player 2", "Player 3"},
                CardGame.getBlackJackWinners(
                        new String[]{"J", "7"},    //17
                        new String[]{"J", "8"},    //18
                        new String[]{"J", "9"},    //19
                        new String[]{"10", "7"},    //17
                        "6", "6", "A", "8", "9", "A", "3", "Q", "5", "2", "3", "8", "6", "J", "K", "2", "8", "7", "7", "K", "Q"));
    }


    @Test
    public void exampleTest23() {
        assertArrayEquals(new String[]{},
                CardGame.getBlackJackWinners(
                        new String[]{"J", "5"},    //15
                        new String[]{"9", "6"},    //15
                        new String[]{"J", "4"},    //14
                        new String[]{"10", "6"},    //16
                        "6", "6", "A", "8", "9", "A", "3", "Q", "5", "2", "3", "8", "6", "J", "K", "2", "8", "7", "7", "K", "Q"));
    }
}