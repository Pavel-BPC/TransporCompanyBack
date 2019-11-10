package com.blinets.services.security.constant;

public final class Roles {

    public static final String ADMIN_ROLE = "ADMIN";

    public static final String ADMIN = "hasAuthority('" + ADMIN_ROLE + "')";

    public static final String USER_ROLE = "USER";

    public static final String USER = "hasAuthority('" + USER_ROLE + "')";

    private Roles() {
    }
}
