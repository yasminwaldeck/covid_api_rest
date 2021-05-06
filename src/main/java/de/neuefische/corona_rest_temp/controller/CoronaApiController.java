package de.neuefische.corona_rest_temp.controller;

import de.neuefische.corona_rest_temp.model.CoronaOut;
import de.neuefische.corona_rest_temp.service.CoronaApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("corona")
public class CoronaApiController {
    private final CoronaApiService coronaApiService;

    @Autowired
    public CoronaApiController(CoronaApiService coronaApiService){
        this.coronaApiService = coronaApiService;
    }

    @GetMapping
    public CoronaOut getAverage(@RequestParam String countryCode, @RequestParam String date){
        return coronaApiService.getConfirmedCasesByCountry(countryCode,date);
    }

    @GetMapping("schools")
    public String schoolsClosed(@RequestParam String countryCode, @RequestParam String date){
        return (coronaApiService.getConfirmedCasesByCountry(countryCode,date).getAverage() < 100000) ? "Schule läuft" : "Schule läuft nicht";

    }
}
