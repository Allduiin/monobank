package test.task.monobank.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
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
    public Long add(@RequestBody RequestDto requestDto) {
        return requestService.add(requestMapper.getRequestFromRequestDto(requestDto));
    }

    @GetMapping("/get-status")
    public String getStatus(@RequestParam Long id) {
        return requestService.getStatus(id).toString();
    }

    @Scheduled(fixedRate = 60000)
    public void updateStatus() throws IOException {
        URL url = new URL("http://localhost:8080/update-statuses");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.connect();
        con.getResponseCode();
        con.disconnect();
    }
}
