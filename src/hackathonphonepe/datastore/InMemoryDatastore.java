package hackathonphonepe.datastore;

import hackathonphonepe.model.Problem;
import hackathonphonepe.model.Submission;
import hackathonphonepe.model.User;
import notification.model.LeaderBoardRow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class InMemoryDatastore{

    List<User> users = new ArrayList<>();
    java.util.List<Problem> problems = new ArrayList<>();
    TreeSet<User> leaderboard = new TreeSet<>((a, b) -> (int)(b.getScore() - a.getScore()));
    List<Submission> submissions = new ArrayList<>();
    Map<String, Map<String, LocalDateTime>> userToProblemToTime = new HashMap<>();

    public void addUser(User user) {
        users.add(user);
        userToProblemToTime.put(user.getUserName(), new HashMap<>());
    }

    public void addProblem(Problem problem) {
        problems.add(problem);
    }

    public void addSubmission(Submission submission) {
        submissions.add(submission);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public TreeSet<User> getLeaderboard() {
        return leaderboard;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public Map<String, Map<String, LocalDateTime>> getUserToProblemToTime() {
        return userToProblemToTime;
    }
}
