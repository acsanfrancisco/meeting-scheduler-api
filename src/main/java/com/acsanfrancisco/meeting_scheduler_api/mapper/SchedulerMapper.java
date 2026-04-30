package com.acsanfrancisco.meeting_scheduler_api.mapper;

import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulerIn;
import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulerOut;
import com.acsanfrancisco.meeting_scheduler_api.entities.Scheduler;

public class SchedulerMapper {

    public static Scheduler toEntity(SchedulerIn dto){
        Scheduler scheduler = new Scheduler();
        scheduler.setReceiverEmail(dto.getReceiverEmail());
        scheduler.setReceiverTelephone(dto.getReceiverTelephone());
        scheduler.setMessage(dto.getMessage());
        scheduler.setMeetingDate(dto.getMeetingDate());
        return scheduler;
    }

    public static SchedulerOut toDto(Scheduler scheduler){
        SchedulerOut schedulerOut= new SchedulerOut();
        schedulerOut.setId(scheduler.getId());
        schedulerOut.setMessage(scheduler.getMessage());
        schedulerOut.setReceiverEmail(scheduler.getReceiverEmail());
        schedulerOut.setReceiverTelephone(scheduler.getReceiverTelephone());
        schedulerOut.setMeetingDate(scheduler.getMeetingDate());
        schedulerOut.setStatus(schedulerOut.getStatus());
        return schedulerOut;
    }
}
