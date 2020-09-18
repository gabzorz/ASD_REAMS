package uts.asd.persistence;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.bild.codec.PojoCodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import uts.asd.model.user.User;

import java.util.Objects;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * Factory class with reasonable defaults for providing an implementation of the {@code MongoDatabaseProvider} interface.
 */
public class MongoDatabaseProviderFactory {

    public static MongoDatabaseProviderImpl mongo(String connectionString, String database) {
        MongoClientOptions options =  MongoClientOptions.builder().sslEnabled(true).sslInvalidHostNameAllowed(true).build();
        final MongoClient client = MongoClients.create(connectionString);
        //final MongoClient client = new MongoClient(connectionString, options);
        final PojoCodecProvider provider = PojoCodecProvider.builder()
                .register(
                        User.class
                ).build();
        final CodecRegistry registry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), fromProviders(provider));
        final MongoDatabase db = client.getDatabase(database).withCodecRegistry(registry);
        return new MongoDatabaseProviderImpl(client, db);
    }

/*   private static MongoClientURI uri(String user, String password, String role, String database, List<String> clusters) {
        final StringBuilder builder = new StringBuilder("mongodb://").append(user).append(":").append(password).append("@");

        final StringJoiner hosts = new StringJoiner(",");
        clusters.forEach(hosts::add);

        builder.append(hosts.toString()).append("/").append(database).append("?");
        builder.append("ssl=true&replicaSet=Cluster0-shard-0&retryWrites=true").append("&authSource=").append(role);

        return new MongoClientURI(builder.toString());
    }*/

    private static class MongoDatabaseProviderImpl implements MongoDatabaseProvider {

        private final MongoClient client;
        private final MongoDatabase database;

        private MongoDatabaseProviderImpl(MongoClient client, MongoDatabase database) {
            this.client = Objects.requireNonNull(client);
            this.database = Objects.requireNonNull(database);
        }

        @Override
        public MongoDatabase database() {
            return database;
        }

        @Override
        public <T> MongoCollection<T> collection(String name, Class<T> clazz) {
            return database.getCollection(name, clazz);
        }

        @Override
        public void close() {
            client.close();
        }
    }
}
