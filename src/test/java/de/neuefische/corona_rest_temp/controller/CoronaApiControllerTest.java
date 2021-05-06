package de.neuefische.corona_rest_temp.controller;

import de.neuefische.corona_rest_temp.model.CoronaIn;
import de.neuefische.corona_rest_temp.model.CoronaOut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoronaApiControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private RestTemplate mockedTemplate;


    @Test
    public void getCoronaAverageTest(){
        //GIVEN
        CoronaIn[] given = new CoronaIn[]{
                    new CoronaIn("DE", Integer.valueOf(10)),
                    new CoronaIn("DE", Integer.valueOf(10)),

                 new CoronaIn("DE", Integer.valueOf(10)),
                new CoronaIn("DE", Integer.valueOf(10)),
                new CoronaIn("DE", Integer.valueOf(10)),
                new CoronaIn("DE", Integer.valueOf(10)),
                new CoronaIn("DE", Integer.valueOf(10)),
                new CoronaIn("DE", Integer.valueOf(80))};
        String mockUrl = "https://api.covid19api.com/country/DE?from=2021-04-27T00:00:00Z&to=2021-05-05T00:00:00Z";
        when(mockedTemplate.getForEntity(mockUrl, CoronaIn[].class)).thenReturn(ResponseEntity.ok(given));

        //WHEN
        String url = "http://localhost:" + port + "/corona/?countryCode=DE&date=2021-05-05";
        ResponseEntity<CoronaOut> response = restTemplate.getForEntity(url, CoronaOut.class);

        //THEN
        CoronaOut expected = new CoronaOut("DE", Integer.valueOf(10));
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(expected));
        assertEquals(given.length, 8);
    }


    @Test
    public void schoolsRunningOrSchoolsRunningNotThatsTheQuestion(){
        //GIVEN
        CoronaIn[] given = new CoronaIn[]{
                new CoronaIn("DE", Integer.valueOf(10)),
                new CoronaIn("DE", Integer.valueOf(10)),
                new CoronaIn("DE", Integer.valueOf(10)),
                new CoronaIn("DE", Integer.valueOf(10)),
                new CoronaIn("DE", Integer.valueOf(10)),
                new CoronaIn("DE", Integer.valueOf(10)),
                new CoronaIn("DE", Integer.valueOf(10)),
                new CoronaIn("DE", Integer.valueOf(80))};
        String mockUrl = "https://api.covid19api.com/country/DE?from=2021-04-27T00:00:00Z&to=2021-05-05T00:00:00Z";
        when(mockedTemplate.getForEntity(mockUrl, CoronaIn[].class)).thenReturn(ResponseEntity.ok(given));

        //WHEN
        String url = "http://localhost:" + port + "/corona/schools/?countryCode=DE&date=2021-05-05";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        //THEN
        String expected = "Schule läuft";
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(expected));

    }
}
