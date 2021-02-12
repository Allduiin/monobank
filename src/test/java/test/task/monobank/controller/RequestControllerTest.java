package test.task.monobank.controller;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import test.task.monobank.mapper.RequestMapper;
import test.task.monobank.model.Request;
import test.task.monobank.model.RequestDto;
import test.task.monobank.service.RequestService;


public class RequestControllerTest {
    private final RequestController requestController;
    private final RequestMapper requestMapper;
    private final RequestService requestService;
    private final static Long ROUTE_NUMBER = 1234L;
    private final static Long ID = 12L;
    private final static Request.Status STATUS = Request.Status.PROCESSING;

    public RequestControllerTest() {
        requestMapper = mock(RequestMapper.class);
        requestService = mock(RequestService.class);
        requestController = new RequestController(requestMapper, requestService);
    }

    @Test
    public void normalAddTest() {
        RequestDto requestDto = new RequestDto();
        requestDto.setRouteNumber(ROUTE_NUMBER);
        when(requestService.add(requestMapper.getRequestFromRequestDto(requestDto)))
                .thenReturn(ID);
        Assert.assertEquals("Incorrect return at add method",
                ID, requestController.add(requestDto));
    }

    @Test
    public void normalGetStatusTest() {
        RequestDto requestDto = new RequestDto();
        requestDto.setRouteNumber(ROUTE_NUMBER);
        when(requestService.getStatus(ID)).thenReturn(STATUS);
        Assert.assertEquals("Incorrect return at getStatus method",
                STATUS.toString(), requestController.getStatus(ID));
    }
}
