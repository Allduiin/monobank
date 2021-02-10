package test.task.monobank.mapper;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import test.task.monobank.model.Request;
import test.task.monobank.model.RequestRequestDto;

@Component
public class RequestMapper {
    public Request getRequestFromRequestDto(RequestRequestDto requestRequestDto) {
        Request request = new Request();
        request.setRouteNumber(requestRequestDto.getRouteNumber());
        request.setRequestDateTime(LocalDateTime.now());
        return request;
    }
}
