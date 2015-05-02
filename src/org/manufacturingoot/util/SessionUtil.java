package org.manufacturingoot.util;

import org.manufacturingoot.model.User;

public class SessionUtil {

    private SessionUtil() {
    }

    private static User session;

    public static void setSession(User u) {
        session = u;
    }

    public static User getSession() {
        return session;
    }
}
