package com.buster.controller;

import com.buster.models.BusterConstants;
import com.buster.models.Report;
import com.buster.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Ramon on 5/12/2018.
 */

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private PublisherController publisherController;

    @ResponseBody
    @RequestMapping(value = "/all/user/{username}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Report>> getAllPostsByUser(@PathVariable("username") String username) {

        List<Report> reportList = reportRepository.findByUsername(username);

        //TODO: get posts from DB
        return new ResponseEntity<List<Report>>(reportList, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/new/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> newReport(@RequestBody Report report) {
        report.setStatus("new");
        reportRepository.save(report);
        publisherController.receiveReport(report);
        return new ResponseEntity<String>("created report", HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/update/report/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> updateReport(@RequestBody Report report) {
        report.setStatus("update");
        reportRepository.save(report);
        return new ResponseEntity<String>("created report", HttpStatus.OK);
    }
}
