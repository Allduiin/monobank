package test.task.monobank.mapper;

import org.junit.Assert;
import org.junit.Test;
import test.task.monobank.model.Request;
import test.task.monobank.model.RequestDto;

public class RequestMapperTest {
    private RequestMapper requestMapper = new RequestMapper();
    private final static Long ROUTE_NUMBER = 543L;

    @Test
    public void normalGetRequestFromRequestDtoTest() {
        RequestDto requestDto = new RequestDto();
        requestDto.setRouteNumber(ROUTE_NUMBER);
        Request request = requestMapper.getRequestFromRequestDto(requestDto);
        Assert.assertNotNull("RequestMapper did not set Time of request",
                request.getRequestDateTime());
        Assert.assertEquals("RequestMapper set incorrect rout number of request",
                ROUTE_NUMBER, request.getRouteNumber());
    }
}
