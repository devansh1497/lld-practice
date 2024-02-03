package hackathonphonepe.model;

public class Submission {
    private String problemId;
    private String userId;
    private Status status;

    public Submission(String problemId, String userId, Status status) {
        this.problemId = problemId;
        this.userId = userId;
        this.status = status;
    }

    public String getProblemId() {
        return problemId;
    }

    public String getUserId() {
        return userId;
    }

    public Status getStatus() {
        return status;
    }
}
