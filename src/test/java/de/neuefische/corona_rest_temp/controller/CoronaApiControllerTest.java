package de.neuefische.corona_rest_temp.controller;

import de.neuefische.corona_rest_temp.model.CoronaFrontEnd;
import de.neuefische.corona_rest_temp.service.CoronaApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoronaApiControllerTest {


    @LocalServerPort
    private int port;



    @Test
    public void getCoronaAverageTest(){
        //GIVEN
        RestTemplate restTemplate = new RestTemplate();
        CoronaFrontEnd expected = new CoronaFrontEnd("DE", Integer.valueOf(17676));

        //WHEN
        ResponseEntity<CoronaFrontEnd> response = restTemplate.getForEntity("http://localhost:" + port + "/corona/?countryCode=DE&date=2021-05-05", CoronaFrontEnd.class);

        //THEN

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(expected));

    }
}
