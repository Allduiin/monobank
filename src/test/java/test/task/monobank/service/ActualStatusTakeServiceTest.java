package test.task.monobank.service;

import org.junit.Test;
import test.task.monobank.model.Request;
import test.task.monobank.service.actual.status.take.ActualStatusTakeService;
import test.task.monobank.service.actual.status.take.impl.ActualStatusTakeServiceImpl;

public class ActualStatusTakeServiceTest {
    private final ActualStatusTakeService actualStatusTakeService = new ActualStatusTakeServiceImpl();

    @Test
    public void normalGetActualStatusTest() {
        for (int i = 0; i < Request.Status.values().length * 5; i++) {
            assert actualStatusTakeService.getActualStatus(Request.Status.values()).getClass()
                    == Request.Status.class;
        }
    }
}
