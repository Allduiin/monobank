package test.task.monobank.service.actual_status_take.impl;

import java.util.List;
import test.task.monobank.model.Request.Status;
import test.task.monobank.service.actual_status_take.ActualStatusTakeService;

public class ActualStatusTakeServiceImpl implements ActualStatusTakeService {
    @Override
    public Status getActualStatus(List<Status> statuses) {
        int rand = ((int) (Math.random() * statuses.size()));
        return (rand == statuses.size()) ? statuses.get(0) : statuses.get(rand);
    }
}
