package uts.asd.model;

import org.bson.types.ObjectId;

/**
 * Provides a means of retrieving and updating an entities {@code ObjectId}
 */
public interface Identifiable {

    ObjectId getId();

    void setId(ObjectId id);

}
