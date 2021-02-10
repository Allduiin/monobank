package test.task.monobank.service.actual_status_take;

import java.util.List;
import test.task.monobank.model.Request.Status;

public interface ActualStatusTakeService {
    Status getActualStatus(List<Status> statuses);
}
