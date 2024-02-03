package hackathonphonepe.service;

import hackathonphonepe.datastore.InMemoryDatastore;
import hackathonphonepe.model.Problem;
import hackathonphonepe.model.Status;
import hackathonphonepe.model.Submission;
import hackathonphonepe.model.User;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

public class SubmissionService {

    private final InMemoryDatastore datastore;
    private final LeaderboardService leaderboardService;

    public SubmissionService(InMemoryDatastore datastore, LeaderboardService leaderboardService) {
        this.datastore = datastore;

        this.leaderboardService = leaderboardService;
    }


    public void submit(User user, Problem problem) {
        if(user.getProblemsSolved().contains(problem.getId())) return;
        Status status = getRandomStatus();
        Submission submission = new Submission(problem.getId(), user.getUserName(), status);
        datastore.addSubmission(submission);
        if(status != Status.ACCEPTED) return;
        LocalDateTime elapsedTime = datastore.getUserToProblemToTime().get(user.getUserName()).get(problem.getId());
        problem.getSolvedBy().add(user.getUserName());
        problem.setAverageTime(problem.getSolvedBy().size()*problem.getAverageTime()+elapsedTime.toEpochSecond(ZoneOffset.UTC)/((problem.getSolvedBy().size()+1)));
        user.solve(problem.getId());
        double score = problem.getScoringStrategy().score(problem, null);
        user.setScore(user.getScore()+score);
        leaderboardService.update(user);
    }

    private static Status getRandomStatus() {
        return (new Random()).nextInt(100) % 2 == 0 ? Status.ACCEPTED : Status.REJECTED;
    }
}
