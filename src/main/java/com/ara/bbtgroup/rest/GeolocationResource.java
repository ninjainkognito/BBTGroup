package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.model.Geolocation;
import com.ara.bbtgroup.repository.GeolocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/geolocation")
public class GeolocationResource{

    @Autowired
    private GeolocationRepository geolocationRepository;

    // ======================================
    // =             GET METHOD             =
    // ======================================

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    List<Geolocation> getAllGeolocationData() {

        return (List<Geolocation>) geolocationRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Geolocation> getById(@PathVariable String id) {

        Long temp = Long.valueOf(id).longValue();

        return new ResponseEntity<>(geolocationRepository.findByGeolocationId(temp), HttpStatus.OK);
    }

    // ======================================
    // =             POST METHOD            =
    // ======================================

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Geolocation> createGeolocation(@RequestBody Geolocation geolocationData){

        geolocationRepository.save(geolocationData);
        return new ResponseEntity<Geolocation>(geolocationData, HttpStatus.CREATED);
    }

    // ======================================
    // =             PUT METHOD             =
    // ======================================

    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Geolocation> updateGeolocationData(@RequestBody Geolocation dataRequest) {

        geolocationRepository.save(dataRequest);
        return new ResponseEntity<Geolocation>(dataRequest, HttpStatus.OK);
    }

    // ======================================
    // =          DELETE METHOD             =
    // ======================================

    @RequestMapping(path = "/{geolocationId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteGeolocationData(@PathVariable Long geolocationId) {

        geolocationRepository.delete(geolocationId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
