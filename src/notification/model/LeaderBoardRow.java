package notification.model;

public class LeaderBoardRow {

    private final String user;
    private int problemsSolved;
    private int score;


    public LeaderBoardRow(String user) {
        this.user = user;
    }

    public void updateScore(int score) {
        this.score = score;
    }

    public void incrementProblemsSolved() {
        this.problemsSolved++;
    }

    public String getUser() {
        return user;
    }

    public int getProblemsSolved() {
        return problemsSolved;
    }

    public int getScore() {
        return score;
    }
}
