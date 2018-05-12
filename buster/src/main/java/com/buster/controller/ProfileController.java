package com.buster.controller;

import com.buster.models.PublisherProfile;
import com.buster.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    PublisherRepository publisherRepository;

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<PublisherProfile> getUser(@PathVariable("id") Long id) {
        PublisherProfile profile = publisherRepository.findById(id).get();
        return new ResponseEntity<PublisherProfile>(profile, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> login(@RequestParam("username") String username,
                                        @RequestParam("password") String password) {
        PublisherProfile publisherProfile = publisherRepository.findByUsernameAndPassword(username, password);
        ResponseEntity<String> responseEntity;
        if(publisherProfile != null) {
            responseEntity = new ResponseEntity<String>("Success", HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<String>("Failed", HttpStatus.UNAUTHORIZED);
        }
        return responseEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/user/register", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> register(@RequestBody PublisherProfile profile) {
        publisherRepository.save(profile);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}


