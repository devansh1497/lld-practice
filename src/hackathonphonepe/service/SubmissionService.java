package hackathonphonepe.service;

import hackathonphonepe.datastore.InMemoryDatastore;
import hackathonphonepe.model.Problem;
import hackathonphonepe.model.Status;
import hackathonphonepe.model.Submission;
import hackathonphonepe.model.User;

import java.util.Random;

public class SubmissionService {

    private final InMemoryDatastore datastore;
    private final LeaderboardService leaderboardService;
    private final ProblemService problemService;
    private final UserService userService;

    public SubmissionService(InMemoryDatastore datastore, LeaderboardService leaderboardService, ProblemService problemService, UserService userService) {
        this.datastore = datastore;
        this.leaderboardService = leaderboardService;
        this.problemService = problemService;
        this.userService = userService;
    }


    public void submit(User user, Problem problem) {
        if(user.getProblemsSolved().contains(problem.getId())) return;
        Status status = getRandomStatus();
        Submission submission = new Submission(problem.getId(), user.getUserName(), status);
        datastore.addSubmission(submission);
        if(status != Status.ACCEPTED) return;
        problemService.updateProblemStats(problem, user);
        userService.updateUserStats(user, problem);
        leaderboardService.update(user);
    }

    private static Status getRandomStatus() {
        return (new Random()).nextInt(100) % 2 == 0 ? Status.ACCEPTED : Status.REJECTED;
    }
}
