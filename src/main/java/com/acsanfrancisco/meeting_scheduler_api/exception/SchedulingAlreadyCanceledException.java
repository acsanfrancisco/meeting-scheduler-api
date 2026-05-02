package com.acsanfrancisco.meeting_scheduler_api.exception;

public class SchedulingAlreadyCanceledException extends RuntimeException {
    public SchedulingAlreadyCanceledException(String message) {
        super(message);
    }
}
