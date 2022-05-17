package io.gunahusko.pelican.service;

import io.gunahusko.pelican.exception.PelicanException;
import io.gunahusko.pelican.models.TranslationResponse;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PelicanService {

    private final Environment environment;
    private final RestTemplate restTemplate;

    public PelicanService(Environment environment, RestTemplate restTemplate) {
        this.environment = environment;
        this.restTemplate = restTemplate;
    }

    public String getTranslation(String country, String word) throws PelicanException {

        String url = getDomain(country) + "/translation/" + word.toLowerCase();

        return formatIfNecessary(country, retrieveTranslation(url));
    }

    private String getDomain(String country) throws PelicanException {
        try {
            return environment.getProperty("pelican-api.domain-" + country.toLowerCase());
        } catch (NullPointerException e) {
            throw new PelicanException("Country not supported!");
        }
    }

    private String retrieveTranslation(String url) throws PelicanException {
        try {
            return restTemplate.getForEntity(url, TranslationResponse.class).getBody().getTranslation();
        } catch (NullPointerException e) {
            throw new PelicanException("The word cannot be translated!");
        }
    }

    private String formatIfNecessary(String country, String word) {
        if (country.equalsIgnoreCase("estonia")) {
            return word.substring(0, 1).toUpperCase() + word.substring(1);
        } else {
            return word;
        }
    }
}
