package test.task.monobank.service.impl;

import org.springframework.stereotype.Service;
import test.task.monobank.model.Request;
import test.task.monobank.repository.RequestRepository;
import test.task.monobank.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {
    private RequestRepository requestRepository;

    RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Long add(Request request) {
        request.setStatus(Request.Status.PROCESSING);
        return requestRepository.save(request).getId();
    }

    @Override
    public Request.Status status(Long requestId) {
        return null;
    }
}
