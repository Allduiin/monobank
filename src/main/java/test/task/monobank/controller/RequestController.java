package test.task.monobank.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.task.monobank.mapper.RequestMapper;
import test.task.monobank.model.RequestDto;
import test.task.monobank.service.RequestService;

@RestController
@AllArgsConstructor
@RequestMapping("/request")
public class RequestController {
    private final RequestMapper requestMapper;
    private final RequestService requestService;

    @PostMapping("/add")
    public void add(@RequestBody RequestDto requestDto) {
        requestService.add(requestMapper.getRequestFromRequestDto(requestDto));
    }

    @GetMapping("/get-status")
    public String getStatus(@RequestParam Long id) {
        return requestService.getStatus(id).toString();
    }
}
