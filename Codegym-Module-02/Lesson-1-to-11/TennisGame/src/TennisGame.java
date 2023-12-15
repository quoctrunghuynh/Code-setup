public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        String score = "";
        int tempScore = 0;
        if (m_score1 == m_score2) {
            score = getScore(m_score1);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = getWinCondition(m_score1, m_score2);
        } else {
            score = showScore(m_score1, m_score2, score);
        }
        return score;
    }

    private static String showScore(int m_score1, int m_score2, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = m_score1;
            else {
                score += "-";
                tempScore = m_score2;
            }
            switch (tempScore) {
                case 0 -> score += "Love";
                case 1 -> score += "Fifteen";
                case 2 -> score += "Thirty";
                case 3 -> score += "Forty";
            }
        }
        return score;
    }

    private static String getWinCondition(int m_score1, int m_score2) {
        String score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private static String getScore(int m_score1) {
        return switch (m_score1) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            case 3 -> "Forty-All";
            default -> "Deuce";
        };
    }
}

