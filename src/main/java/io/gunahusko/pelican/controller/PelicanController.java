package io.gunahusko.pelican.controller;

import io.gunahusko.pelican.exception.PelicanException;
import io.gunahusko.pelican.models.PelicanResponse;
import io.gunahusko.pelican.service.PelicanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class PelicanController {

    private final PelicanService pelicanService;

    public PelicanController(PelicanService pelicanService) {
        this.pelicanService = pelicanService;
    }

    @GetMapping("/{country}/{word}")
    public PelicanResponse translation(
            @PathVariable("country") String country,
            @PathVariable("word") String word) throws PelicanException {

        return new PelicanResponse(pelicanService.getTranslation(country, word));
    }
}
