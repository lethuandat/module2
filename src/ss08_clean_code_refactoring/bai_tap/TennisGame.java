package ss08_clean_code_refactoring.bai_tap;

public class TennisGame {

    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String DEUCE = "Deuce";
    public static final String ALL = "-All";

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        boolean isDeuce = player1Score == player2Score;
        boolean isFinish = player1Score >= 4 || player2Score >= 4;
        String scorePlayer = "";
        if (isDeuce) {
            scorePlayer += getDeuceScore(player1Score);
        } else if (isFinish) {
            scorePlayer += getFinishScore(player1Score, player2Score);
        } else {
            scorePlayer += setScore(player1Score, player2Score);
        }
        return scorePlayer;
    }

    public static String getDeuceScore(int deuceScore) {
        switch (deuceScore) {
            case 0:
                return LOVE + ALL;
            case 1:
                return FIFTEEN + ALL;
            case 2:
                return THIRTY + ALL;
            case 3:
                return FORTY + ALL;
            default:
                return DEUCE;
        }
    }

    public static String getFinishScore(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    public static String setScore(int player1Score, int player2Score) {
        int tempScore = 0;
        String s = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Score;
            } else {
                s += "-";
                tempScore = player2Score;
            }

            switch (tempScore) {
                case 0:
                    s += LOVE;
                    break;
                case 1:
                    s += FIFTEEN;
                    break;
                case 2:
                    s += THIRTY;
                    break;
                case 3:
                    s += FORTY;
                    break;
            }
        }
        return s;
    }
}