package test.task.monobank.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long routeNumber;
    private LocalDateTime requestDateTime;
    @Enumerated(EnumType.STRING)
    private STATUS status;

    public enum STATUS {
        PROCESSING, COMPLETE, ERROR
    }
}
