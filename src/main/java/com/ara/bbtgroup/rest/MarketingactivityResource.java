package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.model.Customer;
import com.ara.bbtgroup.model.Marketingactivity;
import com.ara.bbtgroup.repository.MarketingactivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/marketingactivities")
public class MarketingactivityResource {

    @Autowired
    private MarketingactivityRepository marketingactivityRepository;

    // ======================================
    // =             GET METHOD             =
    // ======================================

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<Marketingactivity> getAllMarketingactivities() {

        return (List<Marketingactivity>) marketingactivityRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Marketingactivity> getMarketingActivityById(@PathVariable Long id){

        return new ResponseEntity<>(marketingactivityRepository.findOne(id), HttpStatus.OK);
    }

    @GetMapping(path = "/active/{ownerId}")
    public @ResponseBody List<Marketingactivity> getAllActiveJobsByEmployeeId(@PathVariable String ownerId) {

        return marketingactivityRepository.getAllByEmployeeIdAndStatusEqualsTodo(ownerId);
    }

    @GetMapping(path = "/progress/{ownerId}")
    public @ResponseBody List<Marketingactivity> getAllProgressJobsByEmployeeId(@PathVariable String ownerId) {

        return marketingactivityRepository.getAllByEmployeeIdAndStatusEqualsInProgress(ownerId);
    }

    @GetMapping(path = "/completed/{ownerId}")
    public @ResponseBody List<Marketingactivity> getAllDoneJobsByEmployeeId(@PathVariable String ownerId) {

        return marketingactivityRepository.getAllByEmployeeIdAndStatusEqualsCompleted(ownerId);
    }

    @GetMapping(path = "/begin/{begin}/end/{end}/id/{id}/status/{status}")
    public @ResponseBody List<Marketingactivity> getAllBetweenDate(@PathVariable String begin,
                                                                   @PathVariable String end,
                                                                   @PathVariable int id,
                                                                   @PathVariable int status){
        return marketingactivityRepository.getAllByDate(begin, end, id, status);
    }

    // ======================================
    // =             POST METHOD            =
    // ======================================

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Marketingactivity> createMarketingavtivities(@RequestBody Marketingactivity marketingactivityRequest){

        marketingactivityRepository.save(marketingactivityRequest);
            return new ResponseEntity<Marketingactivity>(marketingactivityRequest, HttpStatus.CREATED);
    }

    // ======================================
    // =             PUT METHOD             =
    // ======================================

    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Marketingactivity> updateMarketingavtivity(@RequestBody Marketingactivity marketingactivityRequest) {
        marketingactivityRepository.save(marketingactivityRequest);
        return new ResponseEntity<>(marketingactivityRequest, HttpStatus.OK);
    }

    // ======================================
    // =          DELETE METHOD             =
    // ======================================

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delteMarketingactivity (@PathVariable Long id) {

        marketingactivityRepository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
