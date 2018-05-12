package com.buster.controller;

import models.BusterConstants;
import models.Report;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ramon on 5/12/2018.
 */

@RestController
@RequestMapping("/report")
public class ReportController {

    @ResponseBody
    @RequestMapping(value = "/all/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Report> getAllPosts() {
        //TODO: get posts from DB
        return new ResponseEntity<>(new Report("test", BusterConstants.ReportType.CRIME,"test"), HttpStatus.OK);
    }
}
