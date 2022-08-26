package refactoring;

public class TennisGame {

    public static final String LOVE_ALL = "Love-All";
    public static final String FIFTEEN_ALL = "Fifteen-All";
    public static final String THIRTY_ALL = "Thirty-All";
    public static final String FORTY_ALL = "Forty-All";
    public static final String DEUCE = "Deuce";
    public static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER_2 = "Advantage player2";
    public static final String WIN_FOR_PLAYER_1 = "Win for player1";
    public static final String WIN_FOR_PLAYER_2 = "Win for player2";

    public static String deuce(int score) {
        switch (score) {
            case 0:
                return LOVE_ALL;
            case 1:
                return FIFTEEN_ALL;
            case 2:
                return THIRTY_ALL;

            case 3:
                return FORTY_ALL;
            default:
                return DEUCE;
        }
    }

    public static String advantage(int score) {
        switch (score) {
            case 1:
                return ADVANTAGE_PLAYER_1;
            case -1:
                return ADVANTAGE_PLAYER_2;
            default:
                return score >= 2 ? WIN_FOR_PLAYER_1 : WIN_FOR_PLAYER_2;
        }
    }

    public static String zeroToThree(int tempScore) {
        switch (tempScore) {
            case 0:
                return  "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }

    public static String getScore(int scorePlayer1, int scorePlayer2) {
        String score = "";
        int tempScore = 0;
        if (scorePlayer1 == scorePlayer2) {
            return deuce(scorePlayer1);
        }
        if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            int minusResult = scorePlayer1 - scorePlayer2;
            return advantage(minusResult);

        }
        return zeroToThree(scorePlayer1) + "-" + zeroToThree(scorePlayer2);
    }
}
