package com.codegym;

public class TennisGame {

    public static final int FIRTS_SCORE = 1;
    public static final int SECOND_SCORE = 2;
    public static final int THIRD_SCORE = 3;
    public static final int FOUR_SCORE = 4;

    public static String getScore(int player1score, int player2score) {
        String score = "";
        if (player1score==player2score)
        {
            score = getDrawScore(player1score);
        }
        else if (player1score>= FOUR_SCORE || player2score>=FOUR_SCORE)
        {
            int minusResult = getMinusResult(player1score, player2score);
            if (minusResult== FIRTS_SCORE) score ="Advantage player1";
            else if (minusResult ==-FIRTS_SCORE) score ="Advantage player2";
            else if (minusResult>= SECOND_SCORE) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i = FIRTS_SCORE; i< THIRD_SCORE; i++)
            {
                score = getScore1(player1score, player2score, i, score);
            }
        }
        return score;
    }

    private static String getDrawScore(int player1score) {
        String score;
        switch (player1score)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    private static String getScore1(int player1score, int player2score, int i, String score) {
        int tempScore;
        if (i ==FIRTS_SCORE) tempScore = player1score;
        else { score +="-"; tempScore = player2score;}
        switch(tempScore)
        {
            case 0:
                score +="Love";
                break;
            case 1:
                score +="Fifteen";
                break;
            case 2:
                score +="Thirty";
                break;
            case 3:
                score +="Forty";
                break;
        }
        return score;

    }

    private static int getMinusResult(int player1score, int player2score) {
        return player1score - player2score;
    }
}