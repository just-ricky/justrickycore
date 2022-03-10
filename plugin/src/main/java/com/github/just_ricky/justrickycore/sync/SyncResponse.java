package com.github.just_ricky.justrickycore.sync;

public class SyncResponse {

    /**
     * If an error occurred
     */
    private final boolean error;

    /**
     * Response
     */
    private final String message;

    /**
     * SyncResponse
     *
     * @param error   error
     * @param message message
     */
    public SyncResponse(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    /**
     * Returns is error
     *
     * @return is error
     */
    public boolean isError() {
        return error;
    }

    /**
     * Returns message
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }
}
