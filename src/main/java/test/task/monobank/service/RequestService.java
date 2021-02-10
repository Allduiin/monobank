package test.task.monobank.service;

import test.task.monobank.model.Request;

public interface RequestService {
    Long add(Request request);

    Request.Status status(Long requestId);
}
