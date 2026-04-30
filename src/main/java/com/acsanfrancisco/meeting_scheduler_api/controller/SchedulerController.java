package com.acsanfrancisco.meeting_scheduler_api.controller;

import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulerIn;
import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulerOut;
import com.acsanfrancisco.meeting_scheduler_api.services.SchedulerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedulers")
public class SchedulerController {

    private final SchedulerService service;
    @PostMapping
    public ResponseEntity<SchedulerOut> create(@RequestBody @Valid SchedulerIn scheduler){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(scheduler));
    }
}
