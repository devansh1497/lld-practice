package hackathonphonepe.service;

import hackathonphonepe.datastore.InMemoryDatastore;
import hackathonphonepe.model.Difficulty;
import hackathonphonepe.model.Problem;

import java.util.List;
import java.util.stream.Collectors;

public class SortByDifficultyStrategy implements ProblemSortingStrategy {

    private final InMemoryDatastore dataStore;

    public SortByDifficultyStrategy(InMemoryDatastore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public List<Problem> sort(Problem problem, Object metadata) {
        List<Difficulty> difficulty = (List<Difficulty>) metadata;
        return dataStore.getProblems().stream().filter(p -> difficulty.contains(p.getDifficulty())).sorted((a, b) -> b.getScore() - a.getScore()).collect(Collectors.toList());
    }
}
