package test.task.monobank.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.data.domain.Example;
import test.task.monobank.exceptions.DataProcessingException;
import test.task.monobank.model.Request;
import test.task.monobank.repository.RequestRepository;
import test.task.monobank.service.impl.RequestServiceImpl;

public class RequestServiceTest {
    private RequestRepository requestRepository;
    private RequestService requestService;
    private static final Long ROUT_NUMBER = 123L;
    private static final Long TEST_ID = 1L;
    private static final Long TEST_ID2 = 100L;
    private static final Request.Status TEST_REQUEST_STATUS = Request.Status.PROCESSING;

    @Before
    public void configService() {
        requestRepository = mock(RequestRepository.class);
        requestService = new RequestServiceImpl(requestRepository);
    }

    @Test
    public void normalAddTest() {
        Request testRequest = new Request();
        testRequest.setRouteNumber(ROUT_NUMBER);
        Request expected = new Request();
        when(requestRepository.save(testRequest)).thenReturn(expected);
        expected.setId(TEST_ID);
        Assert.assertEquals("Incorrect return id at add method", requestService.add(testRequest), TEST_ID);
        expected.setId(TEST_ID2);
        Assert.assertEquals(TEST_ID2, requestService.add(testRequest));
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerAddTest() {
        requestService.add(null);
    }

    @Test
    public void normalGetStatusTest() {
        Request expectedRequest = new Request();
        expectedRequest.setStatus(TEST_REQUEST_STATUS);
        when(requestRepository.getOne(TEST_ID)).thenReturn(expectedRequest);
        Assert.assertEquals("Incorrect return status at get status method",
                TEST_REQUEST_STATUS, requestService.getStatus(TEST_ID));
    }

    @Test(expected = DataProcessingException.class)
    public void incorrectGetStatusTest() {
        Request expectedRequest = new Request();
        expectedRequest.setStatus(TEST_REQUEST_STATUS);
        when(requestRepository.getOne(TEST_ID)).thenThrow(EntityNotFoundException.class);
        requestService.getStatus(TEST_ID);
    }

    @Test
    public void normalUpdateTest() {
        Request testRequest = new Request();
        testRequest.setId(TEST_ID);
        when(requestRepository.existsById(TEST_ID)).thenReturn(true);
        when(requestRepository.save(testRequest)).thenReturn(testRequest);
        Assert.assertEquals("Incorrect updating of Entity", testRequest, requestService.update(testRequest));
    }

    @Test(expected = DataProcessingException.class)
    public void incorrectIdUpdateTest() {
        Request testRequest = new Request();
        testRequest.setId(TEST_ID);
        when(requestRepository.existsById(TEST_ID)).thenReturn(false);
        requestService.update(testRequest);
    }

    @Test(expected = DataProcessingException.class)
    public void nullIdUpdateTest() {
        requestService.update(new Request());
    }

    @Test
    public void normalGetAllWithProcessingStatusTest() {
        List<Request> requests = List.of(new Request(), new Request());
        Request example = new Request();
        example.setStatus(Request.Status.PROCESSING);
        when(requestRepository.findAll(Example.of(example))).thenReturn(requests);
        Assert.assertEquals("Not correct return from getAllProcessingStatus method",
                requests, requestService.getAllWithProcessingStatus());
    }
}
