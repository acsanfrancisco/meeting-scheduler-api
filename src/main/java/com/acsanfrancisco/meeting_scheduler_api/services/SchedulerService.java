package com.acsanfrancisco.meeting_scheduler_api.services;

import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulerIn;
import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulerOut;
import com.acsanfrancisco.meeting_scheduler_api.mapper.SchedulerMapper;
import com.acsanfrancisco.meeting_scheduler_api.repositories.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final SchedulerRepository repository;

    @Transactional
    public SchedulerOut create(SchedulerIn dto){
        return SchedulerMapper.toDto(repository.save(SchedulerMapper.toEntity(dto)));
    }
}
