package test.task.monobank.mapper;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import test.task.monobank.model.Request;
import test.task.monobank.model.RequestDto;

@Component
public class RequestMapper {
    public Request getRequestFromRequestDto(RequestDto requestDto) {
        Request request = new Request();
        request.setRouteNumber(requestDto.getRouteNumber());
        request.setRequestDateTime(LocalDateTime.now());
        return request;
    }
}
