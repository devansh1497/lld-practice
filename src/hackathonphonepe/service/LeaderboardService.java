package hackathonphonepe.service;

import hackathonphonepe.datastore.InMemoryDatastore;
import hackathonphonepe.model.User;

public class LeaderboardService {

    private final InMemoryDatastore datastore;

    public LeaderboardService(InMemoryDatastore datastore) {
        this.datastore = datastore;
    }

    public User topUser() {
        return datastore.getLeaderboard().first();
    }

    public void update(User user) {
        datastore.getLeaderboard().add(user);
    }
}
