package com.wilyendri.portfolio.solarSystemProject;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class NASAController {

    @GetMapping("/eccentricity")
    public String getEccentricity()  {
        try {
            Double majorSemiAxis = 0.0;
            RestTemplate restTemplate = new RestTemplate();
            // Define the URL for the HORIZONS API with the necessary parameters
            String apiUrl = "https://api.le-systeme-solaire.net/rest/bodies/";
            String query = "COMMAND='499'"; // 399 represents Mars, you can change it for other celestial bodies
            // Make an HTTP GET request to the HORIZONS API and receive the response as a ResponseEntity
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

            // Parse the response as JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonResponse = objectMapper.readTree(responseEntity.getBody());

            // Extract the eccentricity value from the JSON response
//            String eccentricity = responseEntity.getBody();

            for(JsonNode res : jsonResponse.get("bodies")) {
                String bodyName = res.get("id").asText();

                if(bodyName.equals("lune")) {
                    majorSemiAxis = res.get("semimajorAxis").asDouble();
                }
            }
            System.out.println(jsonResponse.getClass());
            System.out.println(jsonResponse);

            return "Eccentricity of Mars' orbit: " + majorSemiAxis;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching data.";
        }
    }
}
