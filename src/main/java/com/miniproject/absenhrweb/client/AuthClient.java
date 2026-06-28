package com.miniproject.absenhrweb.client;

import com.miniproject.absenhrweb.dto.request.LoginRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "auth-client",
        url = "${host.rest.api}"
)
public interface AuthClient {

    @PostMapping("/auth/login")
    String login(@RequestBody LoginRequestDto request);

}