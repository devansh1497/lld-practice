package hackathonphonepe.model;

import hackathonphonepe.service.ScoringStrategy;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Problem {
    private String id;
    private String content;
    private Difficulty difficulty;
    private int score;
    private LocalDateTime createdAt;
    private Set<String> solvedBy;
    private Set<String> tags;
    private Double averageTime;
    private ScoringStrategy scoringStrategy;

    public Problem(String id, String content, Difficulty difficulty, int score, Set<String> tags,
                   ScoringStrategy scoringStrategy) {
        this.id = id;
        this.content = content;
        this.difficulty = difficulty;
        this.score = score;
        createdAt = LocalDateTime.now();
        solvedBy = new HashSet<>();
        this.tags = tags;
        this.scoringStrategy = scoringStrategy;
    }

    public String getContent() {
        return content;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getScore() {
        return score;
    }

    public String getId() {
        return id;
    }

    public Set<String> getSolvedBy() {
        return solvedBy;
    }


    public void setAverageTime(Double averageTime) {
        this.averageTime = averageTime;
    }

    public Double getAverageTime() {
        return averageTime == null ? 0.00 : averageTime;
    }

    public ScoringStrategy getScoringStrategy() {
        return scoringStrategy;
    }

    public Set<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", difficulty=" + difficulty +
                ", score=" + score +
                ", createdAt=" + createdAt +
                ", solvedBy=" + solvedBy +
                ", tags=" + tags +
                ", averageTime=" + averageTime +
                ", scoringStrategy=" + scoringStrategy +
                '}';
    }
}
