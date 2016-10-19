package com.github.raunysouza.wwz.controller.v1;

import com.github.raunysouza.wwz.model.Location;
import com.github.raunysouza.wwz.model.Survivor;
import com.github.raunysouza.wwz.ms.SurvivorRequest;
import com.github.raunysouza.wwz.repository.SurvivorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author raunysouza
 */
@RestController
@RequestMapping("/api/v1")
public class SurvivorController {

    @Autowired
    private SurvivorRepository survivorRepository;

    @RequestMapping("/survivor")
    public Iterable<Survivor> get() {
        return survivorRepository.findAll();
    }

    @RequestMapping("/survivor/{id}")
    public Survivor get(@PathVariable("id") Long id) {
        return survivorRepository.findOne(id);
    }

    @RequestMapping(value = "/survivor", method = RequestMethod.POST)
    public void save(@Validated @RequestBody SurvivorRequest request) {
        Survivor survivor = new Survivor();
        survivor.setName(request.getName());
        survivor.setAge(request.getAge());
        survivor.setGender(Survivor.Gender.valueOf(request.getGender()));
        survivor.setLastLocation(new Location(request.getLatitude(), request.getLongitude()));
        survivorRepository.save(survivor);
    }
}
