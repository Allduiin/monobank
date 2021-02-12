package test.task.monobank.service.impl;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import test.task.monobank.exceptions.DataProcessingException;
import test.task.monobank.model.Request;
import test.task.monobank.repository.RequestRepository;
import test.task.monobank.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {
    private RequestRepository requestRepository;

    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Long add(Request request) {
        request.setStatus(Request.Status.PROCESSING);
        return requestRepository.save(request).getId();
    }

    @Override
    public Request.Status getStatus(Long requestId) {
        try {
            return requestRepository.getOne(requestId).getStatus();
        } catch (EntityNotFoundException e) {
            throw new DataProcessingException("Can not find request with id:" + requestId, e);
        }
    }

    @Override
    public Request update(Request request) {
        if (request.getId() != null && requestRepository.existsById(request.getId())) {
            return  requestRepository.save(request);
        }
        throw new DataProcessingException("Request or it's id does not exists");
    }

    @Override
    public List<Request> getAllWithProcessingStatus() {
        Request example = new Request();
        example.setStatus(Request.Status.PROCESSING);
        return requestRepository.findAll(Example.of(example));
    }
}
