package com.buster.controller;


import com.buster.models.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.ReportAssuranceService;

import temporary.tempDatabaseKasiHard;
/**
 * Created by jdulay on 5/11/2018.
 */

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    public void receiveReport(Report report){
        System.out.println("==============================");
        System.out.println(report.username +" have Reported a "+report.type + "-"+report.description
                + " at Location (" + report.location.Latitude + ","+report.location.Longitude+") "+report.location.MarkedLocation);
        //receive post from publisher

        //check post Credibility
        ReportAssuranceService reportAssuranceService = new ReportAssuranceService(report);
        if(reportAssuranceService.isAssured()){
            System.out.println("Number of Report Occurence is:"+reportAssuranceService.getNumberOfRecurringReport());
            System.out.println("Report is Assured");
            System.out.println("Sending it to Message Broker");
        }
        else{
            System.out.println("NOT REPORT NOT Assured");
            System.out.println("Sending rejected report from user");
        }

        addToExistingPenName(report);
        tempDatabaseKasiHard.reports.add(report);
    }

    public void addToExistingPenName(Report report){
        for (PublisherProfile temp : tempDatabaseKasiHard.publisherProfile) {
            if(temp.penName == report.username){
                temp.reports.add(report);
            }
        }
    }
}
