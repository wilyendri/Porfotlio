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

import java.time.LocalTime;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class NASAController {

    @GetMapping("/eccentricity")
    public String getEccentricity()  {
        try {
            Double majorSemiAxis = 0.0;
            LocalTime startTime = LocalTime.now();
            RestTemplate restTemplate = new RestTemplate();
            // Define the URL for the HORIZONS API with the necessary parameters
            String apiUrl = "https://ssd.jpl.nasa.gov/api/horizons.api";
            String query = "format=json&COMMAND='499'&EPHEM_TYPE=ELEMENTS&CENTER='499'" +
                    "&OUT_UNITS=AU-D&START_TIME=2022-01-01&STOP_TIME=2022-01-02&STEP_SIZE=1d"; // 499 represents Mars, you can change it for other celestial bodies
            // Make an HTTP GET request to the HORIZONS API and receive the response as a ResponseEntity
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl + "?" + query, String.class);

            // Parse the response as JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonResponse = objectMapper.readTree(responseEntity.getBody());

            // Extract the eccentricity value from the JSON response
//            String eccentricity = responseEntity.getBody();

//            for(JsonNode res : jsonResponse.get("bodies")) {
//                String bodyName = res.get("id").asText();
//
//                if(bodyName.equals("lune")) {
//                    majorSemiAxis = res.get("semimajorAxis").asDouble();
//                }
//            }
            System.out.println(jsonResponse.getClass());
            System.out.println(startTime);
            System.out.println(jsonResponse.get("result").asText());

            return "Eccentricity of Mars' orbit: " + jsonResponse.get("result").asText();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching data.";
        }
    }
}
