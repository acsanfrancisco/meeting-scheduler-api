package com.acsanfrancisco.meeting_scheduler_api.exception;

public class SchedulingNotFoundException extends RuntimeException {

    public SchedulingNotFoundException(String message) {
        super(message);
    }
}
