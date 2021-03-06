package test.task.monobank.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long routeNumber;
    private LocalDateTime requestDateTime;
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PROCESSING, COMPLETE, ERROR
    }
}
