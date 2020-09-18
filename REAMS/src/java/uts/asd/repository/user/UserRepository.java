package uts.asd.repository.user;

import uts.asd.model.user.User;
import uts.asd.persistence.MongoDatabaseProvider;
import uts.asd.repository.Repository;

public interface UserRepository extends Repository<User> {

    User findByUsername(String username);

    static UserRepository create(MongoDatabaseProvider datasource) {
        if (datasource == null) {
            return InMemoryUserRepository.concurrent();
        }
        return new MongoUserRepository(datasource);
    }
}

