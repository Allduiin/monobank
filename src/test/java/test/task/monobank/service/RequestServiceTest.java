package test.task.monobank.service;

import javax.persistence.EntityNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import test.task.monobank.exceptions.DataProcessingException;
import test.task.monobank.model.Request;
import test.task.monobank.repository.RequestRepository;
import test.task.monobank.service.impl.RequestServiceImpl;

public class RequestServiceTest {
    private final RequestRepository requestRepository = mock(RequestRepository.class);
    private final RequestService requestService = new RequestServiceImpl(requestRepository);
    private static final Long ROUT_NUMBER = 123L;
    private static final Long TEST_ID = 1L;
    private static final Long TEST_ID2 = 100L;
    private static final Request.Status TEST_REQUEST_STATUS = Request.Status.PROCESSING;

    @Test
    public void normalAddTest() {
        Request testRequest = new Request();
        testRequest.setRouteNumber(ROUT_NUMBER);
        Request expected = new Request();
        when(requestRepository.save(testRequest)).thenReturn(expected);
        expected.setId(TEST_ID);
        Assert.assertEquals("Incorrect return id at add method",requestService.add(testRequest), TEST_ID);
        expected.setId(TEST_ID2);
        Assert.assertEquals(requestService.add(testRequest), TEST_ID2);
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
                requestService.getStatus(TEST_ID), TEST_REQUEST_STATUS);
    }

    @Test(expected = DataProcessingException.class)
    public void incorrectGetStatusTest() {
        Request expectedRequest = new Request();
        expectedRequest.setStatus(TEST_REQUEST_STATUS);
        when(requestRepository.getOne(TEST_ID)).thenThrow(EntityNotFoundException.class);
        requestService.getStatus(TEST_ID);
    }
}
