package com.buster.controller;

import com.buster.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getUser(@PathVariable("id") String id) {
        Profile profile = new Profile("green", 10, 7);
        return new ResponseEntity<Profile>(profile, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> login(@RequestParam("username") int username,
                                   @RequestParam("password") int password) {
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/user/register", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> register(@RequestBody Profile profile) {
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}


