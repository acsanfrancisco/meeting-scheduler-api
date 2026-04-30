package com.acsanfrancisco.meeting_scheduler_api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SchedulerIn {

    @NotBlank(message = "Must inform the receiver email")
    @Email(message = "Must inform a valid email")
    private String receiverEmail;
    @NotBlank(message = "Must inform the receiver telephone")
    @Pattern(regexp = "^\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}$", message = "Must inform a valid Brazilian telephone number")
    private String receiverTelephone;
    @NotBlank(message = "Must inform the message")
    private String message;
    @Future(message = "Must be a future date")
    @NotNull(message = "Must inform the meeting date")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime meetingDate;
}
