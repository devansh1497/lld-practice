package hackathonphonepe.service;

import hackathonphonepe.model.Problem;

public interface ScoringStrategy {

    double score(Problem problem, Object metadata);
}
