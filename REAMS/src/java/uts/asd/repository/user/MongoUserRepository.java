package uts.asd.repository.user;

import uts.asd.model.user.User;
import uts.asd.persistence.MongoDatabaseProvider;
import uts.asd.repository.MongoRepository;

import static com.mongodb.client.model.Filters.eq;

public class MongoUserRepository extends MongoRepository<User> implements UserRepository {

    public MongoUserRepository(MongoDatabaseProvider datasource) {
        super(datasource, User.class);
    }

    @Override
    public User findByUsername(String username) {
        return find(eq("username", username));
    }
}
