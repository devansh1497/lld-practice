package hackathonphonepe.service;

import hackathonphonepe.datastore.InMemoryDatastore;
import hackathonphonepe.model.Problem;
import hackathonphonepe.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    private final InMemoryDatastore dataStore;

    public UserService(InMemoryDatastore dataStore) {
        this.dataStore = dataStore;
    }

    public User registerUser(String userName, String department ) {
        User user = new User(userName, department);
        dataStore.addUser(user);
        System.out.println("Added user: " + dataStore.getUsers().get(dataStore.getUsers().size()-1));
        return user;
    }

    public List<Problem> getSolvedQuestions(String userId) {
        User user =
                dataStore.getUsers().stream().filter(u -> u.getUserName().equals(userId)).collect(Collectors.toList()).get(0);
        return dataStore.getProblems().stream().filter(p -> user.getProblemsSolved().contains(p.getId())).collect(Collectors.toList());
    }

    public void updateUserStats(User user, Problem problem) {
        user.solve(problem.getId());
        double score = problem.getScoringStrategy().score(problem, null);
        user.setScore(user.getScore()+score);
    }
}
