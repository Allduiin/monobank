package test.task.monobank.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.task.monobank.mapper.RequestMapper;
import test.task.monobank.model.RequestRequestDto;
import test.task.monobank.service.RequestService;

@RestController
@AllArgsConstructor
@RequestMapping("/request")
public class RequestController {
    private final RequestMapper requestMapper;
    private final RequestService requestService;

    @PostMapping("/add")
    public void add(@RequestBody RequestRequestDto requestRequestDto) {
        requestService.add(requestMapper.getRequestFromRequestDto(requestRequestDto));
    }
}
