package test.task.monobank.service.actual.status.take;

import test.task.monobank.model.Request.Status;

public interface ActualStatusTakeService {
    Status getActualStatus(Status[] statuses);
}
