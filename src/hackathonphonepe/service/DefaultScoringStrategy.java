package hackathonphonepe.service;

import hackathonphonepe.model.Problem;

public class DefaultScoringStrategy implements ScoringStrategy {
    @Override
    public double score(Problem problem, Object metadata) {
        return problem.getScore();
    }
}
