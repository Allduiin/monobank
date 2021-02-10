package test.task.monobank.service;

import java.util.List;
import test.task.monobank.model.Request;

public interface RequestService {
    Long add(Request request);

    Request.Status getStatus(Long requestId);

    List<Request> getAllWithProcessingStatus();
}
