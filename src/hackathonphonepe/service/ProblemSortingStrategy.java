package hackathonphonepe.service;

import hackathonphonepe.model.Problem;

import java.util.List;

public interface ProblemSortingStrategy {

    List<Problem> sort(Problem problem, Object metadata);
}
