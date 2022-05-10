package ss08_clean_code_refactoring.bai_tap;

public class TennisGame {
    public static final String ZERO = "Love";
    public static final String ONE = "Fifteen";
    public static final String TWO = "Thirty";
    public static final String THREE = "Forty";
    public static final String ALL = "-All";
    public static final String DEUCE = "Deuce";
    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        boolean isDeuce = player1Score == player2Score;
        boolean isFinish = player1Score >= 4 || player2Score >= 4;

        if (isDeuce) {
            getDeuceGame(player1Score);
        } else if (isFinish) {
            getFinishGame(player1Score, player2Score);
        }

        return player1Name + ": " + getPlayerScore(player1Score) + " - " + player2Name + ": " + getPlayerScore(player2Score);
    }

    private static String getDeuceGame(int deuceScore) {
        switch (deuceScore) {
            case 0:
                return ZERO + ALL;
            case 1:
                return ONE + ALL;
            case 2:
                return TWO + ALL;
            case 3:
                return THREE + ALL;
            default:
                return DEUCE;
        }
    }

    private static String getFinishGame(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;

        if (minusResult == 1) {
            return "Advantage player1";
        }
        if (minusResult == -1) {
            return "Advantage player2";
        }
        if (minusResult >= 2) {
            return "Win for player1";
        }
        return "Win for player2";
    }

    private static String getPlayerScore(int playerScore) {
        switch (playerScore) {
            case 0:
                return ZERO;
            case 1:
                return ONE;
            case 2:
                return TWO;
            default:
                return THREE;
        }
    }
}
