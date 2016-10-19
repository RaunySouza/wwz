package com.github.raunysouza.wwz.controller.v1;

import com.github.raunysouza.wwz.SurvivorNotFoundException;
import com.github.raunysouza.wwz.model.Location;
import com.github.raunysouza.wwz.model.Survivor;
import com.github.raunysouza.wwz.ms.SurvivorRequest;
import com.github.raunysouza.wwz.ms.SurvivorResponse;
import com.github.raunysouza.wwz.repository.SurvivorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author raunysouza
 */
@RestController
@RequestMapping("/api/v1")
public class SurvivorController {

    @Autowired
    private SurvivorRepository survivorRepository;

    @RequestMapping("/survivor")
    public Iterable<SurvivorResponse> get() {
        return survivorRepository.findAll().stream()
                .reduce(new ArrayList<>(), (list, survivor) -> {
                    list.add(SurvivorResponse.fromSurvivor(survivor));
                    return list;
                }, (l1, l2) -> l1);
    }

    @RequestMapping("/survivor/{id}")
    public SurvivorResponse get(@PathVariable("id") Long id) {
        return SurvivorResponse.fromSurvivor(survivorRepository.findOne(id));
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

    @RequestMapping(value = "/survivor/{id}/infected", method = RequestMethod.PATCH)
    public void flagInfected(@PathVariable("id") Long id) {
        Survivor survivor = survivorRepository.findOne(id);
        if (survivor == null) {
            throw new SurvivorNotFoundException();
        }

        survivor.flag();
        survivorRepository.save(survivor);
    }
}
