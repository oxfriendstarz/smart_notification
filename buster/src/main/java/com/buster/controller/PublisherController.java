package com.buster.controller;

import com.buster.models.*;
import org.springframework.stereotype.Component;
import services.BusterMessageProducer;
import services.ReportAssuranceService;

import temporary.tempDatabaseKasiHard;

import javax.jms.JMSException;

/**
 * Created by jdulay on 5/11/2018.
 */

@Component
public class PublisherController {
    private BusterMessageProducer messageProducer;

    public PublisherController() {
        messageProducer = new BusterMessageProducer();
    }

    public void receiveReport(Report report){
        System.out.println("==============================");
        System.out.println(report.username +" have Reported a "+report.type + " - "+report.description
                + "- at Location (" + report.location.Latitude + ","+report.location.Longitude+") "+report.location.MarkedLocation);
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

        try {
            messageProducer.sendMessage(report);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        tempDatabaseKasiHard.reports.add(report);
    }

}
