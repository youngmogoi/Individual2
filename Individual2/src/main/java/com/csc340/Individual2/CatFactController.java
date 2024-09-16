package com.csc340.Individual2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatFactController {

    private final RestApiController restApiController;

    public CatFactController(RestApiController restApiController) {
        this.restApiController = restApiController;
    }

    /**
     * @return a CatFact.
     */
    @GetMapping("/catfact")
    public CatFact getCatFact() {
        return restApiController.getCatFact();
    }
}
