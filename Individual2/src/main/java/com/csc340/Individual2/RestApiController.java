package com.csc340.Individual2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RestApiController {

    public CatFact getCatFact() {
        try {
            String url = "https://cat-fact.herokuapp.com/facts/random?animal_type=cat&amount=1";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            // Fetch the response from the Cat Facts API
            String jsonResponse = restTemplate.getForObject(url, String.class);

            // Parse the JSON response
            JsonNode root = mapper.readTree(jsonResponse);

            // Extract the fact from the response
            String fact = root.get("text").asText();

            // Return the CatFact object with the extracted fact
            return new CatFact(fact);
        } catch (Exception ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE, null, ex);
            return new CatFact("Error in fetching cat fact");
        }
    }
}
