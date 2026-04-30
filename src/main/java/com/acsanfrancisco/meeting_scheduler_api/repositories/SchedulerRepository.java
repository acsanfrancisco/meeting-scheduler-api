package com.acsanfrancisco.meeting_scheduler_api.repositories;

import com.acsanfrancisco.meeting_scheduler_api.entities.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerRepository extends JpaRepository<Scheduler, Long> {
}
