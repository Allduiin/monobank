package test.task.monobank.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import test.task.monobank.model.Request;
import test.task.monobank.service.RequestService;
import test.task.monobank.service.actual.status.take.ActualStatusTakeService;

@RestController
@AllArgsConstructor
public class StatusController {
    private final RequestService requestService;
    private final ActualStatusTakeService actualStatusTakeService;

    @PostMapping("/update-statuses")
    public void checkStatuses() {
        Request.Status[] statuses = Request.Status.values();
        List<Request> requests = requestService.getAllWithProcessingStatus();
        for (Request r : requests) {
            r.setStatus(actualStatusTakeService.getActualStatus(statuses));
            requestService.update(r);
        }
    }
}
