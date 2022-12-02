package net.catena_x.btp.libraries.util.apihelper.preparation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.catena_x.btp.libraries.util.apihelper.model.DefaultApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public final class ApiResponse {
    @Autowired ObjectMapper objectMapper;

    public <T> ResponseEntity<String> toString(@NotNull final ApiResult<T> apiResult) {
        try {
            final String resultAsString = objectMapper.writerFor(DefaultApiResult.class)
                    .writeValueAsString(apiResult.getApiResult());
            return new ResponseEntity<>(resultAsString, apiResult.getHeaders(),
                    apiResult.getStatusCode() );
        } catch ( JsonProcessingException exception) {
            return new ResponseEntity<>("{\"message\": \"Error in error handling!\"}",
                    apiResult.getHeaders(), apiResult.getStatusCode() );
        }
    }

    public <T> ResponseEntity<T> toObject(@NotNull final ApiResult<T> apiResult) {
        return new ResponseEntity<>( apiResult.getApiResult(),
                apiResult.getHeaders(), apiResult.getStatusCode() );
    }
}
