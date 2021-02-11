package test.task.monobank.service.impl;

import java.util.List;
import org.springframework.data.domain.Example;
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
    public Request.Status getStatus(Long requestId) {
        return requestRepository.getOne(requestId).getStatus();
    }

    @Override
    public void update(Request request) {
        requestRepository.save(request);
    }

    @Override
    public List<Request> getAllWithProcessingStatus() {
        Request example = new Request();
        example.setStatus(Request.Status.PROCESSING);
        return requestRepository.findAll(Example.of(example));
    }
}
