package com.acsanfrancisco.meeting_scheduler_api.entities;

import com.acsanfrancisco.meeting_scheduler_api.entities.enums.SchedulingStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "scheduling")
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "receiver_email", nullable = false)
    private String receiverEmail;
    @Column(name = "receiver_telephone", nullable = false)
    private String receiverTelephone;
    @Column(name = "message", nullable = false)
    private String message;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "meeting_date", nullable = false)
    private LocalDateTime meetingDate;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private SchedulingStatusEnum status;
    @Column(name = "modified_At")
    private LocalDateTime modifiedAt;

    @PrePersist
    public void prePersist(){
        if(this.status == null){
            this.status = SchedulingStatusEnum.SCHEDULED;
        }
        if(this.createdAt == null){
            this.createdAt = LocalDateTime.now();
        }
    }
}
