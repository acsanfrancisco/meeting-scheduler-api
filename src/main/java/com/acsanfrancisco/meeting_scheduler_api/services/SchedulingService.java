package com.acsanfrancisco.meeting_scheduler_api.services;

import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulingIn;
import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulingOut;
import com.acsanfrancisco.meeting_scheduler_api.entities.Scheduling;
import com.acsanfrancisco.meeting_scheduler_api.exception.SchedulingNotFoundException;
import com.acsanfrancisco.meeting_scheduler_api.mapper.SchedulingMapper;
import com.acsanfrancisco.meeting_scheduler_api.repositories.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SchedulingService {

    private final SchedulerRepository repository;

    @Transactional
    public SchedulingOut create(SchedulingIn dto){
        return SchedulingMapper.toDto(repository.save(SchedulingMapper.toEntity(dto)));
    }

    @Transactional
    public SchedulingOut findById(Long id){
        Scheduling scheduling = repository.findById(id)
                .orElseThrow(() -> new SchedulingNotFoundException("Scheduling not found. ID = " + id));
        return SchedulingMapper.toDto(scheduling);
    }
}
