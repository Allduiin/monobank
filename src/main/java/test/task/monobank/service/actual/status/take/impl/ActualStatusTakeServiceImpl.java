package test.task.monobank.service.actual.status.take.impl;

import org.springframework.stereotype.Service;
import test.task.monobank.model.Request.Status;
import test.task.monobank.service.actual.status.take.ActualStatusTakeService;

@Service
public class ActualStatusTakeServiceImpl implements ActualStatusTakeService {
    @Override
    public Status getActualStatus(Status[] statuses) {
        int rand = ((int) (Math.random() * statuses.length));
        return (rand == statuses.length) ? statuses[0] : statuses[rand];
    }
}
