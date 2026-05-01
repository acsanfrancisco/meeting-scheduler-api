package com.acsanfrancisco.meeting_scheduler_api.services;

import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulingIn;
import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulingOut;
import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulingUpdate;
import com.acsanfrancisco.meeting_scheduler_api.entities.Scheduling;
import com.acsanfrancisco.meeting_scheduler_api.entities.enums.SchedulingStatusEnum;
import com.acsanfrancisco.meeting_scheduler_api.exception.SchedulingNotFoundException;
import com.acsanfrancisco.meeting_scheduler_api.mapper.SchedulingMapper;
import com.acsanfrancisco.meeting_scheduler_api.repositories.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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

    @Transactional
    public void cancel(Long id){
        Scheduling scheduling = repository.findById(id)
                .orElseThrow(()->new SchedulingNotFoundException("Scheduling not found. ID = " +  id));
        scheduling.setStatus(SchedulingStatusEnum.CANCELED);
        scheduling.setModifiedAt(LocalDateTime.now());
    }

    @Transactional
    public SchedulingOut update(SchedulingUpdate dto, Long id){
        Scheduling scheduling = repository.findById(id)
                .orElseThrow(()-> new SchedulingNotFoundException("Scheduling not found. ID = " +  id));
        scheduling.setReceiverEmail(dto.getReceiverEmail());
        scheduling.setReceiverTelephone(dto.getReceiverTelephone());
        scheduling.setMessage(dto.getMessage());
        scheduling.setMeetingDate(dto.getMeetingDate());
        scheduling.setModifiedAt(LocalDateTime.now());
        return SchedulingMapper.toDto(repository.save(scheduling));
    }
}
