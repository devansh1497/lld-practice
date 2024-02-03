package hackathonphonepe.model;

import java.util.HashSet;
import java.util.Set;

public class User {

    private String userName;
    private String department;
    private Set<String> problemsSolved = new HashSet<>();
    private double score;

    public User(String userName, String department) {
        this.userName = userName;
        this.department = department;
    }

    public String getUserName() {
        return userName;
    }

    public String getDepartment() {
        return department;
    }

    public void solve(String id) {
        problemsSolved.add(id);
    }

    public Set<String> getProblemsSolved() {
        return problemsSolved;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", department='" + department + '\'' +
                ", problemsSolved=" + problemsSolved +
                ", score=" + score +
                '}';
    }
}
