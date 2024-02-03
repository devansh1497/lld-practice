package hackathonphonepe.service;

import hackathonphonepe.datastore.InMemoryDatastore;
import hackathonphonepe.model.Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortByTagsStrategy implements ProblemSortingStrategy {

    private final InMemoryDatastore datastore;

    public SortByTagsStrategy(InMemoryDatastore datastore) {
        this.datastore = datastore;
    }

    @Override
    public List<Problem> sort(Problem problem, Object metadata) {
        List<String> tags = (List<String>) metadata;
        return datastore.getProblems().stream().filter(p -> !Collections.disjoint(tags, p.getTags())).collect(Collectors.toList());
    }
}
