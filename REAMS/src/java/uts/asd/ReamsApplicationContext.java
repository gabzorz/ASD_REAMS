package uts.asd;

import lombok.Getter;
import uts.asd.action.ActionProcessor;
import uts.asd.action.ActionRegistry;
import uts.asd.action.InMemoryActionRegistry;
import uts.asd.action.impl.LoginAction;
import uts.asd.action.impl.LogoutAction;
import uts.asd.action.impl.RegisterAction;
import uts.asd.action.impl.UserAction;
import uts.asd.persistence.MongoDatabaseProvider;
import uts.asd.persistence.MongoDatabaseProviderFactory;
import uts.asd.repository.user.UserRepository;

import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;
import java.io.Serializable;
import java.util.Objects;
import java.util.function.Supplier;


/**
 * Represents the centralised Reams application state; stored as a singleton within the active servlet context object
 * of the web-server.
 */

    @Getter
    public final class ReamsApplicationContext implements Serializable, AutoCloseable {

        private static final String CONTEXT_KEY = "application-context";

        private final MongoDatabaseProvider datasource;
        private final ActionProcessor processor;
        private final UserRepository users;

        ReamsApplicationContext(MongoDatabaseProvider datasource, ActionProcessor processor, UserRepository users) {
            this.datasource = datasource;
            this.processor = Objects.requireNonNull(processor);
            this.users = Objects.requireNonNull(users);
        }

        ReamsApplicationContext(MongoDatabaseProvider datasource, ActionProcessor processor) {
            this(datasource, processor, UserRepository.create(datasource));
        }

        public static ReamsApplicationContext getInstance(ServletContext application, Supplier<ReamsApplicationContext> supplier) {
            return getInstance(application, CONTEXT_KEY, supplier);
        }

        public static ReamsApplicationContext getInstance(ServletContext application) {
            return getInstance(application, () -> {
                final ActionProcessor processor = new ActionProcessor(createRegistry());
                final MongoDatabaseProvider datasource;
                if (Constants.PERSISTENCE_ENABLED) {
                    //TODO: don't hardcode
                    //datasource = MongoDatabaseProviderFactory.mongo("mongodb+srv://asd:asd@reams.jhz5t.mongodb.net/asd?retryWrites=true&w=majority", "asd");

                    datasource = MongoDatabaseProviderFactory.mongo("mongodb+srv://asd:asd@cluster0.jhz5t.mongodb.net/reams?retryWrites=true&w=majority","reams");
                } else {
                    datasource = null;
                }
                return new ReamsApplicationContext(datasource, processor);
            });

        }

        private static <T> T getInstance(ServletContext application, String key, Supplier<T> supplier) {
            T result = (T) application.getAttribute(key);
            if (result == null) {
                synchronized (application) {
                    result = (T) application.getAttribute(key);
                    if (result == null) {
                        result = supplier.get();
                        application.setAttribute(key, result);
                    }
                }
            }
            return result;
        }

        private static ActionRegistry createRegistry() {
            final ActionRegistry registry = InMemoryActionRegistry.concurrent();

            registry.register("login", LoginAction::new);
            registry.register("register", RegisterAction::new);
            registry.register("logout", LogoutAction::new);
            registry.register("user", UserAction::new);
            return registry;
        }

        @Override
        @PreDestroy
        public void close() {
            try {
                if (datasource != null) {
                    datasource.close();
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }