package hackathonphonepe.service;

import hackathonphonepe.datastore.InMemoryDatastore;
import hackathonphonepe.model.Difficulty;
import hackathonphonepe.model.Problem;
import hackathonphonepe.model.ProblemSearchResult;
import hackathonphonepe.model.User;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Set;
import java.util.stream.Collectors;

public class ProblemService {

    private final InMemoryDatastore dataStore;

    public ProblemService(InMemoryDatastore dataStore) {
        this.dataStore = dataStore;
    }

    public Problem addProblem(String id, String content, Difficulty diff, int score, Set<String> tags,
                              ScoringStrategy scoringStrategy) {
        Problem problem = new Problem(id, content, diff, score, tags, scoringStrategy);
        dataStore.addProblem(problem);
        System.out.println("Added problem: " + problem);
        return problem;
    }

    public Problem openProblem(String userId, String problemId) {
        if (dataStore.getUserToProblemToTime().get(userId).get(problemId) == null) {
            dataStore.getUserToProblemToTime().get(userId).put(problemId, LocalDateTime.now());
        }
        return dataStore.getProblems().stream().filter(p -> p.getId().equals(problemId)).collect(Collectors.toList()).get(0);
    }

    public ProblemSearchResult getProblemResult(String problemId) {
        Problem problem =
                dataStore.getProblems().stream().filter(p -> p.getId().equals(problemId)).collect(Collectors.toList()).get(0);
        return new ProblemSearchResult(problemId, problem.getSolvedBy().stream().distinct().collect(Collectors.toList()), problem.getAverageTime());
    }

    public void updateProblemStats(Problem problem, User user) {
        problem.getSolvedBy().add(user.getUserName());
        LocalDateTime elapsedTime = dataStore.getUserToProblemToTime().get(user.getUserName()).get(problem.getId());
        problem.setAverageTime(problem.getSolvedBy().size() * problem.getAverageTime() + elapsedTime.toEpochSecond(ZoneOffset.UTC) / ((problem.getSolvedBy().size() + 1)));
    }
}
