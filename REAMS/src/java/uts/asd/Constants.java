package uts.asd;

import java.util.StringJoiner;

public final class Constants {

    public static boolean PERSISTENCE_ENABLED = true;

    public static final String APPLICATION_NAME = "Reams";

    public static final String APPLICATION_DESCRIPTION = "Welcome to REAMS\n" +
            "Real Estate Auction Management System";

    private static final String BASE_URL = "http://localhost:8080/ASD_REAMS/";

    public static String path(boolean directory, String... components) {
        if (components == null || components.length == 0) {
            return BASE_URL;
        }
        final StringJoiner joiner = new StringJoiner("/");
        for (String component : components) {
            joiner.add(component);
        }
        return BASE_URL + joiner.toString() + (directory ? "/" : "");
    }

    private Constants() {
        throw new IllegalStateException("Unable to create an instance of: " + getClass().getSimpleName());
    }
}

