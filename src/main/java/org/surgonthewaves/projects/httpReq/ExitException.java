package org.surgonthewaves.projects.httpReq;

public class ExitException extends Exception {
    public ExitException() {
        super();
    }

    public ExitException(String message) {
        super(message);
    }

    public ExitException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExitException(Throwable cause) {
        super(cause);
    }
}
