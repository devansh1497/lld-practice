package hackathonphonepe.model;

import java.util.List;

public class ProblemSearchResult {

    private String problemId;
    private List<String> users;
    private double averageTimeTaken;

    public ProblemSearchResult(String problemId, List<String> users, double averageTimeTaken) {
        this.problemId = problemId;
        this.users = users;
        this.averageTimeTaken = averageTimeTaken;
    }

    @Override
    public String toString() {
        return "ProblemSearchResult{" +
                "problemId='" + problemId + '\'' +
                ", users=" + users +
                ", averageTimeTaken=" + averageTimeTaken +
                '}';
    }
}
