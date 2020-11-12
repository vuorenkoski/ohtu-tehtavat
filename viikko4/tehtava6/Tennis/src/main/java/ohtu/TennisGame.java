package ohtu;

public class TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private static String[] points = {"Love","Fifteen","Thirty","Forty"};

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1>=4 || m_score2>=4)
            return endgame(m_score1-m_score2);
        if (m_score1==m_score2)
            return points[m_score1]+"-All";
        return points[m_score1]+"-"+points[m_score2];
    }
    
    private String endgame(int diff) {
        if (diff==0)
            return "Deuce";
        String player = player1Name;
        if (diff<0)
            player = player2Name;
        if (Math.abs(m_score1 - m_score2)>1)
            return "Win for "+player;
        return "Advantage "+player;
    }
}