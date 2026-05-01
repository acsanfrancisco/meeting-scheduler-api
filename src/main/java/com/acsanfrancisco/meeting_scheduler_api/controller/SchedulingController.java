package com.acsanfrancisco.meeting_scheduler_api.controller;

import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulingIn;
import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulingOut;
import com.acsanfrancisco.meeting_scheduler_api.services.SchedulingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schedulings")
public class SchedulingController {

    private final SchedulingService service;

    @PostMapping
    public ResponseEntity<SchedulingOut> create(@RequestBody @Valid SchedulingIn scheduler){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(scheduler));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchedulingOut> findById (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancel(@PathVariable Long id){
        service.cancel(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
