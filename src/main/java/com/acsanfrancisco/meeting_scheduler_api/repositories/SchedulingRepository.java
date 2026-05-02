package com.acsanfrancisco.meeting_scheduler_api.repositories;

import com.acsanfrancisco.meeting_scheduler_api.entities.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
}
