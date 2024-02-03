/*
https://leetcode.com/discuss/interview-question/4623818/PhonePe-or-Machine-Coding-or-Hackathon
 */

package hackathonphonepe;

import hackathonphonepe.datastore.InMemoryDatastore;
import hackathonphonepe.model.Difficulty;
import hackathonphonepe.model.Problem;
import hackathonphonepe.model.User;
import hackathonphonepe.service.DefaultScoringStrategy;
import hackathonphonepe.service.LeaderboardService;
import hackathonphonepe.service.ProblemService;
import hackathonphonepe.service.ScoringStrategy;
import hackathonphonepe.service.SubmissionService;
import hackathonphonepe.service.UserService;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ScoringStrategy scoringStrategy = new DefaultScoringStrategy();

        InMemoryDatastore inMemoryDatastore = new InMemoryDatastore();
        ProblemService problemService = new ProblemService(inMemoryDatastore);
        Problem p1 = problemService.addProblem("1", "problem 1", Difficulty.HARD, 10, new HashSet<>(),
                scoringStrategy);
        Problem p2 = problemService.addProblem("2", "problem 2", Difficulty.EASY, 10, new HashSet<>(),
                scoringStrategy);

        UserService userService = new UserService(inMemoryDatastore);
        User u1 = userService.registerUser("user1", "CSE");
        User u2 = userService.registerUser("user2", "IT");

        problemService.openProblem("user1", "1");
        Thread.sleep(2);
        problemService.openProblem("user2", "2");
        LeaderboardService leaderboardService = new LeaderboardService(inMemoryDatastore);
        SubmissionService submissionService = new SubmissionService(inMemoryDatastore, leaderboardService, problemService, userService);
        submissionService.submit(u1, p1);
        submissionService.submit(u2, p2);

        System.out.println("Problem1 details: "+ problemService.getProblemResult(p1.getId()));
        System.out.println("Problem 2 details: "+problemService.getProblemResult(p2.getId()));

        System.out.println("Top user: " + leaderboardService.topUser());
    }
}
