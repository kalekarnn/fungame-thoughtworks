package com.thoughtwork.programming.fungame.impl;

import com.thoughtwork.programming.fungame.external.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.thoughtwork.programming.fungame.internal.Endpoints.CHLLANGE_INPUT_URL;
import static com.thoughtwork.programming.fungame.internal.Endpoints.CHLLANGE_OUTPUT_URL;

@Service
public class RemoteChallengeServiceImpl {

    public static final String USER_ID = "userId";

    @Value("${base.url}")
    String baseUrl;

    @Value("${userId}")
    String userId;

    @Autowired
    RestTemplate restTemplate;

    public GetChallengeResponse getChallenge() {

        ResponseEntity<GetChallengeResponse> response = restTemplate.exchange(baseUrl + CHLLANGE_INPUT_URL, HttpMethod.GET, getHttpEntity(null, getHeaders(userId)), new ParameterizedTypeReference<GetChallengeResponse>() {
        });
        return response == null ? null : response.getBody();
    }

    public SubmitChallengeResponse submitChallengeResult(Object countChallengeResult) {

        ResponseEntity<SubmitChallengeResponse> response = restTemplate.exchange(baseUrl + CHLLANGE_OUTPUT_URL, HttpMethod.POST, getHttpEntity(countChallengeResult, getHeaders(userId)), new ParameterizedTypeReference<SubmitChallengeResponse>() {
        });
        return response == null ? null : response.getBody();
    }

    private HttpEntity getHttpEntity(Object payload, HttpHeaders headers) {
        HttpEntity httpEntity = null;
        if (payload != null) {
            httpEntity = new HttpEntity(payload, headers);
        } else {
            httpEntity = new HttpEntity(headers);
        }
        return httpEntity;
    }

    private HttpHeaders getHeaders(String userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(USER_ID, userId);
        return headers;
    }
}
