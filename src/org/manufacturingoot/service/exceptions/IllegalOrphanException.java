package org.manufacturingoot.service.exceptions;

import java.util.ArrayList;
import java.util.List;

public class IllegalOrphanException extends Exception {

    private List<String> messages;

    public IllegalOrphanException(List<String> messages) {
        super((messages != null && messages.size() > 0 ? messages.get(0) : null));
        this.messages = messages == null ? new ArrayList<>() : messages;
    }

    public List<String> getMessages() {
        return messages;
    }
}
