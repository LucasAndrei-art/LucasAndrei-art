package repositories;

import annotations.Singleton;
import models.User;

import java.util.ArrayList;
import java.util.List;
public class InMemoryUserRepository implements Repository<User> {
    private final List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }
}