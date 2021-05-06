package de.neuefische.corona_rest_temp.service;

import de.neuefische.corona_rest_temp.model.CoronaBackEnd;
import de.neuefische.corona_rest_temp.model.CoronaFrontEnd;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// from=2020-04-25T00:00:00Z&to=2020-05-03T00:00:00Z
@Service
public class CoronaApiService {

    private final RestTemplate restTemplate = new RestTemplate();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


    public CoronaFrontEnd getConfirmedCasesByCountry(String countryCode, String startDate){

        Calendar c = Calendar.getInstance();

        try {
            c.setTime(formatter.parse(startDate));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        c.add(Calendar.DATE, -8);
        String endDate = formatter.format(c.getTime());
        String coronaApiUrl = "https://api.covid19api.com/country/" + countryCode + "?from="
                + endDate.toString() + "T00:00:00Z&to=" + startDate + "T00:00:00Z";

        ResponseEntity<CoronaBackEnd[]> response = restTemplate.getForEntity(coronaApiUrl, CoronaBackEnd[].class);
        if (response.getBody().length != 8){
            return calculateAverageConfirmed(response.getBody());
            } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "nope");
            }
        }




    public CoronaFrontEnd calculateAverageConfirmed(CoronaBackEnd[] coronaCases) {

        CoronaBackEnd previous = null;
        String countryCode = coronaCases[0].getCountryCode();
        Integer before = coronaCases[0].getConfirmed();
        Integer now = coronaCases[7].getConfirmed();
        Integer total = now - before;
        Integer average = total/Integer.valueOf(7);
        CoronaFrontEnd result = new CoronaFrontEnd(countryCode, average);
        return result;
    }

}
