package io.gunahusko.pelican.service;

import io.gunahusko.pelican.exception.PelicanException;
import io.gunahusko.pelican.models.TranslationResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class PelicanServiceTest {

    @Mock
    private Environment environment;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PelicanService pelicanService;

    @Test
    @DisplayName("When GET Request is called, should return translated word.")
    public void testUrlResponse() throws PelicanException {

        String domainEstonia = "http://localhost:8083";

        Mockito.when(environment.getProperty("pelican-api.domain-" + "estonia")).thenReturn(domainEstonia);
        String url = domainEstonia + "/translation/hello";

        TranslationResponse expected = new TranslationResponse();
        expected.setTranslation("Tere");

        Mockito.when(restTemplate.getForEntity(url, TranslationResponse.class)).thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));

        String response = pelicanService.getTranslation("Estonia", "Hello");

        Assertions.assertEquals(expected.getTranslation(), response);
    }
}
