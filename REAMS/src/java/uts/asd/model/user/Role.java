package uts.asd.model.user;

public enum Role {
    CUSTOMER,
    STAFF,
    ADMINISTRATOR
    ;
    public boolean isStaff() {
        return this == STAFF || this == ADMINISTRATOR;
    }


    public static Role findByName(String name) {
        try {
            return valueOf(name);
        } catch (Exception e) {
            return CUSTOMER;
        }
    }
}

