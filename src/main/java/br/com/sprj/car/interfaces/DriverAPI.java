package br.com.sprj.car.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.sprj.car.domain.Driver;
import br.com.sprj.car.domain.DriverRepository;

@Service
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverAPI {

    @Autowired
    DriverRepository driverRepository;

    @GetMapping("/drivers")
    public List<Driver> listDrivers() {
	return driverRepository.findAll();
    }

    @GetMapping("/drivers/{id}")
    public Driver findDriver(@PathVariable("id") Long id) {
	return driverRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}