package com.acsanfrancisco.meeting_scheduler_api.mapper;

import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulingIn;
import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulingOut;
import com.acsanfrancisco.meeting_scheduler_api.dtos.SchedulingUpdate;
import com.acsanfrancisco.meeting_scheduler_api.entities.Scheduling;

public class SchedulingMapper {

    public static Scheduling toEntity(SchedulingIn dto){
        Scheduling scheduling = new Scheduling();
        scheduling.setReceiverEmail(dto.getReceiverEmail());
        scheduling.setReceiverTelephone(dto.getReceiverTelephone());
        scheduling.setMessage(dto.getMessage());
        scheduling.setMeetingDate(dto.getMeetingDate());
        return scheduling;
    }

    public static SchedulingOut toDto(Scheduling scheduling){
        SchedulingOut schedulingOut = new SchedulingOut();
        schedulingOut.setId(scheduling.getId());
        schedulingOut.setMessage(scheduling.getMessage());
        schedulingOut.setReceiverEmail(scheduling.getReceiverEmail());
        schedulingOut.setReceiverTelephone(scheduling.getReceiverTelephone());
        schedulingOut.setMeetingDate(scheduling.getMeetingDate());
        schedulingOut.setStatus(scheduling.getStatus());
        return schedulingOut;
    }

}
