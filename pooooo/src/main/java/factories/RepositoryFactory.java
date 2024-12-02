package factories;

import models.User;
import repositories.Repository;
import repositories.InMemoryUserRepository;

public class RepositoryFactory {
    public static Repository<User> getUserRepository() {
        return new InMemoryUserRepository();
    }
}