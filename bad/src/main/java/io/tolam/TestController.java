package io.tolam;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.serde.ObjectMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor
@Controller()
public class TestController {

    private final ObjectMapper mapper;

    @Get()
    public String getThat() throws IOException {
        var that = new That("Thing");
        var ts = mapper.writeValueAsString(that);
        return ts;
    }

    @Get("this")
    public Map<String,String> getThis() {
        return Map.of("name", "getThis");
    }
}
